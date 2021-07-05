package com.jupiter.socialapp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.jupiter.socialapp.views.AuthActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler().postDelayed({
            startActivity(
                Intent(
                    this,
                    if (false) MainActivity::class.java else AuthActivity::class.java
                )
            )
            finish()
        }, 750)

    }
}
