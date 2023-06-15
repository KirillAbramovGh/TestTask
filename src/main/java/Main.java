import com.test.task.BracketsValidationService;
import com.test.task.ValidationService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ValidationService validationService = BracketsValidationService.getInstance();

        Scanner scanner = new Scanner(System.in);

        String input;

        while (true) {
            System.out.println("Введите строку или exit для выхода");
            input = scanner.nextLine();

            if("exit".equals(input)) {
                break;
            }

            System.out.println(validationService.getDescription(input));
        }
    }
}
