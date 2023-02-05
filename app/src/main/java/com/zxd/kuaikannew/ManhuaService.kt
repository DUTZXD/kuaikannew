package com.zxd.kuaikannew

import retrofit2.http.GET
import com.zxd.kuaikannew.ManhuaBean
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Query

/**
 * @auther: zhangxiaodong91
 * @date: 2023/2/2
 */
interface ManhuaService {

    @GET("v2/pweb/daily/topics")
    fun getDailyUpdate(): Call<ManhuaBean>
}