package com.ether.damage

import org.junit.jupiter.api.Test

internal class AdditionalHitTest {

    @Test
    fun additionalHitTest() {
        val additionalHit = AdditionalHit(
            additionalHit = 1920,
            additionalHitIncrementPercent = 4.0,
        )
        println("추가타 기댓값 계수: %.3f".format(additionalHit.calculate()))
    }

}
