package com.fda.countrylist.interactors

import javax.inject.Inject

class CountryInteractor
@Inject constructor(
    val fetchCountryListUseCase: FetchCountryListUseCase
)
