package hu.mpb.backendpetproject.model.pettree;

public enum PetSpecies {
    RABBIT(1, 2),
    CAT(3, 5),
    PUG(6, 9),
    BEAGLE(10, 14),
    HUSKY(15, 24),
    GOLDEN_RETRIEVER(25, 34),
    GERMAN_SHEPHERD(35, 39),
    GOAT(40, 69),
    SHEEP(70, 99),
    PIG(100, 349),
    DONKEY(350, 449),
    HORSE(450, 799),
    COW(800, 1099),
    HIPPOPOTAMUS(1100, 1799),
    RHINOCEROS(1800, 2999),
    ELEPHANT(3000, 7999),
    SPERM_WHALE(8000, 39_999),
    FIN_WHALE(40_000, 99_999),
    BLUE_WHALE(100_000, 199_999),
    GREAT_OLD_ONE(200_000, Integer.MAX_VALUE);

    private final int lowerWeightBound;
    private final int upperWeightBound;

    PetSpecies(int lowerWeightBound, int upperWeightBound) {
        this.lowerWeightBound = lowerWeightBound;
        this.upperWeightBound = upperWeightBound;
    }

    public boolean fallsInWeightBounds(int weight) {
        return upperWeightBound >= weight && lowerWeightBound <= weight;
    }
}
