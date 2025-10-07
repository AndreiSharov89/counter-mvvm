package ru.yandex.practicum.mvvm

import CounterViewModel
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.counter_mvvm.R

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: CounterViewModel

    private lateinit var counter: TextView
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startValue = 7

        viewModel = ViewModelProvider(
            this,
            CounterViewModel.getFactory(startValue)
        ).get(CounterViewModel::class.java)

        counter = findViewById(R.id.counter)
        button = findViewById(R.id.button)

        counter.text = viewModel.getCounter()

        button.setOnClickListener {
            viewModel.incrementCounter()
            counter.text = viewModel.getCounter()
        }
    }
}