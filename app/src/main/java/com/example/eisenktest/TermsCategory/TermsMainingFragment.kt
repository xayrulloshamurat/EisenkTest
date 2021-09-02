package com.example.eisenktest.TermsCategory

import android.animation.ValueAnimator
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.airbnb.lottie.LottieAnimationView
import com.example.eisenktest.MyDatabase
import com.example.eisenktest.R
import com.example.eisenktest.data.MyDao
import com.example.eisenktest.data.TermsModel
import kotlinx.android.synthetic.main.terms_meaning_layout.*


class TermsMainingFragment : Fragment(R.layout.terms_meaning_layout) {
    private val safeArgs: TermsMainingFragmentArgs by navArgs()

    private lateinit var dao: MyDao
    private lateinit var menuItem: MenuItem
    private lateinit var termsId: TermsModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dao = MyDatabase.getInstance(requireContext()).questionsDao()
        termsId = dao.searchById(safeArgs.id)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        meaning.text = safeArgs.meaning
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.favourite_terms_menu, menu)
        menuItem = menu.findItem(R.id.item_bookmark)
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
        if (termsId.isFavourite == 0) termsId.isFavourite = 1
        else termsId.isFavourite = 1 - termsId.isFavourite
        setFavouriteIcon()

        dao.updateTerms(termsId)
    }

    private fun setFavouriteIcon() {
        if (termsId.isFavourite == 1) {
            menuItem.setIcon(R.drawable.ic_baseline_bookmark_24)
//            animation_view.playAnimation()
        } else {
            menuItem.setIcon(R.drawable.ic_baseline_bookmark_border_24)
//            animation_view.pauseAnimation()
        }
    }
}