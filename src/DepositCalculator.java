import java.util.Scanner;


public class DepositCalculator {
    public static void main(String[] args) {
        DepositCalculator.depositManager();

    }

    double calculateComplexPercent(double amount, double yearRate, int depositDate) {
        double pay = amount * Math.pow((1 + yearRate / 12), 12 * depositDate);
        return random(pay, 2);
    }

    double calculateSimplePercent(double amount, double yearRate, int depositDate) {
        return random(amount + amount * yearRate * depositDate, 2);
    }

    double random(double value, int places) {
        double Scale = Math.pow(10, places);
        return Math.round(value * Scale) / Scale;
    }

    void depositManager() {
        int date;
        int action;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        date = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();
        double outVar = 0;

        if (action == 1) {
            outVar = calculateSimplePercent(amount, 0.06, date);
        } else if (action == 2) {
            outVar = calculateComplexPercent(amount, 0.06, date);
            System.out.println("Результат вклада: " + amount + " за " + date + " лет превратятся в " + outVar);
        }
    }
}
