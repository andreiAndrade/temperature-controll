package io.pragmabrewery.repository.entity;

import io.pragmabrewery.enums.BeerStyle;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BeerContainerTest {

    private BeerContainer beerContainer;
    @Before
    public void setUp() {
        beerContainer = new BeerContainer(BeerStyle.IPA, 5, 7);
    }

    @Test
    public void isOutsideCorrectRange_assertTrue() {
        beerContainer.setTemperature(10);
        assertTrue(beerContainer.isOutsideCorrectRange());
    }

    @Test
    public void isOutsideCorrectRange_assertFalse() {
        beerContainer.setTemperature(6);
        assertFalse(beerContainer.isOutsideCorrectRange());
    }
}
