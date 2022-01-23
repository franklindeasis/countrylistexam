package com.fda.countrylist.data.api

import com.fda.countrylist.data.model.network.NetworkCountry
import io.reactivex.Single

interface CountryApiHelper {

    fun getCountryList(): Single<List<NetworkCountry>>

}