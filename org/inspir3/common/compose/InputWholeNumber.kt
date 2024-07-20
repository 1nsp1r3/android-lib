/**
 * DO NOT EDIT
 * See android-lib project
 */
package org.inspir3.common.compose

import android.util.Log
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType

@Composable
fun InputWholeNumber(
    label: String,
    value: MutableState<String>,
    onUpdate: (Long) -> Unit,
) {
    var text by rememberSaveable { value }
    var isError by rememberSaveable { mutableStateOf(false) }

    fun validate(text: String) {
        if (text.matches(Regex("^[0-9]+$"))) {
            onUpdate(text.toLong())
            isError = false
        } else {
            onUpdate(0)
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
