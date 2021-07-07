package com.example.paramedix

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SignUp : AppCompatActivity() {

    //loginInstead : EditText
    //var etEmail: EditText? = null

    lateinit var etName: EditText
    //lateinit var etLastName:EditText
    lateinit var etEmail: EditText
    lateinit var etPassword: EditText
    //lateinit var etRepeatPassword:EditText
    val MIN_PASSWORD_LENGTH = 6;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        viewInitializations()
    }

    fun viewInitializations() {
        etName = findViewById(R.id.editName)
        //etLastName = findViewById(R.id.et_last_name)
        etEmail = findViewById(R.id.editEmail)
        etPassword = findViewById(R.id.editPassword)
        // etRepeatPassword = findViewById(R.id.et_repeat_password)

        // To show back button in actionbar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    // Checking if the input in form is valid
    fun validateInput(): Boolean {
        if (etName.text.toString().equals("")) {
            etName.setError("Please Enter First Name")
            return false
        }
//        if (etLastName.text.toString().equals("")) {
//            etLastName.setError("Please Enter Last Name")
//            return false
//        }
        if (etEmail.text.toString().equals("")) {
            etEmail.setError("Please Enter Email")
            return false
        }
        if (etPassword.text.toString().equals("")) {
            etPassword.setError("Please Enter Password")
            return false
        }
//        if (etRepeatPassword.text.toString().equals("")) {
//            etRepeatPassword.setError("Please Enter Repeat Password")
//            return false
//        }

        // checking the proper email format
        if (!isEmailValid(etEmail.text.toString())) {
            etEmail.setError("Please Enter Valid Email")
            return false
        }

        // checking minimum password Length
        if (etPassword.text.length < MIN_PASSWORD_LENGTH) {
            etPassword.setError("Password Length must be more than " + MIN_PASSWORD_LENGTH + "characters")
            return false
        }

        // Checking if repeat password is same
//        if (!etPassword.text.toString().equals(etRepeatPassword.text.toString())) {
//            etRepeatPassword.setError("Password does not match")
//            return false
//        }
        return true
    }

    fun isEmailValid(email: CharSequence?): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }


    // Hook Click Event

    fun performSignUp (view: View) {
        if (validateInput()) {

            // Input is valid, here send data to your server

            val firstName = etName.text.toString()
            //val lastName = etLastName.text.toString()
            val email = etEmail.text.toString()
            val password = etPassword.text.toString()
            //val repeatPassword = etRepeatPassword.text.toString()

            Toast.makeText(this,"Login Success",Toast.LENGTH_SHORT).show()
            // Here you can call you API

        }
    }

    fun goToLogin (view :View) {
        Toast.makeText(this,"Going to the Login Page",Toast.LENGTH_SHORT).show()
        val intent = Intent(this, LoginFragment::class.java)
        // start your next activity
        startActivity(intent)
    }


}
