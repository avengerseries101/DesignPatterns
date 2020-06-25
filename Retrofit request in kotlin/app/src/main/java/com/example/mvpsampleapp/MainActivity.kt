package com.example.mvpsampleapp

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    var listView : ListView = findViewById(R.id.listView)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var retrofit = Retrofit.Builder().baseUrl(ApiInterface.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        var API = retrofit.create(ApiInterface::class.java)

        var call = API.posts

        call?.enqueue(object : Callback<List<PostModel?>?> {
            override fun onFailure(call: Call<List<PostModel?>?>, t: Throwable) {
                TODO("Not yet implemented")
            }

            override fun onResponse(
                call: Call<List<PostModel?>?>,
                response: Response<List<PostModel?>?>
            ) {
                var postList: List<PostModel?>? = response.body() as List<PostModel?>?
                var post = arrayOfNulls<String>(postList!!.size)

                for (i in postList.indices)
                    post[i] = postList[i]?.title

                var adapter = ArrayAdapter<String>(
                    applicationContext,
                    android.R.layout.simple_dropdown_item_1line
                )
                listView.adapter = adapter
            }

        })
    }
}
