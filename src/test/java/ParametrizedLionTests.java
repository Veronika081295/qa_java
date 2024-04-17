import praktikum.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ParametrizedLionTests {
    private Feline feline;
    private final boolean hasMane;
    private final String sex;

    public ParametrizedLionTests(String sex, boolean hasMane) {
        this.sex = sex;
        this.hasMane = hasMane;
    }

    @Before
    public void setUp() {
        feline = Mockito.mock(Feline.class);
    }

    @Parameterized.Parameters
    public static Object[][] getParameters() {
        return new Object[][] {
                {"Самец", true},
                {"Самка", false}
        };
    }
    @Test
    public void testDoesHaveMane() throws Exception {
        Lion lion = new Lion(sex,feline);
        boolean actual = lion.doesHaveMane();
        assertEquals(hasMane, actual);
    }

}
