package com.example.hello

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    private lateinit var tvLogIn:TextView
    lateinit var tilFirstName:TextInputLayout
    lateinit var  tilLastName:TextInputLayout
    lateinit var tilEmail:TextInputLayout
    lateinit var tilPassword:TextInputLayout
    lateinit var tilConfirmPassword:TextInputLayout
    lateinit var etFirstName:TextInputEditText
    lateinit var etLastName:TextInputEditText
    lateinit var etPassword:TextInputEditText
    lateinit var etEmail: TextInputEditText
    lateinit var  etConfirmPassword:TextInputEditText
    lateinit var  btnbutton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        castViews()
        onResume()



    }

    override fun onResume() {
        super.onResume()

        tvLogIn.setOnClickListener {
            val intent=Intent(this,MainActivity2::class.java)
            startActivity(intent)
        }
        tvLogIn.setOnClickListener {
            validateSignUp() }
    }
    fun castViews(){
        tvLogIn=findViewById(R.id.tvLogIn)
        tilFirstName=findViewById(R.id.tilFirstName)
        tilLastName=findViewById(R.id.tilLastName)
        tilEmail=findViewById(R.id.tilEmail)
        tilConfirmPassword=findViewById(R.id.tilConfirmPassword)
        tilPassword=findViewById(R.id.tilPassword)
        btnbutton=findViewById(R.id.btnbutton)


    }

    fun validateSignUp(){
        val firstName=etFirstName.text.toString()
        val lastName=etLastName.text.toString()
        val email=etEmail.text.toString()
        val password=etPassword.text.toString()
        val confirmPassword=etConfirmPassword.text.toString()
        var error=false

        if(firstName.isBlank()){
            tilFirstName.error="Firstname is required"
            error=true
        }
        if(lastName.isBlank()){
            tilLastName.error="Lastname is required"
            error=true
        }
            if(email.isBlank()){
            tilEmail.error="Email is required"
                error=true
        }
            if(password.isBlank()){
            tilPassword.error="Password is required"
                error=true
        }
               if(confirmPassword.isBlank()){
            tilConfirmPassword.error="Confirm password is required"
                   error=true
        }
        if(password!=confirmPassword){
            tilConfirmPassword.error="Password mismatched"
            error=true
        }
          if(!error){
              Toast.makeText(this,"$firstName, $lastName,$email",Toast.LENGTH_LONG)
                  .show()
          }



    }


}