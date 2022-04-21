package com.example.roomex.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.roomex.R
import com.example.roomex.databinding.ItemViewBinding
import com.example.roomex.model.NoteModel
import com.example.roomex.screens.start.StartFragment

class NoteAdapter : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {
    private var item_list = emptyList<NoteModel>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        return NoteViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_view, parent, false)
        )
    }

    override fun getItemCount() = item_list.size

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val ItemsViewModel = item_list[position]
        with(holder) {
            binding.titleNode.text=ItemsViewModel.title
        }
    }

    fun setList(list: List<NoteModel>) {
        item_list = list
        notifyDataSetChanged()
    }

    class NoteViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ItemViewBinding.bind(view)
    }

    override fun onViewAttachedToWindow(holder: NoteViewHolder) {
        super.onViewAttachedToWindow(holder)
        holder.itemView.setOnClickListener {
            StartFragment.clickNote(item_list[holder.adapterPosition])
        }
    }

    override fun onViewDetachedFromWindow(holder: NoteViewHolder) {
        super.onViewDetachedFromWindow(holder)
        holder.itemView.setOnClickListener(null)
    }
}
