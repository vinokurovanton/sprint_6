import com.example.Cat;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;
import java.util.Objects;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {
    String expectedSound = "Мяу";
    @Mock
    Feline feline;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void checkThatCatMeow(){
        Cat cat = new Cat(feline);
        Assert.assertTrue("Cat doesn't meow", expectedSound.contains(cat.getSound()));
    }




}
