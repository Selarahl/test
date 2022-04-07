import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void testTaxEarnings() throws Exception {
        // given:
        int a = 500, expected = 30;
        // when:
        int result = Main.taxEarnings(a);
        // then:
        assertEquals(expected, result);
    }

    @Test
    void testTaxEarningsMinusSpendings() throws Exception {
        // given:
        int a = 500, b = 100, expected = 60;
        // when:
        int result = Main.taxEarningsMinusSpendings(a, b);
        // then:
        assertEquals(expected, result);
    }

    @Test
    void testEqualsTaxEarnings() {
        // given:
        int a = 100, condition = 6;
        // when:
        int result = Main.taxEarnings(a);
        // then:
        assertTrue(condition == result);
    }

    @Test
    void testNotEqualsTaxEarningsMinusSpendings() {
        // given:
        int a = 100, b = 200, condition = 333;
        // when:
        int result = Main.taxEarningsMinusSpendings(a, b);
        // then:
        assertFalse(condition == result);
    }

    //HAMCREST

    @Test
    void givenNumber_More_thenCorrect() {
        Integer a = 500;
        Integer result = Main.taxEarnings(a);
        assertThat(result, (greaterThan(5)));
    }

    @Test
    void givenNumber_notEqual_thenCorrect() {
        Integer a = 100, b = 200;
        Integer result = Main.taxEarningsMinusSpendings(a, b);
        assertThat(result, not(equalTo(5)));
    }
}