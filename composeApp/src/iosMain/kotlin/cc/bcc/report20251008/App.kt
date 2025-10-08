package cc.bcc.report20251008

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun App() {
    MaterialTheme {
        var mainText by remember { mutableStateOf("") }
        var showDialog by remember { mutableStateOf(false) }
        var dialogText by remember { mutableStateOf("") }

        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.primaryContainer)
                .safeContentPadding()
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            OutlinedTextField(
                value = mainText,
                onValueChange = { mainText = it },
                label = { Text("Main Text") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = { showDialog = true }) {
                Text("Open Dialog")
            }
        }

        if (showDialog) {
            AlertDialog(
                onDismissRequest = { showDialog = false },
                title = { Text("Dialog") },
                text = {
                    OutlinedTextField(
                        value = dialogText,
                        onValueChange = { dialogText = it },
                        label = { Text("Dialog Text") },
                        modifier = Modifier.fillMaxWidth()
                    )
                },
                confirmButton = {
                    Button(onClick = { showDialog = false }) {
                        Text("Close")
                    }
                }
            )
        }
    }
}