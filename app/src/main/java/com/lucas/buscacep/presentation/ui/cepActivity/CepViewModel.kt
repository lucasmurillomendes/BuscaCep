package com.lucas.buscacep.presentation.ui.cepActivity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.lucas.buscacep.data.model.Cep
import com.lucas.buscacep.data.repository.CepRepositoryImpl
import com.lucas.buscacep.data.repository.FailResource
import com.lucas.buscacep.data.repository.Resource
import com.lucas.buscacep.presentation.ui.base.CoroutineViewModel
import kotlinx.coroutines.launch

class CepViewModel(
    private val repository: CepRepositoryImpl
) : CoroutineViewModel() {

    private val cep: MutableLiveData<Resource<Cep>> = MutableLiveData()
    private val loading: MutableLiveData<Boolean> = MutableLiveData()
    private val error: MutableLiveData<Throwable> = MutableLiveData()

    fun cep() = cep as LiveData<Resource<Cep>>
    fun loading() = loading as LiveData<Boolean>
    fun error() = error as LiveData<Throwable>

    fun findByCEP(cepQuery: String) {

        jobs add launch {
            loading.value = true
            try {
                cep.value = repository.getCep(cepQuery).await()
                loading.value = false
            } catch (t: Throwable) {
                cep.value = FailResource(t.message)
                error.value = t
            } finally {
                loading.value = false
            }
        }
    }

}