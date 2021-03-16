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
        underTest.powerOn();
        underTest.pressShutter();
        verify(memoryCard).write(eq(new byte[]{1,0,1}), any() );
    }

    @Test
    public void whenPowerIsOffPressingTheShutterDoesNothing() {
        underTest.powerOff();
        verifyZeroInteractions(sensor, memoryCard);

//        //using mocks - only mockOne is interacted
//        mockOne.add("one");
//
//        //ordinary verification
//        verify(mockOne).add("one");
//
//        //verify that method was never called on a mock
//        verify(mockOne, never()).add("two");
//
//        //verify that other mocks were not interacted
//        verifyZeroInteractions(mockTwo, mockThree);

    }

}
