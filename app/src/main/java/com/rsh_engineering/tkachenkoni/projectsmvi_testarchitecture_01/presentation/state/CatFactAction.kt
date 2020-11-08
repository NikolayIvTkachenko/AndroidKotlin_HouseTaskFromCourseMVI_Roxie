package com.rsh_engineering.tkachenkoni.projectsmvi_testarchitecture_01.presentation.state

import com.ww.roxie.BaseAction

/**
 *
 * Created by Nikolay Tkachenko on 08, November, 2020
 *
 */

sealed class CatFactAction : BaseAction {
    object GetFactButtonClicked : CatFactAction()
}