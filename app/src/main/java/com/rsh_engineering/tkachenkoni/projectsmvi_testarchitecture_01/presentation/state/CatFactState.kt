package com.rsh_engineering.tkachenkoni.projectsmvi_testarchitecture_01.presentation.state

import com.ww.roxie.BaseState

/**
 *
 * Created by Nikolay Tkachenko on 08, November, 2020
 *
 */

data class CatFactState(
    val activity: Boolean = false,
    val fact: String = "",
    val displayError: Boolean = false
) : BaseState