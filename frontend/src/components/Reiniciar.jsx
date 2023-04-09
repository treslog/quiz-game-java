export default function Reiniciar ({ handleReset }) {
  return (
    <span
      class='reiniciar' onClick={() => {
        handleReset()
      }}
    >Reiniciar 💥
    </span>

  )
}
