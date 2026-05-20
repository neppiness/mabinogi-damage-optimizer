package com.ether.damage

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class BaseAttackPowerTest {

    @Nested
    internal inner class Neppiness {
        @Test
        fun case1() {
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

            val actualTotalAttackPower = 31531L
            val actualBaseAttackPower = actualTotalAttackPower / amplifier.calculate()
            val actualCharacterLevelAttackPower = actualBaseAttackPower - (character.cards + character.titles + weapon.calculate() + baseAttackPower.necklaceSeal + baseAttackPower.pet + baseAttackPower.fashion + baseAttackPower.enchant + baseAttackPower.runeWord + baseAttackPower.justice)
            println("actual character level attack power: %.2f".format(actualCharacterLevelAttackPower))

            Assertions.assertEquals(statusAttack.calculate(), actualTotalAttackPower)
        }

        @Test
        fun case2() {
            val character = BaseAttackPower.Character(
                cards = 800,
                titles = 865,
            )
            println(String.format("character attack value: %d", character.calculate()))

            val weapon = BaseAttackPower.Weapon(
                base = 3321,
                rune = 550,
                seal = 500,
                skilled = 3100,
                emblemPercentage = 0.0,
                statBonus = 2083.2 + 1308,
            )
            println(String.format("weapon attack value: %.2f", weapon.calculate()))

            val baseAttackPower = BaseAttackPower(
                character = character,
                weapon = weapon,
                necklaceSeal = 250,
                pet = 0,
                fashion = 310,
                enchant = 204 * 5,
                runeWord = 690,
                justice = 878,
            )
            println(String.format("base attack value: %.2f", baseAttackPower.calculate()))

            val amplifier = BaseAttackPowerAmplifier(
                itemPercentage = 20.0,
                skillPercentage = 0.0,
                enchantPercentage = 1.7 * 3,
            )
            println(String.format("amplifier: %.3f", amplifier.calculate()))

            val statusAttack = AttackPower(baseAttackPower, amplifier)

            val actualTotalAttackPower = 22105L
            val actualBaseAttackPower = actualTotalAttackPower / amplifier.calculate()
            val actualCharacterLevelAttackPower = actualBaseAttackPower - (character.cards + character.titles + weapon.calculate() + baseAttackPower.necklaceSeal + baseAttackPower.pet + baseAttackPower.fashion + baseAttackPower.enchant + baseAttackPower.runeWord + baseAttackPower.justice)
            println("actual character level attack power: %.2f".format(actualCharacterLevelAttackPower))

            Assertions.assertEquals(statusAttack.calculate(), actualTotalAttackPower)
        }

        @Test
        fun case3() {
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
                itemPercentage = 22.0,
                skillPercentage = 0.0,
                enchantPercentage = 1.7 * 4,
            )
            println(String.format("amplifier: %.3f", amplifier.calculate()))

            val statusAttack = AttackPower(baseAttackPower, amplifier)

            val actualTotalAttackPower = 32029L
            val actualBaseAttackPower = actualTotalAttackPower / amplifier.calculate()
            val actualCharacterLevelAttackPower = actualBaseAttackPower - (character.cards + character.titles + weapon.calculate() + baseAttackPower.necklaceSeal + baseAttackPower.pet + baseAttackPower.fashion + baseAttackPower.enchant + baseAttackPower.runeWord + baseAttackPower.justice)
            println("actual character level attack power: %.2f".format(actualCharacterLevelAttackPower))

            Assertions.assertEquals(statusAttack.calculate(), actualTotalAttackPower)
        }
    }

    @Nested
    internal inner class MarshallJr {

        @Test
        fun case1() {
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
            println(String.format("weapon attack value: %.2f", weapon.calculate()))

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
            println(String.format("base attack value: %.2f", baseAttackPower.calculate()))

            val amplifier = BaseAttackPowerAmplifier(
                itemPercentage = 22.0,
                skillPercentage = 0.0,
                enchantPercentage = 1.7 * 4,
            )
            println(String.format("amplifier: %.3f", amplifier.calculate()))

            val statusAttack = AttackPower(baseAttackPower, amplifier)

            val actualTotalAttackPower = 29297L
            val actualBaseAttackPower = actualTotalAttackPower / amplifier.calculate()
            val actualCharacterLevelAttackPower = actualBaseAttackPower - (character.cards + character.titles + weapon.calculate() + baseAttackPower.necklaceSeal + baseAttackPower.pet + baseAttackPower.fashion + baseAttackPower.enchant + baseAttackPower.runeWord + baseAttackPower.justice)
            println("actual character level attack power: %.2f".format(actualCharacterLevelAttackPower))

            Assertions.assertEquals(statusAttack.calculate(), actualTotalAttackPower)
        }

    }

}
