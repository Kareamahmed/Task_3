package com.example.task_3

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.task_3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var biding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        biding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(biding.root)
        biding.button.setOnClickListener {

            val userName = biding.username.text.toString().trim()
            val password = biding.password.text.toString().trim()

            val containsNumber = password.any { it.isDigit() }
            val containsLetter = password.any { it.isLetter() }

            if (userName.isBlank())
                biding.rs.text = "Enter your username"
            else if (password.isBlank())
                biding.rs.text = "Enter your password"
            else if (password.length < 8 || !containsNumber || !containsLetter)
                biding.rs.text = "Weak Password "
            else {
                val intent = Intent(this,SecondActivity::class.java)
                intent.putExtra("name",userName)
                startActivity(intent)
                finish()
            }
        }

    }
}