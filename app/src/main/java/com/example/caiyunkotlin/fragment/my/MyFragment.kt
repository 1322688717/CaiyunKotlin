package com.example.caiyunkotlin.fragment.my
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.caiyunkotlin.R
import com.example.caiyunkotlin.databinding.FragmentMy2Binding
import com.example.caiyunkotlin.utlis.RouterUtil

class MyFragment : Fragment() {

    private lateinit var binding: FragmentMy2Binding
    private lateinit var viewModel: MyViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMy2Binding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this).get(MyViewModel::class.java)
        initView()

        return binding.root
    }


    private fun initView() {
        viewModel.getNickname(requireActivity())

        viewModel.nickname.observe(viewLifecycleOwner){
            binding.tvNickName.text = it
        }

        viewModel.IndSignature.observe(viewLifecycleOwner){
            binding.tvIndSigin.text = it
        }

        initHeadPicture()
        initClick()
    }

    private fun initClick() {
        binding.apply {
            imgHeadPortrait.setOnClickListener {
              RouterUtil().goPersonalCenterActivity(requireContext())
            }

            tvNickName.setOnClickListener {
                RouterUtil().goPersonalCenterActivity(requireContext())
            }

            tvIndSigin.setOnClickListener {
                RouterUtil().goPersonalCenterActivity(requireContext())
            }
        }
    }

    /**
     * 设置头像
     */
    private fun initHeadPicture() {

        val opt : RequestOptions = RequestOptions().circleCrop()
        Glide.with(requireActivity())
            .load(R.mipmap.head_picture)
            .apply(opt)
            .into(binding.imgHeadPortrait)
    }

}