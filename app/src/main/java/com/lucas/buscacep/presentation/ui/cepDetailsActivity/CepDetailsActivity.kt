package com.lucas.buscacep.presentation.ui.cepDetailsActivity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.lucas.buscacep.R
import com.lucas.buscacep.data.model.Cep
import com.lucas.buscacep.presentation.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_cep_details.*
import kotlinx.android.synthetic.main.include_toolbar.*

class CepDetailsActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cep_details)

        setupToolbar(toolbarMain, R.string.title_toolbar_main, true)

        setupDadosActivity()

    }

    private fun setupDadosActivity() {
        intent.getParcelableExtra<Cep>(EXTRA_CEP)?.let {
            textCep.text = "Cep pesquisado: ${it.cep}"
            textLogradouro.text = "Logradouro: ${it.logradouro}"
            textBairro.text = "Bairro: ${it.bairro}"
            textComplemento.text = "Complemento: ${it.complemento}"
            textCidade.text = "Cidade: ${it.localidade}"
            textEstado.text = "Estado: ${it.uf}"
        }
    }

    companion object {
        private const val EXTRA_CEP = "EXTRA_CEP"
        fun getStartActivity(context: Context, cep: Cep?): Intent {
            return Intent(context, CepDetailsActivity::class.java).apply {
                putExtra(EXTRA_CEP, cep)
            }
        }
    }
}
