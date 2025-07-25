package br.com.lconeto.manualdomc.common.data.entity.check

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CheckObservation(
    val textId: Int
) : Parcelable
