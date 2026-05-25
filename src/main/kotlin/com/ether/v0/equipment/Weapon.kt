package com.ether.v0.equipment

import com.ether.v0.character.CharacterType

data class Weapon(
    val characterType : CharacterType,
    val attackPower : Int,
) {
}
