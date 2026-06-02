import { useState } from 'react'
import type { EquipmentState } from '../types'

const INITIAL: EquipmentState = {
  str: 0,
  dex: 0,
  int: 0,
  wil: 0,
  lck: 0,
  breakStat: 0,
  heavyHit: 0,
  combo: 0,
  skillPower: 0,
  aoe: 0,
  recovery: 0,
  critAvoid: 0,
  additionalHit: 0,
  damageReduction: 0,
  fastAttack: 0,
  multiHit: 0,
  fastSkill: 0,
  additionalHp: 0,
  ultimate: 0,
  criticalHit: 0,
  levelupBonusAtk: 0,
  paladinJustice: 0,
  runeWordAtk: 0,
  necklaceEquipAtk: 0,
  necklaceBlessingAtk: 0,
  weaponMainStatBonus: 0,
  weaponSubStatBonus: 0,
  weaponBaseAtk: 0,
  weaponBlessingAtk: 0,
  weaponProficiencyAtk: 0,
  weaponEmblemAtkRate: 0,
  rightEnchantRates: [
    { count: 0, value: 1.5 },
    { count: 0, value: 1.6 },
    { count: 0, value: 1.7 },
  ],
  leftEnchantAtk: [
    { count: 0, value: 200 },
    { count: 0, value: 202 },
    { count: 0, value: 204 },
  ],
  fashionSetAtk: 0,
  petAtk: 0,
}

function NInput({
  value,
  onChange,
  className = '',
  step,
  width,
}: {
  value: number
  onChange: (v: number) => void
  className?: string
  step?: number
  width?: string
}) {
  return (
    <input
      type="number"
      className={`num-input ${className}`}
      style={width ? { width } : undefined}
      value={value || ''}
      min={0}
      step={step}
      placeholder="0"
      onChange={(e) => onChange(Number(e.target.value))}
    />
  )
}

const MAIN_STATS = [
  { label: '힘', key: 'str' as const, color: 'c-str', focus: 'str' },
  { label: '솜씨', key: 'dex' as const, color: 'c-dex', focus: 'dex' },
  { label: '지력', key: 'int' as const, color: 'c-int', focus: 'int' },
  { label: '의지', key: 'wil' as const, color: 'c-wil', focus: 'wil' },
  { label: '행운', key: 'lck' as const, color: 'c-lck', focus: 'lck' },
]

const SUB_LEFT = [
  { label: '브레이크', key: 'breakStat' as const, color: 'c-str' },
  { label: '강타 강화', key: 'heavyHit' as const, color: 'c-str' },
  { label: '콤보 강화', key: 'combo' as const, color: 'c-dex' },
  { label: '스킬 위력', key: 'skillPower' as const, color: 'c-int' },
  { label: '광역 강화', key: 'aoe' as const, color: 'c-int' },
  { label: '회복력', key: 'recovery' as const, color: 'c-wil' },
  { label: '급소 회피', key: 'critAvoid' as const, color: 'c-lck' },
  { label: '추가타', key: 'additionalHit' as const, color: 'c-lck' },
]

const SUB_RIGHT = [
  { label: '피해 감소', key: 'damageReduction' as const, color: 'c-str' },
  { label: '빠른 공격', key: 'fastAttack' as const, color: 'c-dex' },
  { label: '연타 강화', key: 'multiHit' as const, color: 'c-dex' },
  { label: '빠른 스킬', key: 'fastSkill' as const, color: 'c-int' },
  { label: '추가 체력', key: 'additionalHp' as const, color: 'c-wil' },
  { label: '궁극기', key: 'ultimate' as const, color: 'c-wil' },
  { label: '치명타', key: 'criticalHit' as const, color: 'c-lck' },
]

