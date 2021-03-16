package com.develogical.camera;

public class Camera {

    private MemoryCard memoryCard;
    private Sensor sensor;

    public Camera(Sensor sensor) {
        this.sensor=sensor;
    }

    public Camera(Sensor sensor, MemoryCard memoryCard) {
        this.sensor=sensor;
        this.memoryCard=memoryCard;
    }

    public void pressShutter() {
        WriteCompleteListener callback = () -> {

        };
        byte[] data = sensor.readData();
        memoryCard.write(data, callback);
    }

    public void powerOn() {
        sensor.powerUp();
    }

    public void powerOff() {
       sensor.powerDown();
    }
}

