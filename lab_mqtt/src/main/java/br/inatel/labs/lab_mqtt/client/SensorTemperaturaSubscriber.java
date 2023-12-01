package br.inatel.labs.lab_mqtt.client;

import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;

import java.util.UUID;

public class SensorTemperaturaSubscriber {
    public static void main(String[] args) throws MqttException {
        String subscriberID = UUID.randomUUID().toString();
        IMqttClient subscriber = new MqttClient(MyConstants.URL_BROKER, subscriberID);

        MqttConnectOptions options = new MqttConnectOptions();
        options.setAutomaticReconnect(true);
        options.setCleanSession(true);
        options.setConnectionTimeout(10);
        System.out.println("Subscriber conectado e aguardando resposta");

        subscriber.connect();

        subscriber.subscribe(MyConstants.TOPC_SENSOR, (topic, msg) -> {
            byte[] payload = msg.getPayload();
            System.out.println("Payload recebido: " + payload);
            System.out.println("Messagem recebida: " + msg);
            System.out.println("Topico recebido: " + topic);
        });
    }
}
