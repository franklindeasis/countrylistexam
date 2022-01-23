package com.fda.countrylist.data.common.utils

import com.fda.countrylist.data.model.business.Country

fun queryCountryAndSortCountryListByAscending(
    queryString: String,
    originalCountryList: List<Country>
): List<Country> {
    return originalCountryList.filter {
        it.commonName.orEmpty().lowercase().contains(queryString.lowercase()) && it.commonName.orEmpty().lowercase().startsWith(queryString.lowercase())
    }.sortedBy {
        it.commonName
    }
}