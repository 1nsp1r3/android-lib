package org.inspir3.common

import android.content.Context
import android.content.Intent

/**
 * DO NOT EDIT
 * See android-lib project
 */
class I3 {
    companion object {
        const val TAG = "Inspir3"

        inline fun <reified T : Any> switchToActivity(context: Context, klass: Class<T>) {
            val intent = Intent(context, klass)
            context.startActivity(intent)
        }
    }
}
