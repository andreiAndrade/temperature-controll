package io.pragmabrewery.repository;

import io.pragmabrewery.database.Database;
import io.pragmabrewery.enums.BeerStyle;
import io.pragmabrewery.repository.entity.BeerContainer;

import java.util.Arrays;
import java.util.List;

public class BeerContainerRepository {

    private static BeerContainerRepository instance;

    private BeerContainerRepository() {
        BeerContainer beerContainer1 = new BeerContainer(BeerStyle.PILSNER, 4, 6);
        BeerContainer beerContainer2 = new BeerContainer(BeerStyle.IPA, 5, 6);
        BeerContainer beerContainer3 = new BeerContainer(BeerStyle.LAGER, 4, 7);
        BeerContainer beerContainer4 = new BeerContainer(BeerStyle.STOUT, 6, 8);
        BeerContainer beerContainer5 = new BeerContainer(BeerStyle.WHEAT_BEER, 3, 5);
        BeerContainer beerContainer6 = new BeerContainer(BeerStyle.PALE_ALE, 4, 6);

        Database.instance().setBeerContainerList(Arrays.asList(
                beerContainer1,
                beerContainer2,
                beerContainer3,
                beerContainer4,
                beerContainer5,
                beerContainer6
        ));
    }

    public static BeerContainerRepository instance() {
        return instance == null ? instance = new BeerContainerRepository() : instance;
    }

    public List<BeerContainer> list() {
        return Database.instance().getBeerContainerList();
    }

    public void update(List<BeerContainer> beerContainerList) {
        Database.instance().setBeerContainerList(beerContainerList);
    }
}
