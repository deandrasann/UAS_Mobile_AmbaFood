package com.example.ambafood

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ambafood.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var prefManager: PrefManager
    private var usernameAccount = "Rusdi"
    private var noMeja ="16"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        prefManager = PrefManager.getInstance(this)

        with(binding) {
            btnMenu.setOnClickListener {
                val usernameInput = editName.text.toString()
                val mejaInput = editMeja.text.toString()

                if (usernameInput == usernameAccount && mejaInput == noMeja) {
                    prefManager.saveUsername(usernameInput)
                    checkLoginStatus()
                } else {
                    Toast.makeText(
                        this@LoginActivity,
                        "Username atau nomor meja tidak tersedia",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }
    private fun checkLoginStatus(){
        val username = prefManager.getUsername()
        if (username.isNotEmpty()){
            startActivity(Intent(this@LoginActivity, MainActivity::class.java))
            finish()
        }
    }
}