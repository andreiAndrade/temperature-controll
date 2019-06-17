package io.pragmabrewery.controller;

import io.pragmabrewery.repository.entity.BeerContainer;
import io.pragmabrewery.service.BeerContainerService;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/beer-container")
@Produces("application/json")
public class BeerContainerController {

    private final BeerContainerService beerContainerService;

    public BeerContainerController() {
        beerContainerService = BeerContainerService.instance();
    }

    @GET
    public List<BeerContainer> list() {
        return beerContainerService.list();
    }
}
