import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Виберіть тип збірки (100% або Full): ");
        String buildType = scanner.nextLine();

        if (buildType.equalsIgnoreCase("1")) {
            Builder.createBasicBuild();
        } else if (buildType.equalsIgnoreCase("2")) {
            FullBuilder.createFullBuild();
        } else {
            System.out.println("Неправильний вибір. Завершення програми.");
        }
    }
}