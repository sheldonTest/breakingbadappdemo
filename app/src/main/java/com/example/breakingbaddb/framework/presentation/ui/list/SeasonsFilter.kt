package com.example.breakingbaddb.framework.presentation.ui.list

enum class SeasonsFilter(val value: Int) {
    SEASON_ONE(1),
    SEASON_TWO(2),
    SEASON_THREE(3),
    SEASON_FOUR(4),
    SEASON_FIVE(5),
}

fun getAllSeasons() : List<SeasonsFilter> {
    return listOf(SeasonsFilter.SEASON_ONE, SeasonsFilter.SEASON_TWO, SeasonsFilter.SEASON_THREE,
        SeasonsFilter.SEASON_FOUR, SeasonsFilter.SEASON_FIVE)
}

fun getSeasons(value: Int) : SeasonsFilter? {
    val map = SeasonsFilter.values().associateBy { SeasonsFilter::value }
    return map[value]
}
