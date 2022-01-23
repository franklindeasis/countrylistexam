package com.fda.countrylist.data.model.network

class NetworkCountry (
    val name: NetworkCountryName? = null,
    val tld: List<String>? = null,
    val cca2: String? = null,
    val ccn3: String? = null,
    val cca3: String? = null,
    val cioc: String? = null,
    val independent: Boolean? = null,
    val status: String? = null,
    val unMember: Boolean? = null,
    val currencies: Map<String, NetworkCountryCurrency>? = null,
    val capital: List<String>? = null,
    val region: String? = null,
    val subregion: String? = null,
    val latlng: List<Float>? = null,
    val landlocked: Boolean? = null,
    val borders: List<String>? = null,
    val area: Double? = null,
    val maps: NetworkCountryMap? = null,
    val population: Int? = null,
    val timezones: List<String>? = null,
    val continents: List<String>? = null,
    val flags: NetworkCountryFlag? = null,
    val coatOfArms: NetworkCountryCoatOfArms? = null

)