package com.develogical.camera;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

import static org.mockito.Mockito.*;

public class CameraTest {
    @Test
    public void switchingTheCameraOnPowersUpTheSensor() {
        Sensor sensor = mock(Sensor.class);
        Camera underTest = new Camera(sensor);
        underTest.powerOn();
        verify(sensor).powerUp();
    }


    @Test
    public void switchingTheCameraOffPowersDownTheSensor() {
        Sensor sensor = mock(Sensor.class);
        Camera underTest = new Camera(sensor);

        underTest.powerOff();

        verify(sensor).powerDown();

    }

    @Test
    public void pressingShutterCopiesData() {
        Sensor sensor = mock(Sensor.class);
        MemoryCard memoryCard = mock(MemoryCard.class);
        Camera underTest = new Camera(sensor, memoryCard);


    }

}
