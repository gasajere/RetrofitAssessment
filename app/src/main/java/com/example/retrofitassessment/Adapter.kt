package com.example.retrofitassessment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitassessment.databinding.ItemsBinding

class Adapter(var list: List<Items>) : RecyclerView.Adapter<Adapter.TodoViewHolder>() {

    class TodoViewHolder(val binding: ItemsBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(items: Items) {
            binding.textView.text = items.id.toString()
            binding.textView2.text = items.name
            binding.textView3.text = items.price.toString()

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val binding = ItemsBinding.inflate(LayoutInflater.from(parent.context))
        return TodoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val singleItems = list.get(position)
        holder.bind(singleItems)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}