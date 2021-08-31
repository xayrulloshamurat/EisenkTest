package com.example.eisenktest.aforizm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        activity?.title = "Aforizmlar"
            return super.onCreateView(inflater, container, savedInstanceState)
    }
    override fun onViewCreated(view: View, savedInstanceState : Bundle?) {
        recyclerView.adapter = adapter
        dao = MyDatabase.getInstance(requireContext()).questionsDao()
        adapter.models = dao.getAllAforizm(safeArgs.id)
        super.onViewCreated(view, savedInstanceState)
    }
}