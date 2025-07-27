package br.com.lconeto.manualdomc.projects.index.data

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.parcelize.Parcelize

@Parcelize
data class ProjectVO(
    val code: EnumProjects,
    @DrawableRes
    val image: Int,
    val name: String,
    val description: String,
    val pdfFileName: String
) : Parcelable
