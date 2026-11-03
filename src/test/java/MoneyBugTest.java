import org.example.Currency;
import org.example.MoneyBug;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import static org.example.Currency.USD;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MoneyBugTest {
    HashSet<MoneyBug> money = new HashSet<>(Set.of(
            new MoneyBug(new BigDecimal("100.00"), Currency.EUR),
            new MoneyBug(new BigDecimal("125.1"), Currency.USD),
            new MoneyBug(new BigDecimal("438.24"), Currency.RUB)));

    MoneyBug moneyInHashSet = new MoneyBug(new BigDecimal("125.1"), Currency.USD);

    @Test
    @DisplayName("wrong implementation of hashCode()")
    void testHashSetWithWrongHashCodeImplementation(){
        assertFalse(money.contains(moneyInHashSet));
        assertTrue(money.add(moneyInHashSet));
    }
}
