package com.example.eisenktest.TermsCategory

import android.os.Bundle
import android.view.*
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.eisenktest.MyDatabase
import com.example.eisenktest.R
import com.example.eisenktest.data.MyDao
import kotlinx.android.synthetic.main.terms_layout.*

class FragmentTerms : Fragment(R.layout.terms_layout) {
    lateinit var dao: MyDao
    var adapter = TermsListAdapter()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        activity?.title = "Psixologik Atamalar"
        return super.onCreateView(inflater, container, savedInstanceState)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView.adapter = adapter
        setData()
        adapter.onPostItemClicked = { termsModel ->
            val action = FragmentTermsDirections.actionTermsFragmentToTermsMainingFragment(
                termsModel.meaning,
                termsModel.word,
                termsModel.id
            )
            findNavController().navigate(action)
        }
        editText.addTextChangedListener {
            if (it.toString().length >= 2) {
                adapter.models = dao.searchByWord("%${it.toString()}%")
            } else if (it.toString().isEmpty()) {
                setData()
            }
        }
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                DividerItemDecoration.VERTICAL
            )
        )
    }

    private fun setData() {
        dao = MyDatabase.getInstance(requireContext()).questionsDao()
        adapter.models = dao.getAllTerms()
    }
}