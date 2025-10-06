package ru.yandex.practicum.mvvm

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.counter_mvvm.R

class MainActivity : AppCompatActivity() {

    private lateinit var counter: TextView
    private lateinit var button: Button

    private var value = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        counter = findViewById(R.id.counter)
        button = findViewById(R.id.button)

        counter.text = value.toString()

        button.setOnClickListener {
            counter.text = (++value).toString()
        }
    }
}