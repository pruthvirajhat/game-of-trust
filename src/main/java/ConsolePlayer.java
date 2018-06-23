import java.util.Scanner;

public class ConsolePlayer implements PlayerType {
    @Override
    public String readInput() {
        return new Scanner(System.in).nextLine();
    }
}
