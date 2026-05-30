package com.ether.domain.damage

import com.ether.domain.damage.Vulnerable
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class VulnerableTest {

    @Test
    fun nonBreakingSetupTest() {
        val vulnerable = Vulnerable(
            breaking = 2015,
            vulnerableIncrementPercent = 0.0,
            isBreakExtend = false,
        )
        println("무방비 계수: %.3f".format(vulnerable.calculate()))
    }

    @Test
    fun breakingSetupTest() {
        val nonBreakExtendVulnerable = Vulnerable(
            breaking = 2015,
            vulnerableIncrementPercent = 48.0 + 30.0,
            isBreakExtend = false,
        )
        println("일반 무방비 계수: %.3f".format(nonBreakExtendVulnerable.calculate()))

        val breakExtendVulnerable = Vulnerable(
            breaking = 2015,
            vulnerableIncrementPercent = 48.0 + 30.0,
            isBreakExtend = true,
        )
        println("브레이크 익스텐드 시 무방비 계수: %.3f".format(breakExtendVulnerable.calculate()))
        Assertions.assertEquals(nonBreakExtendVulnerable.calculate() * 2, breakExtendVulnerable.calculate())
    }

}
