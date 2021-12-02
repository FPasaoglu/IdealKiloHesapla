package com.example.idealkilohesapla

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }


}

enum class Gender {
    MALE, FEMALE
}

// MAN -> 50 + (2.3 / 2.54) * (height - 152.4)
// WOMAN -> 45.4 + (2.3 / 2.54) * (height - 152.4)