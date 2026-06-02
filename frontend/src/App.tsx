import { useState } from 'react'
import Sidebar from './components/Sidebar'
import EquipmentPage from './components/EquipmentPage'
import RunePage from './components/RunePage'
import ResultPage from './components/ResultPage'
import type { Page } from './types'
import './App.css'

export default function App() {
  const [page, setPage] = useState<Page>('equipment')

  return (
    <div className="app">
      <Sidebar page={page} onNavigate={setPage} />
      <main className="main">
        <header className="app-header">
          <h1 className="app-title">마비노기 모바일</h1>
          <p className="app-subtitle">(가칭) 데미지 최적화</p>
        </header>
        <div className="page">
          {page === 'equipment' && <EquipmentPage />}
          {page === 'rune' && <RunePage />}
          {page === 'result' && <ResultPage />}
        </div>
      </main>
    </div>
  )
}
