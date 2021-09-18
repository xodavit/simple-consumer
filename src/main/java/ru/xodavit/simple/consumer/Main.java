package ru.xodavit.simple.consumer;

import ru.xodavit.http.server.framework.Server;
import ru.xodavit.http.server.framework.resolver.argument.RequestHandlerMethodArgumentResolver;
import ru.xodavit.http.server.framework.resolver.argument.RequestHeaderHandlerMethodArgumentResolver;
import ru.xodavit.http.server.framework.resolver.argument.ResponseHandlerMethodArgumentResolver;

public class Main {
    public static void main(String[] args) {

        final var server = new Server();
        server.autoRegisterHandlers("ru.xodavit.simple.consumer.app");
        server.addArgumentResolver(
                new RequestHandlerMethodArgumentResolver(),
                new ResponseHandlerMethodArgumentResolver(),
                new RequestHeaderHandlerMethodArgumentResolver()
        );
//        new Thread(() -> {
//            try {
//                Thread.sleep(10000);
//                server.stop();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }).start();
        server.listen(9999);
    }
}
