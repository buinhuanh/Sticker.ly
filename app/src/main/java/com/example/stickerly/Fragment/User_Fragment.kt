package com.example.stickerly.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.stickerly.Adapter.ViewPager_User_Adapter
import com.example.stickerly.R
import com.example.stickerly.databinding.FragmentUserBinding
import com.google.android.material.tabs.TabLayoutMediator

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [User_Fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class User_Fragment : Fragment() {
    private lateinit var binding: FragmentUserBinding
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
        binding= FragmentUserBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initTabLayout()
    }

    private fun initTabLayout() {

     val fragmets= listOf(
         Menu_User_Fragment(),
         Lock_User_Fragment(),
         Heart_User_Fragment()

     )
        val adapter=ViewPager_User_Adapter(this@User_Fragment,fragmets)
        binding.viewPager.adapter=adapter
        TabLayoutMediator(binding.tabLayout,binding.viewPager){tab,position ->
         when(position){
             0->{
                 tab.icon=resources.getDrawable(R.drawable.menu_icon,null)
             }
             1 ->{
                 tab.icon=resources.getDrawable(R.drawable.lock_icon,null)
             }
             2 -> {
                 tab.icon=resources.getDrawable(R.drawable.heart_icon,null)
             }
         }

        }.attach()
    }
}