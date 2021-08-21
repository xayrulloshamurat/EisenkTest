package com.example.eisenktest.TermsCategory

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.eisenktest.MyDatabase
import com.example.eisenktest.R
import com.example.eisenktest.data.MyDao
import kotlinx.android.synthetic.main.terms_meaning_layout.*

class TermsMainingFragment:Fragment(R.layout.terms_meaning_layout) {
    private val  safeArgs : TermsMainingFragmentArgs by navArgs()
    var word = safeArgs.word
    var dao = MyDatabase.getInstance(requireContext()).questionsDao()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        meaning.text = safeArgs.meaning

        super.onViewCreated(view, savedInstanceState)

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater){
        inflater.inflate(R.menu.favourite_terms_menu,menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.item_bookmark-> setFavourite()
        }
        return super.onOptionsItemSelected(item)
    }
    private fun setFavourite(){

    }
}