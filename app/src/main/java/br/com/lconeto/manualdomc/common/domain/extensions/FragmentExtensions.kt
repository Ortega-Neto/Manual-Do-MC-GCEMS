package br.com.lconeto.manualdomc.common.domain.extensions

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController

fun Fragment.setTitleName(title: String) {
    (requireActivity() as AppCompatActivity).supportActionBar?.title = title
}

fun Fragment.toastMessage(message: String) {
    Toast.makeText(requireContext(), message, Toast.LENGTH_LONG).show()
}

fun Fragment.navigateTo(action: NavDirections) {
    val navController = findNavController()
    navController.navigate(action)
}

private const val COPIED_TEXT = "Copied Text"
fun Fragment.copyTextToClipboard(text: String) {
    val clipboard = requireContext().getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
    val clip = ClipData.newPlainText(COPIED_TEXT, text)
    clipboard.setPrimaryClip(clip)
}
