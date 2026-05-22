package com.ether.damage

import org.junit.jupiter.api.Test

internal class DamageAmplifierTest {

    @Test
    fun neppinessTest() {
        val given = DamageAmplifier.Given(
            skillPower = 1758,
            skillPowerPercentage = 0.0,
            heliodor = 0.0,
            itemGivenDamagePercentage = 21.0 + 26.0,
            synergyDamageIncrease = 0.0,
        )
        println(String.format("주는 피해 증가 계수: %.3f", given.calculate()))

        val taken = DamageAmplifier.Taken(
            armorBreakPercentage = 0.0,
            synergyDamageIncreasePercentage = 10.0,
        )
        println(String.format("받는 피해 증가 계수: %.3f", taken.calculate()))

        val damageAmplifier = DamageAmplifier(
            given = given,
            taken = taken,
        )
        println(String.format("피해 증가 계수: %.4f", damageAmplifier.calculate()))
    }

}
