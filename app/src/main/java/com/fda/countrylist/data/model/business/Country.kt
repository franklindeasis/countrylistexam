package com.fda.countrylist.data.model.business

import android.os.Parcelable
import com.fda.countrylist.data.model.network.NetworkCountryCurrency
import kotlinx.android.parcel.Parcelize

@Parcelize
class Country (
    val commonName: String? = "",
    val officialName: String? = "",
    val isIndependent: Boolean? = null,
    val status: String? = null,
//    val currencies: Map<String, NetworkCountryCurrency>? = null,
    val capital: List<String>? = null,
    val region: String? = null,
    val subregion: String? = null,
    val latlng: List<Float>? = null,
    val landlocked: Boolean? = null,
    val borders: List<String>? = null,
    val area: Double? = null,
    val googleMaps: String? = null,
    val openStreetMaps: String? = null,
    val population: Int? = null,
    val timezones: List<String>? = null,
    val continents: List<String>? = null,
    val flagPngUrl: String? = null,
    val flagSvgUrl: String? = null,
    val coatOfArmsPngUrl: String? = null,
    val coatOfArmsSvgUrl: String? = null
) : Parcelable
