package com.lucas.buscacep.data.repository

import com.lucas.buscacep.data.model.Cep
import kotlinx.coroutines.Deferred

interface CepRepository {
    suspend fun getCep(cep: String): Deferred<Resource<Cep>>
}