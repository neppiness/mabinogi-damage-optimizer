package com.ether.stat

data class SubStats(
    val attackPower: Int,            // 공격력
    val defense: Int,                // 방어력

    val breaking: Int,               // 브레이크
    val heavyStrike: Int,            // 강타 강화
    val combo: Int,                  // 콤보 강화
    val skillPower: Int,             // 스킬 위력
    val aoeEnhancement: Int,         // 광역 강화
    val healingPower: Int,           // 회복력
    val dodge: Int,                  // 급소 회피
    val additionalHit: Int,          // 추가타

    val damageReduction: Int,        // 피해 감소
    val attackBoost: Int,            // 빠른 공격
    val chainStrike: Int,            // 연타 강화
    val skillSpeed: Int,             // 빠른 스킬
    val healthBonus: Int,            // 추가 체력
    val ultimateSkill: Int,          // 궁극기
    val criticalHit: Int             // 치명타
)
