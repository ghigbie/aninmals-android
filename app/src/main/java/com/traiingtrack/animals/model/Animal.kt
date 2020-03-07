package com.traiingtrack.animals.model

import com.google.gson.annotations.SerializedName

data class ApiKey(
    val message: String?,
    val key: String?
)

data class Animal(
    val name: String?,
    val taxonmy: Taxonmy?,
    val location: String,
    val speed: Speed?,

    @SerializedName("lifespan")
    val lifeSpan: String?,

    @SerializedName("image")
    val imageUrl: String?
)

data class Taxonmy(
    val kingdom: String?,
    val name: String?,
    val family: String?
)

data class Speed(
    val metric: String?,
    val imperial: String?
)