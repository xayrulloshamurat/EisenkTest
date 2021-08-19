package com.example.eisenktest

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.terms_meaning_layout.*

class TermsMainingFragment:Fragment(R.layout.terms_meaning_layout) {
    private val  safeArgs : TermsMainingFragmentArgs by navArgs()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        meaning.text = safeArgs.itemView
        super.onViewCreated(view, savedInstanceState)
    }
}