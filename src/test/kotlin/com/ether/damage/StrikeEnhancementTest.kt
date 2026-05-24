package com.ether.damage

import org.junit.jupiter.api.Test

internal class StrikeEnhancementTest {

    @Test
    fun neppinessTest() {
        val enhancement = StrikeEnhancement(
            chain = 1125,
            chainMultiplierPercent = 6.0,
            heavy = 4352,
            heavyMultiplierPercent = 30.0,
            aoe = 965,
            aoeMultiplierPercent = 0.0,
            combo = 1146,
            comboMultiplierPercent = 0.0,
            ultimate = 891,
            ultimateMultiplierPercent = 0.0,
        )
        val chain = enhancement.calculateChainFactor()
        println("연타 피해 증가 계수: %.3f".format(chain))

        val heavy = enhancement.calculateHeavyFactor()
        println("강타 피해 증가 계수: %.3f".format(heavy))

        val aoe = enhancement.calculateAoeFactor()
        println("광역 피해 증가 계수: %.3f".format(aoe))

        val combo = enhancement.calculateComboFactor()
        println("콤보 피해 증가 계수: %.3f".format(combo))

        val ultimate = enhancement.calculateUltimateFactor()
        println("궁극기 피해 증가 계수: %.3f".format(ultimate))

        println("총 피해 증가 계수: %.3f".format(enhancement.calculate()))
    }

}
