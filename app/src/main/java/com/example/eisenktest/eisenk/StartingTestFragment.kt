package com.example.eisenktest.eisenk

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.eisenktest.R
import kotlinx.android.synthetic.main.starting_test_layout.*

class StartingTestFragment : Fragment(R.layout.starting_test_layout) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        start.setOnClickListener {
            findNavController().navigate(R.id.action_startingTestFragment_to_quizFragment)
        }
    }
}