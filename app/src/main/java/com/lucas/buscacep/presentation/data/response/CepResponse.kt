package com.lucas.buscacep.presentation.data.response

import com.lucas.buscacep.presentation.data.model.Cep
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CepResponse(
    @Json(name = "cep")
    val cep : String,
    @Json(name = "logradouro")
    val logradouro : String,
    @Json(name = "complemento")
    val bairro : String,
    @Json(name = "bairro")
    val localidade: String,
    @Json(name = "localidade")
    val uf : String,
    @Json(name = "ibge")
    val ibge : String
){
    fun getModel() = Cep(
        cep = this.cep,
        logradouro = this.logradouro,
        bairro = this.bairro,
        localidade = this.localidade,
        uf = this.uf,
        ibge = this.ibge
    )
}

