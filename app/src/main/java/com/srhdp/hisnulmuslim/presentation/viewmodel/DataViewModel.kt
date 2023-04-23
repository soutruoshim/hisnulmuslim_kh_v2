package com.srhdp.hisnulmuslim.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.srhdp.hisnulmuslim.domain.usecase.GetContentUseCase
import com.srhdp.hisnulmuslim.domain.usecase.GetSearchContentUseCase

class DataViewModel(
    private val app: Application,
    private val getContentUseCase: GetContentUseCase,
    private val getSearchContentUseCase: GetSearchContentUseCase
) :
    ViewModel() {
    fun getContent() = liveData {
        getContentUseCase.execute().collect {
            emit(it)
        }
    }

    fun getSearchContent(query:String) = liveData {
        getSearchContentUseCase.execute(query).collect {
            emit(it)
        }
    }
}