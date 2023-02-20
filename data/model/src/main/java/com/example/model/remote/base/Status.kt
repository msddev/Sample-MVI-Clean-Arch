package com.example.model.remote.base

import com.example.framework.network.moshi.IValueEnum
import com.serjltt.moshi.adapters.FallbackEnum
import com.squareup.moshi.Json

@FallbackEnum(name = "unknown")
enum class Status(override val value: String) : IValueEnum {
    @Json(name = "Alive")
    Alive("Alive"),

    @Json(name = "Dead")
    Dead("Dead"),

    @Json(name = "unknown")
    Unknown("unknown");
}