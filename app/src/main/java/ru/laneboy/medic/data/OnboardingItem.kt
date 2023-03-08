package ru.laneboy.medic.data

import androidx.annotation.DrawableRes

data class OnboardingItem(
    val title: String,
    val description: String,
    @DrawableRes
    val image: Int
)