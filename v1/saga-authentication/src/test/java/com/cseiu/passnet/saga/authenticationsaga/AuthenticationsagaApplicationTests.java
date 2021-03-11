package com.cseiu.passnet.saga.authenticationsaga;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Mono;

@SpringBootTest
@Slf4j(topic = "[AuthenticationsagaApplicationTests]")
class AuthenticationsagaApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void monoSubscriber() {
        String myName = "tony";
        Mono<String> mono = Mono.just(myName)
           .log()
           .map(String::toUpperCase)
           .doOnSubscribe(subscription -> log.info("Subscribed!!"))
           .doOnRequest(number -> log.info("Request received, start doing something"))
           .doOnNext(s -> log.info("Value is here, executing doOnNext {}", s))
           .doOnSuccess(s -> log.info("Do on success execute"));


        mono.subscribe(
           s -> {
               log.info("name: -> {}", s);
           },
           err -> {
               log.error("something bad");
           },
           () -> {
               log.info("Finish!!");
           });
    }
}
