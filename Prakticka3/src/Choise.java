import java.util.Scanner;
public class Choise {
    public static int getUserChoice(TypeComponent type) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Оберіть компонент " + type.toString() + " або введіть '0' для завершення: ");
        int choice = scanner.nextInt();
        if (choice >= 1 && choice <= 3) {
            return choice;
        } else {
            System.out.println("Неправильний вибір. Спробуйте ще раз.");
            return getUserChoice(type);
        }
    }
}
