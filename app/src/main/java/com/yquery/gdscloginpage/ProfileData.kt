package com.yquery.gdscloginpage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yquery.gdscloginpage.databinding.ActivityProfileDataBinding

class ProfileData : AppCompatActivity() {

    private lateinit var binding : ActivityProfileDataBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileDataBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        title = "Profile"

        val profileTextView = binding.profileText

        val bundle = intent.extras!!

        val name = bundle.get("name")
        val email = bundle.get("email")
        val phone = bundle.get("phone")

        if (name.toString() == "null"){
            profileTextView.text = "Email : $email\nPhone : $phone"
        }else {
            profileTextView.text = "Name : $name\nEmail : $email\nPhone : $phone"
        }

    }
}