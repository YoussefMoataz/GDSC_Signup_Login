package com.yquery.gdscloginpage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.yquery.gdscloginpage.databinding.ActivitySignupPageBinding

class SignupPage : AppCompatActivity() {

    private lateinit var binding: ActivitySignupPageBinding

    lateinit var name: String
    lateinit var email: String
    lateinit var password: String

    var nameEntered: Boolean = false
    var emailEntered: Boolean = false
    var passwordEntered: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupPageBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        title = "Sign Up"

        val nameInput = binding.nameInput
        val emailInput = binding.emailInput
        val passwordInput = binding.passwordInput

        binding.signInButton.setOnClickListener {

            name = nameInput.text.toString()
            email = emailInput.text.toString()
            password = passwordInput.text.toString()

            if (name.isBlank()) {
                nameEntered = false
                nameInput.error = "Name required"
            } else {
                nameEntered = true
            }

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

            if (nameEntered && emailEntered && passwordEntered) {
//                Toast.makeText(this, "$name $email $phone", Toast.LENGTH_SHORT).show()

                val intent: Intent = Intent(this, ProfileData::class.java)

                intent.putExtra("name", name)
                intent.putExtra("email", email)
                intent.putExtra("phone", password)

                startActivity(intent)

                Toast.makeText(this, "Sign Up Successful" , Toast.LENGTH_SHORT).show()

                finish()

            }

        }

        binding.signInInstead.setOnClickListener {
            startActivity(Intent(this, LoginPage::class.java))
        }

    }
}