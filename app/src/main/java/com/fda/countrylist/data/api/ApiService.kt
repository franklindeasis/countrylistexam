package com.fda.countrylist.data.api

import com.fda.countrylist.data.model.network.NetworkCountry
import io.reactivex.Single
import retrofit2.http.GET

interface ApiService {

    @GET("all")
    fun getCountryList(): Single<List<NetworkCountry>>

}