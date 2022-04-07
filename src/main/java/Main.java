import java.util.Scanner;

class Main {

    public static int taxEarnings(int earnings) {
        int taxA = earnings * 6 / 100;
        return taxA;
    }

    public static int taxEarningsMinusSpendings(int earnings, int spendings) {
        int taxB = (earnings - spendings) * 15 / 100;
        if (taxB >= 0) {
            return taxB;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int earnings = 0; // доходы
        int spendings = 0; // расходы

        while (true) {
            System.out.println(
                    "Выберите операцию и введите её номер:\n 1. Добавить новый доход\n 2. Добавить новый расход\n 3. Выбрать ситему налогооблажения");

            String input = scanner.nextLine();
            if ("end".equals(input)) {
                System.out.println("Программа завершена!");
                break;
            }

            int operation = Integer.parseInt(input);
            switch (operation) {
                case 1:
                    System.out.println("Введите сумму дохода:");
                    String earn = scanner.nextLine();
                    int moneyE = Integer.parseInt(earn);
                    earnings += moneyE;
                    break;
                case 2:
                    System.out.println("Введите сумму расхода:");
                    String spend = scanner.nextLine();
                    int moneyS = Integer.parseInt(spend);
                    spendings += moneyS;
                    break;
                case 3:
                    int taxA = taxEarnings(earnings);
                    int taxB = taxEarningsMinusSpendings(earnings, spendings);
                    if (taxA > taxB) {
                        System.out.println("Мы советум УСН доходы - расходы");
                        System.out.println("Ваш налог составит:" + taxB);
                        System.out.println("Налог на другой системе:" + taxA);
                        System.out.println("Экономия:" + (taxA - taxB));
                        break;
                    } else if (taxA < taxB) {
                        System.out.println("Мы советум УСН доходы");
                        System.out.println("Ваш налог составит:" + taxA);
                        System.out.println("Налог на другой системе:" + taxB);
                        System.out.println("Экономия:" + (taxB - taxA));
                        break;
                    } else {
                        System.out.println("Вам одинаково подойдут обе системы налогообложения.");
                        break;
                    }

            }

        }
    }
}
