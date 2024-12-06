package com.example.stickerly.Activity

import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.stickerly.Adapter.StickerPlusAdapter
import com.example.stickerly.R
import com.example.stickerly.ViewModel.MainViewModel
import com.example.stickerly.databinding.ActivityStickerlyPlusBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

class StickerlyPlusActivity : AppCompatActivity() {
    private lateinit var binding:ActivityStickerlyPlusBinding
    private var viewModel=MainViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding=ActivityStickerlyPlusBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initShowDialogSheet()
        initViewPlus()
    }

    private fun initViewPlus() {
        viewModel.plus.observe(this, Observer {
            binding.viewStickerlyPlus.layoutManager=LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
            binding.viewStickerlyPlus.adapter=StickerPlusAdapter(it)
        })
         viewModel.loadStickerPlus()

    }

    private fun initShowDialogSheet() {
        val dialog= BottomSheetDialog(this)
        val view=layoutInflater.inflate(R.layout.dialog_sticker_plus,null)
        dialog.dismiss()
//        dialog.setCancelable(false)
        dialog.setContentView(view)
        dialog.show()
    }
}