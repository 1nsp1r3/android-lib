/**
 * DO NOT EDIT
 * See android-lib project
 */
package org.inspir3.common.compose

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType

class InputWholeNumberState {
    var value: Long by mutableLongStateOf(0)
}

@Composable
fun InputWholeNumber(
    label: String,
    inputWholeNumberState: InputWholeNumberState,
) {
    var text by remember { mutableStateOf(inputWholeNumberState.value.toString()) }
    var isError by remember { mutableStateOf(false) }

    fun validate(text: String) {
        if (text.matches(Regex("^[0-9]+$"))) {
            inputWholeNumberState.value = text.toLong()
            isError = false
        } else {
            inputWholeNumberState.value = 0
            isError = true
        }
    }

    OutlinedTextField(
        label = { Text(label) },
        value = text,
        onValueChange = {
            text = it
            validate(text)
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        isError = isError,
        supportingText = {
            if (isError) {
                Text(
                    text = "Not a whole number",
                    color = MaterialTheme.colorScheme.error
                )
            }
        },
        modifier = Modifier.fillMaxWidth(),
    )
}
