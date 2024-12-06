package com.example.stickerly.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.stickerly.Adapter.CategoryAdapter
import com.example.stickerly.Adapter.Trending_Adapter
import com.example.stickerly.R
import com.example.stickerly.ViewModel.MainViewModel
import com.example.stickerly.databinding.FragmentTrendingBinding
import com.example.stickerly.databinding.ViewholderTrendingBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Trending_Fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class Trending_Fragment : Fragment() {
    private var viewModel=MainViewModel()
    private lateinit var binding: FragmentTrendingBinding
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
        binding=FragmentTrendingBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initViewTrending()
    }

    private fun initViewTrending() {
        viewModel.categorys.observe(viewLifecycleOwner, Observer {
            binding.viewTrending.layoutManager=GridLayoutManager(requireContext(),3,GridLayoutManager.VERTICAL,false)
            binding.viewTrending.adapter=Trending_Adapter(it)

        })
            viewModel.loadCategory()
    }

}