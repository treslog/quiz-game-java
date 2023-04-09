export default function Cabecera ({ item }) {
  return (
    <>
      <div class='registro'>
        <p>🔥 Pregunta número
          <span class='opcion-cabecera'>
            {item?.preguntaNumero}
          </span>
        </p>
        <p>💸 Puntos totales
          <span class='opcion-cabecera'>
            {item?.totalPuntos}
          </span>
        </p>
      </div>

      <h1 class='titulo-pregunta'>{item?.preguntaActual}</h1>
    </>
  )
}
