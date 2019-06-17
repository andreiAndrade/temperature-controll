package io.pragmabrewery.service;

import io.pragmabrewery.repository.entity.BeerContainer;

import java.util.List;
import java.util.TimerTask;
import java.util.logging.Logger;

public class BeerContainerMonitor extends TimerTask {

    private Logger logger = Logger.getLogger(BeerContainerMonitor.class.getName());
    private BeerContainerService beerContainerService;
    private final TemperatureSensor temperatureSensor;

    public BeerContainerMonitor(TemperatureSensor temperatureSensor) {
        this.beerContainerService = BeerContainerService.instance();
        this.temperatureSensor = temperatureSensor;
    }

    @Override
    public void run() {
        List<BeerContainer> beerContainerList = beerContainerService.list();

        logger.info("=========== Monitoring temperature ===========");
        beerContainerList.forEach(beerContainer -> {
            double temperature = temperatureSensor.getRandomTemperature(beerContainer);
            beerContainer.setTemperature(temperature);

            if (beerContainer.isOutsideCorrectRange()) {
                logger.warning(beerContainer.getBeerStyle() + ": " + beerContainer.getTemperature());
            } else {
                logger.info(beerContainer.getBeerStyle() + ": " + beerContainer.getTemperature());
            }
        });

        beerContainerService.update(beerContainerList);
    }
}
