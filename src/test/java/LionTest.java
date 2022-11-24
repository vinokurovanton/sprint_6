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
public class LionTest {
    @Mock
    Feline feline;
    List<String> food = List.of("Животные", "Птицы", "Рыба");

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void maleShouldHaveMane() throws Exception {
        Lion lion = new Lion(feline, "Самец");
        Assert.assertTrue("A male doesn't have a male" ,lion.doesHaveMane());
    }

    @Test
    public void femaleShouldNotHaveMane() throws Exception {
        Lion lion = new Lion(feline, "Самка");
        Assert.assertFalse("A female have a male" ,lion.doesHaveMane());
    }



    @Test
    public void countOfKittensIsOne() throws Exception {
        Lion lion = new Lion(feline, "Самка");
        Assert.assertFalse("Count of kittens is incorrect" ,lion.getKittens() == 1);
    }

    @Test
    public void checkListOfLionsFood() throws Exception {
        Lion lion = new Lion(feline, "Самка");
        Mockito.when(feline.getFood("Хищник")).thenReturn(food);
        Assert.assertTrue(Objects.equals(lion.getFood(), food));
    }
}
