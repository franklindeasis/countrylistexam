package com.fda.countrylist.repo

import com.fda.countrylist.data.common.data.Resource
import com.fda.countrylist.data.model.business.Country
import com.fda.countrylist.data.model.network.NetworkCountry
import io.reactivex.Single
import javax.inject.Inject

class CountryRepository
@Inject
constructor(
    private val countryLocalDataSource: CountryDataSourceContract.Local,
    private val countryNetworkDataSource: CountryDataSourceContract.Network
) : CountryDataSourceContract.Repository {
    override fun fetchCountryList(): Single<List<NetworkCountry>> {
        return countryNetworkDataSource.fetchCountryListRemotely()
    }
}