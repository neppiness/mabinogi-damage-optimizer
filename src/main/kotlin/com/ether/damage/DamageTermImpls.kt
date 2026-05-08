package com.ether.damage

/**
 * A항, 공격력
 */
data class AttackPower(
    val character: Int,
    val weapon: Int,
    val necklace: Int,
    val pet: Int,
    val fashion: Int,
    val enchant: Int,
    val runeWord: Int,
    val paladin: Int,
) : DamageTerm {
    override fun toValue(): Int = character + weapon + necklace + pet + fashion + enchant + runeWord + paladin
}

/**
 * B항, 공격력 증가
 */
data class AttackPowerAmplifier(
    val item: Int,
    val skill: Int,
    val enchant: Int,
) : DamageTerm {
    override fun toValue(): Int = TODO()
}

/**
 * C장, 피해 증가
 */
data class DamageAmplifier(
    val give: Int,
    val take: Int,
) : DamageTerm {
    override fun toValue(): Int = TODO()
}

/**
 * D항, 강화류
 */
data class StrikeEnhancement(
    val chain: Int,
    val heavy: Int,
    val aoe: Int,
    val combo: Int,
    val ult: Int,
) : DamageTerm {
    override fun toValue(): Int = TODO()
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
) : DamageTerm {
    override fun toValue(): Int = 0
}

/**
 * F항, 치명타
 */
data class Critical(
    val critical: Int,
) : DamageTerm {
    override fun toValue(): Int = TODO()
    private fun probability() : Int = TODO()
    private fun amplifier() : Int = TODO()
}

/**
 * G항, 무방비
 */
data class Vulnerable(
    val breaking: Int,
) : DamageTerm {
    override fun toValue(): Int = TODO()
}

/**
 * H항, 스킬 계수 강화
 */
class SkillFactorAmplifier : DamageTerm {
    override fun toValue(): Int = TODO()
}

/**
 * I항, 방어력 감소율
 */
data class DefenseReduction(
    val defense: Int,
) : DamageTerm {
    override fun toValue(): Int = TODO()
}

/**
 * J항, 카운터
 */
class Counter(
) : DamageTerm {
    override fun toValue(): Int = TODO()
}

/**
 * K항, 추가타
 */
 data class AdditionalHit(
    val additionalHit: Int,
 ) : DamageTerm {
    override fun toValue(): Int = TODO()
 }

/**
 * L항, 최종 데미지 증가
 */
data class FinalDamageAmplifier(
    val give: Int,
    val take: Int,
) : DamageTerm {
    override fun toValue(): Int = TODO()
}

/**
 * 스킬 계수
 */
data class SkillFactor(
    val level: Int,
) : DamageTerm {
    override fun toValue(): Int = TODO()
}

class Etcs() : DamageTerm {
    override fun toValue(): Int = TODO()
}
