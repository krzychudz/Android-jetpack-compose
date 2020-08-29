package com.example.jetpack_compose_playground.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jetpack_compose_playground.R
import com.example.jetpack_compose_playground.data.CarModel

class MainActivityViewModel: ViewModel() {
    val carData: LiveData<CarModel> = MutableLiveData()

    init {
        val carModel = CarModel(
            R.drawable.audi,
            "Audi A8",
            "Test description"
        )
        //carData.value = carModel
    }
}