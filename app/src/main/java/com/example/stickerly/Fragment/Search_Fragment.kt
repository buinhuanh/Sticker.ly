package com.example.stickerly.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.stickerly.Adapter.SearchTrendingAdapter
import com.example.stickerly.Adapter.SuggestedAdapter
import com.example.stickerly.ViewModel.MainViewModel
import com.example.stickerly.databinding.FragmentSearchBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Search_Fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class Search_Fragment : Fragment() {
    private lateinit var binding: FragmentSearchBinding
    private  var viewModel=MainViewModel()
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentSearchBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initSearchTrending()

        initSearchSuggested()
    }

    private fun initSearchSuggested() {
        viewModel.searchSuggested.observe(viewLifecycleOwner, Observer {
            binding.viewSearchSuggested.layoutManager=GridLayoutManager(requireContext(),2,GridLayoutManager.VERTICAL,false)
            binding.viewSearchSuggested.adapter=SuggestedAdapter(it)
        })
        viewModel.loadSearchSuggested()
    }

    private fun initSearchTrending() {
        binding.progressBar.visibility=View.VISIBLE
        viewModel.searchTrending.observe(viewLifecycleOwner, Observer {
            binding.viewSearchTrending.layoutManager=GridLayoutManager(requireContext(),2,GridLayoutManager.VERTICAL,false)
            binding.viewSearchTrending.adapter=SearchTrendingAdapter(it)
            binding.progressBar.visibility=View.GONE


        })
        viewModel.loadSearchTrending()
    }
}