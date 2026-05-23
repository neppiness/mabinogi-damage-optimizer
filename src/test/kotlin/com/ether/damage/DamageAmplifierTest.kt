package com.ether.damage

import org.junit.jupiter.api.Test

internal class DamageAmplifierTest {

    @Test
    fun neppinessTest() {
        val given = DamageAmplifier.Given(
            skillPower = 1758,
            skillPowerIncrementPercent = 0.0,
            heliodorPercent = 0.0,
            itemGivenDamagePercent = 21.0 + 26.0,
            synergyDamageIncreasePercent = 0.0,
        )
        println(String.format("주는 피해 증가 계수: %.3f", given.calculate()))

        val taken = DamageAmplifier.Taken(
            armorBreakPercent = 0.0,
            synergyDamageIncrementPercent = 10.0,
        )
        println(String.format("받는 피해 증가 계수: %.3f", taken.calculate()))

        val damageAmplifier = DamageAmplifier(
            given = given,
            taken = taken,
        )
        println(String.format("피해 증가 계수: %.4f", damageAmplifier.calculate()))
    }

}
