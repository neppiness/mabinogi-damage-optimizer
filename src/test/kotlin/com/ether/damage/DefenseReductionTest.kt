package com.ether.damage

import com.ether.damage.DefenseReduction
import org.junit.jupiter.api.Test

internal class DefenseReductionTest {

    @Test
    fun withDefenseReductionTest() {
        val defenseReduction = DefenseReduction(
            enemyDefense = 6410,
            defenseReduction = 10.0,
        )
        println("방어력 감소율: %.3f".format(defenseReduction.calculate()))
    }

    @Test
    fun withoutDefenseReductionTest() {
        val defenseReduction = DefenseReduction(
            enemyDefense = 6410,
            defenseReduction = 0.0,
        )
        println("방어력 감소율: %.3f".format(defenseReduction.calculate()))
    }

}
