package info.dmerej;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ShopTest {



    @Test
    public void happy_path() {
        final User user = new UserBuilder().withDefaultValues().build();

        assertTrue(Shop.canOrder(user));
        assertFalse(Shop.mustPayForeignFee(user));
    }

    @Test
    public void minors_cannot_order_from_shop() {
        final User user = new UserBuilder().withDefaultValues().minor().build();

        assertFalse(Shop.canOrder(user));
    }

    @Test
    public void must_be_verified_to_order_from_shop() {
        final User user = new UserBuilder().withDefaultValues().notVerified().build();

        assertFalse(Shop.canOrder(user));
    }

    @Test
    public void foreigners_must_pay_foreign_fee() {
        final User user = new UserBuilder().withDefaultValues().withForeignAddress().build();

        assertTrue(Shop.mustPayForeignFee(user));
    }

}
