public enum Emoji {
    STONE("\uD83E\uDEA8"), RABBIT("🐇"), WOLF("\uD83D\uDC3A"),
    LEAF("\uD83C\uDF3F"), PALM("\uD83C\uDF34"), EMPTY("\uD83C\uDF43") ;
    private final String symbol;

    public String getSymbol() {
        return symbol;
    }

    Emoji(String symbol) {
        this.symbol = symbol;
    }
}
