package com.example.eisenktest.aforizm

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.eisenktest.MyDatabase
import com.example.eisenktest.R
import com.example.eisenktest.data.MyDao
import kotlinx.android.synthetic.main.aforizm_layout.*

class AforizmFragment: Fragment(R.layout.aforizm_layout) {
    private var adapter = AforizmListAdapter()
    lateinit var dao: MyDao
    private val safeArgs : AforizmFragmentArgs by navArgs()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView.adapter = adapter
        dao = MyDatabase.getInstance(requireContext()).questionsDao()
        adapter.models = dao.getAllAforizm()
        super.onViewCreated(view, savedInstanceState)
    }
}