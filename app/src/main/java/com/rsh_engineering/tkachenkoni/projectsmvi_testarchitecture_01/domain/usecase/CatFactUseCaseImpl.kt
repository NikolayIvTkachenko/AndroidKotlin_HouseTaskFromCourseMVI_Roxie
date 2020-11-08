package com.rsh_engineering.tkachenkoni.projectsmvi_testarchitecture_01.domain.usecase

import com.rsh_engineering.tkachenkoni.projectsmvi_testarchitecture_01.data.repository.CatFactRepository
import io.reactivex.Single

/**
 *
 * Created by Nikolay Tkachenko on 08, November, 2020
 *
 */

class CatFactUseCaseImpl(private val catFactRepository: CatFactRepository) : CatFactUseCase {
    override fun getFact(): Single<String> = catFactRepository.getCatFact()
}