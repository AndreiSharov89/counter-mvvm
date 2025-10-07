import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.counter_mvvm.R


class CounterViewModel(
    private val startValue: Int,
    private val prefix: String
) : ViewModel() {

    private var counterValue = startValue

    fun getCounter(): String {
        return prefix + " " + counterValue
    }

    fun incrementCounter() {
        counterValue++
    }

    override fun onCleared() {
        super.onCleared()
        counterValue = 0
    }

    companion object {
        fun getFactory(value: Int): ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val app = (this[APPLICATION_KEY] as Application)
                val text = app.getString(R.string.counter_prefix)
                CounterViewModel(value, text)
            }
        }
    }

} 