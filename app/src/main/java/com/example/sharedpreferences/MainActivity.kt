package com.example.sharedpreferences

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.sharedpreferences.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding
class MainActivity : AppCompatActivity() {
    var dem=0
    var send :String?=null
    var message:String?=null
    var isChecked:Boolean?=null
    lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnDem.setOnClickListener {
            dem++
            binding.btnDem.text=dem.toString()
        }
    }

    override fun onPause() {
        super.onPause()
        saveData()
    }

    override fun onResume() {
        super.onResume()
        callData()
    }

    private fun callData() {
        sharedPreferences=this.getSharedPreferences("saveData",Context.MODE_PRIVATE)
        send=sharedPreferences.getString("Key_send",null)
        message=sharedPreferences.getString("Key_mes",null)
        dem=sharedPreferences.getInt("Key_dem",0)
        isChecked=sharedPreferences.getBoolean("Key_checkbox",false)
        binding.edtSend.setText(send)
        binding.edtMessage.setText(message)
        binding.btnDem.text.toString()
        binding.checkBox.isChecked=isChecked!!

    }

    private fun saveData() {
    sharedPreferences=this.getSharedPreferences("saveData",Context.MODE_PRIVATE)
        send= binding.edtSend.text.toString()
        message= binding.edtMessage.text.toString()
        isChecked= binding.checkBox.isChecked

        val editor=sharedPreferences.edit()
        editor.putString("Key_send",send)
        editor.putString("Key_mes",message)
        editor.putInt("Key_dem",dem)
        editor.putBoolean("Key_checkbox",isChecked!!)
        editor.apply()
        Toast.makeText(applicationContext,"đã lưu thông tin",Toast.LENGTH_SHORT).show()
    }
}