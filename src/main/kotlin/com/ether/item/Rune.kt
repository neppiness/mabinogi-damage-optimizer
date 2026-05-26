package com.ether.item

interface Rune {
    fun getSkillPowerPercent(isAwakening: Boolean): Double = 0.0
    fun getChainStrikePercent(isAwakening: Boolean): Double = 0.0
    fun getHeavyStrikePercent(isAwakening: Boolean): Double = 0.0
    fun getDamagePercent(isAwakening: Boolean): Double = 0.0
    fun getGivenDamagePercent(isAwakening: Boolean): Double = 0.0
    fun getAoePercent(isAwakening: Boolean): Double = 0.0
    fun getComboPercent(isAwakening: Boolean): Double = 0.0
    fun getCriticalProbabilityPercent(isAwakening: Boolean): Double = 0.0
    fun getCriticalDamagePercent(isAwakening: Boolean): Double = 0.0
    fun getVulnerableDamagePercent(isAwakening: Boolean): Double = 0.0
    fun getAdditionalHitPercent(isAwakening: Boolean): Double = 0.0
}
