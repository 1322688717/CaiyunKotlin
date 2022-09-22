package com.example.caiyunkotlin.fragment.shop

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.caiyunkotlin.R
import com.example.caiyunkotlin.databinding.FragmentShopBinding


class ShopFragment : Fragment() {

    lateinit var binding: FragmentShopBinding
    lateinit var viewmodel : ShopViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_shop, container, false)
    }


}