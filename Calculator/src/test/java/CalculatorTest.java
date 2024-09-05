import org.blitmatthew.Calculator;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

    @Test
    public void Calculator_divide_ShouldReturnInt() {
        assertEquals(5, calculator.divide(15,3));
    }

    @Test
    public void Calculator_divide_ShouldThrowExceptionDivideByZero() {
        Throwable throwable = assertThrows(ArithmeticException.class, () -> calculator.divide(5,0));
        assertEquals("Cannot divide by zero!", throwable.getMessage());
    }
}
