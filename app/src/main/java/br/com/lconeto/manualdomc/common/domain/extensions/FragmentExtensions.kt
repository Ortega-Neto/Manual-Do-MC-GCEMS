package br.com.lconeto.manualdomc.common.domain.extensions

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

fun Fragment.setTitleName(title: String) {
    (requireActivity() as AppCompatActivity).supportActionBar?.title = title
}
