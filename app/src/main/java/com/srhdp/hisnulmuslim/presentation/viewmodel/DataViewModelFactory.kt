package com.srhdp.hisnulmuslim.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.srhdp.hisnulmuslim.domain.usecase.GetContentUseCase
import com.srhdp.hisnulmuslim.domain.usecase.GetSearchContentUseCase

class DataViewModelFactory(
    private val getContentsUseCase: GetContentUseCase,
    private val getSearchContentUseCase: GetSearchContentUseCase
):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return DataViewModel(
            getContentsUseCase,
            getSearchContentUseCase
        ) as T
    }
}