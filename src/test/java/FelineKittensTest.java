import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class FelineKittensTest {
    Feline feline = new Feline();

    private final int firstNumber;
    private final int secondNumber;

    public FelineKittensTest(int firstNumber, int secondNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][] {
                {0, 0},
                {1, 1},
                {-1, -1},
        };
    }

    @Test
    public void checkKittens(){
        Assert.assertTrue(feline.getKittens(firstNumber) == secondNumber);
    }
}
