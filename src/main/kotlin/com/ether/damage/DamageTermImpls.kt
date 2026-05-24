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
    val chainMultiplierPercent: Double,
    val heavy: Int,
    val heavyMultiplierPercent: Double,
    val aoe: Int,
    val aoeMultiplierPercent: Double,
    val combo: Int,
    val comboMultiplierPercent: Double,
    val ultimate: Int,
    val ultimateMultiplierPercent: Double,
) : Factor {

    override fun calculate(): Double {
        val chainFactor = calculateChainFactor()
        val heavyFactor = calculateHeavyFactor()
        val aoeFactor = calculateAoeFactor()
        val comboFactor = calculateComboFactor()
        val ultimateFactor = calculateUltimateFactor()
        return 1 + chainFactor + heavyFactor + aoeFactor + comboFactor + ultimateFactor
    }

    fun calculateChainFactor(): Double =
        (1 + chain / 8500.0) * (1 + chainMultiplierPercent / 100.0) - 1

    fun calculateHeavyFactor(): Double =
        (1 + heavy / 8500.0) * (1 + heavyMultiplierPercent / 100.0) - 1

    fun calculateAoeFactor(): Double =
        (1 + aoe / 8500.0) * (1 + aoeMultiplierPercent / 100.0) - 1

    fun calculateComboFactor(): Double =
        (1 + combo / 8500.0) * (1 + comboMultiplierPercent / 100.0) - 1

    fun calculateUltimateFactor(): Double =
        (1 + ultimate / 8500.0) * (1 + ultimateMultiplierPercent / 100.0) - 1

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
    val stat: Int,
    val probabilityIncrementPercent: Double, // 치명타 확률 증가: 룬, 캐릭터, 던전 보너스
    val damageIncrementPercent: Double, // 치명타 데미지 증가: 룬,
) : Factor {

    override fun calculate(): Double = 1 + probability() * (multiplier() - 1)

    fun probability(): Double = (0.5 - 1 / (2 + stat / 1000.0) + probabilityIncrementPercent / 100).coerceAtMost(1.0)
    fun multiplier(): Double = (1.4 + stat / 5000.0) * (1 + damageIncrementPercent / 100)

}

/**
 * G항, 무방비
 */
data class Vulnerable(
    val breaking: Int,
    val vulnerableIncrementPercent: Double,
    val isBreakExtend: Boolean,
) : Factor {

    override fun calculate(): Double {
        val tagDamageIncrementPercent = 0.0 // TODO
        val multiplier = (1 + breaking / 5250) * (1 + vulnerableIncrementPercent / 100) + (20 + tagDamageIncrementPercent) / 100.0
        return if (isBreakExtend) multiplier * 2 else multiplier
    }

}

/**
 * H항, 스킬 계수 강화
 */
class SkillFactorAmplifier : Factor {
    override fun calculate(): Double = 1.0
}

/**
 * I항, 방어력 감소율
 */
data class DefenseReduction(
    val enemyDefense: Int,
    val defenseReduction: Double,
) : Factor {
    override fun calculate(): Double = 1 / (1 + enemyDefense * (1 - defenseReduction / 100) / 10328)
}

/**
 * J항, 카운터
 */
class Counter(
    val isCounter: Boolean,
) : Factor {
    override fun calculate(): Double = if (isCounter) 1.1 else 1.0
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
