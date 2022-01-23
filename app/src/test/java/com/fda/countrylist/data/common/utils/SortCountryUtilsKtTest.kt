package com.fda.countrylist.data.common.utils

import com.fda.countrylist.data.model.business.Country
import junit.framework.TestCase
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.internal.runners.JUnit4ClassRunner
import org.junit.runner.RunWith

@RunWith(JUnit4ClassRunner::class)
class SortCountryUtilsKtTest {

    @Test
    fun `when passed country list and query string A then return sorted list`(){
        //Given
        val countryList = provideTestCountryList()
        val queryString = "a"

        //When
        val sortedList = queryCountryAndSortCountryListByAscending(queryString, countryList)

        //Then
        assert(sortedList.size == 2)
        assertEquals(sortedList[0].commonName, "Afghanistan")
        assertEquals(sortedList[1].commonName, "Angola")
    }

    @Test
    fun `when passed country list and query string P then return sorted list`(){
        //Given
        val countryList = provideTestCountryList()
        val queryString = "p"

        //When
        val sortedList = queryCountryAndSortCountryListByAscending(queryString, countryList)

        //Then
        assert(sortedList.size == 3)
        assertEquals(sortedList[0].commonName, "Papua New Guinea")
        assertEquals(sortedList[1].commonName, "Philippines")
        assertEquals(sortedList[2].commonName, "Puerto Rico")
    }

    fun provideTestCountryList() : List<Country> {
        val countryList = mutableListOf<Country>()
        countryList.add(Country("Puerto Rico"))
        countryList.add(Country("Angola"))
        countryList.add(Country("Iraq"))
        countryList.add(Country("Bolivia"))
        countryList.add(Country("Papua New Guinea"))
        countryList.add(Country("Afghanistan"))
        countryList.add(Country("Philippines"))
        return countryList
    }
}