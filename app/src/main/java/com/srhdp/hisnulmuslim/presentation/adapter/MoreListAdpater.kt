package com.srhdp.hisnulmuslim.presentation.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.srhdp.hisnulmuslim.R
import com.srhdp.hisnulmuslim.databinding.ListMoreItemBinding

class MoreListAdpater(private val context: Activity, private val title: Array<String>, private val imgid: Array<Int>)
    : ArrayAdapter<String>(context, R.layout.list_more_item, title) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val binding: ListMoreItemBinding =
            if (convertView != null) ListMoreItemBinding.bind(convertView)
            else ListMoreItemBinding.inflate(LayoutInflater.from(context), parent, false)

        binding.tvTitle.text = title[position]
        binding.ivIconList.setImageResource(imgid[position])

        return binding.root
    }
}