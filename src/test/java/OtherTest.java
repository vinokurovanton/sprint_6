import com.example.Animal;
import com.example.Cat;
import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;
import java.util.Objects;

@RunWith(MockitoJUnitRunner.class)
public class OtherTest {
    @Mock
    Feline feline;
    String expectedFamily = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
    String expectedException = "Используйте допустимые значения пола животного - самец или самка";
    String expectedExceptionFood = "Неизвестный вид животного, используйте значение Травоядное или Хищник";
    List<String> foodMeat = List.of("Животные", "Птицы", "Рыба");
    List<String> foodGreen = List.of("Трава", "Различные растения");

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getExceptionIfIncorrectSex() throws Exception {
        try {
            Lion lion = new Lion(feline, "Самица");
        } catch (Exception e){
            Assert.assertTrue("Exception doesn't show", e.getMessage().contains(expectedException));
        }
    }

    @Test
    public void checkCatsFood() throws Exception {
        Cat cat = new Cat(feline);
        Mockito.when(cat.getFood()).thenReturn(foodMeat);
        Assert.assertTrue(Objects.equals(cat.getFood(), foodMeat));
    }

    @Test
    public void checkFamily() throws Exception {
        Animal belka = new Animal();
        Assert.assertTrue(belka.getFamily().equals(expectedFamily));
    }

    @Test
    public void checkHerbivoreFood() throws Exception {
        Animal belka = new Animal();
        Assert.assertTrue(Objects.equals(belka.getFood("Травоядное"), foodGreen));
    }

    @Test
    public void checkUnknownFood() throws Exception {
        Animal belka = new Animal();
        try {
            Assert.assertTrue(Objects.equals(belka.getFood("Инопланетное"), foodGreen));
        } catch (Exception e){
            Assert.assertTrue("Exception doesn't show", e.getMessage().contains(expectedExceptionFood));
        }
    }
}
