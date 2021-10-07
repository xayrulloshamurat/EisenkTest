package com.example.eisenktest.TestCategory

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.Fragment
import com.example.eisenktest.R
import com.example.eisenktest.eisenk.MainActivity
import kotlinx.android.synthetic.main.test_layout.*


class TestFragment : Fragment(R.layout.test_layout) {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        activity?.title = "Psixologik Testlar"
        return super.onCreateView(inflater, container, savedInstanceState)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        testName.setOnClickListener {
            val intent = Intent(activity, MainActivity::class.java)
            startActivity(intent)
        }
        super.onViewCreated(view, savedInstanceState)
    }
}