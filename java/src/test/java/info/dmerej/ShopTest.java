package info.dmerej;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ShopTest {
    private final Address parisAddress = new Address(
        "33 quai d'Orsay",
        "",
        "Paris",
        "75007",
        "France"
    );


    @Test
    public void happy_path() {
        final User user = new UserBuilder().withDefaultValues().build();

        assertTrue(Shop.canOrder(user));
        assertFalse(Shop.mustPayForeignFee(user));
    }

    @Test
    public void minors_cannot_order_from_shop() {
        final User user = new UserBuilder().withDefaultValues().withAge(16).build();

        assertFalse(Shop.canOrder(user));
    }

    @Test
    public void must_be_verified_to_order_from_shop() {
        final User user = new UserBuilder().withDefaultValues().withVerified(false).build();

        assertFalse(Shop.canOrder(user));
    }

    @Test
    public void foreigners_must_pay_foreign_fee() {
        final User user = new UserBuilder().withDefaultValues().withAddress(parisAddress).build();

        assertTrue(Shop.mustPayForeignFee(user));
    }

}
