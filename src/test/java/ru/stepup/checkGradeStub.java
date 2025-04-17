package ru.stepup;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class checkGradeStub {
    public static void stub() throws IOException {
        // Создаём HTTP-сервер на порту 5352
        HttpServer server = HttpServer.create(new InetSocketAddress(5352), 0);

        // Обработка запроса /checkGrade
        server.createContext("/checkGrade", exchange -> { //добавляет обработчик для пути /checkGrade
            String query = exchange.getRequestURI().getQuery(); // получает query-параметр, например "grade=число"

            int grade = Integer.parseInt(query.split("=")[1]);

            // Эмуляция проверки — допустим, оценки от 0 до 100
            boolean isValid = grade > 1 && grade < 6;

            String response = Boolean.toString(isValid); // "true" или "false"

            // Возвращаем ответ
            exchange.sendResponseHeaders(200, response.length()); //отправляет HTTP-ответ с кодом 200 OK
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        });
    }
}
