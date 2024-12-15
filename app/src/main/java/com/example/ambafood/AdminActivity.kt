package com.example.ambafood

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ambafood.databinding.ActivityAdminBinding

class AdminActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAdminBinding
    private lateinit var prefManager: PrefManager
    private var usernameAccount = "Rusdi"
    private var password ="16"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAdminBinding.inflate(layoutInflater)
        setContentView(binding.root)

        prefManager = PrefManager.getInstance(this)

        with(binding) {
            btnMenu.setOnClickListener {
                val usernameInput = editName.text.toString()
                val mejaInput = editMeja.text.toString()

                if (usernameInput == usernameAccount && mejaInput == password) {
                    prefManager.saveUsername(usernameInput)
                    checkLoginStatus()
                } else {
                    Toast.makeText(
                        this@AdminActivity,
                        "Username atau password salah",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }
    private fun checkLoginStatus(){
        val username = prefManager.getUsername()
        if (username.isNotEmpty()){
            startActivity(Intent(this@AdminActivity, MenuActivity::class.java))
            finish()
        }
    }
}