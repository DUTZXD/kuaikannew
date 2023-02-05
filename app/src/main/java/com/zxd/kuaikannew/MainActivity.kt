package com.zxd.kuaikannew

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    private var recyclerView: RecyclerView? = null
    private var btn: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn = findViewById(R.id.mybtn)
        recyclerView = findViewById(R.id.manhuaRv)
        val adapter = ManHuaAdapter(this)
        recyclerView?.adapter = adapter
        recyclerView?.layoutManager = LinearLayoutManager(this)
        val viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.manhuaData.observe(this) {
            adapter.setData(it)
        }
        btn?.setOnClickListener {
            viewModel.getUpdate()
        }
    }
}