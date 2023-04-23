package com.srhdp.hisnulmuslim.presentation.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.srhdp.hisnulmuslim.R
import com.srhdp.hisnulmuslim.databinding.FragmentContentBinding
import com.srhdp.hisnulmuslim.presentation.adapter.ContentAdapter
import com.srhdp.hisnulmuslim.presentation.viewmodel.DataViewModel

class ContentFragment : Fragment() {
    private lateinit var viewModel: DataViewModel
    private lateinit var contentAdapter: ContentAdapter
    private lateinit var binding:FragmentContentBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_content, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentContentBinding.bind(view)

        viewModel = (activity as MainActivity).viewModel
        contentAdapter = (activity as MainActivity).contentAdapter

        initRecyclerView()

        viewModel.getContent().observe(viewLifecycleOwner){
            contentAdapter.differ.submitList(it)
        }
    }

    private fun initRecyclerView(){
        binding.rvDiscoverMainItems.apply {
            adapter = contentAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }


}