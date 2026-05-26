package com.ether.damage

import com.ether.item.Enchant
import com.ether.item.ExtraAttribute
import com.ether.item.Rune
import com.ether.stat.MainStats
import com.ether.stat.SubStats

data class Damage(
    val mainStats: MainStats,
    val subStats: SubStats,
    val runes: List<Rune>,
    val enchants: List<Enchant>,
    val attributes: List<ExtraAttribute>,
)
