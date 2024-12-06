package com.example.stickerly.Fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.stickerly.Activity.StickerlyPlusActivity
import com.example.stickerly.Adapter.ViewPagerAdapter
import com.example.stickerly.R
import com.example.stickerly.databinding.FragmentHomeBinding
import com.google.android.material.tabs.TabLayoutMediator

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Home_Fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class Home_Fragment : Fragment() {
    // TODO: Rename and change types of parameters
    private lateinit var binding: FragmentHomeBinding
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
        binding= FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initPagerFragment()
        initSetting()
        initStickerPlus()

//
    }

    private fun initStickerPlus() {
        binding.btnStickerPlus.setOnClickListener{
            val i =Intent(requireContext(),StickerlyPlusActivity::class.java)
            startActivity(i)
        }
    }

    private fun initSetting() {
        binding.btnSetting.setOnClickListener{
          parentFragmentManager.beginTransaction()
              .replace(R.id.viewFragment,Setting_Fragment())
              .addToBackStack(null)
              .commit()
        }
    }

    private fun initPagerFragment() {
        val fragments= listOf(
            Fragment_For_You(),
            Artists_Fragment(),
            Trending_Fragment(),
            Following_Fragment(),
            Love_Fragment(),
            Meme_Fragment()

        )
        val tabTitles= listOf("For You","Artists","Trending","Following","Love","Meme")
        val adapter= ViewPagerAdapter(this@Home_Fragment,fragments)
        binding.viewPager.adapter=adapter
        TabLayoutMediator(binding.tabLayout,binding.viewPager){ tab,position ->
            tab.text=tabTitles[position]
        }.attach()
    }

}