package com.example.breakingbaddb.business.domain.model

import java.io.Serializable

data class Characters(
    val appearance: List<Int>,
    val birthday: String? = null,
    val category: String? = null,
    val char_id: Int? = null,
    val img: String? = null,
    val name: String? = null,
    val nickname: String? = null,
    val occupation: List<String>,
    val portrayed: String? = null,
    val status: String? = null
) : Serializable