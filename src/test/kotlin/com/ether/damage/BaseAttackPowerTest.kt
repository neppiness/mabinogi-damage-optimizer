package com.ether.damage

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class BaseAttackPowerTest {

    @Test
    fun neppinessTest() {
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
            statBonus = 2806.2 + 1394.0,
        )
        println(String.format("weapon attack value: %d", weapon.calculate()))

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
        println(String.format("base attack value: %d", baseAttackPower.calculate()))

        val amplifier = BaseAttackPowerAmplifier(
            itemPercentage = 20.0,
            skillPercentage = 0.0,
            enchantPercentage = 1.7 * 4,
        )
        println(String.format("amplifier: %.3f", amplifier.calculate()))

        val statusAttack = AttackPower(baseAttackPower, amplifier)

        val actualTotalAttackPower = 31533L
        val actualBaseAttackPower = actualTotalAttackPower / amplifier.calculate()
        val actualCharacterLevelAttackPower = actualBaseAttackPower - (character.cards + character.titles + weapon.calculate() + baseAttackPower.necklaceSeal + baseAttackPower.pet + baseAttackPower.fashion + baseAttackPower.enchant + baseAttackPower.runeWord + baseAttackPower.justice)
        println("actual character level attack power: %.2f".format(actualCharacterLevelAttackPower))

        Assertions.assertEquals(actualTotalAttackPower, statusAttack.calculate())
    }

    @Test
    fun marshallTest() {
        val character = BaseAttackPower.Character(
            cards = 800,
            titles = 10,
        )
        println(String.format("character attack value: %d", character.calculate()))

        val weapon = BaseAttackPower.Weapon(
            base = 3374,
            rune = 4296,
            seal = 500,
            skilled = 465,
            emblemPercentage = 42.8,
            statBonus = 2719.2 + 1764,
        )
        println(String.format("weapon attack value: %d", weapon.calculate()))

        val baseAttackPower = BaseAttackPower(
            character = character,
            weapon = weapon,
            necklaceSeal = 250,
            pet = 0,
            fashion = 310,
            enchant = 204 * 6,
            runeWord = 600,
            justice = 745,
        )
        println(String.format("base attack value: %d", baseAttackPower.calculate()))

        val amplifier = BaseAttackPowerAmplifier(
            itemPercentage = 22.0,
            skillPercentage = 0.0,
            enchantPercentage = 1.7 * 4,
        )
        println(String.format("amplifier: %.3f", amplifier.calculate()))

        val statusAttack = AttackPower(baseAttackPower, amplifier)

        val actualTotalAttackPower = 29271L
        val actualBaseAttackPower = actualTotalAttackPower / amplifier.calculate()
        val actualCharacterLevelAttackPower = actualBaseAttackPower - (character.cards + character.titles + weapon.calculate() + baseAttackPower.necklaceSeal + baseAttackPower.pet + baseAttackPower.fashion + baseAttackPower.enchant + baseAttackPower.runeWord + baseAttackPower.justice)
        println("actual character level attack power: %.2f".format(actualCharacterLevelAttackPower))

        Assertions.assertEquals(actualTotalAttackPower, statusAttack.calculate())
    }

}
