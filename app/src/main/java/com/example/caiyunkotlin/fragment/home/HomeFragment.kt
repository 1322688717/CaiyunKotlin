package com.example.caiyunkotlin.fragment.home

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.example.caiyunkotlin.R
import com.example.caiyunkotlin.databinding.FragmentHome2Binding

class HomeFragment : Fragment() {


    private lateinit var viewModel: HomeViewModel
    private lateinit var binding : FragmentHome2Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =  FragmentHome2Binding.inflate(layoutInflater)
        return binding.root
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        initView()
    }

    private fun initView() {
        viewModel.setErathy()
        viewModel.erathy.observe(viewLifecycleOwner, Observer {
            binding.tvEarthy.text = it
        })

        viewModel.setSao()
        viewModel.sao.observe(viewLifecycleOwner, Observer {
            binding.tvSao.text = it
        })
    }
}