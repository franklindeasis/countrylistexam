package com.fda.countrylist.interactors

import com.fda.countrylist.data.model.network.NetworkCountry
import com.fda.countrylist.interactors.usecase.SingleUseCase
import com.fda.countrylist.repo.CountryDataSourceContract
import io.reactivex.Single
import javax.inject.Inject

class FetchCountryListUseCase
@Inject
constructor(
    private val repository: CountryDataSourceContract.Repository
) : SingleUseCase<List<NetworkCountry>>() {

    override fun buildUseCaseSingle(): Single<List<NetworkCountry>> {
        return repository.fetchCountryList()
    }
}