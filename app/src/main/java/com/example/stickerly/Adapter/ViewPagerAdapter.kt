package com.example.stickerly.Adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.stickerly.Fragment.Home_Fragment

class ViewPagerAdapter(activity: Home_Fragment, private val fragment:List<Fragment>) :FragmentStateAdapter(activity){
    override fun getItemCount(): Int {
        return fragment.size
    }

    override fun createFragment(position: Int): Fragment = fragment[position]
}