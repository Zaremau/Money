package org.example;

import java.math.BigDecimal;
import java.util.Objects;

public class MoneyBug {

    private final BigDecimal amount;
    private final Currency currency;

    public MoneyBug(BigDecimal amount, Currency currency) {
        this.amount = Objects.requireNonNull(amount, "amount").stripTrailingZeros();
        this.currency = Objects.requireNonNull(currency, "currency");
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        MoneyBug money = (MoneyBug) o;
        return this.amount.compareTo(money.amount) == 0 && Objects.equals(this.currency, money.currency);
    }

    /**
     * Реализация hashCode() из Object считает хэш-код на основе адреса памяти,
     * поэтому у двух одинаковых объектов будет разный хэш-код
     */
    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
