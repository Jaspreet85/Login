package com.JaspreetKaur.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.core.widget.doOnTextChanged

class MainActivity : AppCompatActivity() {
    lateinit var etName: EditText
    lateinit var etPassword: EditText
    lateinit var tvForgotPassword: TextView
    lateinit var btnLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        etName = findViewById(R.id.etName)
        etPassword = findViewById(R.id.etPassword)
        tvForgotPassword = findViewById(R.id.tvForgotPassword)
        btnLogin = findViewById(R.id.btnLogin)




           tvForgotPassword.setOnClickListener {

               var intent = Intent(this, ForgetPassword::class.java)
               startActivity(intent)
           }

            btnLogin.setOnClickListener {
                System.out.println("Login Clicked")

            var name = etName.text.toString()
            var password = etPassword.text.toString()
            System.out.println("name $name")
            if(name.isNullOrEmpty()){
                etName.error = resources.getString(R.string.please_enter_name)
                etName.requestFocus()

             }
            else if (password.isNullOrEmpty()){
                etPassword.error = resources.getString(R.string.please_enter_password)
                etPassword.requestFocus()
             }
            else if (password.length<6) {
                etPassword.error = resources.getString(R.string.password_should_be_greater_than_6)
                etPassword.requestFocus()
            }
            else {
                Toast.makeText(this,resources.getString(R.string.login_successfully), Toast.LENGTH_LONG).show()
                var intent = Intent(this, MainScreenActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}

