package com.ezetap.test.ui.customUi

import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ezetap.test.data.customUi.CustomUiRepository
import com.ezetap.test.data.customUi.model.CustomUIModel
import com.ezetap.test.utils.Event
import kotlinx.coroutines.launch
import javax.inject.Inject

class CustomUiViewModel @Inject constructor(private val customUiRepository: CustomUiRepository): ViewModel() {

    val isLoading = ObservableBoolean(false)
    val hasError = ObservableBoolean(false)
    val errorMsg = ObservableField<String>()

    var customUiData = MutableLiveData<Event<CustomUIModel>>()

    fun getCustomUIData(){
        isLoading.set(true)
        viewModelScope.launch {
            val(response, responseCode) = try{
                customUiRepository.getCustomUis()
            } catch (e: Exception){
                hasError.set(true)
                errorMsg.set("Something Went Wrong.")
                null to 0
            }

            if (responseCode == 200){
                if (response != null) {
                    hasError.set(false)
                    customUiData.value = Event(response)
                }else {
                    errorMsg.set("Something Went Wrong.")
                    hasError.set(true)
                }
            }else {
                errorMsg.set("Something Went Wrong.")
                hasError.set(true)
            }

            isLoading.set(false)
        }
    }
}