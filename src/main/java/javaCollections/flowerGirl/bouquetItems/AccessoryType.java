package javaCollections.flowerGirl.bouquetItems;

public enum AccessoryType {

    PAPER_WRAP("Paper wrap"),
    RIBBON("Ribbon"),
    BASKET("Basket"),
    BOX("Box");

    private final String value;

    AccessoryType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
