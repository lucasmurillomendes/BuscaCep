package com.lucas.buscacep.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Cep (
    val cep : String,
    val logradouro : String,
    val complemento: String,
    val bairro : String,
    val localidade: String,
    val uf : String,
    val ibge : String
) : Parcelable