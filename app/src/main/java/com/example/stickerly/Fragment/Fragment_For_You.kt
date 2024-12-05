package com.example.stickerly.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.stickerly.Adapter.CategoryAdapter
import com.example.stickerly.Adapter.StickerAdapter
import com.example.stickerly.Adapter.SuggestedAdapter

import com.example.stickerly.ViewModel.MainViewModel
import com.example.stickerly.databinding.FragmentForYouBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Fragment_For_You.newInstance] factory method to
 * create an instance of this fragment.
 */
class Fragment_For_You : Fragment() {

    private var viewModel=MainViewModel()
    private lateinit var binding: FragmentForYouBinding
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
            viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentForYouBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
      initCategoty()

        initSticker()

        initSuggested()
        initStickerSecond()

    }

    private fun initStickerSecond() {
      viewModel.stickerSecond.observe(viewLifecycleOwner, Observer {
          binding.viewStickerSecond.layoutManager=LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
          binding.viewStickerSecond.adapter=StickerAdapter(it)
      })
        viewModel.loadStickerSecond()
    }

    private fun initSuggested() {
        viewModel.suggested.observe(viewLifecycleOwner, Observer {
            binding.viewSuggested.layoutManager=LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
            binding.viewSuggested.adapter=SuggestedAdapter(it)
        })
        viewModel.loadSuggested()
    }

    private fun initSticker() {

        viewModel.stickers.observe(viewLifecycleOwner, Observer {
            binding.viewSticker.layoutManager=LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
            binding.viewSticker.adapter=StickerAdapter(it)

        })
        viewModel.loadSticker()
    }

    private fun initCategoty() {
        binding.progressBarSticker.visibility=View.VISIBLE
        viewModel.categorys.observe(viewLifecycleOwner, Observer {
         binding.viewCategory.layoutManager=GridLayoutManager(requireContext(),2,GridLayoutManager.HORIZONTAL,false)
         binding.viewCategory.adapter=CategoryAdapter(it)
            binding.progressBarSticker.visibility=View.GONE
        })

        viewModel.loadCategory()
    }

}