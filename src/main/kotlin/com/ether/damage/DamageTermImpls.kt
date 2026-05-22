package com.ether.damage

import kotlin.math.roundToLong

/**
 * A항, 공격력
 */
data class BaseAttackPower(
    val character: Character,
    val weapon: Weapon,
    val necklaceSeal: Long,
    val pet: Long,
    val fashion: Long,
    val enchant: Long, // 오른쪽 장비 인챈트
    val runeWord: Long,
    val justice: Long,
) {
    fun calculate(): Long =
        character.calculate() + weapon.calculate() + necklaceSeal + pet + fashion + enchant + runeWord + justice

    data class Character(
        val levelBase: Long = 1995,
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
        val emblemPercentage: Double,
        val statBonus: Double,
    ) {
        fun calculate(): Long = ((base + rune + seal + skilled) * (1 + emblemPercentage / 100) + statBonus).roundToLong()
    }

}

/**
 * B항, 공격력 증가
 */
data class BaseAttackPowerAmplifier(
    val itemPercentage: Double,
    val skillPercentage: Double,
    val enchantPercentage: Double,
) : Factor {

    override fun calculate(): Double {
        val itemFactor = itemPercentage / 100
        val skillFactor = skillPercentage / 100
        val enchantFactor = enchantPercentage / 100
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
    fun calculate(): Long = (base.calculate() * amplifier.calculate()).roundToLong()
}

/**
 * C장, 피해 증가
 */
data class DamageAmplifier(
    val givePercentage: Double,
    val takePercentage: Double,
) : Factor {

    // TODO: 여기는 보강해야 함
    override fun calculate(): Double {
        val giveFactor = givePercentage / 100
        val takeFactor = takePercentage / 100
        return 1 + giveFactor + takeFactor
    }

}

/**
 * D항, 강화류
 */
data class StrikeEnhancement(
    val chain: Int,
    val chainAmplifier: Int,
    val heavy: Int,
    val heavyAmplifier: Int,
    val aoe: Int,
    val aoeAmplifier: Int,
    val combo: Int,
    val comboAmplifier: Int,
    val ultimate: Int,
    val ultimateAmplifier: Int,
) : Factor {

    // TODO: 가동률을 고려하는 게 더 합리적일 듯
    override fun calculate(): Double {
        val chainFactor = calculateChainFactor(chain, chainAmplifier)
        val heavyFactor = calculateHeavyFactor(heavy, heavyAmplifier)
        val aoeFactor = calculateAoeFactor(aoe, aoeAmplifier)
        val comboFactor = calculateComboFactor(combo, comboAmplifier)
        val ultimateFactor = calculateUltimateFactor(ultimate, ultimateAmplifier)
        return 1 + chainFactor + heavyFactor + aoeFactor + comboFactor + ultimateFactor
    }

    // TODO: 공통 부분이 반복되고 있으니 이 형태를 정의하는 게 좋을 것
    private fun calculateChainFactor(stat: Int, statPercentage: Int): Double =
        (1 + stat / 8500.0) * (1 + statPercentage / 100.0) - 1

    private fun calculateHeavyFactor(stat: Int, statPercentage: Int): Double =
        (1 + stat / 8500.0) * (1 + statPercentage / 100.0) - 1

    private fun calculateAoeFactor(stat: Int, statPercentage: Int): Double =
        (1 + stat / 8500.0) * (1 + statPercentage / 100.0) - 1

    private fun calculateComboFactor(stat: Int, statPercentage: Int): Double =
        (1 + stat / 8500.0) * (1 + statPercentage / 100.0) - 1

    private fun calculateUltimateFactor(stat: Int, statPercentage: Int): Double =
        (1 + stat / 8500.0) * (1 + statPercentage / 100.0) - 1

}

/**
 * E항, 보석. 체급 계산에는 굳이 필요 없을 것
 */
data class Jewel(
    val chain: Int,
    val heavy: Int,
    val sub: Int,
    val elemental: Int,
    val survival: Int,
    val interrupting: Int,
) : Factor {
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
