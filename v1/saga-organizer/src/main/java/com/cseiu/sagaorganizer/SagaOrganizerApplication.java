package com.cseiu.sagaorganizer;

import io.opentracing.Tracer;
import io.opentracing.contrib.grpc.TracingClientInterceptor;
import net.devh.boot.grpc.client.interceptor.GrpcGlobalClientInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
public class SagaOrganizerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SagaOrganizerApplication.class, args);
    }

    @GrpcGlobalClientInterceptor
    TracingClientInterceptor tracingInterceptor(Tracer tracer) {
        return TracingClientInterceptor
           .newBuilder()
           .withTracer(tracer)
           .build();
    }

}
