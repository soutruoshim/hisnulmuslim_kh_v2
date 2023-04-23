package com.srhdp.hisnulmuslim.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.srhdp.hisnulmuslim.domain.usecase.GetContentUseCase

class DataViewModel (private val app: Application, private val getContentUseCase: GetContentUseCase) :
    ViewModel() {
    fun getContent() = liveData{
        getContentUseCase.execute().collect {
            emit(it)
        }
    }
}