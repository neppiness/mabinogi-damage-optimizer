import { useState } from 'react'
import './App.css'

type StatField = {
  label: string
  key: string
}

const PRIMARY_STATS: StatField[] = [
  { label: '힘', key: 'str' },
  { label: '솜씨', key: 'dex' },
  { label: '지력', key: 'int' },
  { label: '의지', key: 'will' },
  { label: '행운', key: 'luck' },
]

const COMBAT_STATS: StatField[] = [
  { label: '공격력', key: 'atk' },
  { label: '방어력', key: 'def' },
]

const SECONDARY_STATS_LEFT: StatField[] = [
  { label: '브레이크', key: 'break' },
  { label: '강타 강화', key: 'smash' },
  { label: '콤보 강화', key: 'combo' },
  { label: '스킬 위력', key: 'skillPower' },
  { label: '광역 강화', key: 'aoe' },
  { label: '회복력', key: 'recovery' },
  { label: '급소 회피', key: 'critAvoid' },
  { label: '추가타', key: 'extraHit' },
]

const SECONDARY_STATS_RIGHT: StatField[] = [
  { label: '피해 감소', key: 'dmgReduce' },
  { label: '빠른 공격', key: 'fastAtk' },
  { label: '연타 강화', key: 'multiHit' },
  { label: '빠른 스킬', key: 'fastSkill' },
  { label: '추가 체력', key: 'bonusHp' },
  { label: '궁극기', key: 'ultimate' },
  { label: '치명타', key: 'critical' },
]

type Stats = Record<string, string>

function StatInput({
  label,
  value,
  onChange,
}: {
  label: string
  value: string
  onChange: (v: string) => void
}) {
  return (
    <div className="stat-row">
      <span className="stat-label">{label}</span>
      <input
        type="number"
        className="stat-input"
        value={value}
        min={0}
        onChange={(e) => onChange(e.target.value)}
      />
    </div>
  )
}

function App() {
  const allKeys = [
    ...PRIMARY_STATS,
    ...COMBAT_STATS,
    ...SECONDARY_STATS_LEFT,
    ...SECONDARY_STATS_RIGHT,
  ]

  const initialStats: Stats = Object.fromEntries(allKeys.map((s) => [s.key, '']))

  const [stats, setStats] = useState<Stats>(initialStats)

  const set = (key: string) => (value: string) =>
    setStats((prev) => ({ ...prev, [key]: value }))

  return (
    <div className="panel">
      {/* Primary stats */}
      <div className="primary-stats">
        {PRIMARY_STATS.map((s) => (
          <div key={s.key} className="primary-stat">
            <span className="primary-label">{s.label}</span>
            <input
              type="number"
              className="primary-input"
              value={stats[s.key]}
              min={0}
              onChange={(e) => set(s.key)(e.target.value)}
            />
          </div>
        ))}
      </div>

      <div className="divider" />

      {/* Combat stats */}
      <div className="combat-stats">
        {COMBAT_STATS.map((s) => (
          <div key={s.key} className="combat-stat">
            <span className="combat-label">{s.label}</span>
            <input
              type="number"
              className="combat-input"
              value={stats[s.key]}
              min={0}
              onChange={(e) => set(s.key)(e.target.value)}
            />
          </div>
        ))}
      </div>

      <div className="divider" />

      {/* Secondary stats */}
      <div className="secondary-stats">
        <div className="secondary-col">
          {SECONDARY_STATS_LEFT.map((s) => (
            <StatInput
              key={s.key}
              label={s.label}
              value={stats[s.key]}
              onChange={set(s.key)}
            />
          ))}
        </div>
        <div className="col-divider" />
        <div className="secondary-col">
          {SECONDARY_STATS_RIGHT.map((s) => (
            <StatInput
              key={s.key}
              label={s.label}
              value={stats[s.key]}
              onChange={set(s.key)}
            />
          ))}
        </div>
      </div>
    </div>
  )
}

export default App
