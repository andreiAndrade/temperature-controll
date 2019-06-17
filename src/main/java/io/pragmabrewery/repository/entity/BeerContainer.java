package io.pragmabrewery.repository.entity;

import io.pragmabrewery.enums.BeerStyle;

public class BeerContainer {
    private BeerStyle beerStyle;
    private double temperature;
    private double maxTemperature;
    private double minTemperature;
    private boolean outsideCorrectRange;

    public BeerContainer() {}

    public BeerContainer(BeerStyle beerStyle, double minTemperature, double maxTemperature) {
        this.beerStyle = beerStyle;
        this.minTemperature = minTemperature;
        this.maxTemperature = maxTemperature;
    }

    public BeerStyle getBeerStyle() {
        return beerStyle;
    }

    public void setBeerStyle(BeerStyle beerStyle) {
        this.beerStyle = beerStyle;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(double maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    public double getMinTemperature() {
        return minTemperature;
    }

    public void setMinTemperature(double minTemperature) {
        this.minTemperature = minTemperature;
    }

    public boolean isOutsideCorrectRange() {
        return this.outsideCorrectRange =
                this.temperature > this.maxTemperature || this.temperature < this.minTemperature;
    }

    public void setOutsideCorrectRange(boolean outsideCorrectRange) {
        this.outsideCorrectRange = outsideCorrectRange;
    }
}
