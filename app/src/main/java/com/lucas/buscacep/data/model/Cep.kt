package com.lucas.buscacep.data.model

import android.os.Parcelable
import com.lucas.buscacep.data.repository.SucessResource
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Cep(
    val cep: String,
    val logradouro: String = "Não encontrado",
    val complemento: String = "Não encontrado",
    val bairro: String = "Não encontrado",
    val cidade: String = "Não encontrado",
    val estado: String = "Não encontrado",
    val ibge: String = "Não encontrado"
) : Parcelable {

    fun toResource() = SucessResource(this)
}