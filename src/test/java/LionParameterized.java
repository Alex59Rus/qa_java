import com.example.Feline;
import com.example.Lion;
import org.hamcrest.MatcherAssert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.hamcrest.CoreMatchers.equalTo;

@RunWith(Parameterized.class)
public class LionParameterized {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();
    @Mock
    Feline feline;

    private final String sex;
    private final boolean hasMane;

    public LionParameterized(String sex, boolean hasMane) {
        this.sex = sex;
        this.hasMane = hasMane;
    }

    @Parameterized.Parameters(name = "Класс Lion. Пол: {0}")
    public static Object[][] setSexForLion() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
        };
    }

    @Test
    public void doesHaveManeIsCorrect() {
        MatcherAssert.assertThat("Грива есть только у льва",
                new Lion(this.sex, feline).doesHaveMane(),
                equalTo(hasMane)
        );

    }

}