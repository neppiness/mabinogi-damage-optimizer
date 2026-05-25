package com.ether.v0.damage

import com.ether.v0.rune.Rune
import com.ether.v0.stat.MainStats
import com.ether.v0.stat.SubStats

data class Damage(
    val mainStats: MainStats,
    val subStats: SubStats,
    val runes: List<Rune>,
) {
    // TODO: IMPLEMENT THIS
}
