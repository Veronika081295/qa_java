import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Feline;
import praktikum.Lion;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

@RunWith(MockitoJUnitRunner.class)
public class LionTests {
    private Lion lion;
    @Mock
    Feline feline;

    @Test
    public void testGetKittens() throws Exception {
        lion = new Lion("Самец",feline);
        lion.getKittens();
        Mockito.verify(feline).getKittens();
    }

    @Test
    public void testGetFood() throws Exception {
        Lion lion = new Lion("Самец",feline);
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood(Mockito.eq("Хищник"))).thenReturn(expected);

        List<String> actual = lion.getFood();
        assertEquals(expected, actual);
        Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");
    }

    @Test
    public void testExceptionMessage() throws Exception{
        Exception exception = assertThrows(Exception.class, () -> new Lion("Не определено", feline));
        String exceptionMessage = "Используйте допустимые значения пола животного - самец или самка";
        assertEquals(exceptionMessage, exception.getMessage());
    }
}
