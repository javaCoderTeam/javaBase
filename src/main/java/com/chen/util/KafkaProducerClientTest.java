package com.chen.util;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.junit.Test;
import org.springframework.util.Assert;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author :  chen weijie
 * @Date: 2019-09-24 00:18
 */
public class KafkaProducerClientTest {


    private static final Properties props = new Properties();

    private static KafkaProducer<String, String> producer;

    static {
        try {
            InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("producer.properties");
            props.load(in);
            producer = new KafkaProducer<>(props);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public boolean send(String topic, String message) {

        try {
            Assert.notNull(topic);
            Assert.notNull(message);

            Future<RecordMetadata> future = producer.send(new ProducerRecord<>(topic, message));
            RecordMetadata recordMetadata = future.get();
            System.out.println(recordMetadata.timestamp());
            return true;
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            return false;
        }
    }


    @Test
    public void sendMessageTest() {


        for (int i = 0; i < 20; i++) {

            new Thread(() -> {

                for (int i1 = 0; i1 < 100000; i1++) {
                    send("ent_record_topic", Thread.currentThread().getName() + ":" + i1+"ent_record_topicent_record_topicent_record_topicent_record_topicent_record_topicent_record_topicent_record_topicent_record_topicent_record_topicent_record_topicent_record_topicent_record_topic");
                }

            }).start();

        }



        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
