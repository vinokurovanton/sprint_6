import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Objects;

public class FelineTest {
    Feline feline = new Feline();
    List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
    String expectedFamily = "Кошачьи";
    int expectedKitten = 1;

    @Test
    public void checkListOfLionsFood() throws Exception {
        Assert.assertTrue(Objects.equals(feline.eatMeat(), expectedFood));
    }

    @Test
    public void checkFamilyOfFeline() throws Exception {
        Assert.assertTrue(expectedFamily.contains(feline.getFamily()));
    }

    @Test
    public void checkKittens() {
        Assert.assertTrue(feline.getKittens() == expectedKitten);
    }
}
