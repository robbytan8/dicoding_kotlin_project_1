package com.robby.dicoding_kotlin_project_1.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Club(val name: String, val logo: Int, val description: String) : Parcelable