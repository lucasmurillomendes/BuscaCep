package com.lucas.buscacep.presentation.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lucas.buscacep.data.model.Cep
import com.lucas.buscacep.data.repository.FailResource
import com.lucas.buscacep.data.repository.Resource
import com.lucas.buscacep.data.repository.SucessResource
import com.lucas.buscacep.data.response.CepResponse
import com.lucas.buscacep.data.retrofitConf.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CepViewModel() : ViewModel() {

    val cepLiveData: MutableLiveData<Resource<Cep>> = MutableLiveData()

    fun findByCEP(cep: String) {
        ApiService.service.getCep(cep).enqueue(object : Callback<CepResponse> {
            override fun onResponse(call: Call<CepResponse>, response: Response<CepResponse>) {
                when {
                    response.isSuccessful -> {

                        response.body()?.let { cepResponse ->
                            val cepIU = cepResponse.mapFrom()
                            cepLiveData.postValue(SucessResource(cepIU))
                        }
                    }
                }
            }

            override fun onFailure(call: Call<CepResponse>, error: Throwable) {
                cepLiveData.postValue(FailResource(erro = error.message))
            }

        })
    }

}