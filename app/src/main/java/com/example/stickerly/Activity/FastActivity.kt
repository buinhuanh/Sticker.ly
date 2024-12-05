package com.example.stickerly.Activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.stickerly.R
import com.example.stickerly.databinding.ActivityFastBinding

class FastActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFastBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding=ActivityFastBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.imageView2.alpha = 0f
        binding.imageView2.animate().alpha(1f).setDuration(2500).withEndAction {
            val i = Intent(this, LoginActivity::class.java)
            startActivity(i)
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        }

        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed({
            finish()
        }, 3000)
    }
}