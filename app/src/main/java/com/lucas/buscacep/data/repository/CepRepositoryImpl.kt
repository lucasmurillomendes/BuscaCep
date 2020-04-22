package com.lucas.buscacep.data.repository

import com.lucas.buscacep.data.retrofitConf.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext

class CepRepositoryImpl(
    private val api: ApiService = ApiService
) : CepRepository {

    override suspend fun getCep(cep: String) = withContext(Dispatchers.IO) {
        async { api.service.getCep(cep).mapFrom().toResource() }
    }
}