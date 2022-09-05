package com.example.caiyunkotlin.fragment.like

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.get
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.caiyunkotlin.adapter.AdapterLike
import com.example.caiyunkotlin.bean.BeanLike
import com.example.caiyunkotlin.databinding.FragmentLike2Binding
import com.google.gson.Gson
import okhttp3.*
import org.json.JSONArray
import org.json.JSONObject
import java.io.IOException
import java.util.concurrent.TimeUnit

/**
 * 随机壁纸
 * 请求方式：get

请求地址：https://api.btstu.cn/sjbz/api.php

返回格式：json/images

请求示例：https://api.btstu.cn/sjbz/api.php?lx=dongman&format=images

请求参数：

名称	必填	类型	说明
method	否	string	输出壁纸端[mobile|pc|zsy]默认为pc
lx	否	string	选择输出分类[meizi|dongman|fengjing|suiji]，为空随机输出
format	否	string	输出壁纸格式[json|images]默认为images

返回参数：

名称	类型	说明
code	string	返回的状态码
imgurl	string	返回图片地址
width	string	返回图片宽度
height	string	返回图片高度

返回示例：

{"code":"200","imgurl":"https:\/\/tva4.sinaimg.cn\/large\/9bd9b167gy1g2qkr95hylj21hc0u01kx.jpg","width":"1920","height":"1080"}
 */
class LikeFragment : Fragment() {

    private val url : String = "https://service.picasso.adesk.com/v1/vertical/vertical?limit=30&skip=180&adult=false&first=0&order=hot"
    private lateinit var viewModel: LikeViewModel
    private var binding : FragmentLike2Binding? = null
    private var adapter : AdapterLike? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLike2Binding.inflate(inflater,container,false)
        viewModel = ViewModelProvider(this).get(LikeViewModel::class.java)
        initView()
        return binding!!.root
    }


    private fun initView() {
        viewModel.setLikeBean(url,requireActivity())
        binding!!.rcWallpaper.layoutManager = GridLayoutManager(activity, 2)
        viewModel.likeBean.observe(viewLifecycleOwner, Observer {
            adapter = AdapterLike(it.res.vertical, requireActivity())
            binding!!.rcWallpaper.adapter = adapter
        })
    }

}


