package com.rsh_engineering.tkachenkoni.projectsmvi_testarchitecture_01.domain.usecase

import io.reactivex.Single

/**
 *
 * Created by Nikolay Tkachenko on 08, November, 2020
 *
 */

interface CatFactUseCase {
    fun getFact(): Single<String>
}