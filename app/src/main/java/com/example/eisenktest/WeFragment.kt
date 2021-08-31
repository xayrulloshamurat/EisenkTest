package com.example.eisenktest

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.we_layout.*

class WeFragment : Fragment(R.layout.we_layout) {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        activity?.title = "Biz haqqimizda"
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        telegram.setOnClickListener {
            val telegram = Intent(Intent.ACTION_VIEW, Uri.parse("http://t.me/xayrullo_shamurat"))
            startActivity(telegram)
        }
        twitter.setOnClickListener {
            val twitter = Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/muxbir_786?s=09"))
            startActivity(twitter)
        }
        instagram.setOnClickListener {
            val instagram = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/xayrullo.shamuratov"))
            startActivity(instagram)
        }
        super.onViewCreated(view, savedInstanceState)
    }
}