package com.alura.listfilme

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(
    val id: Int,
    val titulo: String,
    val descricao: String?,
    val image: String?,
    @SerializedName("data_lancamento")
    val datalancamento: String?,

    ): Parcelable