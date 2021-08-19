package com.example.eisenktest

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.eisenktest.data.User
import kotlinx.android.synthetic.main.category_layout.*

class FragmentCategory : Fragment(R.layout.category_layout) {

    var adapter = TermsListAdapter()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        recyclerView.adapter = adapter
//        setData()

        imageTest.setOnClickListener {
          findNavController().navigate(R.id.action_fragmentCategory_to_testFragment)
        }
        imageTerms.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentCategory_to_termsFragment)
        }
    }

    private fun setData() {
        val models = mutableListOf<TermsModel>()
        for (i in 1..10){
            models.add(TermsModel(i, "Question Number $i","Xayrullo"))
        }
        adapter.models = models
    }
}