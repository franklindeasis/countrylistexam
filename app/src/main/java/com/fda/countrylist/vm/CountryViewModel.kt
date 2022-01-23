package com.fda.countrylist.vm

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.fda.countrylist.data.base.BaseViewModel
import com.fda.countrylist.data.common.data.Resource
import com.fda.countrylist.data.common.data.Status
import com.fda.countrylist.data.model.business.Country
import com.fda.countrylist.data.model.mapper.CountryDataMapper
import com.fda.countrylist.interactors.CountryInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject


@HiltViewModel
public class CountryViewModel
@Inject
public constructor(
    private val countryInteractor: CountryInteractor
) : BaseViewModel() {

    private val _countryList = MutableLiveData<Resource<List<Country>>>()

    val countryList: LiveData<Resource<List<Country>>>
        get() = _countryList

    init {
        fetchCountryList()
    }

    fun fetchCountryList() {
        _countryList.postValue(Resource.loading(null))
        countryInteractor.fetchCountryListUseCase.execute(
            onSuccess = {
                val list = mutableListOf<Country>()
                for(networkCountry in it){
                   list.add(CountryDataMapper().map(networkCountry))
                }
                _countryList.postValue(Resource.success(list))
            },
            onError = {
                _countryList.postValue (
                    (Resource.error(
                        status = Status.GENERIC_ERROR,
                        data = null,
                        msg = it.message ?: "Something Went Wrong"
                    ))
                )
            }
        )
    }

    override fun onCleared() {
        super.onCleared()
    }

}
