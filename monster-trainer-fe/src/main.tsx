import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import DogChow from './App.tsx'
import './index.css'
import { QueryClient, QueryClientProvider } from '@tanstack/react-query'
import { BrowserRouter as Router } from 'react-router-dom'

const queryClient = new QueryClient()

createRoot(document.getElementById('root')!).render(
  <StrictMode>
    <QueryClientProvider client={queryClient}>
      <Router>
        <DogChow />
      </Router>
    </QueryClientProvider>
  </StrictMode>,
)
