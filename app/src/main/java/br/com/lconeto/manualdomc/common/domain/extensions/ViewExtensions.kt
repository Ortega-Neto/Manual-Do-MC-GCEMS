package br.com.lconeto.manualdomc.common.domain.extensions

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.view.View

private const val COPIED_TEXT = "Copied Text"
fun View.copyTextToClipboard(text: String) {
    val clipboard = this.context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
    val clip = ClipData.newPlainText(COPIED_TEXT, text)
    clipboard.setPrimaryClip(clip)
}
