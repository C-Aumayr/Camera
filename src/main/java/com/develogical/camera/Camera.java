package com.develogical.camera;

public class Camera {

    private MemoryCard memoryCard;
    private Sensor sensor;
    public boolean powerState;
    public boolean currentlyWriting;

    public Camera(Sensor sensor) {
        this.sensor=sensor;
    }

    public Camera(Sensor sensor, MemoryCard memoryCard) {
        this.sensor=sensor;
        this.memoryCard=memoryCard;
    }

    public void pressShutter() {
        if (powerState) {
            WriteCompleteListener callback = () -> {
            };
            byte[] data = sensor.readData();
            memoryCard.write(data, callback);
            currentlyWriting = true;
        }
    }

    public void powerOn() {
        sensor.powerUp();
        powerState=true ;
    }

    public void powerOff() {
       if (!currentlyWriting) {
           sensor.powerDown();
        }
       powerState=false;
    }
}

