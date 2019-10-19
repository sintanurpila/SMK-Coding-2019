package com.sintanurpila.smkcoding

import android.icu.text.CaseMap
import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class  MovieModel(
    var title:  String? = null,
    var rating: Int? = null,
    var image: String? = null,
    var description: String? =null
):Parcelable

