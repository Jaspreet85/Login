package com.JaspreetKaur.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.*
import androidx.core.widget.doOnTextChanged

class MainScreenActivity : AppCompatActivity() {
    lateinit var etName: EditText
    lateinit var etMail: EditText
    lateinit var etphone: EditText
    lateinit var etPassword: EditText
    lateinit var etConPass: EditText
    lateinit var rgGender: RadioGroup
    lateinit var rbHe: RadioButton
    lateinit var rbShe: RadioButton
    lateinit var rbOther: RadioButton
    lateinit var etOtherName: EditText
    lateinit var btnSign: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_screen)

        etName = findViewById(R.id.etName)
        etOtherName = findViewById(R.id.etOtherName)
        etMail = findViewById(R.id.etMail)
        etphone = findViewById(R.id.etphone)
        etPassword = findViewById(R.id.etPassword)
        etConPass = findViewById(R.id.etConPass)
        rbHe = findViewById(R.id.rbHe)
        rbShe = findViewById(R.id.rbShe)
        rbOther = findViewById(R.id.rbOther)
        rgGender = findViewById(R.id.rgGender)
        btnSign = findViewById(R.id.btnSign)

        rgGender.setOnCheckedChangeListener { radioGroup, id ->
            when(id){
                R.id.rbOther->{
                    Toast.makeText(this, resources.getString(R.string.others), Toast.LENGTH_LONG).show()
                    etOtherName.visibility = View.VISIBLE
                }
                else->{
                    etOtherName.visibility = View.GONE
                }
            }
        }



        btnSign.setOnClickListener {
            System.out.println("SIGNUP Clicked")

            var name = etName.text.toString()
            var email = etMail.text.toString()
            var phone = etphone.text.toString()
          var password = etPassword.text.toString()
        var conPass = etConPass.text.toString()
          var otherName = etOtherName.text.toString()


            System.out.println("name $name")
            if (name.isNullOrEmpty()) {
                etName.error = resources.getString(R.string.enter_name)
                etName.requestFocus()
            }
            else if (email.isNullOrEmpty() || (!Patterns.EMAIL_ADDRESS.matcher(email).matches())) {
                etMail.error = resources.getString(R.string.please_enter_email)
                etMail.requestFocus()

            }
            else if (phone.isNullOrEmpty() || (phone.length<10)) {
                etphone.error = resources.getString(R.string.enter_your_phone_number)
                etphone.requestFocus()
            }
         else if (password.isNullOrEmpty() ) {
                 etPassword.error = resources.getString(R.string.enter_password)
                etPassword.requestFocus()
            }
        else if (conPass.isNullOrEmpty()) {
                etConPass.error = resources.getString(R.string.Re_enter_password)
                etConPass.requestFocus()
            }
       else if (conPass != password){
                etConPass.error = resources.getString(R.string.password_should_be_same)
                etConPass.requestFocus()
            }

         else if ((etOtherName.visibility == View.VISIBLE) && (otherName.isNullOrEmpty())) {
                etOtherName.error = resources.getString(R.string.enter_other_name)
                etOtherName.requestFocus()
            }

            else {
                Toast.makeText(
                    this,
                    resources.getString(R.string.SignUp_successfully),
                    Toast.LENGTH_LONG
                ).show()
                finish()
            }
        }
    }
}







