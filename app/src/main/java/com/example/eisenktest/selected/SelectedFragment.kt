package com.example.eisenktest.selected

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.eisenktest.MyDatabase
import com.example.eisenktest.R
import com.example.eisenktest.data.MyDao
import kotlinx.android.synthetic.main.selected_layout.*

class SelectedFragment : Fragment(R.layout.selected_layout) {
    private var adapter = SelectedAdapter()
    lateinit var dao: MyDao
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        activity?.title = "Siz tanlaganlar"
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView.adapter = adapter
        dao = MyDatabase.getInstance(requireContext()).questionsDao()
        adapter.models = dao.getIsFavourite()
    }
}