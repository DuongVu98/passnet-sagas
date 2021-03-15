package com.cseiu.passnet.saga.recruitmentsaga.config;

import com.cse.iu.passnet.saga.avro.AcceptStudentApplicationEventAvro;
import com.cse.iu.passnet.saga.avro.DeleteJobEventAvro;
import com.cse.iu.passnet.saga.avro.PostNewJobEventAvro;
import com.cse.iu.passnet.saga.avro.RemoveStudentApplicationEventAvro;

import io.confluent.kafka.serializers.KafkaAvroSerializer;
import io.confluent.kafka.serializers.subject.TopicRecordNameStrategy;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
public class KafkaProducerConfiguration {

    @Value("${spring.kafka.producer.bootstrap-servers}")
    private String bootstrapServer;

    @Value("${spring.kafka.properties.schema-registry-url}")
    private String schemaRegistryUrl;

    private Map<String, Object> configProps() {
        Map<String, Object> configProps = new HashMap<>();

        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class.getName());
        configProps.put("schema.registry.url", schemaRegistryUrl);
        configProps.put("value.subject.name.strategy", TopicRecordNameStrategy.class.getName());

        return configProps;
    }

    @Bean(value = "post-new-job")
    public KafkaTemplate<String, PostNewJobEventAvro> postNewJobEventAvroKafkaTemplate() {
        return new KafkaTemplate<>(new DefaultKafkaProducerFactory<>(configProps()));
    }

    @Bean(value = "accept-student-application")
    public KafkaTemplate<String, AcceptStudentApplicationEventAvro> acceptStudentApplicationEventAvroKafkaTemplate() {
        return new KafkaTemplate<>(new DefaultKafkaProducerFactory<>(configProps()));
    }

    @Bean(value = "remove-student-application")
    public KafkaTemplate<String, RemoveStudentApplicationEventAvro> removeStudentApplicationEventAvroKafkaTemplate() {
        return new KafkaTemplate<>(new DefaultKafkaProducerFactory<>(configProps()));
    }

    @Bean(value = "delete-job")
    public KafkaTemplate<String, DeleteJobEventAvro> deleteJobEventAvroKafkaTemplate() {
        return new KafkaTemplate<>(new DefaultKafkaProducerFactory<>(configProps()));
    }
}
