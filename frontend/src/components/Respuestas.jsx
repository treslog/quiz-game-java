export default function Respuestas ({ item, handleRespuesta }) {
  const opciones = ['A) ', 'B) ', 'C) ', 'D) ']

  return (
    <div className='respuestas'>

      {Object.entries(item?.respuestas).map(([key, value]) => {
        return (
          <div
            class='respuesta-item'
            key={key}
            onClick={() => {
              handleRespuesta(key)
            }}
          >
            {value && (
              <span class='opcion'>{opciones[key]}</span>
            )}
            {value}
          </div>
        )
      })}

      {Object.entries(item?.opciones).map(([key, value]) => {
        return (
          <div
            class='respuesta-saltar'
            key={key}
            onClick={() => {
              handleRespuesta(key)
            }}
          >
            {value}
          </div>
        )
      })}
    </div>
  )
}
