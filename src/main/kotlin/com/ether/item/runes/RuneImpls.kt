package com.ether.item.runes

import com.ether.item.Rune

// 뇌명
class Thunder : Rune {
    override fun getHeavyStrikePercent(
        isAwakening: Boolean,
        transcendenceLevel: Int,
        itemLevel: Int,
    ): Double = when (transcendenceLevel) {
        0 -> 20.0
        1 -> 22.0
        2 -> 24.0
        else -> throw IllegalArgumentException("잘못된 초월 레벨입니다.")
    }
}

// 아득한 힘
class DistantLight : Rune {
    override fun getCriticalProbabilityPercent(
        isAwakening: Boolean,
        transcendenceLevel: Int,
        itemLevel: Int,
    ): Double {
        val constant = 5.0
        return constant + if (isAwakening) 20.0 else 0.0
    }

    override fun getCriticalDamagePercent(
        isAwakening: Boolean,
        transcendenceLevel: Int,
        itemLevel: Int,
    ): Double {
        val constant = 10.0
        val awakening = if (!isAwakening) 0.0 else when (transcendenceLevel) {
            0 -> 50.0
            1 -> 50.0
            2 -> 62.0
            else -> throw IllegalArgumentException("잘못된 초월 레벨입니다.")
        }
        return constant + awakening
    }

    override fun getGivenDamagePercent(
        isAwakening: Boolean,
        transcendenceLevel: Int,
        itemLevel: Int,
    ): Double = when (transcendenceLevel) {
        0 -> 5.0
        1 -> 7.0
        2 -> 7.0
        else -> throw IllegalArgumentException("잘못된 초월 레벨입니다.")
    }
}

// 압도적인 힘
class OverwhelmingPower : Rune {
    override fun getAttackPowerPercent(
        isAwakening: Boolean,
        transcendenceLevel: Int,
        itemLevel: Int,
    ): Double {
        val constant = when (transcendenceLevel) {
            0 -> 6.0
            1 -> 8.0
            2 -> 10.0
            else -> throw IllegalArgumentException("잘못된 초월 레벨입니다.")
        }
        return if (isAwakening) constant * 2 else constant
    }

    override fun getHeavyStrikePercent(
        isAwakening: Boolean,
        transcendenceLevel: Int,
        itemLevel: Int,
    ): Double {
        val constant = 6.0
        return if (isAwakening) constant * 2 else constant
    }

    override fun getCriticalProbabilityPercent(
        isAwakening: Boolean,
        transcendenceLevel: Int,
        itemLevel: Int,
    ): Double {
        val constant = 4.0
        return if (isAwakening) constant * 2 else constant
    }
}

// 섬세한 손놀림
class DelicateHandling : Rune {
    override fun getAttackPowerPercent(
        isAwakening: Boolean,
        transcendenceLevel: Int,
        itemLevel: Int,
    ): Double {
        val constant = when (transcendenceLevel) {
            0 -> 6.0
            1 -> 8.0
            2 -> 10.0
            else -> throw IllegalArgumentException("잘못된 초월 레벨입니다.")
        }
        return if (isAwakening) constant * 2 else constant
    }

    override fun getChainStrikePercent(
        isAwakening: Boolean,
        transcendenceLevel: Int,
        itemLevel: Int,
    ): Double {
        val constant = 6.0
        return if (isAwakening) constant * 2 else constant
    }

    override fun getAdditionalHitPercent(
        isAwakening: Boolean,
        transcendenceLevel: Int,
        itemLevel: Int,
    ): Double {
        val constant = 4.0
        return if (isAwakening) constant * 2 else constant
    }
}

// 불안정한 힘
class UnstablePower : Rune {
    override fun getGivenDamagePercent(
        isAwakening: Boolean,
        transcendenceLevel: Int,
        itemLevel: Int,
    ): Double = when (transcendenceLevel) {
        0 -> 22.0
        1 -> 24.0
        2 -> 26.0
        else -> throw IllegalArgumentException("잘못된 초월 레벨입니다.")
    }
}

// 검게 물든 후광
class DarkenHalo : Rune {
    override fun getGivenDamagePercent(
        isAwakening: Boolean,
        transcendenceLevel: Int,
        itemLevel: Int,
    ): Double {
        val constant = 15.0
        return when {
            itemLevel >= 15 -> constant + 12;
            itemLevel >= 10 -> constant + 6;
            else -> constant;
        }
    }
}
