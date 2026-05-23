package com.ether.damage

import kotlin.math.roundToLong

/**
 * A항, 공격력
 */
data class BaseAttackPower(
    val character: Character,
    val weapon: Weapon,
    val necklace: Long,
    val necklaceSeal: Long,
    val pet: Long,
    val fashion: Long,
    val enchant: Long, // 오른쪽 장비 인챈트
    val runeWord: Long,
    val justice: Long,
) {

    fun calculate(): Long =
        character.calculate() + weapon.calculate() + necklace + necklaceSeal + pet + fashion + enchant + runeWord + justice

    data class Character(
        val levelBase: Long = 1498,
        val cards: Long,
        val titles: Long,
    ) {
        fun calculate(): Long = levelBase + cards + titles
    }

    data class Weapon(
        val base: Long,
        val rune: Long,
        val seal: Long,
        val skilled: Long,
        val emblemPercent: Double,
        val statBonus: Double,
    ) {
        fun calculate(): Long = ((base + rune + seal + skilled) * (1 + emblemPercent / 100) + statBonus).roundToLong()
    }

}

/**
 * B항, 공격력 증가
 */
data class BaseAttackPowerAmplifier(
    val itemPercent: Double,
    val skillPercent: Double,
    val enchantPercent: Double,
) : Factor {

    override fun calculate(): Double {
        val itemFactor = itemPercent / 100
        val skillFactor = skillPercent / 100
        val enchantFactor = enchantPercent / 100
        return 1 + itemFactor + skillFactor + enchantFactor
    }

}

/**
 * 스탯창 공격력, rounddown(A*B, 0)
 */
data class AttackPower(
    val base: BaseAttackPower,
    val amplifier: BaseAttackPowerAmplifier,
) {
    fun calculate(): Long = (base.calculate() * amplifier.calculate()).toLong()
}

/**
 * C장, 피해 증가
 */
data class DamageAmplifier(
    val given: Given,
    val taken: Taken,
) : Factor {

    override fun calculate(): Double = given.calculate() * taken.calculate()

    data class Given(
        val skillPower: Int,
        val skillPowerIncrementPercent: Double,
        val heliodorPercent: Double,
        val itemGivenDamagePercent: Double,
        val synergyDamageIncreasePercent: Double,
    ) {
        fun calculate(): Double = 1 + (skillPower / 8500.0) * (1 + skillPowerIncrementPercent / 100) + heliodorPercent / 100 + itemGivenDamagePercent / 100 + synergyDamageIncreasePercent / 100
    }

    data class Taken(
        val armorBreakPercent: Double,
        val synergyDamageIncrementPercent: Double,
    ) {
        fun calculate(): Double = 1 + armorBreakPercent / 100 + synergyDamageIncrementPercent / 100
    }

}

/**
 * D항, 강화류
 */
data class StrikeEnhancement(
    val chain: Int,
    val chainAmplifier: Double,
    val heavy: Int,
    val heavyAmplifier: Double,
    val aoe: Int,
    val aoeAmplifier: Double,
    val combo: Int,
    val comboAmplifier: Double,
    val ultimate: Int,
    val ultimateAmplifier: Double,
) : Factor {

    override fun calculate(): Double {
        val chainFactor = calculateChainFactor(chain, chainAmplifier)
        val heavyFactor = calculateHeavyFactor(heavy, heavyAmplifier)
        val aoeFactor = calculateAoeFactor(aoe, aoeAmplifier)
        val comboFactor = calculateComboFactor(combo, comboAmplifier)
        val ultimateFactor = calculateUltimateFactor(ultimate, ultimateAmplifier)
        return 1 + chainFactor + heavyFactor + aoeFactor + comboFactor + ultimateFactor
    }

    private fun calculateChainFactor(stat: Int, statPercentage: Double): Double =
        (1 + stat / 8500.0) * (1 + statPercentage / 100.0) - 1

    private fun calculateHeavyFactor(stat: Int, statPercentage: Double): Double =
        (1 + stat / 8500.0) * (1 + statPercentage / 100.0) - 1

    private fun calculateAoeFactor(stat: Int, statPercentage: Double): Double =
        (1 + stat / 8500.0) * (1 + statPercentage / 100.0) - 1

    private fun calculateComboFactor(stat: Int, statPercentage: Double): Double =
        (1 + stat / 8500.0) * (1 + statPercentage / 100.0) - 1

    private fun calculateUltimateFactor(stat: Int, statPercentage: Double): Double =
        (1 + stat / 8500.0) * (1 + statPercentage / 100.0) - 1

}

/**
 * E항, 보석
 */
data class Jewel(
    val chainPercentage: Double,
    val heavyPercentage: Double,
    val subPercentage: Double,
    val elementalPercentage: Double,
    val survivalPercentage: Double,
    val interruptingPercentage: Double,
) : Factor {
    // 특정 스킬에 대한 보석 반영분만 계산하기 위해 필요
    override fun calculate(): Double = 0.0
}

/**
 * F항, 치명타
 */
data class Critical(
    val critical: Int,
) : Factor {

    override fun calculate(): Double = 1 + probability() * (factor() - 1)

    private fun probability(): Double {
        TODO()
    }

    private fun factor(): Double {
        TODO()
    }

}

/**
 * G항, 무방비
 */
data class Vulnerable(
    val breaking: Int,
) : Value {
    override fun calculate(): Long = TODO()
}

/**
 * H항, 스킬 계수 강화
 */
class SkillFactorAmplifier : Value {
    override fun calculate(): Long = TODO()
}

/**
 * I항, 방어력 감소율
 */
data class DefenseReduction(
    val defense: Int,
) : Value {
    override fun calculate(): Long = TODO()
}

/**
 * J항, 카운터
 */
class Counter(
) : Value {
    override fun calculate(): Long = TODO()
}

/**
 * K항, 추가타
 */
 data class AdditionalHit(
    val additionalHit: Int,
 ) : Value {
    override fun calculate(): Long = TODO()
 }

/**
 * L항, 최종 데미지 증가
 */
data class FinalDamageAmplifier(
    val give: Int,
    val take: Int,
) : Value {
    override fun calculate(): Long = TODO()
}

/**
 * 스킬 계수
 */
data class SkillFactor(
    val level: Int,
) : Value {
    override fun calculate(): Long = TODO()
}

class Etcs() : Value {
    override fun calculate(): Long = TODO()
}
