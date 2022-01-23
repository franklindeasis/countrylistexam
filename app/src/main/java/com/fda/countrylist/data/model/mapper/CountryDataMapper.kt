package com.fda.countrylist.data.model.mapper

import com.fda.countrylist.data.model.business.Country
import com.fda.countrylist.data.model.network.NetworkCountry
import com.ttc.finch_station.data.common.mapper.core.Mapper
import javax.inject.Inject

class CountryDataMapper
@Inject
constructor() : Mapper<NetworkCountry, Country> {

    override fun map(input: NetworkCountry): Country {
        return Country(
            commonName = input.name?.common,
            officialName = input.name?.official,
            isIndependent = input.independent,
            status = input.status,
//            currencies = input.currencies,
            capital = input.capital,
            region = input.region,
            subregion = input.subregion,
            latlng = input.latlng,
            landlocked = input.landlocked,
            borders = input.borders,
            area = input.area,
            googleMaps = input.maps?.googleMaps,
            openStreetMaps = input.maps?.openStreetMaps,
            population = input.population,
            timezones = input.timezones,
            continents = input.continents,
            flagPngUrl = input.flags?.png,
            flagSvgUrl = input.flags?.svg,
            coatOfArmsPngUrl = input.coatOfArms?.png,
            coatOfArmsSvgUrl = input.coatOfArms?.svg
        )
    }
}
