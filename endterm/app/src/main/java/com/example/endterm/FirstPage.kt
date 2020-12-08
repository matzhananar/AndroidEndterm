package com.example.endterm

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.firstpage.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.POST

class FirstPage: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.firstpage, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerview.adapter = PostsAdapterList(view.context)
        recyclerview.layoutManager = LinearLayoutManager(view.context)

        MainActivity.apiService.getPosts().enqueue(object : Callback<MutableList<Posts>> {
            override fun onFailure(call: Call<MutableList<Posts>>, t: Throwable) {
                Log.e("error", t.message.toString())
            }
            override fun onResponse(call: Call<MutableList<Posts>>, response: Response<MutableList<Posts>>) {
                Log.e("Response size: ", response.body()!!.size.toString())
                MainActivity.posts = response.body()!!
                (recyclerview.adapter as PostsAdapterList).notifyDataSetChanged()
            }
        })
    }
}