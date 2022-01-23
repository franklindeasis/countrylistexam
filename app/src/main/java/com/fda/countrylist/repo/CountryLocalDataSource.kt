package com.fda.countrylist.repo

import com.fda.countrylist.data.common.data.Resource
import com.fda.countrylist.data.model.business.Country
import javax.inject.Inject

class CountryLocalDataSource
@Inject
constructor() : CountryDataSourceContract.Local {
    override fun fetchCountryListLocally(): Resource<List<Country>> {
        TODO("Not yet implemented")
    }
}