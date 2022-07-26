package ru.javarush.cryptoanalyzer.belitsky.myclasses;

/**
 * Класс создан для облегчения работы с парой символ его кол вхождений
 * и сортировки по значению от большего к меньшему.
 */
public class CharInt implements Comparable<CharInt> {
    private Character symbol;
    private Integer symbolQuantity;

    public CharInt(Character symbol, Integer symbolQuantity/*Integer allSymbols*/) {
        this.symbol = symbol;
        this.symbolQuantity = symbolQuantity;
    }

    public void setSymbol(Character symbol) {
        this.symbol = symbol;
    }

    public void setSymbolQuantity(Integer symbolQuantity) {
        this.symbolQuantity = symbolQuantity;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        CharInt charInt = (CharInt) obj;
        return this.symbol.equals(charInt.symbol);
    }

    @Override
    public int hashCode() {
        return this.symbol.hashCode();
    }

    public Integer getSymbolQuantity() {
        return symbolQuantity;
    }

    public Character getSymbol() {
        return symbol;
    }

    //TODO Code style. Many warnings. Skip or fix it.
    private int compare(CharInt first, CharInt second) {
        return first.getSymbolQuantity() < second.getSymbolQuantity() ? 1 : first.getSymbolQuantity() == second.getSymbolQuantity() ? 0 : -1;
    }

    @Override
    public int compareTo(CharInt o) {
        return compare(this, o);
    }

    @Override
    public String toString() {
        return symbol + ", " + symbolQuantity;
    }
}
