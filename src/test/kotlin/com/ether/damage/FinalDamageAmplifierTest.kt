package com.ether.damage

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class FinalDamageAmplifierTest {

    @Test
    fun neppinessTest() {
        val finalDamageAmplifier = FinalDamageAmplifier(9.0)
        Assertions.assertEquals(1.09, finalDamageAmplifier.calculate())
    }

}
