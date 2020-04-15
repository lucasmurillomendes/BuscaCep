package com.lucas.buscacep.presentation.data.model

data class Cep (
    val cep : String,
    val logradouro : String,
    val bairro : String,
    val localidade: String,
    val uf : String,
    val ibge : String
)