package com.lucas.buscacep.presentation.ui.cepActivity

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.lucas.buscacep.data.repository.CepRepositoryImpl

class CepViewModelFactory(
    private val repository: CepRepositoryImpl
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CepViewModel(repository) as T
    }

}