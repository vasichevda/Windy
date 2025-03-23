package com.example.windy

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MainCompose(viewModel: MainViewModel) {

    var input by remember { mutableStateOf("") } //input value
    val result by viewModel.result.collectAsState() //result of flows
    val isDisable by viewModel.isRunning.collectAsState() //state of the btn

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        //input field
        TextField(
            value = input,
            onValueChange = { input = it },
            label = { Text("input N") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
        )

        Spacer(modifier = Modifier.height(16.dp))

        //launch btn
        Button(
            onClick = {
                viewModel.startFlow(input.toIntOrNull())
            },
            modifier = Modifier.fillMaxWidth(),
            enabled = !isDisable //disable btn while running
        ) {
            Text("run")
        }

        Spacer(modifier = Modifier.height(16.dp))

        //result field
        Text(
            text = result,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MainCompose(viewModel = MainViewModel())
}
