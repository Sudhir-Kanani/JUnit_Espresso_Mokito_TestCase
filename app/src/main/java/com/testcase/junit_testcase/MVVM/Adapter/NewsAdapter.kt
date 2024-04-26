package com.testcase.prectice.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.testcase.junit_testcase.R
import com.testcase.prectice.Api.Model.Result

class NewsAdapter(private val listNews : List<Result>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.news_item,   parent,false)
        return myViewHolder(view)
    }

    override fun getItemCount(): Int {
       return listNews.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as myViewHolder).txtNews.text = listNews[position].title
    }
    inner  class  myViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val txtNews = view.findViewById<TextView>(R.id.txtNews)
    }
}