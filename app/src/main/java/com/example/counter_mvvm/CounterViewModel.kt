import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.counter_mvvm.CounterState
import com.example.counter_mvvm.SingleLiveEvent


class CounterViewModel(private val startValue: Int) : ViewModel() {

    private val counterStateLiveData = MutableLiveData<CounterState>(CounterState(startValue, true))
    fun observeCounterState(): LiveData<CounterState> = counterStateLiveData
    private val showMessageLiveData = SingleLiveEvent<String>()
    fun observeShowMessage(): LiveData<String> = showMessageLiveData

    fun incrementCounter() {
        val value = counterStateLiveData.value?.counterValue?.plus(1) ?: startValue
        val enabled = value < 15
        counterStateLiveData.postValue(CounterState(value, enabled))
        if (value == 10) {
            showMessageLiveData.postValue("Осталось 5")
        }
    }

    companion object {
        fun getFactory(value: Int): ViewModelProvider.Factory = viewModelFactory {
            initializer {
                CounterViewModel(value)
            }
        }
    }
}