package com.lucas.buscacep.presentation.ui.cepDetailsActivity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.lucas.buscacep.R
import com.lucas.buscacep.data.model.Cep
import com.lucas.buscacep.databinding.ActivityCepDetailsBinding
import com.lucas.buscacep.presentation.ui.base.BaseActivity
import kotlinx.android.synthetic.main.include_toolbar.*

class CepDetailsActivity : BaseActivity() {

    private val viewModel by lazy {
        ViewModelProvider(this).get(CepDetailViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cep_details)

        val cep = intent.getParcelableExtra<Cep>(EXTRA_CEP)

        setupDataBinding()
        setupObservers(cep)

    }

    /**
     * Init Databinding
     */
    private fun setupDataBinding() {
        val binding = DataBindingUtil.setContentView<ActivityCepDetailsBinding>(
            this,
            R.layout.activity_cep_details
        )
        binding.viewmodel = viewModel

        setupToolbar(binding.toolbarMain, R.string.title_toolbar_main, true)

        binding.lifecycleOwner = this
    }

    /**
     * Pass parameter CEP
     */
    private fun setupObservers(cep: Cep?) {
        cep?.let {
            viewModel.addCep(it)
        }
    }

    companion object {
        private const val EXTRA_CEP = "EXTRA_CEP"

        fun open(context: Context, cep: Cep?) {
            val intent = Intent(context, CepDetailsActivity::class.java)
                .apply {
                    putExtra(EXTRA_CEP, cep)
                }

            context.startActivity(intent)
        }
    }
}
