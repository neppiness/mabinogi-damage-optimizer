package com.ether.domain.damage

import com.ether.domain.damage.Critical
import org.junit.jupiter.api.Test

internal class CriticalTest {

    @Test
    fun neppinessTest() {
        val critical = Critical(
            stat = 6657,
            probabilityIncrementPercent = 5.0 + 4.0,
            damageIncrementPercent = 10.0,
        )
        val probability = critical.probability()
        println("치명타 확률: %.3f".format(probability))

        val multiplier = critical.multiplier()
        println("치명타 피해 증가 계수: %.3f".format(multiplier))

        println("총 치명타 기댓값 계수: %.3f".format(critical.calculate()))
    }

}
