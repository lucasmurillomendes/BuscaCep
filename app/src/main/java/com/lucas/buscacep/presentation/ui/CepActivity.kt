package com.lucas.buscacep.presentation.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.github.rtoshiro.util.format.SimpleMaskFormatter
import com.github.rtoshiro.util.format.text.MaskTextWatcher
import com.lucas.buscacep.R
import com.lucas.buscacep.presentation.ui.base.BaseActivity
import com.lucas.buscacep.presentation.viewModel.CepViewModel
import kotlinx.android.synthetic.main.cep_activity.*
import kotlinx.android.synthetic.main.include_toolbar.*

class CepActivity : BaseActivity() {

    public var bairro = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.cep_activity)

        setupToolbar(toolbarMain, R.string.title_toolbar_main)

        setupMask()
        setupButton()

        val viewModel: CepViewModel = ViewModelProvider(this).get(CepViewModel::class.java)

        setupObservers(viewModel)

    }

    private fun setupObservers(viewModel: CepViewModel) {
        viewModel.cepLiveData.observe(this, Observer {
            it?.let {
                 bairro = it.get(0).bairro
            }
        })
    }

    private fun setupMask() {
        val smf = SimpleMaskFormatter("NNNNN-NNN")
        val mtw = MaskTextWatcher(editTextCep, smf)
        editTextCep.addTextChangedListener(mtw)
    }

    private fun setupButton() {
        buttonBuscar.setOnClickListener(View.OnClickListener {
            Toast.makeText(this, bairro, Toast.LENGTH_SHORT).show()
        })
    }
}
