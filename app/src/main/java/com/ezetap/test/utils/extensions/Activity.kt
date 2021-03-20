package com.ezetap.test.utils.extensions

import android.app.Activity
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.google.android.material.snackbar.Snackbar


/**
 * File will contain all the extension functions for [Activity]s
 */

fun <T : ViewDataBinding> Activity.setDataBindingView(layoutId: Int): T =
        DataBindingUtil.setContentView(this, layoutId)

/**
 * Extension function to create and show a Snackbar
 *
 * Also customised the Snackbar ui for app
 *
 * @param text message for Snackbar
 * @param snackBarType Type of Snackbar [SnackbarType]
 */
fun AppCompatActivity.showSnackbar(
    text: String,
    snackBarType: SnackbarType = SnackbarType.Success
) {

    val contentView = findViewById<View>(android.R.id.content)
    val snackbar = Snackbar.make(contentView, "", Snackbar.LENGTH_LONG)

    // Customise the Snackbar using an extension function
    snackbar.customiseForEzetap(text, snackBarType)

    snackbar.show()
}

/**
 * Extension function for showing Snackbar with type [SnackbarType.Warning]
 *
 *  @param text Warning message
 */
fun AppCompatActivity.showWarningSnackbar(text: String) =
        showSnackbar(text, SnackbarType.Warning)

/**
 * Extension function for showing Snackbar with type [SnackbarType.Error]
 *
 * @param text Error message
 */
fun AppCompatActivity.showErrorSnackbar(text: String) =
        showSnackbar(text, SnackbarType.Error)

/**
 * Extension function for showing Snackbar with type [SnackbarType.Success]
 *
 * @param text Success message
 */
fun AppCompatActivity.showSuccessSnackbar(text: String) =
        showSnackbar(text, SnackbarType.Success)
