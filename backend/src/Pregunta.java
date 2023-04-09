import java.util.List;

public class Pregunta {
    private String textoPregunta;
    private List<String> opcionesRespuesta;
    private int indexRespuestaCorrecta;

    public Pregunta(String textoPregunta, List<String> opcionesRespuesta, int indexRespuestaCorrecta) {
        this.textoPregunta = textoPregunta;
        this.opcionesRespuesta = opcionesRespuesta;
        this.indexRespuestaCorrecta = indexRespuestaCorrecta;
    }

    public String obtenerTextoPregunta() {
        return textoPregunta;
    }

    public List<String> obtenerOpcionesRespuesta() {
        return opcionesRespuesta;
    }

    public int obtenerIndexRespuestaCorrecta() {
        return indexRespuestaCorrecta;
    }
}