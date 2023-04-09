import { useEffect, useState } from 'preact/hooks'

export const useJuego = () => {
  const [respuesta, setRespuesta] = useState('inicio')
  const [juego, setJuego] = useState(
    {
      respuestaAnterior: 'inicio',
      totalPreguntas: '',
      preguntaNumero: '',
      totalPuntos: '',
      preguntaActual: '',
      respuestas: {
        0: '',
        1: '',
        2: '',
        3: ''
      },
      opciones: {
        4: '',
        5: ''
      }
    }
  )
  const [numeroPregunta, setNumeroPregunta] = useState(0)

  useEffect(() => {
    fetch(`http://localhost:8000/juego?respuesta=${respuesta}`)
      .then((res) => res.json())
      .then((juego) => setJuego(juego[0]))
      .catch((err) => console.log(err))
  }, [numeroPregunta])

  const handleRespuesta = (respuesta) => {
    setNumeroPregunta(prev => prev + 1)
    setRespuesta(respuesta)
  }

  const handleReset = () => {
    setRespuesta('inicio')
    setNumeroPregunta(0)
  }

  return { handleRespuesta, juego, handleReset }
}
