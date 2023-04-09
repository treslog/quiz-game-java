import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class Server {

    public static void main() throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        server.createContext("/juego", new QueryHandler());
        server.setExecutor(null);
        server.start();

        System.out.println("Servidor iniciado en el puerto 8000");
    }

    static class QueryHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {

            Headers headers = exchange.getResponseHeaders();
            headers.add("Access-Control-Allow-Origin", "*");
            headers.add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
            headers.add("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With");
            headers.add("Content-Type", "application/json; charset=utf-8");

            String query = exchange.getRequestURI().getQuery();
            String[] params = query.split("&");
            Map<String, String> response = new HashMap<>();
            for (String param : params) {
                String[] keyValue = param.split("=");
                response.put(keyValue[0], keyValue[1]);
            }

            String param = response.get("respuesta");
            String jsonResponse = Juego.jugar(param);

            byte[] jsonResponseBytes = jsonResponse.getBytes("UTF-8");

            exchange.sendResponseHeaders(200, jsonResponseBytes.length);
            OutputStream os = exchange.getResponseBody();
            os.write(jsonResponseBytes);
            os.close();
        }
    }
}