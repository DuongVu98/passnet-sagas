package com.cseiu.passnet.saga.classroomsaga.config;

import com.cse.iu.passnet.saga.avro.AcceptStudentApplicationEventAvro;
import com.cse.iu.passnet.saga.avro.DeleteJobEventAvro;
import com.cse.iu.passnet.saga.avro.PostNewJobEventAvro;
import com.cse.iu.passnet.saga.avro.RemoveStudentApplicationEventAvro;
import io.confluent.kafka.serializers.KafkaAvroSerializer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;

import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
public class KafkaConsumerConfiguration {

    @Value("${kafka.bootstrap-server}")
    private String bootstrapServer;

    @Bean
    public Map<String, Object> consumerConfigs(){
        Map<String, Object> props = new HashMap<>();

        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "classroom-saga");
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

        return props;
    }

    public ConsumerFactory<String, Object> consumerFactory(){
        return new DefaultKafkaConsumerFactory<>(consumerConfigs());
    }

    @Bean
    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, PostNewJobEventAvro>> postNewJobEventContainerFactory(){
        ConcurrentKafkaListenerContainerFactory<String, PostNewJobEventAvro> factory = new ConcurrentKafkaListenerContainerFactory<>();

        factory.setConsumerFactory(consumerFactory());
        return factory;
    }

    @Bean
    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, AcceptStudentApplicationEventAvro>> acceptStudentApplicationEventContainerFactory(){
        ConcurrentKafkaListenerContainerFactory<String, AcceptStudentApplicationEventAvro> factory = new ConcurrentKafkaListenerContainerFactory<>();

        factory.setConsumerFactory(consumerFactory());
        return factory;
    }

    @Bean
    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, RemoveStudentApplicationEventAvro>> removeStudentApplicationEventContainerFactory(){
        ConcurrentKafkaListenerContainerFactory<String, RemoveStudentApplicationEventAvro> factory = new ConcurrentKafkaListenerContainerFactory<>();

        factory.setConsumerFactory(consumerFactory());
        return factory;
    }

    @Bean
    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, DeleteJobEventAvro>> deleteJobEventContainerFactory(){
        ConcurrentKafkaListenerContainerFactory<String, DeleteJobEventAvro> factory = new ConcurrentKafkaListenerContainerFactory<>();

        factory.setConsumerFactory(consumerFactory());
        return factory;
    }
}
