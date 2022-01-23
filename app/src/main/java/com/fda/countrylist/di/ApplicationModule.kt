package com.fda.countrylist.di

import com.fda.countrylist.data.api.CountryApiHelper
import com.fda.countrylist.data.model.mapper.CountryDataMapper
import com.fda.countrylist.repo.CountryDataSourceContract
import com.fda.countrylist.repo.CountryLocalDataSource
import com.fda.countrylist.repo.CountryNetworkDataSource
import com.fda.countrylist.repo.CountryRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
class ApplicationModule {

    @Provides
    fun provideCountryRepository(
        countryLocalDataSource: CountryDataSourceContract.Local,
        countryNetworkDataSource: CountryDataSourceContract.Network
    ): CountryDataSourceContract.Repository =
        CountryRepository(countryLocalDataSource, countryNetworkDataSource)

    @Provides
    fun provideCountryLocalDataSource(): CountryDataSourceContract.Local
            = CountryLocalDataSource()

    @Provides
    fun provideCountryRemoteDataSource(
        countryApiHelper: CountryApiHelper
    ): CountryDataSourceContract.Network  =
        CountryNetworkDataSource(countryApiHelper)

}