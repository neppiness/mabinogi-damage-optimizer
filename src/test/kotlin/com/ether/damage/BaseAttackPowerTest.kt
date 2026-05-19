package com.ether.damage

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class BaseAttackPowerTest {

    @Test
    fun testCaseOne() {
        val character = BaseAttackPower.Character(
            cards = 800,
            titles = 865,
        )
        println(String.format("character attack value: %d", character.calculate()))

        val weapon = BaseAttackPower.Weapon(
            base = 3383,
            rune = 4285,
            seal = 500,
            skilled = 1395,
            emblemPercentage = 42.8,
            statBonus = 2805.0 + 1394.0,
        )
        println(String.format("weapon attack value: %.2f", weapon.calculate()))

        val baseAttackPower = BaseAttackPower(
            character = character,
            weapon = weapon,
            necklaceSeal = 250,
            pet = 0,
            fashion = 310,
            enchant = 204 * 6,
            runeWord = 690,
            justice = 878,
        )
        println(String.format("base attack value: %.2f", baseAttackPower.calculate()))

        val amplifier = BaseAttackPowerAmplifier(
            itemPercentage = 20.0,
            skillPercentage = 0.0,
            enchantPercentage = 1.7 * 4,
        )
        println(String.format("amplifier: %.3f", amplifier.calculate()))

        val statusAttack = AttackPower(baseAttackPower, amplifier)
        Assertions.assertEquals(statusAttack.calculate(), 31531)
    }

    @Test
    fun testCaseTwo() {
        val character = BaseAttackPower.Character(
            cards = 800,
            titles = 865,
        )
        println(String.format("character attack value: %d", character.calculate()))

        val weapon = BaseAttackPower.Weapon(
            base = 3324,
            rune = 4285,
            seal = 500,
            skilled = 1395,
            emblemPercentage = 42.8,
            statBonus = 2793.6 + 1388.8,
        )
        println(String.format("weapon attack value: %.2f", weapon.calculate()))

        val baseAttackPower = BaseAttackPower(
            character = character,
            weapon = weapon,
            necklaceSeal = 250,
            pet = 0,
            fashion = 310,
            enchant = 204 * 6,
            runeWord = 690,
            justice = 867,
        )
        println(String.format("base attack value: %.2f", baseAttackPower.calculate()))

        val amplifier = BaseAttackPowerAmplifier(
            itemPercentage = 22.0,
            skillPercentage = 0.0,
            enchantPercentage = 1.7 * 4,
        )
        println(String.format("amplifier: %.3f", amplifier.calculate()))

        val statusAttack = AttackPower(baseAttackPower, amplifier)
        Assertions.assertEquals(statusAttack.calculate(), 31878)
    }

}
