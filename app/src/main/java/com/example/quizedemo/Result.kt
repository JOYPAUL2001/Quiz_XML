package com.example.quizedemo

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.quizedemo.databinding.ActivityMainBinding
import com.example.quizedemo.databinding.ActivityResultBinding

class Result : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding
    private var name:String? = null
    private var correctAns: Int = 0
    private var TotalAns:Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityResultBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        name = intent.getStringExtra(Constants.USER_NAME)
        correctAns = intent.getIntExtra(Constants.CORRECT_ANSWER,0)
        TotalAns = intent.getIntExtra(Constants.TOTAL_QUESTION,0)

        binding.resultName.text = name
        binding.resultScore.text = "Your score is $correctAns out of $TotalAns"
        binding.resultFinish.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}