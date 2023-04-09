
import './app.css'
import Cabecera from './components/Cabecera'
import FinJuego from './components/FinJuego'
import Reiniciar from './components/Reiniciar'
import Respuestas from './components/Respuestas'
import { useJuego } from './hooks/useJuego'

export function App () {
  const {
    juego,
    handleRespuesta,
    handleReset
  } = useJuego()

  const juegoTerminado = juego?.estado === 'perdiste' || juego?.estado === 'ganaste'

  return (
    <>
      <main>
        <h2>TRISTAN VIDAL 🎉</h2>

        {juegoTerminado
          ? <FinJuego item={juego} key={juego.estado} />

          : (
            <div>
              <Cabecera item={juego} />
              <Respuestas item={juego} handleRespuesta={handleRespuesta} />
            </div>
            )}

      </main>

      <Reiniciar handleReset={handleReset} />
    </>
  )
}
