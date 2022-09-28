package com.example.caiyunkotlin.fragment.shop

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.caiyunkotlin.R
import com.example.caiyunkotlin.adapter.AdapterClassification
import com.example.caiyunkotlin.adapter.AdapterLike
import com.example.caiyunkotlin.adapter.AdapterProduct
import com.example.caiyunkotlin.databinding.FragmentShopBinding
import com.scwang.smart.refresh.footer.BallPulseFooter
import com.scwang.smart.refresh.header.BezierRadarHeader


class ShopFragment : Fragment() {

    lateinit var binding: FragmentShopBinding
    lateinit var viewmodel : ShopViewModel
    private var adapterClassification : AdapterClassification? = null
    private var adapterProduct : AdapterProduct? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentShopBinding.inflate(layoutInflater)
        viewmodel = ViewModelProvider(this).get(ShopViewModel::class.java)
        initView()
        return binding.root
    }

    private fun initView() {
        binding.apply {
            //分类列表初始化
            viewmodel.getClassification()
            viewmodel.BeanShopClass.observe(viewLifecycleOwner){
                //rcClassification.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL,false)
                rcClassification.layoutManager = GridLayoutManager(activity, 5)
                 adapterClassification  = AdapterClassification(requireActivity(),it)
                rcClassification.adapter = adapterClassification
            }

            //商品列表初始化
            rcProduct.layoutManager = GridLayoutManager(activity, 2)
             adapterProduct  = AdapterProduct(requireActivity())
            rcProduct.adapter = adapterProduct

            //刷新控件初始化
            srSmartRefreshLayout.setRefreshHeader(BezierRadarHeader(activity).setEnableHorizontalDrag(true))
            srSmartRefreshLayout.setOnRefreshListener {
                it.finishRefresh()
            }


        }
    }

}
