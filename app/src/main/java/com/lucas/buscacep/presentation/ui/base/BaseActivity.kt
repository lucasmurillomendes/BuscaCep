package com.lucas.buscacep.presentation.ui.base

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

open class BaseActivity : AppCompatActivity() {

    protected fun setupToolbar(toolbar: Toolbar, titleResId: Int, showBackButton: Boolean = false){
        toolbar.title = getString(titleResId)
        setSupportActionBar(toolbar)
        if (showBackButton) supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}