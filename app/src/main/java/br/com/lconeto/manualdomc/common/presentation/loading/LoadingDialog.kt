package br.com.lconeto.manualdomc.common.presentation.loading

import android.content.Context
import androidx.core.content.ContextCompat
import br.com.lconeto.manualdomc.R
import cn.pedant.SweetAlert.SweetAlertDialog

class LoadingDialog(
    val context: Context,
    private var message: String
) {
    private val dialog: SweetAlertDialog =
        SweetAlertDialog(
            this.context,
            SweetAlertDialog.PROGRESS_TYPE
        )

    fun setText(message: String) {
        dialog.titleText = message
    }

    fun show(isCancelable: Boolean = false) {
        dialog.progressHelper.barColor = ContextCompat.getColor(context, R.color.colorPrimaryVariant)
        dialog.titleText = this.message
        dialog.setCancelable(isCancelable)
        dialog.show()
    }

    fun dismiss() {
        dialog.cancel()
    }
}
