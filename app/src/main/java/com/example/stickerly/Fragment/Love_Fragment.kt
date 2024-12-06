package com.example.stickerly.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.stickerly.Adapter.StickerAdapter
import com.example.stickerly.R
import com.example.stickerly.ViewModel.MainViewModel
import com.example.stickerly.databinding.FragmentLoveBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Love_Fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class Love_Fragment : Fragment() {
    private var viewModel=MainViewModel()
    private lateinit var binding: FragmentLoveBinding
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
        binding=FragmentLoveBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.stickerSecond.observe(viewLifecycleOwner, Observer {
            binding.viewLove.layoutManager=
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL,false)
            binding.viewLove.adapter= StickerAdapter(it)
        })
        viewModel.loadStickerSecond()
    }
}