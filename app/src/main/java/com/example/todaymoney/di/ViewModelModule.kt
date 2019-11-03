package com.example.todaymoney.di

import com.example.todaymoney.ui.add.AddViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { AddViewModel(get(), get()) }
}