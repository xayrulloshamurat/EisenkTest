package com.example.eisenktest.aforizmAuthor

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.eisenktest.R
import com.example.eisenktest.data.AforizmAuthorModel
import kotlinx.android.synthetic.main.item_author_aforizm.view.*

class AforizmAuthorListAdapter :
    RecyclerView.Adapter<AforizmAuthorListAdapter.AforizmAuthorListViewHolder>() {

    var models: List<AforizmAuthorModel> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }
    var onPostItemClicked: (aforizmAuthorModel: AforizmAuthorModel) -> Unit = {}


    inner class AforizmAuthorListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun populateModel(aforizmAuthorModel: AforizmAuthorModel) {
            itemView.aforizmAuthorText.text = aforizmAuthorModel.authorName
            itemView.setOnClickListener {
                onPostItemClicked.invoke(aforizmAuthorModel)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AforizmAuthorListViewHolder {
        var view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_author_aforizm, parent, false)
        return AforizmAuthorListViewHolder(view)
    }

    override fun onBindViewHolder(holder: AforizmAuthorListViewHolder, position: Int) {
        holder.populateModel(models[position])
    }

    override fun getItemCount() = models.size
}