package net.maiatoday.magicsprinkles

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CounterViewModel @Inject constructor(): ViewModel() {
    private val _counter = MutableStateFlow(0)
    val counter: StateFlow<Int> = _counter

    private val interval = 250L

    private var counterState = CounterState.DECREMENT
    private var hasStarted = false

    fun onClick() {
        counterState = when (counterState) {
            CounterState.INCREMENT -> CounterState.DECREMENT
            CounterState.DECREMENT -> CounterState.INCREMENT
        }
        startTimer()
    }

    private fun startTimer() {
        if (!hasStarted) {
            hasStarted = true
            viewModelScope.launch {
                while (hasStarted) {
                    when (counterState) {
                        CounterState.INCREMENT -> _counter.value++
                        CounterState.DECREMENT -> _counter.value--
                    }
                    delay(interval)
                    if ((_counter.value == 0) or (_counter.value == 999999)) hasStarted = false
                }
            }
        }
    }

    enum class CounterState {
        INCREMENT,
        DECREMENT
    }
}