package com.example.stickerly.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.stickerly.Adapter.ArtistsAdapter
import com.example.stickerly.R
import com.example.stickerly.ViewModel.MainViewModel
import com.example.stickerly.databinding.FragmentArtistsBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Artists_Fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class Artists_Fragment : Fragment() {
    private  var viewModel=MainViewModel()
    private lateinit var binding: FragmentArtistsBinding
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
        val binding=FragmentArtistsBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        binding.progressBar2.visibility=View.VISIBLE
//        viewModel.artists.observe(viewLifecycleOwner, Observer {
//            binding.viewArtists.layoutManager=LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
//            binding.viewArtists.adapter=ArtistsAdapter(it)
//            binding.progressBar2.visibility=View.GONE
//        })
//
//        viewModel.loadArtists()

    }

}