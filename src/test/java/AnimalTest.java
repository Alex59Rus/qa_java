import com.example.Animal;

import org.hamcrest.MatcherAssert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.assertj.core.api.Assertions.catchThrowable;

import static org.assertj.core.api.Assertions.assertThat;

public class AnimalTest {
    Animal animal = new Animal();

    @Test
    public void getFamilyIsCorrect() {
        String expectedString = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        MatcherAssert.assertThat("Некорректный перечень семейств",
                new Animal().getFamily(),
                equalTo(expectedString)
        );
    }

    @Test
    public void getFoodCheckException() {
        Throwable throwable = catchThrowable(() -> animal.getFood("unsupported animal kind"));
        assertThat(throwable)
                .isInstanceOf(Exception.class)
                .hasMessage("Неизвестный вид животного, используйте значение Травоядное или Хищник");
    }
}