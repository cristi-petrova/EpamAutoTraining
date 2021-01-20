package javaCollections.flowerGirl.bouquetItems;

public enum FlowerType {

    MATTHIOLA("Matthiola", 30),
    ROSE("Rose", 50),
    PAEONY("Paeony", 40),
    AMARYLLIS("Amaryllis", 45),
    CAMOMILE("Camomile", 35),
    LILAC("Lilac", 25),
    LILY("Lily", 30),
    PANICUM("Panicum", 45),
    EUCALYPTUS("Eucalyptus", 50);

    private final String value;
    private final int stemLength;

    FlowerType(String value, int stemLength) {
        this.value = value;
        this.stemLength = stemLength;
    }

    public String getValue() {
        return value;
    }

    public static FlowerType fromString(String text) {
        for (FlowerType b : FlowerType.values()) {
            if (b.getValue().equalsIgnoreCase(text)) {
                return b;
            }
        }
        return null;
    }

    public int getStemLength() {
        return stemLength;
    }
}
