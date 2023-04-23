package com.srhdp.hisnulmuslim.presentation.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.srhdp.hisnulmuslim.data.model.Content
import com.srhdp.hisnulmuslim.databinding.ContentItemBinding

class ContentAdapter:RecyclerView.Adapter<ContentAdapter.ContentViewHolder>() {

    inner class ContentViewHolder(
        val binding: ContentItemBinding
    ): RecyclerView.ViewHolder(binding.root){
        fun bind(content: Content){
            Log.i("MYTAG","came here ${content.name}")
            binding.subContentId.text = content.id.toString()
            binding.subContentName.text = content.name

            binding.root.setOnClickListener {
                onItemClickListener?.let {
                    it(content)
                }
            }
        }
    }

    private val callback = object : DiffUtil.ItemCallback<Content>(){
        override fun areItemsTheSame(oldItem: Content, newItem: Content): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Content, newItem: Content): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this,callback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContentViewHolder {
        val binding = ContentItemBinding
            .inflate(LayoutInflater.from(parent.context),parent,false)
        return ContentViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: ContentViewHolder, position: Int) {
        val content = differ.currentList[position]
        holder.bind(content)
    }
    private var onItemClickListener :((Content)->Unit)?=null
    fun setOnItemClickListener(listener : (Content)->Unit){
        onItemClickListener = listener
    }
}