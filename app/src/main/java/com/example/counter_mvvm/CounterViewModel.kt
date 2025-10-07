import androidx.lifecycle.ViewModel

class CounterViewModel(private val startValue: Int) : ViewModel() {

    private var counterValue = startValue

    fun getCounter(): String {
        return counterValue.toString()
    }

    fun incrementCounter() {
        counterValue++
    }
} 