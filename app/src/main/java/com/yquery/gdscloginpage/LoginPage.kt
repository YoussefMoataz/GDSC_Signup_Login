package com.yquery.gdscloginpage

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.yquery.gdscloginpage.databinding.ActivityLoginPageBinding

class LoginPage : AppCompatActivity() {

    private lateinit var binding : ActivityLoginPageBinding

    lateinit var email: String
    lateinit var password: String

    var emailEntered: Boolean = false
    var passwordEntered: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginPageBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        title = "Log In"

        val emailInput = binding.emailInput
        val passwordInput = binding.passwordInput

        binding.signInButton.setOnClickListener {

            email = emailInput.text.toString()
            password = passwordInput.text.toString()

            if (email.isBlank()) {
                emailEntered = false
                emailInput.error = "Email required"
            } else {
                emailEntered = true
            }

            if (password.isBlank()) {
                passwordEntered = false
                passwordInput.error = "Phone required"
            } else {
                passwordEntered = true
            }

            if (emailEntered && passwordEntered) {
//                Toast.makeText(this, "$name $email $phone", Toast.LENGTH_SHORT).show()

                val intent: Intent = Intent(this, ProfileData::class.java)

                intent.putExtra("email", email)
                intent.putExtra("phone", password)

                startActivity(intent)

                Toast.makeText(this, "Log In Successful" , Toast.LENGTH_SHORT).show()

                finish()

            }

        }

        binding.signInInstead.setOnClickListener {
            startActivity(Intent(this, SignupPage::class.java))
            finish()
        }

    }
}