package com.example.toasthandler

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1. Toast
        val buttonOk = findViewById<Button>(R.id.button_ok)

        buttonOk.setOnClickListener {
            Toast.makeText(
                this,
                "Кнопка ОК",
                Toast.LENGTH_SHORT
            ).show()
        }

        // 2. Log и Timber
        val editTextLog = findViewById<EditText>(R.id.editTextLog)
        val buttonLog = findViewById<Button>(R.id.button_log)
        val buttonTimber = findViewById<Button>(R.id.button_timber)

        if (Timber.treeCount == 0) {
            Timber.plant(Timber.DebugTree())
        }

        buttonLog.setOnClickListener {
            val text = editTextLog.text.toString()

            Log.v(
                "From EditText",
                text
            )
        }

        buttonTimber.setOnClickListener {
            val text = editTextLog.text.toString()
            Timber.v(text)
        }

        // 3. Атрибуты
        val editTextAttributes =
            findViewById<EditText>(R.id.editTextAttributes)

        val buttonBlack =
            findViewById<Button>(R.id.button_black)

        val buttonRed =
            findViewById<Button>(R.id.button_red)

        val buttonSize8 =
            findViewById<Button>(R.id.button_size_8)

        val buttonSize24 =
            findViewById<Button>(R.id.button_size_24)

        val buttonWhite =
            findViewById<Button>(R.id.button_white)

        val buttonYellow =
            findViewById<Button>(R.id.button_yellow)

        buttonBlack.setOnClickListener {
            editTextAttributes.setTextColor(Color.BLACK)
        }

        buttonRed.setOnClickListener {
            editTextAttributes.setTextColor(Color.RED)
        }

        buttonSize8.setOnClickListener {
            editTextAttributes.textSize = 8f
        }

        buttonSize24.setOnClickListener {
            editTextAttributes.textSize = 24f
        }

        buttonWhite.setOnClickListener {
            editTextAttributes.setBackgroundColor(Color.WHITE)
        }

        buttonYellow.setOnClickListener {
            editTextAttributes.setBackgroundColor(Color.YELLOW)
        }
    }
}