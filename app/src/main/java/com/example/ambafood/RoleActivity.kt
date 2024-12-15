package com.example.ambafood

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ambafood.databinding.ActivityRoleBinding

class RoleActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRoleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRoleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ArrayAdapter.createFromResource(
            this,
            R.array.role,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.spinnerRole.adapter = adapter
        }

        binding.btnMenu.setOnClickListener {
            val selectedRole = binding.spinnerRole.selectedItem.toString()
            when (selectedRole) {
                "Admin" -> {
                    val intent = Intent(this, AdminActivity::class.java)
                    startActivity(intent)
                }
                "Pelanggan" -> {
                    val intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent)
                }
                else -> {
                    Toast.makeText(this, "Pilih role yang valid", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
