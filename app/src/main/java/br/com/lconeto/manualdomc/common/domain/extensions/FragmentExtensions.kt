package br.com.lconeto.manualdomc.common.domain.extensions

import android.Manifest
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.provider.Settings
import android.text.SpannableString
import android.text.Spanned
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import java.io.File
import java.io.FileOutputStream
import java.io.IOException

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

fun Fragment.requestStoragePermissions(requestPermissionLauncher: ActivityResultLauncher<Array<String>>) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
        if (!Environment.isExternalStorageManager()) {
            val intent = Intent(Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION)
            val uri = Uri.fromParts("package", requireContext().packageName, null)
            intent.data = uri
            startActivity(intent)
            toastMessage("Por favor, conceda permissão de gerenciamento de todos os arquivos.")
        }
    } else {
        val permissions = arrayOf(
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
        )
        val notGrantedPermissions = permissions.filter {
            ContextCompat.checkSelfPermission(requireContext(), it) != PackageManager.PERMISSION_GRANTED
        }.toTypedArray()

        if (notGrantedPermissions.isNotEmpty()) {
            requestPermissionLauncher.launch(notGrantedPermissions)
        }
    }
}

fun Fragment.openPdfFromAssets(pdfFileName: String) {
    val file = File(requireContext().cacheDir, pdfFileName)

    try {
        requireContext().assets.open(pdfFileName).use { inputStream ->
            FileOutputStream(file).use { outputStream ->
                inputStream.copyTo(outputStream)
            }
        }
        val pdfUri = FileProvider.getUriForFile(
            requireContext().applicationContext,
            requireContext().applicationContext.packageName + ".provider",
            file
        )

        val intent = Intent(Intent.ACTION_VIEW).apply {
            setDataAndType(pdfUri, "application/pdf")
            flags = Intent.FLAG_GRANT_READ_URI_PERMISSION
        }

        startActivity(intent)

    } catch (e: IOException) {
        toastMessage("Erro ao abrir o PDF do assets: ${e.message}")
        e.printStackTrace()
    } catch (e: Exception) {
        toastMessage("Nenhum aplicativo encontrado para abrir PDF.")
        e.printStackTrace()
    }
}

fun Fragment.setupLink(textView: TextView, linkText: String, url: String) {
    val fullString = SpannableString(linkText)

    val clickableSpan = object : ClickableSpan() {
        override fun onClick(widget: View) {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            try {
                startActivity(intent)
            } catch (e: Exception) {
                toastMessage("Não foi possível abrir o link.")
            }
        }
    }

    fullString.setSpan(clickableSpan, 0, linkText.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

    textView.text = fullString
    textView.movementMethod = LinkMovementMethod.getInstance()
}
