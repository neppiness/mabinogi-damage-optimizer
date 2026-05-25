package com.ether.stat

data class SubStats(
    val attack: Int = 0,                 // 공격력
    val defense: Int = 0,                // 방어력

    val breaking: Int = 0,               // 브레이크
    val damageReduction: Int = 0,        // 피해 감소
    val heavyStrike: Int = 0,            // 강타 강화

    val attackSpeed: Int = 0,            // 빠른 공격
    val comboStrike: Int = 0,            // 콤보 강화
    val chainStrike: Int = 0,            // 연타 강화

    val skillPower: Int = 0,             // 스킬 위력
    val skillSpeed: Int = 0,             // 빠른 스킬
    val aoeStrike: Int = 0,              // 광역 강화

    val additionalHealth: Int = 0,       // 추가 체력
    val heal: Int = 0,                   // 회복력
    val ultimate: Int = 0,               // 궁극기

    val dodge: Int = 0,                  // 급소 회피
    val critical: Int = 0,               // 치명타
    val additionalHit: Int = 0,          // 추가타
) {

    fun reflection(mainStats: MainStats): SubStats {
        return SubStats(
            breaking = mainStats.strength / 4,
            damageReduction = mainStats.strength / 4,
            heavyStrike = mainStats.strength / 4,

            attackSpeed = mainStats.skill / 4,
            comboStrike = mainStats.skill / 4,
            chainStrike = mainStats.skill / 4,

            skillPower = mainStats.intelligence / 4,
            skillSpeed = mainStats.intelligence / 4,
            aoeStrike = mainStats.intelligence / 4,

            additionalHealth = mainStats.will / 4,
            heal = mainStats.will / 4,
            ultimate = mainStats.will / 4,

            dodge = mainStats.luck / 4,
            critical = mainStats.luck / 4,
            additionalHit = mainStats.luck / 4,
        )
    }

    operator fun plus(rightTerm: SubStats): SubStats {
        return SubStats(
            attack = attack + rightTerm.attack,
            defense = defense + rightTerm.defense,

            breaking = breaking + rightTerm.breaking,
            damageReduction = damageReduction + rightTerm.damageReduction,
            heavyStrike = heavyStrike + rightTerm.heavyStrike,

            attackSpeed = attackSpeed + rightTerm.attackSpeed,
            comboStrike = comboStrike + rightTerm.comboStrike,
            chainStrike = chainStrike + rightTerm.chainStrike,

            skillPower = skillPower + rightTerm.skillPower,
            skillSpeed = skillSpeed + rightTerm.skillSpeed,
            aoeStrike = aoeStrike + rightTerm.aoeStrike,

            additionalHealth = additionalHealth + rightTerm.additionalHealth,
            heal = heal + rightTerm.heal,
            ultimate = ultimate + rightTerm.ultimate,

            dodge = dodge + rightTerm.dodge,
            critical = critical + rightTerm.critical,
            additionalHit = additionalHit + rightTerm.additionalHit,
        )
    }

    companion object {
        fun sum(vararg stats: SubStats): SubStats {
            return stats.fold(SubStats()) { acc, stat ->
                acc + stat
            }
        }
    }

}
