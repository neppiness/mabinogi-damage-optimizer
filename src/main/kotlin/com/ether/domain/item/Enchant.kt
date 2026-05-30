package com.ether.domain.item

data class Enchant(
    val id: Long,
    val attackPowerIncrementPercent: Double = 0.0,
    val attackPower: Int = 0,
)
