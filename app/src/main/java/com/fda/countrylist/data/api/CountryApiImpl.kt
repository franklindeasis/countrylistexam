package com.fda.countrylist.data.api

import com.fda.countrylist.data.model.network.NetworkCountry
import io.reactivex.Single
import javax.inject.Inject

class CountryApiImpl

@Inject
constructor(
    private val apiService: ApiService
) : CountryApiHelper {

    override fun getCountryList() = apiService.getCountryList()

}