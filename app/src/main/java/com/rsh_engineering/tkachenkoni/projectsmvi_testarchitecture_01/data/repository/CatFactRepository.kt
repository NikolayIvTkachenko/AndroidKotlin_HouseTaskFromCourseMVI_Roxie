package com.rsh_engineering.tkachenkoni.projectsmvi_testarchitecture_01.data.repository

import com.rsh_engineering.tkachenkoni.projectsmvi_testarchitecture_01.data.api.CatService
import io.reactivex.Single
import kotlin.random.Random

/**
 *
 * Created by Nikolay Tkachenko on 08, November, 2020
 *
 */


class CatFactRepository(private val catFactService: CatService) {

    fun getCatFact(): Single<String> {
        return catFactService.getFacts()
            .map { response ->
                val randomInt = Random.nextInt(0, response.all.size)
                response.all[randomInt].text
            }
    }
}