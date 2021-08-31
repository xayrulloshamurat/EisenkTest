package com.example.eisenktest.eisenk

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.eisenktest.MyDatabase
import com.example.eisenktest.R
import com.example.eisenktest.data.User
import kotlinx.android.synthetic.main.quiz_layout.*

class QuizFragment : Fragment(R.layout.quiz_layout) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var massiv: MutableList<User> = mutableListOf()
        var score = 0
        var extravert_yes_sum = 0
        var extravert_no_sum = 0
        var extravert_total_sum = 0

        var neurotism_yes_sum = 0

        var lie_yes_sum = 0
        var lie_no_sum = 0
        var lie_total_sum = 0

        val dao = MyDatabase.getInstance(requireContext()).questionsDao()
        massiv.addAll(dao.getAllQuestions())
        massiv.shuffle()
        questionPlace.text = massiv[score].questions
        scoreItem.text = "${score + 1}/ 57"

        trueButton.setOnClickListener {
            when (massiv[score].questionType) {
                1 -> {
                    lie_yes_sum++
                }
                3 -> {
                    extravert_yes_sum++
                }
                5 -> {
                    neurotism_yes_sum++
                }
            }
            if (score == 56) {
                extravert_total_sum = extravert_no_sum + extravert_yes_sum
                lie_total_sum = lie_no_sum + lie_yes_sum
                val actions = QuizFragmentDirections.actionQuizFragmentToResultFragment(
                    extravert_total_sum,
                    neurotism_yes_sum,
                    lie_total_sum
                )
                findNavController().navigate(actions)
            } else {
                score++
                questionPlace.text = massiv[score].questions
            }
            scoreItem.text = "${score + 1}/ 57"
        }

        falseButton.setOnClickListener {

            when (massiv[score].questionType) {
                2 -> {
                    lie_no_sum++
                }
                4 -> {
                    extravert_no_sum++
                }
            }
            if (score == 56) {
                extravert_total_sum = extravert_no_sum + extravert_yes_sum
                lie_total_sum = lie_no_sum + lie_yes_sum
                val actions = QuizFragmentDirections.actionQuizFragmentToResultFragment(
                    extravert_total_sum,
                    neurotism_yes_sum,
                    lie_total_sum
                )
                findNavController().navigate(actions)
            } else {
                score++
                questionPlace.text = massiv[score].questions
            }
            scoreItem.text = "${score + 1}/ 57"
        }
    }
}