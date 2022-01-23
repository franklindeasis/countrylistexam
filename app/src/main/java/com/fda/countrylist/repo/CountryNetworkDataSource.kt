package com.fda.countrylist.repo

import com.fda.countrylist.data.api.CountryApiHelper
import com.fda.countrylist.data.model.mapper.CountryDataMapper
import com.fda.countrylist.data.model.network.NetworkCountry
import io.reactivex.Single
import javax.inject.Inject

class CountryNetworkDataSource
@Inject
constructor(
    private val apiHelperImpl: CountryApiHelper
) : CountryDataSourceContract.Network {
    override fun fetchCountryListRemotely(): Single<List<NetworkCountry>> {
        return apiHelperImpl.getCountryList()
    }

}