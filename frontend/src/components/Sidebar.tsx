import React from 'react'
import type { Page } from '../types'

interface Props {
  page: Page
  onNavigate: (p: Page) => void
}

function IconEquipment() {
  return (
    <svg viewBox="0 0 24 24" fill="none" stroke="currentColor" strokeWidth="1.7" strokeLinecap="round" strokeLinejoin="round">
      <circle cx="12" cy="8" r="4" />
      <path d="M4 20c0-4.4 3.6-8 8-8s8 3.6 8 8" />
    </svg>
  )
}

function IconRune() {
  return (
    <svg viewBox="0 0 24 24" fill="currentColor">
      <path d="M12 2L3.5 8.5l2.5 9.5h12l2.5-9.5L12 2z" opacity="0.3" />
      <path d="M12 2L3.5 8.5 12 6l8.5 2.5L12 2zM5.5 18H18.5L21 8.5 12 11 3 8.5 5.5 18z" />
    </svg>
  )
}

function IconTrophy() {
  return (
    <svg viewBox="0 0 24 24" fill="none" stroke="currentColor" strokeWidth="1.7" strokeLinecap="round" strokeLinejoin="round">
      <path d="M8 21h8M12 17v4" />
      <path d="M5 3H3c0 5 2 8 5 9M19 3h2c0 5-2 8-5 9" />
      <path d="M17 3H7v7a5 5 0 0010 0V3z" />
    </svg>
  )
}

const NAV_ITEMS: { key: Page; label: string; Icon: () => React.ReactElement }[] = [
  { key: 'equipment', label: '장비 정보', Icon: IconEquipment },
  { key: 'rune', label: '룬 정보', Icon: IconRune },
  { key: 'result', label: '결과 보기', Icon: IconTrophy },
]

export default function Sidebar({ page, onNavigate }: Props) {
  return (
    <nav className="sidebar">
      {NAV_ITEMS.map(({ key, label, Icon }, i) => (
        <>
          {i > 0 && <div key={`div-${key}`} className="sidebar-divider" />}
          <button
            key={key}
            className={`sidebar-btn${page === key ? ' active' : ''}`}
            onClick={() => onNavigate(key)}
          >
            <Icon />
            {label}
          </button>
        </>
      ))}
    </nav>
  )
}
