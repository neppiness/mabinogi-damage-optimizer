package com.ether.domain.damage

import com.ether.domain.damage.AttackPower
import com.ether.domain.damage.BaseAttackPower
import com.ether.domain.damage.BaseAttackPowerAmplifier
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class BaseAttackPowerTest {

    @Test
    fun fullItemTest() {
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
            emblemPercent = 42.8,
            statBonus = 2806.2 + 1394.0,
        )
        println(String.format("weapon attack value: %d", weapon.calculate()))

        val baseAttackPower = BaseAttackPower(
            character = character,
            weapon = weapon,
            necklace = 498,
            necklaceSeal = 250,
            pet = 0,
            fashion = 310,
            enchant = 204 * 6,
            runeWord = 690,
            justice = 878,
        )
        println(String.format("base attack value: %d", baseAttackPower.calculate()))

        val amplifier = BaseAttackPowerAmplifier(
            itemPercent = 20.0,
            skillPercent = 0.0,
            enchantPercent = 1.7 * 4,
        )
        println(String.format("amplifier: %.3f", amplifier.calculate()))

        val statusAttack = AttackPower(baseAttackPower, amplifier)

        val actualTotalAttackPower = 31533L
        val actualBaseAttackPower = actualTotalAttackPower / amplifier.calculate()
        val actualCharacterLevelAttackPower = calculateActualCharacterLevelAttackPower(actualBaseAttackPower, baseAttackPower)
        println("actual character level attack power: %.2f".format(actualCharacterLevelAttackPower))

        Assertions.assertEquals(actualTotalAttackPower, statusAttack.calculate())
    }

    @Test
    fun noItemTest() {
        val character = BaseAttackPower.Character(
            cards = 800,
            titles = 865,
        )
        println(String.format("character attack value: %d", character.calculate()))

        val weapon = BaseAttackPower.Weapon(
            base = 0,
            rune = 0,
            seal = 0,
            skilled = 0,
            emblemPercent = 0.0,
            statBonus = 0.0,
        )
        println(String.format("weapon attack value: %d", weapon.calculate()))

        val baseAttackPower = BaseAttackPower(
            character = character,
            weapon = weapon,
            necklace = 0,
            necklaceSeal = 0,
            pet = 0,
            fashion = 310,
            enchant = 0,
            runeWord = 690,
            justice = 878,
        )
        println(String.format("base attack value: %d", baseAttackPower.calculate()))

        val amplifier = BaseAttackPowerAmplifier(
            itemPercent = 0.0,
            skillPercent = 0.0,
            enchantPercent = 0.0,
        )
        println(String.format("amplifier: %.3f", amplifier.calculate()))

        val statusAttack = AttackPower(baseAttackPower, amplifier)

        val actualTotalAttackPower = 5041L
        val actualBaseAttackPower = actualTotalAttackPower / amplifier.calculate()
        val actualCharacterLevelAttackPower = calculateActualCharacterLevelAttackPower(actualBaseAttackPower, baseAttackPower)
        println("actual character level attack power: %.2f".format(actualCharacterLevelAttackPower))

        Assertions.assertEquals(actualTotalAttackPower, statusAttack.calculate())
    }

    @Test
    fun weaponOnlyTest() {
        val character = BaseAttackPower.Character(
            cards = 800,
            titles = 865,
        )
        println(String.format("character attack value: %d", character.calculate()))

        val weapon = BaseAttackPower.Weapon(
            base = 3383,
            rune = 4285,
            seal = 500,
            skilled = 0,
            emblemPercent = 0.0,
            statBonus = 1473.0 + 796.0,
        )
        println(String.format("weapon attack value: %d", weapon.calculate()))

        val baseAttackPower = BaseAttackPower(
            character = character,
            weapon = weapon,
            necklace = 0,
            necklaceSeal = 0,
            pet = 0,
            fashion = 310,
            enchant = 0,
            runeWord = 690,
            justice = 878,
        )
        println(String.format("base attack value: %d", baseAttackPower.calculate()))

        val amplifier = BaseAttackPowerAmplifier(
            itemPercent = 0.0,
            skillPercent = 0.0,
            enchantPercent = 1.7,
        )
        println(String.format("amplifier: %.3f", amplifier.calculate()))

        val statusAttack = AttackPower(baseAttackPower, amplifier)

        val actualTotalAttackPower = 15741L
        val actualBaseAttackPower = actualTotalAttackPower / amplifier.calculate()
        val actualCharacterLevelAttackPower = calculateActualCharacterLevelAttackPower(actualBaseAttackPower, baseAttackPower)
        println("actual character level attack power: %.2f".format(actualCharacterLevelAttackPower))

        Assertions.assertEquals(actualTotalAttackPower, statusAttack.calculate())
    }

    private fun calculateActualCharacterLevelAttackPower(
        actualBaseAttackPower: Double,
        baseAttackPower: BaseAttackPower,
    ): Double {
        val character = baseAttackPower.character
        val weapon = baseAttackPower.weapon
        val baseAttackPowerExceptLevelTerm = character.cards + character.titles + weapon.calculate() +
                        baseAttackPower.necklace + baseAttackPower.necklaceSeal + baseAttackPower.pet +
                        baseAttackPower.fashion + baseAttackPower.enchant + baseAttackPower.runeWord +
                        baseAttackPower.justice
        return actualBaseAttackPower - baseAttackPowerExceptLevelTerm
    }

}
