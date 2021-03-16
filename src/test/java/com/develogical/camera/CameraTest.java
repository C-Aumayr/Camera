package com.develogical.camera;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

public class CameraTest {

    Sensor sensor = mock(Sensor.class);
    MemoryCard memoryCard = mock(MemoryCard.class);
    Camera underTest = new Camera(sensor, memoryCard);

    @Test
    public void switchingTheCameraOnPowersUpTheSensor() {
        underTest.powerOn();
        verify(sensor).powerUp();
    }


    @Test
    public void switchingTheCameraOffPowersDownTheSensor() {
        underTest.powerOff();
        verify(sensor).powerDown();

    }

    @Test
    public void pressingShutterCopiesData() {
        given(sensor.readData()).willReturn(new byte[]{1,0,1});
        underTest.pressShutter();
        verify(memoryCard).write(eq(new byte[]{1,0,1}), any() );
    }

}
