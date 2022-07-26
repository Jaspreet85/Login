package com.JaspreetKaur.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class ForgetPassword : AppCompatActivity() {
    lateinit var etMail: EditText
    lateinit var btnForgetPassword: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forget_password)

        etMail = findViewById(R.id.etMail)
        btnForgetPassword = findViewById(R.id.btnForgetPassword)

        btnForgetPassword.setOnClickListener {
            if (etMail.text.toString().isNullOrEmpty()) {
                etMail.error = resources.getString(R.string.please_enter_email)
                etMail.requestFocus()

            } else {
                var intent = Intent(this, OtpActivity::class.java)
                intent.putExtra("email", etMail.text.toString())
                startActivity(intent)
            }

        }
    }
}

