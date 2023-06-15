import com.test.task.BracketsValidationService;
import com.test.task.ValidationService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestValidator {

    private final ValidationService validationService = BracketsValidationService.getInstance();

    @Test
    public void testCorrectInput() {
        Assertions.assertTrue(validationService.isValid("({})[]{{}}((({})))"));
    }

    @Test
    public void testIncorrectCorrectInput() {
        Assertions.assertFalse(validationService.isValid("({}{}}((({})))"));
    }
}
