package ru.yandex.practicum.mvvm

import CounterViewModel
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.counter_mvvm.R

class MainActivity : AppCompatActivity() {

    private val viewModel: CounterViewModel by viewModels()

    private lateinit var counter: TextView
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        counter = findViewById(R.id.counter)
        button = findViewById(R.id.button)

        counter.text = viewModel.getCounter()

        button.setOnClickListener {
            viewModel.incrementCounter()
            counter.text = viewModel.getCounter()
        }
    }
}