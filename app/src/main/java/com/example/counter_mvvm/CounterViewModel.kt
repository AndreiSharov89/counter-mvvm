import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory


class CounterViewModel(private val startValue: Int) : ViewModel() {

    private val counterLiveData = MutableLiveData<Int>(startValue)
    fun observeCounter(): LiveData<Int> = counterLiveData
    private val isIncrementEnabledLiveData = MutableLiveData<Boolean>(true)
    fun observeIsIncrementEnabled(): LiveData<Boolean> = isIncrementEnabledLiveData

    fun incrementCounter() {
        counterLiveData.postValue(counterLiveData.value?.plus(1))
        val value = counterLiveData.value ?: startValue
        val enabled = value <= 15
        isIncrementEnabledLiveData.postValue(enabled)
    }

    companion object {
        fun getFactory(value: Int): ViewModelProvider.Factory = viewModelFactory {
            initializer {
                CounterViewModel(value)
            }
        }
    }
}