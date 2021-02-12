package com.example.breakingbaddb.business.network.model

import com.google.gson.annotations.SerializedName

data class CharacterDto(
    @SerializedName("appearance")
    val appearance: List<Int>,
    @SerializedName("better_call_saul_appearance")
    val better_call_saul_appearance: List<Any>,
    @SerializedName("birthday")
    val birthday: String? = null,
    @SerializedName("category")
    val category: String? = null,
    @SerializedName("char_id")
    val char_id: Int? = null,
    @SerializedName("img")
    val img: String? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("nickname")
    val nickname: String? = null,
    @SerializedName("occupation")
    val occupation: List<String>,
    @SerializedName("portrayed")
    val portrayed: String,
    @SerializedName("status")
    val status: String
)