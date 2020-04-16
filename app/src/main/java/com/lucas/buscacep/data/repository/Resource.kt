package com.lucas.buscacep.data.repository

open class Resource<T>(
    val sucess: T?,
    val erro: String? = null
)

class SucessResource<T>(dado: T) : Resource<T>(dado)

class FailResource<T>(erro: String?) : Resource<T>(sucess = null, erro = erro)