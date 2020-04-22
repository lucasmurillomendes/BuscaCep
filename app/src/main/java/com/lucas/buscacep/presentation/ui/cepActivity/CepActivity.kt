package com.lucas.buscacep.presentation.ui.cepActivity

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.github.rtoshiro.util.format.SimpleMaskFormatter
import com.github.rtoshiro.util.format.text.MaskTextWatcher
import com.lucas.buscacep.R
import com.lucas.buscacep.data.repository.CepRepositoryImpl
import com.lucas.buscacep.data.repository.FailResource
import com.lucas.buscacep.data.repository.SucessResource
import com.lucas.buscacep.presentation.ui.base.BaseActivity
import com.lucas.buscacep.presentation.ui.cepDetailsActivity.CepDetailsActivity
import kotlinx.android.synthetic.main.cep_activity.*
import kotlinx.android.synthetic.main.include_toolbar.*

class CepActivity : BaseActivity() {

    private val repository by lazy {
        CepRepositoryImpl()
    }

    private val viewModel by lazy {
        val factory = CepViewModelFactory(repository)
        ViewModelProvider(this, factory).get(CepViewModel::class.java)
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
        viewModel.cep().observe(this, Observer {
            when (it) {
                is SucessResource -> {
                    CepDetailsActivity.open(this@CepActivity, it.sucess)
                }
                is FailResource -> {
                    Toast.makeText(this, R.string.cep_invalido, Toast.LENGTH_LONG).show()
                }
            }
        })

        viewModel.loading().observe(this, Observer {
            progressBar.visibility = if (it) View.VISIBLE else View.GONE
        })

        viewModel.error().observe(this, Observer {
            it?.let {
                Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
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
