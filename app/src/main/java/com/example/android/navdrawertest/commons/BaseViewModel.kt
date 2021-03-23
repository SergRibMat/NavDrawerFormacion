package com.example.android.navdrawertest.commons

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.android.data.remote.ResultHandler
import com.example.android.navdrawertest.utils.SingleLiveEvent

abstract class BaseViewModel: ViewModel() {

    private var _showMessage = SingleLiveEvent<String>()
    val showMessage: LiveData<String>
        get() = _showMessage

    private var _showError = SingleLiveEvent<String>()
    val showError: LiveData<String>
        get() = _showError

    fun showMessage(text: String){
        _showMessage.postValue(text)
    }

    fun setShowError(resultHandler: ResultHandler<Any>){
        when (resultHandler){
            is ResultHandler.NetworkError -> {
                _showError.postValue("Constants.NETWORK_ERROR")
            }
            is ResultHandler.HttpError -> {
                _showError.postValue("${resultHandler.code!!}")
            }
            is ResultHandler.GenericError -> {
                _showError.postValue(resultHandler.message!!)
            }
            else -> {
                _showError.postValue("Constants.NETWORK_ERROR")
            }
        }
    }
}