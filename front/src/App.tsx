import './App.css'
import LoginPage from '@/app/loginPage.tsx'
import Main from '@/app/main.tsx'
import { BrowserRouter, Routes, Route, Navigate  } from "react-router-dom"
import { ProtectedRoute } from './components/ProtectedRoute'

function App() {
  return (
    <>
      <BrowserRouter>
        <Routes>
          <Route path="/login" element={<LoginPage />} />
          <Route
            path='/main'
            element={
              <ProtectedRoute>
                <Main/>
              </ProtectedRoute>
            }/>
          {/* ✅ 루트 접근 시 로그인으로 */}
        <Route path="*" element={<Navigate to="/login" />} />
        </Routes>
      </BrowserRouter>
    </>
  )
}

export default App
