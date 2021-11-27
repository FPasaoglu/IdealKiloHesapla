package com.example.idealkilohesapla

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val buttonHesapla = findViewById<Button>(R.id.buttonHesapla)
        val imageView = findViewById<ImageView>(R.id.imageViewThin)

        buttonHesapla.setOnClickListener {
            imageView.setColorFilter(getColor(R.color.teal_700))
        }
    }


    fun calculateIdealWeight(height: Double, weight: Double, sex: Sex) {
        val idealWeight = when(sex) {
            Sex.MAN -> 50 + (2.3 / 2.54) * (height - 152.4)
            Sex.WOMAN -> 45.4 + (2.3 / 2.54) * (height - 152.4)
        }

        val bodyIndex = (idealWeight - weight)
    }


    override fun onStart() {
        super.onStart()
        println("onStart")
    }

    override fun onResume() {
        super.onResume()
        println("onResume")
    }

    override fun onPause() {
        super.onPause()
        println("onPause")
    }

    override fun onStop() {
        super.onStop()
        println("onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        println("onDestroy")
    }
}

enum class Sex {
    MAN, WOMAN
}