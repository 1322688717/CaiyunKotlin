package com.example.caiyunkotlin.fragment.like

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.caiyunkotlin.R
import com.example.caiyunkotlin.adapter.AdapterLike
import com.example.caiyunkotlin.bean.BeanLike
import com.google.gson.Gson
import com.google.gson.JsonObject
import kotlinx.android.synthetic.main.fragment_like2.*
import okhttp3.*
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

    companion object {
        fun newInstance() = LikeFragment()
    }
    private var picture : String? = null
    private val url : String? = "https://api.btstu.cn/sjbz/api.php"

    private lateinit var viewModel: LikeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_like2, container, false)

        initData()
        initView()
        return view
    }

    private fun initData() {
        val request = Request.Builder().url(url!!).build()
        val client = OkHttpClient.Builder()
            .connectTimeout(2,TimeUnit.SECONDS)
            .writeTimeout(2,TimeUnit.SECONDS)
            .readTimeout(2,TimeUnit.SECONDS)
            .retryOnConnectionFailure(true).build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                TODO("Not yet implemented")

            }

            override fun onResponse(call: Call, response: Response) {
                TODO("Not yet implemented")
                val body = response.body?.string()
                val jsonObject = JSONObject(body)
                //val json = Gson().fromJson(jsonObject,BeanLike::class.java)
                picture = jsonObject.optString("imgurl")

            }

        })
    }

    private fun initView() {
//        rc_like.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
//        rc_like.adapter = AdapterLike(picture!!)
        rc_like.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        val adapter = AdapterLike(picture!!)
        rc_like.adapter = adapter

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(LikeViewModel::class.java)
        // TODO: Use the ViewModel
    }

}


