package com.example.endterm

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ThirdPage: Fragment() {override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
): View? {
    return inflater.inflate(R.layout.thirdpage, container, false)
}

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val postId = arguments?.getInt("Id")!!
        val userId = arguments?.getInt("userId")!!
        val title = arguments?.getString("title")!!
        val body = arguments?.getString("body")!!

        MainActivity.apiService.getTaskById(postId).enqueue(object : Callback<Posts> {
            override fun onFailure(call: Call<Posts>, t: Throwable) {
                Log.e("error", t.message.toString())
            }
            override fun onResponse(call: Call<Posts>, response: Response<Posts>) {
                Log.e("Response body: ", response.body()!!.toString())
                val posts = response.body()!!
                title.text = posts.title
                body.text = posts.body
                id.text = posts.id
                userId.text = posts.userId
            }
        })

    }
    }