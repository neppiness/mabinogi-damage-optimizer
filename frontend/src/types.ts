export type Page = 'equipment' | 'rune' | 'result'

export interface EnchantRow {
  count: number
  value: number
}

export interface EquipmentState {
  str: number
  dex: number
  int: number
  wil: number
  lck: number

  breakStat: number
  heavyHit: number
  combo: number
  skillPower: number
  aoe: number
  recovery: number
  critAvoid: number
  additionalHit: number
  damageReduction: number
  fastAttack: number
  multiHit: number
  fastSkill: number
  additionalHp: number
  ultimate: number
  criticalHit: number

  levelupBonusAtk: number
  paladinJustice: number
  runeWordAtk: number

  necklaceEquipAtk: number
  necklaceBlessingAtk: number

  weaponMainStatBonus: number
  weaponSubStatBonus: number
  weaponBaseAtk: number
  weaponBlessingAtk: number
  weaponProficiencyAtk: number
  weaponEmblemAtkRate: number

  rightEnchantRates: EnchantRow[]
  leftEnchantAtk: EnchantRow[]

  fashionSetAtk: number
  petAtk: number
}
