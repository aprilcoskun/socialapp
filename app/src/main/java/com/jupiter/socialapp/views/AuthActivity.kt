package com.jupiter.socialapp.views

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.jupiter.socialapp.R


class AuthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)
    }

    fun signup(v: View){
        val intent = Intent(this, SignupActivity::class.java).also {
            startActivity(it)
        }
    }
    fun login(v:View){
        val intent = Intent(this, LoginActivity::class.java).apply {
            startActivity(this)
        }
    }
}