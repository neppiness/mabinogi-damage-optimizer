package com.ether.item

interface Rune {

    fun getAttackPowerPercent(
        isAwakening: Boolean,
        transcendenceLevel: Int,
        itemLevel: Int,
    ): Double = 0.0

    fun getSkillPowerPercent(
        isAwakening: Boolean,
        transcendenceLevel: Int,
        itemLevel: Int,
    ): Double = 0.0

    fun getChainStrikePercent(
        isAwakening: Boolean,
        transcendenceLevel: Int,
        itemLevel: Int,
    ): Double = 0.0

    fun getHeavyStrikePercent(
        isAwakening: Boolean,
        transcendenceLevel: Int,
        itemLevel: Int,
    ): Double = 0.0

    fun getDamagePercent(
        isAwakening: Boolean,
        transcendenceLevel: Int,
        itemLevel: Int,
    ): Double = 0.0

    fun getGivenDamagePercent( // 적에게 주는 피해 증가량(%)
        isAwakening: Boolean,
        transcendenceLevel: Int,
        itemLevel: Int,
    ): Double = 0.0

    fun getAoePercent(
        isAwakening: Boolean,
        transcendenceLevel: Int,
        itemLevel: Int,
    ): Double = 0.0

    fun getComboPercent(
        isAwakening: Boolean,
        transcendenceLevel: Int,
        itemLevel: Int,
    ): Double = 0.0

    fun getCriticalProbabilityPercent(
        isAwakening: Boolean,
        transcendenceLevel: Int,
        itemLevel: Int,
    ): Double = 0.0

    fun getCriticalDamagePercent(
        isAwakening: Boolean,
        transcendenceLevel: Int,
        itemLevel: Int,
    ): Double = 0.0

    fun getVulnerableDamagePercent(
        isAwakening: Boolean,
        transcendenceLevel: Int,
        itemLevel: Int,
    ): Double = 0.0

    fun getAdditionalHitPercent(
        isAwakening: Boolean,
        transcendenceLevel: Int,
        itemLevel: Int,
    ): Double = 0.0

}
