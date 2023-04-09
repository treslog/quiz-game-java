public class Juego {
    private static Preguntas preguntas = new Preguntas(15);

    private int preguntaActual = 1;
    private boolean preguntaSaltada = false;
    private int cincuentaCincuenta = 0;

    private static Juego juego = new Juego();

    public static String jugar(String param) {

        String jsonResponse = "";
        debug();

        if (param.matches("inicio")) {
            juego.reiniciarJuego();
            jsonResponse = juego.obtenerMenu(param);
            return jsonResponse;
        }

        if (juego.preguntaActual < preguntas.obtenerNumeroPreguntas()) {
            if (param.matches("[0-3]")) {

                if (juego.obtenerIndexCorrecta() == Integer.parseInt(param)) {
                    juego.siguientePregunta();
                    jsonResponse = juego.obtenerMenu(param);
                } else {
                    jsonResponse = juego.terminarJuego();
                }
            } else {
                jsonResponse = juego.obtenerMenu(param);
            }

            if (param.matches("4")) {
                juego.cincuentaCincuenta();
                jsonResponse = juego.obtenerMenu(param);
            }

            if (param.matches("5")) {
                juego.saltarPregunta();
                jsonResponse = juego.obtenerMenu(param);
            }

            return jsonResponse;

        }

        jsonResponse = juego.ganarJuego();
        return jsonResponse;
    }

    public String obtenerMenu(String respuesta) {

        String respuestaJson = "[{\"respuestaAnterior\": \"" + respuesta + "\"," + "\n";
        respuestaJson += "\"totalPreguntas\": \"" + preguntas.obtenerNumeroPreguntas() + "\"," + "\n";
        respuestaJson += "\"preguntaNumero\": \"" + (preguntaActual + 1) + "\"," + "\n";
        respuestaJson += "\"totalPuntos\": \"" + (preguntaActual * 100) + "\"," + "\n";
        respuestaJson += "\"preguntaActual\": \"" + mostrarPreguntas() + "}]" + "\n";

        return respuestaJson;
    }

    public int obtenerIndexCorrecta() {
        return preguntas.obtenerPregunta(juego.preguntaActual).obtenerIndexRespuestaCorrecta();
    }

    public void siguientePregunta() {
        preguntaActual++;
    }

    public String ganarJuego() {
        String respuestaJson = "[{";
        respuestaJson += "\"estado\": \"" + "ganaste" + "\"," + "\n";
        respuestaJson += "\"preguntasCorrectas\": \"" + preguntaActual + "\"," + "\n";
        respuestaJson += "\"puntos\": \"" + (preguntaActual * 100) + "\"}]" + "\n";

        return respuestaJson;
    }

    public String terminarJuego() {
        String respuestaJson = "[{";
        respuestaJson += "\"estado\": \"" + "perdiste" + "\"," + "\n";
        respuestaJson += "\"preguntasCorrectas\": \"" + preguntaActual + "\"," + "\n";
        respuestaJson += "\"puntos\": \"" + (preguntaActual * 100) + "\"}]" + "\n";
        return respuestaJson;
    }

    public void reiniciarJuego() {
        preguntaActual = 0;
        cincuentaCincuenta = 0;
        preguntaSaltada = false;
        preguntas.mezclarPreguntas();
    }

    public void saltarPregunta() {
        if (preguntaSaltada) {
            return;
        }

        preguntas.cambiarPregunta(preguntaActual);

        preguntaSaltada = true;

    }

    public void cincuentaCincuenta() {
        if (cincuentaCincuenta >= 1) {
            return;
        }

        cincuentaCincuenta++;
    }

    public static String mostrarPreguntas() {

        String saltarCincuentaCincuenta = "\"4\": " + "\"" + "50/50" + "\",";
        String saltarPregunta = "\"5\": " + "\"" + "Saltar pregunta" + "\"";

        String pregunta = preguntas.obtenerPregunta(juego.preguntaActual).obtenerTextoPregunta();
        String respuesta1 = preguntas.obtenerPregunta(juego.preguntaActual).obtenerOpcionesRespuesta().get(0);
        String respuesta2 = preguntas.obtenerPregunta(juego.preguntaActual).obtenerOpcionesRespuesta().get(1);
        String respuesta3 = preguntas.obtenerPregunta(juego.preguntaActual).obtenerOpcionesRespuesta().get(2);
        String respuesta4 = preguntas.obtenerPregunta(juego.preguntaActual).obtenerOpcionesRespuesta().get(3);

        if (juego.preguntaSaltada) {
            saltarPregunta = "";
        }

        if (juego.cincuentaCincuenta >= 1) {
            saltarCincuentaCincuenta = "";
        }

        if (juego.preguntaSaltada && juego.cincuentaCincuenta < 1) {
            saltarCincuentaCincuenta = "\"4\": " + "\"" + "50/50" + "\"";
        }

        if (juego.cincuentaCincuenta == 1) {
            int correcta = preguntas.obtenerPregunta(juego.preguntaActual).obtenerIndexRespuestaCorrecta();
            if (correcta == 0) {
                respuesta2 = "";
                respuesta3 = "";
            } else if (correcta == 1) {
                respuesta1 = "";
                respuesta4 = "";
            } else if (correcta == 2) {
                respuesta1 = "";
                respuesta4 = "";
            } else if (correcta == 3) {
                respuesta2 = "";
                respuesta3 = "";
            }
            juego.cincuentaCincuenta++;
        }

        String preguntaCompleta = pregunta + "\",\n";
        preguntaCompleta += "\"" + "respuestas" + "\": {";
        preguntaCompleta += "\"0\": " + "\"" + respuesta1 + "\",";
        preguntaCompleta += "\"1\": " + "\"" + respuesta2 + "\",\n";
        preguntaCompleta += "\"2\": " + "\"" + respuesta3 + "\",";
        preguntaCompleta += "\"3\": " + "\"" + respuesta4 + "\"";
        preguntaCompleta += "},\n";
        preguntaCompleta += "\"" + "opciones" + "\": {";
        preguntaCompleta += saltarCincuentaCincuenta;
        preguntaCompleta += saltarPregunta;
        preguntaCompleta += "}\n";

        return preguntaCompleta;

    }

    public static void debug() {
        System.out.println("--------------------");
        System.out.println("Pregunta actual: " + juego.preguntaActual);
        System.out.println("Pregunta saltada: " + juego.preguntaSaltada);
        System.out.println("Cincuenta cincuenta: " + juego.cincuentaCincuenta);
        System.out.println("Preguntas: " + (preguntas.obtenerNumeroPreguntas()));

        String listaPreguntas = "";
        for (int i = 0; i < preguntas.obtenerNumeroPreguntas(); i++) {
            listaPreguntas += preguntas.obtenerPregunta(i).obtenerTextoPregunta() + "\n ";
        }

        System.out.println("pull de preguntas: \n" + listaPreguntas);
        System.out.println("--------------------");

    }

}
