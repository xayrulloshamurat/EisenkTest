package com.example.eisenktest

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.category_layout.view.*
import kotlinx.android.synthetic.main.terms_layout.*
import kotlinx.android.synthetic.main.test_layout.*

class TermsFragment:Fragment(R.layout.terms_layout) {
    lateinit var dao : MyDao
    var adapter = TermsListAdapter()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView.adapter = adapter
        setData()
        adapter.onPostItemClicked = {
            termsModel ->
            val action = TermsFragmentDirections.actionTermsFragmentToTermsMainingFragment(termsModel.meaning)
           findNavController().navigate(action)
        }
    }
    private fun setData(){
       dao = MyDatabase.getInstance(requireContext()).questionsDao()
       adapter.models = dao.getAllTerms()
    }
}