package com.example.windy

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val _result = MutableStateFlow("")
    val result: StateFlow<String> = _result

    private val _isRunning = MutableStateFlow(false)
    val isRunning: StateFlow<Boolean> = _isRunning

    fun startFlow(n: Int?) {
        if (n != null && n > 0) {
            viewModelScope.launch {
                _result.value = "" //clear result
                _isRunning.value = true //disable btn
                var currentSum = 0
                val resultStringBuilder = StringBuilder()

                //flow logic
                val flows = Array(n) { index ->
                    flow {
                        delay((index + 1) * 100L)
                        emit(index + 1)
                    }
                }

                val jobList = mutableListOf<Job>()

                flows.forEach { flow ->
                    val job = launch {
                        flow.collect { value ->
                            currentSum += value
                            resultStringBuilder.append("$currentSum\n")
                            _result.value = resultStringBuilder.toString()
                        }
                    }
                    jobList.add(job)
                }

                jobList.forEach { it.join() }

                _isRunning.value = false //able btn
            }
        } else {
            _result.value = "Please input a correct number"
            _isRunning.value = false //able btn
        }
    }
}
