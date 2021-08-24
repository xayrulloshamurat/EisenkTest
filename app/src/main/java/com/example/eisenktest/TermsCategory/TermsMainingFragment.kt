package com.example.eisenktest.TermsCategory

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.eisenktest.MyDatabase
import com.example.eisenktest.R
import com.example.eisenktest.data.MyDao
import kotlinx.android.synthetic.main.terms_meaning_layout.*

class TermsMainingFragment : Fragment(R.layout.terms_meaning_layout) {
    private val safeArgs: TermsMainingFragmentArgs by navArgs()

    lateinit var dao: MyDao

    private lateinit var menuItem: MenuItem

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        meaning.text = safeArgs.meaning
        dao = MyDatabase.getInstance(requireContext()).questionsDao()
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.favourite_terms_menu, menu)
        menuItem = menu?.findItem(R.id.item_bookmark)
        setFavouriteIcon()
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.item_bookmark -> setFavourite()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setFavourite() {

        var termsId = dao.searchById(safeArgs.id)
        if(termsId.isFavourite == 0) termsId.isFavourite =1
        else termsId.isFavourite = 1 - termsId.isFavourite!!
        setFavouriteIcon()
        dao.updateTerms(termsId)
    }
    private fun setFavouriteIcon(){
        var termsId = dao.searchById(safeArgs.id)
        if(termsId.isFavourite == 1){
            menuItem?.setIcon(R.drawable.ic_baseline_bookmark_24)
        }else{
            menuItem?.setIcon(R.drawable.ic_baseline_bookmark_border_24)
        }
    }
}