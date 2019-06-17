package io.pragmabrewery.enums;

public enum BeerStyle {
    PILSNER("Pilsner"),
    IPA("IPA"),
    LAGER("Lager"),
    STOUT("Stout"),
    WHEAT_BEER("Wheat beer"),
    PALE_ALE("Pale Ale");

    String label;

    BeerStyle(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
