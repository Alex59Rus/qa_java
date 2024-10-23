import com.example.Animal;

import java.util.List;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AnimalTest {
    Animal animal = new Animal();

    @Test
    public void getFamilyIsCorrect() {
    }

    @Test
    public void getFoodCheckException() {
        List<String> expectedPredatorFood = List.of("Животные", "Птицы", "Рыба");
        String expectedExceptionMessage = "Неизвестный вид животного, используйте значение Травоядное или Хищник";

        try {
            List<String> actualAnimalFood = animal.getFood("animalKind");
            assertEquals(expectedPredatorFood, actualAnimalFood);
        } catch (Exception exception) {
            String actualException = exception.getMessage();
            assertEquals(expectedExceptionMessage, actualException);
        }
    }

}