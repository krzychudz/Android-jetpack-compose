package com.example.jetpack_compose_playground.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jetpack_compose_playground.R
import com.example.jetpack_compose_playground.data.CarModel

class MainActivityViewModel: ViewModel() {
    val carData = MutableLiveData<CarModel>()

    init {
        val carModel = CarModel(
            R.drawable.audi,
            "Audi A8",
            "Test description",
            "Engine 4.8",
            "Black",
            "4",
            "Sedan",
            "480 HP",
            "Manual",
            "2012"
        )
        carData.value = carModel
    }
}