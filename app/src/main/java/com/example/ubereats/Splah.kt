package com.example.ubereats

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.view.WindowManager
import kotlinx.android.synthetic.main.activity_splah.*

class Splah : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splah)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        val cien = 1000.toLong()
        val timer = object: CountDownTimer(6000, 1) {
            override fun onTick(millisUntilFinished: Long) {
                cuenta.text = (millisUntilFinished/cien).toString()
            }
            override fun onFinish() {
                cuenta.text = "Bienvenido :)"
            }
        }
        timer.start()
        Handler().postDelayed({
            val intento = Intent(this, MainActivity::class.java)
            startActivity(intento)
            finish()
        }, 6500)
    }

}