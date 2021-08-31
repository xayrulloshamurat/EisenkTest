package com.example.eisenktest.selected

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.eisenktest.R
import com.example.eisenktest.data.TermsModel
import kotlinx.android.synthetic.main.item_selected.view.*

class SelectedAdapter : RecyclerView.Adapter<SelectedAdapter.SelectedListViewHolder>() {

    var models: List<TermsModel> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }


    inner class SelectedListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun populateModel(termsModel: TermsModel) {
            itemView.selectedView.text = termsModel.word
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SelectedListViewHolder {
        var view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_selected, parent, false)
        return SelectedListViewHolder(view)
    }

    override fun onBindViewHolder(holder: SelectedListViewHolder, position: Int) {
        holder.populateModel(models[position])
    }

    override fun getItemCount() = models.size
}