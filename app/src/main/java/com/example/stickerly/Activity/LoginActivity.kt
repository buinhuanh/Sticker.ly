package com.example.stickerly.Activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.stickerly.R
import com.example.stickerly.databinding.ActivityLoginBinding

class LoginActivity : BaseActivity() {
    private lateinit var binding:ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.layout.setOnClickListener {
            val i=Intent(this@LoginActivity,MainActivity::class.java)
            startActivity(i)
        }

    }
}