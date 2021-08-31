package com.example.eisenktest.aforizmAuthor

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.eisenktest.MyDatabase
import com.example.eisenktest.R
import com.example.eisenktest.data.MyDao
import kotlinx.android.synthetic.main.author_aforizm_layout.*

class AforizmAuthorFragment : Fragment(R.layout.author_aforizm_layout) {
    var adapter = AforizmAuthorListAdapter()
    lateinit var dao: MyDao
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        activity?.title = "Psixologlar"
            return super.onCreateView(inflater, container, savedInstanceState)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView.adapter = adapter
        adapter.onPostItemClicked = { aforizmAuthorModel ->
            var actions =
                AforizmAuthorFragmentDirections.actionAforizmAuthorFragmentToAforizmFragment(
                    aforizmAuthorModel.id
                )
            findNavController().navigate(actions)
        }
        dao = MyDatabase.getInstance(requireContext()).questionsDao()
        adapter.models = dao.getAllAforizmAuthor()
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                DividerItemDecoration.VERTICAL
            )
        )
        super.onViewCreated(view, savedInstanceState)
    }
}