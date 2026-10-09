package com.example.linearlayout

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextName = findViewById<EditText>(R.id.editTextName)
        val buttonOk = findViewById<Button>(R.id.buttonOk)

        buttonOk.setOnClickListener {
            val name = editTextName.text.toString()

            Toast.makeText(
                this,
                "OK: $name",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}