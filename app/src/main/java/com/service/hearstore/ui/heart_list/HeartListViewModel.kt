package com.service.hearstore.ui.heart_list

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.service.hearstore.data.model.HeartModel

class HeartListViewModel : ViewModel() {

    private val _heartsList=  MutableLiveData<MutableList<HeartModel>>(mutableListOf())
    fun getHeartLiveData(): LiveData<MutableList<HeartModel>> = _heartsList


    fun addNewHeart(heart:HeartModel):Boolean{
        Log.i("anahna","tmam l7d kda ::${heart.name}::::${_heartsList.value?.size}")
        return _heartsList.value!!.add(heart)
    }
    fun test(){
        Log.i("anahna",":::::::${_heartsList.value?.size}")
    }



}