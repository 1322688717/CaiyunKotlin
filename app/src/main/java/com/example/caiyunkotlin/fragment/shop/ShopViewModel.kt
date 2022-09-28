package com.example.caiyunkotlin.fragment.shop

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShopViewModel : ViewModel(){

    var BeanShopClass = MutableLiveData<ArrayList<Int>>()
    var BeanShop = ArrayList<Int>()

    fun getClassification(){
        BeanShop.add(1)
        BeanShop.add(2)
        BeanShop.add(3)
        BeanShopClass.value = BeanShop
    }
}