package com.lucas.buscacep.data.response

import com.lucas.buscacep.data.model.Cep
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CepResponse(
    @Json(name = "cep")
    val cep: String,
    @Json(name = "logradouro")
    val logradouro: String,
    @Json(name = "bairro")
    val bairro: String,
    @Json(name = "localidade")
    val localidade: String,
    @Json(name = "complemento")
    val complemento: String,
    @Json(name = "uf")
    val uf: String,
    @Json(name = "ibge")
    val ibge: String
) {
    fun mapFrom() = Cep(
        cep = this.cep,
        logradouro = this.logradouro,
        bairro = this.bairro,
        cidade = this.localidade,
        complemento = this.complemento,
        estado = this.uf,
        ibge = this.ibge
    )
}

