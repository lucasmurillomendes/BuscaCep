package com.lucas.buscacep.presentation.data.retrofitConf

import com.lucas.buscacep.presentation.data.response.CepResponse
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object ApiService {
    private fun initRetrofit():Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://viacep.com.br/ws/")
            .addConverterFactory(
                MoshiConverterFactory.create(
                    Moshi.Builder()
                        .add(KotlinJsonAdapterFactory())
                        .build()
                )
            )
            .build()
    }
    val service: ViaCepServices = initRetrofit().create(ViaCepServices::class.java)
}