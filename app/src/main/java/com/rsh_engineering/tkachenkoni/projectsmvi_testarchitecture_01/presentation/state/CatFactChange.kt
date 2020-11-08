package com.rsh_engineering.tkachenkoni.projectsmvi_testarchitecture_01.presentation.state

/**
 *
 * Created by Nikolay Tkachenko on 08, November, 2020
 *
 */

sealed class CatFactChange {
    object Loading : CatFactChange()
    data class Fact(val fact: String) : CatFactChange()
    data class Error(val throwable: Throwable?) : CatFactChange()
}