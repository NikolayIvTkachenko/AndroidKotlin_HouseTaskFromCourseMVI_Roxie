package com.rsh_engineering.tkachenkoni.projectsmvi_testarchitecture_01.di

import com.rsh_engineering.tkachenkoni.projectsmvi_testarchitecture_01.presentation.state.CatFactAction
import com.rsh_engineering.tkachenkoni.projectsmvi_testarchitecture_01.presentation.state.CatFactState
import com.ww.roxie.BaseViewModel

/**
 *
 * Created by Nikolay Tkachenko on 08, November, 2020
 *
 */

interface DependencyInjection {
    val catFactViewModel: BaseViewModel<CatFactAction, CatFactState>
}