package com.example.quizedemo

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.quizedemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.save.setOnClickListener {
            //Log.d("First Tag", "onCreate: Joydeep")
            if(binding.name.text.isEmpty()){
                Toast.makeText(this@MainActivity,"Enter your name!",Toast.LENGTH_SHORT).show()
            }
            else{
                val intent = Intent(this@MainActivity, QuizQuestion::class.java)
                intent.putExtra(Constants.USER_NAME,binding.name.text.toString())
                startActivity(intent)
                finish()
            }
        }
    }
}