package com.srhdp.hisnulmuslim.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.srhdp.hisnulmuslim.domain.usecase.GetContentUseCase
import com.srhdp.hisnulmuslim.domain.usecase.GetSearchContentUseCase

class DataViewModelFactory(
    private val app: Application,
    private val getContentsUseCase: GetContentUseCase,
    private val getSearchContentUseCase: GetSearchContentUseCase
):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return DataViewModel(
            app,
            getContentsUseCase,
            getSearchContentUseCase
        ) as T
    }
}