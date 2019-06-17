package io.pragmabrewery.service;

import io.pragmabrewery.repository.BeerContainerRepository;
import io.pragmabrewery.repository.entity.BeerContainer;

import java.util.List;

public class BeerContainerService {

    private static BeerContainerService instance;

    private BeerContainerRepository repository;

    private BeerContainerService() {
        repository = BeerContainerRepository.instance();
    }

    public static BeerContainerService instance() {
        return instance == null ? instance = new BeerContainerService() : instance;
    }

    public List<BeerContainer> list() {
        return repository.list();
    }

    public void update(List<BeerContainer> beerContainerList) {
        repository.update(beerContainerList);
    }
}
