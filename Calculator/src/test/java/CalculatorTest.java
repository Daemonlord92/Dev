import org.blitmatthew.Calculator;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    public void setup() {
        calculator = new Calculator();
    }

    @AfterEach
    public void trash() {
        calculator = null;
    }

    @Test
    @DisplayName("It should add two params together")
    public void Calculator_add_ShouldReturnInt(){
        assertEquals(4, calculator.add(2,2));
    }


}
