package com.rsh_engineering.tkachenkoni.projectsmvi_testarchitecture_01.data.api

import com.rsh_engineering.tkachenkoni.projectsmvi_testarchitecture_01.domain.model.CatFact
import com.rsh_engineering.tkachenkoni.projectsmvi_testarchitecture_01.domain.model.Response
import io.reactivex.Single
import retrofit2.http.GET

/**
 *
 * Created by Nikolay Tkachenko on 08, November, 2020
 *
 */

interface CatService {
    @GET("facts")
    fun getFacts(): Single<Response<List<CatFact>>>
}