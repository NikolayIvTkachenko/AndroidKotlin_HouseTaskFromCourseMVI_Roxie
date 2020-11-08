package com.rsh_engineering.tkachenkoni.projectsmvi_testarchitecture_01.di

import com.rsh_engineering.tkachenkoni.projectsmvi_testarchitecture_01.data.api.CatService
import com.rsh_engineering.tkachenkoni.projectsmvi_testarchitecture_01.data.repository.CatFactRepository
import com.rsh_engineering.tkachenkoni.projectsmvi_testarchitecture_01.domain.usecase.CatFactUseCaseImpl
import com.rsh_engineering.tkachenkoni.projectsmvi_testarchitecture_01.presentation.state.CatFactAction
import com.rsh_engineering.tkachenkoni.projectsmvi_testarchitecture_01.presentation.state.CatFactState
import com.rsh_engineering.tkachenkoni.projectsmvi_testarchitecture_01.presentation.viewmodels.CatFactViewModel
import com.squareup.moshi.Moshi
import com.ww.roxie.BaseViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 *
 * Created by Nikolay Tkachenko on 08, November, 2020
 *
 */

class DependencyInjectionImpl : DependencyInjection {

    override lateinit var catFactViewModel: BaseViewModel<CatFactAction, CatFactState>

    init {
        val apiBaseUrl = "https://cat-fact.herokuapp.com"
        val moshi = Moshi.Builder().build()

        val loggingInterceptor =
            HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(apiBaseUrl)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .client(okHttpClient)
            .build()

        val catService = retrofit.create(CatService::class.java)

        val catFactRepository = CatFactRepository(catService)

        val getCatFactUseCase = CatFactUseCaseImpl(catFactRepository)

        catFactViewModel = CatFactViewModel(CatFactState(activity = false), getCatFactUseCase)
    }
}
