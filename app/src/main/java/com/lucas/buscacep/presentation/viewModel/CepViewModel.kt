package com.lucas.buscacep.presentation.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lucas.buscacep.presentation.data.model.Cep
import com.lucas.buscacep.presentation.data.response.CepResponse
import com.lucas.buscacep.presentation.data.retrofitConf.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CepViewModel() : ViewModel() {

    val cepLiveData: MutableLiveData<List<Cep>> = MutableLiveData()

    init {
        getCep()
    }

    fun getCep(){

        ApiService.service.getCep("87490000").enqueue(object: Callback<CepResponse>{
            override fun onResponse(call: Call<CepResponse>, response: Response<CepResponse>) {
                when{
                    response.isSuccessful -> {
                        val ceps: MutableList<Cep> = mutableListOf()

                       response.body()?.let { cepResponse ->
                           val cep = cepResponse.getModel()
                           ceps.add(cep)
                       }
                        cepLiveData.value = ceps
                    }
                }
            }

            override fun onFailure(call: Call<CepResponse>, t: Throwable) {
                Log.d("Erro", t.printStackTrace().toString())
            }

        })
    }



}