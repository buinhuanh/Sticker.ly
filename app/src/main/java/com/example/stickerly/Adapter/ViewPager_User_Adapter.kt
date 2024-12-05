package com.example.stickerly.Adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.stickerly.Fragment.User_Fragment

class ViewPager_User_Adapter(activity: User_Fragment, private val fragment:List<Fragment>) :FragmentStateAdapter(activity){
    override fun getItemCount(): Int {
        return fragment.size
    }

    override fun createFragment(position: Int): Fragment = fragment[position]
}