export default function EquipmentPage() {
  const [s, setS] = useState<EquipmentState>(INITIAL)

  const set = <K extends keyof EquipmentState>(key: K) =>
    (val: number) => setS((prev) => ({ ...prev, [key]: val }))

  const setEnchant = (
    field: 'rightEnchantRates' | 'leftEnchantAtk',
    idx: number,
    part: 'count' | 'value',
    val: number,
  ) => {
    setS((prev) => ({
      ...prev,
      [field]: prev[field].map((row, i) => i === idx ? { ...row, [part]: val } : row),
    }))
  }

  return (
    <div className="eq-grid">
      {/* LEFT COLUMN */}
      <div className="col">

        {/* 주스탯 */}
        <div className="card">
          <div className="card-title c-white">주스탯</div>
          <div className="card-body">
            <div className="main-stats-grid">
              {MAIN_STATS.map(({ label, key, color, focus }) => (
                <div key={key} className="stat-col">
                  <span className={`stat-header ${color}`}>{label}</span>
                  <NInput value={s[key]} onChange={set(key)} className={focus} />
                </div>
              ))}
            </div>
          </div>
        </div>

        {/* 보조스탯 */}
        <div className="card">
          <div className="card-title c-white">보조스탯</div>
          <div className="card-body" style={{ gap: 0 }}>
            <div className="sub-stats-grid">
              <div className="sub-col">
                {SUB_LEFT.map(({ label, key, color }) => (
                  <div key={key} className="sub-row">
                    <span className={`sub-label ${color}`}>{label}</span>
                    <input
                      type="number"
                      className="sub-input"
                      value={s[key] || ''}
                      min={0}
                      placeholder="0"
                      onChange={(e) => set(key)(Number(e.target.value))}
                    />
                  </div>
                ))}
              </div>
              <div className="sub-col">
                {SUB_RIGHT.map(({ label, key, color }) => (
                  <div key={key} className="sub-row">
                    <span className={`sub-label ${color}`}>{label}</span>
                    <input
                      type="number"
                      className="sub-input"
                      value={s[key] || ''}
                      min={0}
                      placeholder="0"
                      onChange={(e) => set(key)(Number(e.target.value))}
                    />
                  </div>
                ))}
              </div>
            </div>
          </div>
        </div>

        {/* 레벨업 보너스 카드 */}
        <div className="card">
          <div className="card-title c-white">레벨업 보너스 카드 적용 효과</div>
          <div className="card-body">
            <div className="val-row">
              <span className="val-label">공격력</span>
              <input
                type="number"
                className="val-input"
                value={s.levelupBonusAtk || ''}
                min={0}
                placeholder="0"
                onChange={(e) => set('levelupBonusAtk')(Number(e.target.value))}
              />
            </div>
          </div>
        </div>

        {/* 팔라딘 */}
        <div className="card">
          <div className="card-title c-white">팔라딘</div>
          <div className="card-body">
            <div className="val-row">
              <span className="val-label">정의</span>
              <input
                type="number"
                className="val-input"
                value={s.paladinJustice || ''}
                min={0}
                placeholder="0"
                onChange={(e) => set('paladinJustice')(Number(e.target.value))}
              />
            </div>
          </div>
        </div>

        {/* 룬 워드 효과 */}
        <div className="card">
          <div className="card-title c-white">선택된 모든 룬 워드 효과</div>
          <div className="card-body">
            <div className="val-row">
              <span className="val-label">공격력</span>
              <input
                type="number"
                className="val-input"
                value={s.runeWordAtk || ''}
                min={0}
                placeholder="0"
                onChange={(e) => set('runeWordAtk')(Number(e.target.value))}
              />
            </div>
          </div>
        </div>

      </div>

      {/* RIGHT COLUMN */}
      <div className="col">

        {/* 목걸이 공격력 */}
        <div className="card">
          <div className="card-title c-gold left">
            목걸이 공격력
            <button
              className="tooltip-btn"
              title="장착한 목걸이에 직접 표시되는 공격력 수치입니다."
            >?</button>
          </div>
          <div className="card-body">
            <div className="val-row">
              <span className="val-label">장비 장착 시 상승 수치</span>
              <input
                type="number"
                className="val-input"
                value={s.necklaceEquipAtk || ''}
                min={0}
                placeholder="0"
                onChange={(e) => set('necklaceEquipAtk')(Number(e.target.value))}
              />
            </div>
            <div className="val-row">
              <span className="val-label">별과 달의 축복, 공격력</span>
              <input
                type="number"
                className="val-input"
                value={s.necklaceBlessingAtk || ''}
                min={0}
                placeholder="0"
                onChange={(e) => set('necklaceBlessingAtk')(Number(e.target.value))}
              />
            </div>
          </div>
        </div>

        {/* 무기 공격력 */}
        <div className="card">
          <div className="card-title c-gold left">무기 공격력</div>
          <div className="card-body">
            <div className="val-row">
              <span className="val-label c-str">메인 주스탯 보너스</span>
              <input
                type="number"
                className="val-input"
                value={s.weaponMainStatBonus || ''}
                min={0}
                step={0.1}
                placeholder="0"
                onChange={(e) => set('weaponMainStatBonus')(Number(e.target.value))}
              />
            </div>
            <div className="val-row">
              <span className="val-label c-dex">서브 주스탯 보너스</span>
              <input
                type="number"
                className="val-input"
                value={s.weaponSubStatBonus || ''}
                min={0}
                step={0.1}
                placeholder="0"
                onChange={(e) => set('weaponSubStatBonus')(Number(e.target.value))}
              />
            </div>
            <div className="val-row">
              <span className="val-label">기본 공격력</span>
              <input
                type="number"
                className="val-input"
                value={s.weaponBaseAtk || ''}
                min={0}
                placeholder="0"
                onChange={(e) => set('weaponBaseAtk')(Number(e.target.value))}
              />
            </div>
            <div className="val-row">
              <span className="val-label">별과 달의 축복, 공격력</span>
              <input
                type="number"
                className="val-input"
                value={s.weaponBlessingAtk || ''}
                min={0}
                placeholder="0"
                onChange={(e) => set('weaponBlessingAtk')(Number(e.target.value))}
              />
            </div>
            <div className="val-row">
              <span className="val-label">숙련 보너스, 공격력</span>
              <input
                type="number"
                className="val-input"
                value={s.weaponProficiencyAtk || ''}
                min={0}
                placeholder="0"
                onChange={(e) => set('weaponProficiencyAtk')(Number(e.target.value))}
              />
            </div>
            <div className="val-row">
              <span className="val-label">엠블럼, 공격력 증가 비율</span>
              <div className="emblem-row">
                <input
                  type="number"
                  className="val-input"
                  style={{ width: 76 }}
                  value={s.weaponEmblemAtkRate || ''}
                  min={0}
                  step={0.1}
                  placeholder="0"
                  onChange={(e) => set('weaponEmblemAtkRate')(Number(e.target.value))}
                />
                <span className="unit">%</span>
              </div>
            </div>
          </div>
        </div>

        {/* 인첸트 */}
        <div className="card">
          <div className="card-title c-gold left">인첸트</div>
          <div className="card-body">

            {/* 오른쪽 장비 */}
            <div className="enchant-group">
              <span className="enchant-group-label">오른쪽 장비 인첸트 공격력 증가 비율</span>
              <div className="enchant-rows">
                {s.rightEnchantRates.map((row, i) => (
                  <div key={i} className="enchant-row">
                    <input
                      type="number"
                      className="enchant-input"
                      value={row.count || ''}
                      min={0}
                      placeholder="0"
                      onChange={(e) => setEnchant('rightEnchantRates', i, 'count', Number(e.target.value))}
                    />
                    <span className="enchant-times">×</span>
                    <input
                      type="number"
                      className="enchant-input"
                      value={row.value || ''}
                      min={0}
                      step={0.1}
                      placeholder="0"
                      onChange={(e) => setEnchant('rightEnchantRates', i, 'value', Number(e.target.value))}
                    />
                    <span className="enchant-unit c-dex">%</span>
                  </div>
                ))}
              </div>
            </div>

            {/* 왼쪽 장비 */}
            <div className="enchant-group">
              <span className="enchant-group-label">왼쪽 장비 인첸트 공격력</span>
              <div className="enchant-rows">
                {s.leftEnchantAtk.map((row, i) => (
                  <div key={i} className="enchant-row">
                    <input
                      type="number"
                      className="enchant-input"
                      value={row.count || ''}
                      min={0}
                      placeholder="0"
                      onChange={(e) => setEnchant('leftEnchantAtk', i, 'count', Number(e.target.value))}
                    />
                    <span className="enchant-times">×</span>
                    <input
                      type="number"
                      className="enchant-input"
                      value={row.value || ''}
                      min={0}
                      placeholder="0"
                      onChange={(e) => setEnchant('leftEnchantAtk', i, 'value', Number(e.target.value))}
                    />
                  </div>
                ))}
              </div>
            </div>

          </div>
        </div>

        {/* 기타 공격력 */}
        <div className="card">
          <div className="card-title c-gold left">기타 공격력</div>
          <div className="card-body">
            <div className="val-row">
              <span className="val-label">패션 4세트 공격력</span>
              <input
                type="number"
                className="val-input"
                value={s.fashionSetAtk || ''}
                min={0}
                placeholder="0"
                onChange={(e) => set('fashionSetAtk')(Number(e.target.value))}
              />
            </div>
            <div className="val-row">
              <span className="val-label">펫 공격력</span>
              <input
                type="number"
                className="val-input"
                value={s.petAtk || ''}
                min={0}
                placeholder="0"
                onChange={(e) => set('petAtk')(Number(e.target.value))}
              />
            </div>
          </div>
        </div>

      </div>
    </div>
  )
}
