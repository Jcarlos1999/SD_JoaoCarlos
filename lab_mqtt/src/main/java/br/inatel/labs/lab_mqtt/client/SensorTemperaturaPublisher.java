package br.inatel.labs.lab_mqtt.client;

import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttConnect;

import java.util.Random;
import java.util.UUID;

public class SensorTemperaturaPublisher {
    public static void main(String[] args) throws MqttException, InterruptedException {
        String publisherId = UUID.randomUUID().toString();
        IMqttClient publisher = new MqttClient(MyConstants.URL_BROKER, publisherId);

        MqttConnectOptions options = new MqttConnectOptions();
        options.setAutomaticReconnect(true);
        options.setCleanSession(true);
        options.setConnectionTimeout(10);
        publisher.connect();

    for( int i=0; i < 10; i++){
        MqttMessage msg = getTemperatureMessage();
        msg.setQos(0);
        msg.setRetained(true);

        publisher.publish(MyConstants.TOPC_SENSOR, msg);
        Thread.sleep(2000);

    }
        publisher.disconnect();
        publisher.close();
    }
    private static MqttMessage getTemperatureMessage(){
        Random r = new Random();
        double temperatura = 80 + r.nextDouble() *20.0;
        byte[] payload = String.format("T:%04.2f", temperatura).getBytes();
        return new MqttMessage(payload);
    }
}
