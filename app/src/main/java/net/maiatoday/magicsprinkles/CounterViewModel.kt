package net.maiatoday.magicsprinkles

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class CounterViewModel @Inject constructor(): ViewModel() {
    private val _counter = MutableStateFlow(0)
    val counter: StateFlow<Int> = _counter

    fun onClick() {

    }
}