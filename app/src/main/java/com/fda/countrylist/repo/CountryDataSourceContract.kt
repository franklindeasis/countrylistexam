package com.fda.countrylist.repo

import com.fda.countrylist.data.common.data.Resource
import com.fda.countrylist.data.model.business.Country
import com.fda.countrylist.data.model.network.NetworkCountry
import io.reactivex.Single

class CountryDataSourceContract {
    interface Repository {
        fun fetchCountryList(): Single<List<NetworkCountry>>
    }

    interface Local {
        fun fetchCountryListLocally(): Resource<List<Country>>
    }

    interface Network {
        fun fetchCountryListRemotely(): Single<List<NetworkCountry>>
    }
}