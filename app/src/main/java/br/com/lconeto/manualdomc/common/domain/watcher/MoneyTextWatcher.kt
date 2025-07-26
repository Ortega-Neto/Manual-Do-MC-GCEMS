package br.com.lconeto.manualdomc.common.domain.watcher

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import java.lang.ref.WeakReference
import java.math.BigDecimal
import java.math.RoundingMode

class MoneyTextWatcher(editText: EditText) : TextWatcher {
    private val editTextWeakReference: WeakReference<EditText> = WeakReference<EditText>(editText)

    override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) = Unit

    override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) = Unit

    override fun afterTextChanged(editable: Editable) {
        val editText = editTextWeakReference.get() ?: return
        editText.removeTextChangedListener(this)

        val valueWithoutFormat = parseToBigDecimal(editable.toString())
        val formatted = formatDoubleToReal(valueWithoutFormat.toString().toDouble())

        editText.setText(formatted)
        editText.setSelection(formatted.length)
        editText.addTextChangedListener(this)
    }

    private fun parseToBigDecimal(value: String): BigDecimal {
        val replaceable = String.format("[%s,.\\s]", "R$")
        val cleanString = value.replace(replaceable.toRegex(), "")
        val valueBigDecimal = BigDecimal(cleanString)

        return valueBigDecimal.setScale(
            TWO,
            RoundingMode.FLOOR
        ).divide(
            BigDecimal(ONE_HUNDRED),
            RoundingMode.FLOOR
        )
    }

    private fun formatDoubleToReal(valor: Double): String {
        val formattedValue = valor.formatMonetary()
        return "R$ $formattedValue"
    }

    private fun Double.formatMonetary() =
        toInt()
            .toString()
            .reversed()
            .chunked(THREE)
            .joinToString(".")
            .reversed() +
            if (this % 1 > 0) {
                val stringDecimal = this.toString().substringAfter(".")
                if (stringDecimal.length == 1) ",${stringDecimal}0" else ",${stringDecimal.substring(0,2)}"
            } else {
                ",00"
            }

    private companion object {
        const val TWO = 2
        const val THREE = 3
        const val ONE_HUNDRED = 100
    }
}
