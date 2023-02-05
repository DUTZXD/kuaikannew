package com.zxd.kuaikannew

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById<RecyclerView?>(R.id.manhuaRv).apply {
            adapter = ManHuaAdapter(this@MainActivity)
            layoutManager = LinearLayoutManager(this@MainActivity)
        }

        val btn = findViewById<Button>(R.id.mybtn)
        btn.setOnClickListener {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://www.kuaikanmanhua.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            //
            val manhuaService = retrofit.create(ManhuaService::class.java)
            val call = manhuaService.getDailyUpdate()
            call.enqueue(object : Callback<ManhuaBean?> {
                override fun onResponse(call: Call<ManhuaBean?>, response: Response<ManhuaBean?>) {
                    val bean = response.body()

                    if (bean != null) {
                        val data = bean.data

                        val topics = data?.topics
                        val entityList = ArrayList<ManhuaEntity>()
                        if (topics != null) {
                            for (i in 0 until topics.size) {
                                val entity = ManhuaEntity()
                                topics[i].apply {
                                    entity.cover = this.cover_image_url
                                    entity.des = this.description
                                    entity.title = this.title
                                }
                                entityList.add(entity)
                            }
                        }
                        val adapter = recyclerView.adapter as ManHuaAdapter
                        adapter.setData(entityList)
                    }
                }

                override fun onFailure(call: Call<ManhuaBean?>, t: Throwable) {}
            })
        }
    }
}