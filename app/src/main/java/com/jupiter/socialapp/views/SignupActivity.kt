package com.jupiter.socialapp.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.jupiter.socialapp.MainActivity
import com.jupiter.socialapp.R

class SignupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
    }

    fun auth(v:View){
        val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}