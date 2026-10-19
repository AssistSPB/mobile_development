package com.example.lab5

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes val nameRes: Int,
    val count: Int,
    @DrawableRes val imageRes: Int
)