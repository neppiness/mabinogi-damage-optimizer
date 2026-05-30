package com.ether.item

data class ExtraAttribute(
    val id: Long,
    val skillPowerPercent: Double = 0.0,
    val chainStrikePercent: Double = 0.0,
    val heavyStrikePercent: Double = 0.0,
    val damagePercent: Double = 0.0,
    val givenDamagePercent: Double = 0.0,
    val aoePercent: Double = 0.0,
    val comboPercent: Double = 0.0,
    val criticalProbabilityPercent: Double = 0.0,
    val criticalDamagePercent: Double = 0.0,
    val vulnerableDamagePercent: Double = 0.0,
    val additionalHitPercent: Double = 0.0,
)
