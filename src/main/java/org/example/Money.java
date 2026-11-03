package org.example;

import java.math.BigDecimal;
import java.util.Objects;

public class Money {
    private final BigDecimal amount;
    private final Currency currency;

    public Money(BigDecimal amount, Currency currency) {
        this.amount = Objects.requireNonNull(amount, "amount").stripTrailingZeros();
        this.currency = Objects.requireNonNull(currency, "currency");
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Money money = (Money) o;
        return this.amount.compareTo(money.amount) == 0 && Objects.equals(this.currency, money.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, currency);
    }
}