package com.lucas.buscacep.presentation.ui.cepDetails

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.util.rangeTo
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
        val cep = intent.getParcelableExtra<Cep>(EXTRA_CEP)
        textCep.text = "Cep pesquisado: ${cep.cep}"
        textLogradouro.text = "Logradouro: ${cep.logradouro}"
        textBairro.text = "Bairro: ${cep.bairro}"
        textComplemento.text = "Complemento: ${cep.complemento}"
        textCidade.text = "Cidade: ${cep.localidade}"
        textEstado.text = "Estado: ${cep.uf}"
    }

    companion object {
        private const val EXTRA_CEP = "EXTRA_CEP"
        fun getStartActivity(context: Context, cep: Cep?) : Intent {
            return Intent(context, CepDetailsActivity::class.java).apply {
                putExtra(EXTRA_CEP, cep)
            }
        }
    }
}
