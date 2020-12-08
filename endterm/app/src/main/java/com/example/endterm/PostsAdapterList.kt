package com.example.endterm

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView

class PostsAdapterList(
    val context: Context
) : RecyclerView.Adapter<PostsAdapterList.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list, parent, false)
        instance = this
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val task = MainActivity.posts[position]
        holder.titleText.text = task.title


        holder.itemView.setOnClickListener {
            val bundle = bundleOf("taskId" to task.id, "userId" to task.userId)
            it.findNavController().navigate(R.id.action_firstPage_to_secondPage, bundle)
        }
    }

    override fun getItemCount(): Int {
        return MainActivity.posts.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var titleText: TextView = itemView.findViewById(R.id.title)
    }

    companion object {
        lateinit var instance: PostsAdapterList
    }
}