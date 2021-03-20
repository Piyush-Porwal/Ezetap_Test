package com.ezetap.test.utils.extensions

import android.content.Context
import android.content.pm.ActivityInfo
import android.net.Uri
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.FrameLayout
import androidx.annotation.LayoutRes
import androidx.annotation.StringRes
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.dialog.MaterialAlertDialogBuilder

/**
 * Extension function to inflate a databinding layout from a Fragment
 *
 * Call this function from [Fragment.onCreateView] to get [ViewDataBinding]
 *
 * @param layoutId Int Layout resource id
 * @param container parent layout
 *
 *
 * @return ViewDataBinding binding for layout resource
 */
fun <T : ViewDataBinding> Fragment.setDataBindingView(
    @LayoutRes
    layoutId: Int,
    container: ViewGroup?
): T =
    (DataBindingUtil.inflate(
        layoutInflater,
        layoutId,
        container,
        false
    ) as T).apply {

        // Setting lifecycle owner to viewLifecycleOwner for databinding with LiveData
        lifecycleOwner = viewLifecycleOwner
    }



/**
 * Extension function for showing Snackbar with type [SnackbarType.Warning]
 *
 *  @param text Warning message
 */
fun Fragment.showWarningSnackbar(text: String) {
    (requireActivity() as? AppCompatActivity)?.showSnackbar(text, SnackbarType.Warning)
}

/**
 * Extension function for showing Snackbar with type [SnackbarType.Error]
 *
 * @param text Error message
 */
fun Fragment.showErrorSnackbar(text: String) {
    (requireActivity() as? AppCompatActivity)?.showSnackbar(text, SnackbarType.Error)
}

/**
 * Extension function for showing Snackbar with type [SnackbarType.Success]
 *
 * @param text Success message
 */
fun Fragment.showSuccessSnackbar(text: String) {
    (requireActivity() as? AppCompatActivity)?.showSnackbar(text, SnackbarType.Success)
}


