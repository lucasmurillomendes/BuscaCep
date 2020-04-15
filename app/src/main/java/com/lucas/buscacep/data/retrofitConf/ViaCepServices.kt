package com.lucas.buscacep.data.retrofitConf

import com.lucas.buscacep.data.response.CepResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ViaCepServices {
    @GET("{cep}/json/")
    fun getCep(
        @Path("cep") cep: String
    ): Call<CepResponse>

}