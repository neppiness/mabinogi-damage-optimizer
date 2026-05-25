package com.ether.equipment

import com.ether.character.CharacterType

data class Weapon(
    val characterType : CharacterType,
    val attackPower : Int,
) {
}
