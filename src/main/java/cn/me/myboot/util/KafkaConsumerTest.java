package cn.me.myboot.util;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

public class KafkaConsumerTest {
    public static void main(String[] args) {
        // 创建用于kafka的配置
        Properties props = new Properties();
        props.put("bootstrap.servers", "23.95.17.10:9092");
        // 多个消费者构成的群组
        props.put("group.id", "consumerGroup");
        // 自动提交offset
        props.put("enable.auto.commit", "true");
        // 自动提交offset的时间间隔
        props.put("auto.commit.interval.ms", "1000");
        props.put("key.deserializer", StringDeserializer.class);
        props.put("value.deserializer", StringDeserializer.class);
        // 创建消费者对象
        KafkaConsumer<String, String> kafkaConsumer = new KafkaConsumer<>(props);
        // 订阅要消费的主题
        kafkaConsumer.subscribe(Collections.singletonList("mykafka"));
        // 使用一个while循环不断从kafka拉取数据
        while (true) {
            // 每五秒拉取数据，一次拉取一个集合
            ConsumerRecords<String, String> records = kafkaConsumer.poll(Duration.ofSeconds(5));
            // 遍历拉取到的数据
            for (ConsumerRecord<String, String> record : records) {
                // 主题
                // 这条消息处于哪个位置
                // key和value
                System.out.println("topic: " + record.topic() + " offset: " + record.offset() + " key: " + record.key() + " value: " + record.value());
            }
        }
        // kafkaConsumer.close();
    }
}
