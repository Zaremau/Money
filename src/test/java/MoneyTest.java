import org.example.Currency;
import org.example.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class MoneyTest {

    HashSet<Money> money = new HashSet<>(Set.of(
            new Money(new BigDecimal("100.00"), Currency.EUR),
            new Money(new BigDecimal("125.1"), Currency.USD),
            new Money(new BigDecimal("438.24"), Currency.RUB)));

    Money moneyInHashSet = new Money(new BigDecimal("125.1"), Currency.USD);
    Money moneyNotInHashSet = new Money(new BigDecimal("125.1"), Currency.EUR);

    @Test
    @DisplayName("right implementation of hashCode()")
    void testHashSetWithCorrectHashCodeImplementation(){
        assertTrue(money.contains(moneyInHashSet));
        assertFalse(money.add(moneyInHashSet));
        assertTrue(money.add(moneyNotInHashSet));
    }
}
