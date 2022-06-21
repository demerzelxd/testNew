package cn.me.myboot.util;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class KafkaProducerTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 创建用于kafka的配置
        Properties props = new Properties();
        props.put("bootstrap.servers", "23.95.17.10:9092");
        props.put("acks", "all");
        props.put("key.serializer", StringSerializer.class);
        props.put("value.serializer", StringSerializer.class);
        // 创建生产者对象
        KafkaProducer<String, String> kafkaProducer = new KafkaProducer<>(props);
        // 发送0-99消息到指定的topic
        for (int i = 0; i < 100; i++) {
            ProducerRecord<String, String> record = new ProducerRecord<>("mykafka", null, i + "");
            Future<RecordMetadata> future = kafkaProducer.send(record);
            // get方法等待响应
            future.get();
            // Thread.sleep(2000);
            // 响应完成后打印
            System.out.println("第" + i + "条写入成功");
        }
        // 关闭生产者
        kafkaProducer.close();
    }
}
