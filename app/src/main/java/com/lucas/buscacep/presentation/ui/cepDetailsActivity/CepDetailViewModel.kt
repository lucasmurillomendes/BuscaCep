package com.lucas.buscacep.presentation.ui.cepDetailsActivity

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lucas.buscacep.data.model.Cep

class CepDetailViewModel : ViewModel() {

    private val _cepResponse: MutableLiveData<Cep> = MutableLiveData()
    val cepResponse: MutableLiveData<Cep> get() = _cepResponse

    fun addCep(cep: Cep) {
        _cepResponse.value = cep
    }


}