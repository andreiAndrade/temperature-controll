package io.pragmabrewery.service;

import io.pragmabrewery.repository.entity.BeerContainer;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class TemperatureSensor {

    public double getRandomTemperature(BeerContainer beerContainer) {
        double minTemperature = beerContainer.getMinTemperature() - 0.5;
        double maxTemperature = beerContainer.getMaxTemperature() + 0.5;

        return BigDecimal.valueOf((Math.random() * ((maxTemperature - minTemperature) + 1)) + minTemperature)
                .setScale(2, RoundingMode.DOWN)
                .doubleValue();
    }
}
