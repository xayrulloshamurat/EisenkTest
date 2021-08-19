package com.example.eisenktest

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.eisenktest.eisenk.MainActivity
import kotlinx.android.synthetic.main.test_layout.*


class TestFragment: Fragment(R.layout.test_layout) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        testName.setOnClickListener {
            val intent = Intent(activity, MainActivity::class.java)
            startActivity(intent)
        }
        super.onViewCreated(view, savedInstanceState)
    }
}