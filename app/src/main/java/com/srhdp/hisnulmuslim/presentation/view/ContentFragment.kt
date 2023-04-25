package com.srhdp.hisnulmuslim.presentation.view

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.srhdp.hisnulmuslim.R
import com.srhdp.hisnulmuslim.databinding.FragmentContentBinding
import com.srhdp.hisnulmuslim.presentation.adapter.ContentAdapter
import com.srhdp.hisnulmuslim.presentation.viewmodel.DataViewModel
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ContentFragment : Fragment() {
    private lateinit var viewModel: DataViewModel
    private lateinit var contentAdapter: ContentAdapter
    private lateinit var binding:FragmentContentBinding

    var skipOnChange:Boolean = false;
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        Log.d("MYTAG", "onCreateView work again")
        return inflater.inflate(R.layout.fragment_content, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentContentBinding.bind(view)


        viewModel = (activity as MainActivity).viewModel
        contentAdapter = (activity as MainActivity).contentAdapter

        contentAdapter.setOnItemClickListener {
            val bundle = bundleOf("myArg" to it.id)
            findNavController().navigate(
                R.id.action_contentFragment_to_detailFragment,
                bundle
            )
            skipOnChange = true;
        }

        initRecyclerView()
        //viewAllContent()
        if(skipOnChange == false){
            viewSearchContent("")
        }
        setSearchView()

    }



    private fun initRecyclerView(){
        Log.d("MYTAG", "work again")
        binding.rvDiscoverMainItems.apply {
            adapter = contentAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }



    //search
    //var job: Job? = null

    private fun setSearchView(){
        binding.etSearchView.addTextChangedListener(
            object : TextWatcher {
                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
//                    if (skipOnChange)
//                        return;
                    skipOnChange = true;

                    MainScope().launch {
                        delay(500)
                         s?.let {
                             viewSearchContent(s.toString())
                        }
                    }
                    Log.d("MYTAG", "TEXT CHANGE")
                }

                override fun afterTextChanged(s: Editable?) {

//                    if (skipOnChange)
//                        return;
//                    skipOnChange = true;

                    MainScope().launch {
                        delay(500)
                        s?.let {
//                            if(s.isNotEmpty()){
//                                viewSearchContent(s.toString())
//                            }else{
//                                viewAllContent()
//                            }
                            viewSearchContent(s.toString())
                        }
                    }
                    Log.d("MYTAG", "TEXT AFTER CHANGE")
                }
        })
    }

    fun viewSearchContent(query:String){
        viewModel.getSearchContent(query).observe(viewLifecycleOwner) { response ->
            contentAdapter.differ.submitList(response)
        }
    }

    fun viewAllContent(){
        viewModel.getContent().observe(viewLifecycleOwner){
            contentAdapter.differ.submitList(it)
        }
    }
}