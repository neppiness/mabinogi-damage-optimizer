package com.ether.damage

import com.ether.rune.Rune
import com.ether.stat.MainStats
import com.ether.stat.SubStats

data class Damage(
    val mainStats: MainStats,
    val subStats: SubStats,
    val runes: List<Rune>,
) {
    // TODO: IMPLEMENT THIS
}
