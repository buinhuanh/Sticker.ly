package com.example.stickerly.Activity

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.example.stickerly.Fragment.Bell_Fragment
import com.example.stickerly.Fragment.Home_Fragment
import com.example.stickerly.Fragment.Search_Fragment
import com.example.stickerly.Fragment.User_Fragment
import com.example.stickerly.R
import com.example.stickerly.ViewModel.MainViewModel
import com.example.stickerly.databinding.ActivityMainBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

class MainActivity : BaseActivity() {
    lateinit var dialog:AlertDialog
    private var viewModel=MainViewModel()
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initListFragment()
        initPlus()







    }

    private fun initPlus() {
        binding.fabPlus.setOnClickListener {
            showDialog()
        }
    }

    private fun showDialog() {
        val dialog= BottomSheetDialog(this)
        val view=layoutInflater.inflate(R.layout.dialog_plus_bottom_nativigation,null)
        val btnBack=view.findViewById<ImageView>(R.id.btnBack)
        btnBack.setOnClickListener {
            dialog.dismiss()
        }
//        dialog.setCancelable(false)
        dialog.setContentView(view)
        dialog.show()
    }

    private fun initListFragment() {
         supportFragmentManager.beginTransaction()
             .replace(R.id.viewFragment,Home_Fragment())
             .commit()
         binding.menu.setOnItemSelectedListener { item->
             var fragment=when(item){
                 R.id.home ->Home_Fragment()
                 R.id.search -> Search_Fragment()
                 R.id.bell ->Bell_Fragment()
                 R.id.user -> User_Fragment()

                 else -> {
                 }
             }
             supportFragmentManager.beginTransaction()
                 .replace(R.id.viewFragment, fragment as Fragment)
                 .commit()
             true

         }
    }


}
