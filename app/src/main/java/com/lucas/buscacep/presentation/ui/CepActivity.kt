package com.lucas.buscacep.presentation.ui

import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.github.rtoshiro.util.format.SimpleMaskFormatter
import com.github.rtoshiro.util.format.text.MaskTextWatcher
import com.lucas.buscacep.R
import com.lucas.buscacep.data.repository.FailResource
import com.lucas.buscacep.data.repository.SucessResource
import com.lucas.buscacep.presentation.ui.base.BaseActivity
import com.lucas.buscacep.presentation.viewModel.CepViewModel
import kotlinx.android.synthetic.main.cep_activity.*
import kotlinx.android.synthetic.main.include_toolbar.*

class CepActivity : BaseActivity() {

    private val viewModel by lazy {
        ViewModelProvider(this).get(CepViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.cep_activity)

        setupToolbar(toolbarMain, R.string.title_toolbar_main)
        setupMask()
        setupButton()
        setupObservers(viewModel)

    }

    private fun setupObservers(viewModel: CepViewModel) {
        viewModel.cepLiveData.observe(this, Observer {
            when (it) {
                is SucessResource -> {
                    Toast.makeText(this, it.sucess.toString(), Toast.LENGTH_LONG).show()
                }
                is FailResource -> {
                    Toast.makeText(this, it.erro, Toast.LENGTH_LONG).show()
                }
            }
        })
    }

    private fun setupMask() {
        val smf = SimpleMaskFormatter("NNNNN-NNN")
        val mtw = MaskTextWatcher(editTextCep, smf)
        editTextCep.addTextChangedListener(mtw)
    }

    private fun setupButton() {
        buttonBuscar.setOnClickListener {
            if (editTextCep.text.isNotBlank()) {
                viewModel.findByCEP(editTextCep.text.toString())
            } else {
                editTextCep.error = "Digite o CEP"
            }
        }
    }

}
