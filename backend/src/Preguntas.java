import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Preguntas {
        public List<Pregunta> preguntas = new ArrayList<Pregunta>();
        public List<Pregunta> preguntasReserva = new ArrayList<Pregunta>();

        public Preguntas(int numeroPreguntas) {

                if (numeroPreguntas > 15 || numeroPreguntas < 1) {
                        System.out.println("El número de preguntas debe ser entre 1 y 15");
                        System.out.println("Esta configuración se ha cambiado a 15 preguntas");
                        numeroPreguntas = 15;
                }

                preguntas.add(new Pregunta("¿En qué año se descubrió América?", List.of("1492", "1493", "1494", "1495"),
                                0));
                preguntas.add(new Pregunta(
                                "¿Quién escribió Don Quijote de la Mancha?", List.of("Miguel de Cervantes",
                                                "Gabriel García Márquez", "William Shakespeare", "Jorge Luis Borges"),
                                0));
                preguntas.add(new Pregunta("¿Cuál es el río más largo del mundo?",
                                List.of("El Nilo", "El Amazonas", "El Yangtze", "El Misisipi"), 1));
                preguntas.add(new Pregunta("¿Cuál es la capital de Rusia?",
                                List.of("San Petersburgo", "Moscú", "Kazán", "Sochi"), 1));
                preguntas.add(new Pregunta("¿Cuál es el océano más grande?", List.of("El Océano Pacífico",
                                "El Océano Atlántico", "El Océano Índico", "El Océano Glacial Ártico"), 0));
                preguntas.add(new Pregunta("¿En qué país se encuentra la Torre Eiffel?",
                                List.of("Italia", "España", "Francia", "Reino Unido"), 2));
                preguntas.add(new Pregunta("¿Quién pintó La Última Cena?",
                                List.of("Pablo Picasso", "Leonardo da Vinci", "Salvador Dalí", "Vincent van Gogh"), 1));
                preguntas.add(new Pregunta("¿Cuál es la moneda oficial de Japón?",
                                List.of("El yen", "El euro", "El dólar", "La libra esterlina"), 0));
                preguntas.add(new Pregunta(
                                "¿Quién compuso la Novena Sinfonía?", List.of("Johann Sebastian Bach",
                                                "Wolfgang Amadeus Mozart", "Ludwig van Beethoven", "Franz Schubert"),
                                2));
                preguntas.add(new Pregunta(
                                "¿Qué país tiene la mayor población del mundo?",
                                List.of("China", "India", "Estados Unidos", "Brasil"),
                                0));
                preguntas.add(new Pregunta(
                                "¿Qué animal es el símbolo nacional de Canadá?",
                                List.of("Oso polar", "Castor", "Alce", "Lobo"),
                                1));
                preguntas.add(new Pregunta(
                                "¿Qué escritor creó el personaje de Sherlock Holmes?",
                                List.of("Charles Dickens", "Arthur Conan Doyle", "Agatha Christie", "J.R.R. Tolkien"),
                                1));
                preguntas.add(new Pregunta(
                                "¿Qué planeta es el más grande del sistema solar?",
                                List.of("Júpiter", "Saturno", "Urano", "Neptuno"),
                                0));
                preguntas.add(new Pregunta(
                                "¿Qué deporte se practica en el Tour de Francia?",
                                List.of("Atletismo", "Esquí", "Ciclismo", "Natación"),
                                2));
                preguntas.add(new Pregunta(
                                "¿Qué instrumento musical tiene 88 teclas?",
                                List.of("Guitarra", "Violín", "Piano", "Arpa"),
                                2));
                preguntas.add(new Pregunta(
                                "¿Qué pintor español es famoso por sus obras cubistas?",
                                List.of("Pablo Picasso", "Salvador Dalí", "Francisco de Goya", "Diego Velázquez"),
                                0));
                preguntas.add(new Pregunta(
                                "¿Qué continente es el más extenso y poblado del mundo?",
                                List.of("América", "Europa", "África", "Asia"),
                                3));
                preguntas.add(new Pregunta(
                                "¿Qué órgano humano produce la insulina?",
                                List.of("Hígado", "Páncreas", "Riñón", "Bazo"),
                                1));
                preguntas.add(new Pregunta(
                                "¿Qué ciudad es la capital de Francia?",
                                List.of("París", "Lyon", "Marsella", "Burdeos"),
                                0));
                mezclarPreguntas();
                System.out.println("Preguntas mezcladas");

                preguntasReserva = preguntas.subList(numeroPreguntas + 1, preguntas.size());
                preguntas = preguntas.subList(0, numeroPreguntas);

        }

        public Pregunta obtenerPregunta(int index) {
                return preguntas.get(index);
        }

        public void mezclarPreguntas() {
                Collections.shuffle(preguntas);
        }

        public int obtenerNumeroPreguntas() {
                return preguntas.size();
        }

        public void cambiarPregunta(int index) {
                Collections.shuffle(preguntasReserva);
                preguntas.set(index, preguntasReserva.get(0));
        }

}