package com.example.eisenktest.aforizm

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.eisenktest.R
import com.example.eisenktest.data.AforizmAuthorWithAforizm
import com.example.eisenktest.data.AforizmModel
import kotlinx.android.synthetic.main.item_aforizm.view.*

class AforizmListAdapter : RecyclerView.Adapter<AforizmListAdapter.AforizmListViewHolder>() {

    var models: List<AforizmAuthorWithAforizm> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }


    inner class AforizmListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun populateModel(models: AforizmAuthorWithAforizm) {
            if(models.aforizmModel.authorId == models.aforizmAuthorModel.id){
                itemView.aforizmText.text = models.aforizmModel.aforizmText
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AforizmListViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_aforizm, parent, false)
        return AforizmListViewHolder(view)
    }

    override fun onBindViewHolder(holder: AforizmListViewHolder, position: Int) {
        holder.populateModel(models[position])
    }

    override fun getItemCount() = models.size
}