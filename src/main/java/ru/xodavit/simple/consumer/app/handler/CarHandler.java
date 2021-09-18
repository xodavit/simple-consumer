package ru.xodavit.simple.consumer.app.handler;

import ru.xodavit.http.server.framework.HttpMethods;
import ru.xodavit.http.server.framework.annotation.RequestHeader;
import ru.xodavit.http.server.framework.annotation.RequestMapping;
import ru.xodavit.http.server.framework.exception.RequestHandleException;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class CarHandler {
    @RequestMapping(method = HttpMethods.GET, path = "/car")
    public void getCar(
            OutputStream response,
            @RequestHeader("Marka") String marka
    ) {
        final var body = "{\"Bmw\": [1, 3, 5, 7, x3, x4, x5, x6]}";
        try {
            response.write(
                    (
                            // language=HTTP
                            "HTTP/1.1 200 OK\r\n" +
                                    "Content-Length: " + body.length() + "\r\n" +
                                    "Content-Type: application/json\r\n" +
                                    "Connection: close\r\n" +
                                    "\r\n" +
                                    body
                    ).getBytes(StandardCharsets.UTF_8)
            );
        } catch (IOException e) {
            throw new RequestHandleException(e);
        }
    }
}
