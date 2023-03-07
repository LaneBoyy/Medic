package ru.laneboy.medic.data

import androidx.annotation.DrawableRes

data class OndoardingItem(
    val title: String,
    val description: String,
    @DrawableRes
    val image: Int
)