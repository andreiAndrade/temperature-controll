package io.pragmabrewery.database;

import io.pragmabrewery.repository.entity.BeerContainer;

import java.util.List;

public class Database {

    private static Database instance;

    private List<BeerContainer> beerContainerList;

    private Database() {}

    public static Database instance() {
        return instance == null ? instance = new Database() : instance;
    }

    public void setBeerContainerList(List<BeerContainer> beerContainerList) {
        this.beerContainerList = beerContainerList;
    }

    public List<BeerContainer> getBeerContainerList() {
        return beerContainerList;
    }
}
