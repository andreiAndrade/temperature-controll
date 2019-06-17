package io.pragmabrewery.service;

import io.pragmabrewery.repository.entity.BeerContainer;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class BeerContainerMonitorTest {

    private BeerContainerService beerContainerService = BeerContainerService.instance();
    private TemperatureSensor temperatureSensorMock = mock(TemperatureSensor.class);
    private BeerContainerMonitor beerContainerMonitor = new BeerContainerMonitor(temperatureSensorMock);

    @Test
    public void run_withFiveInside_andOneOutsideCorrectRange() {
        when(temperatureSensorMock.getRandomTemperature(any())).thenReturn(5D);
        beerContainerMonitor.run();

        assertEquals(beerContainerService.list().stream().filter(BeerContainer::isOutsideCorrectRange).count(), 1);
        assertEquals(beerContainerService.list().stream().filter(beerContainer -> !beerContainer.isOutsideCorrectRange()).count(), 5);

        verify(temperatureSensorMock, times(6)).getRandomTemperature(any());
    }
}
