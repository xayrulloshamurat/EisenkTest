package com.example.eisenktest.TermsCategory

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.eisenktest.R
import com.example.eisenktest.data.TermsModel
import kotlinx.android.synthetic.main.item_terms.view.*

class TermsListAdapter : RecyclerView.Adapter<TermsListAdapter.TermsListViewHolder>() {

    var models: List<TermsModel> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }
    var onPostItemClicked: (termsModel: TermsModel) -> Unit = {}


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TermsListViewHolder {
        val itemview =
            LayoutInflater.from(parent.context).inflate(R.layout.item_terms, parent, false)
        return TermsListViewHolder(itemview)
    }

    override fun onBindViewHolder(holder: TermsListViewHolder, position: Int) {

        holder.populateModel(models[position])
    }

    override fun getItemCount(): Int = models.size

    inner class TermsListViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        fun populateModel(termsModel: TermsModel) {
            itemView.termsView.text = termsModel.word
            itemView.setOnClickListener {
                onPostItemClicked.invoke(termsModel)
            }
        }
    }
}