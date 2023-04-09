export default function FinJuego ({ item }) {
  return (

    <>
      <h1 class='titulo-pregunta'>{item?.estado.toUpperCase()}</h1>
      <div class='registro'>
        <p>Preguntas correctas
          <span class='opcion-cabecera'>
            {item?.preguntasCorrectas}
          </span>
        </p>
        <p>Puntos totales
          <span class='opcion-cabecera'>
            {item?.puntos}
          </span>
        </p>
      </div>

    </>
  )
}
