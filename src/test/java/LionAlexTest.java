import com.example.Feline;
import com.example.LionAlex;
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
public class LionAlexTest {

    String expectedPlace = "Нью-Йоркский зоопарк";
    List<String> expectedFriends = List.of("Марти", "Глория", "Мелман");
    List<String> expectedFood= List.of("Марти", "Глория", "Мелман");
    @Mock
    Feline feline;


    public LionAlexTest() throws Exception {
    }

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void checkPlaceOfLiving() throws Exception {
        LionAlex alex = new LionAlex(feline);
        Assert.assertTrue(alex.getPlaceOfLiving().equals(expectedPlace));
    }

    @Test
    public void checkFood() throws Exception {
        LionAlex alex = new LionAlex(feline);
        Mockito.when(feline.getFood("Хищник")).thenReturn(expectedFood);
        Assert.assertTrue(Objects.equals(alex.getFood(), expectedFood));
    }

    @Test
    public void checkFriends() throws Exception {
        LionAlex alex = new LionAlex(feline);
        Assert.assertTrue(Objects.equals(alex.getFriends(), expectedFriends));
    }

    @Test
    public void checkThatAlexDoNotHaveKittens() throws Exception {
        LionAlex alex = new LionAlex(feline);
        Assert.assertTrue(alex.getKittens() ==0);
    }
}
