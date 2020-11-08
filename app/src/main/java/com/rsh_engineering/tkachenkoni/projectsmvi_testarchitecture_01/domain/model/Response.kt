package com.rsh_engineering.tkachenkoni.projectsmvi_testarchitecture_01.domain.model

import com.squareup.moshi.JsonClass

/**
 *
 * Created by Nikolay Tkachenko on 08, November, 2020
 *
 */


@JsonClass(generateAdapter = true)
data class Response<T>(val all: T)