package br.com.lconeto.manualdomc.contacts.index.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Contact(
    val name: String,
    val function: String,
    val email: String = "",
    val cellphone: String,
) : Parcelable
