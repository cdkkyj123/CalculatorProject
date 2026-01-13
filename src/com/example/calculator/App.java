package com.example.calculator;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ArithmeticCalculator calculator = new ArithmeticCalculator(); // Calculator 인스턴스 생성

        Scanner scanner = new Scanner(System.in);

        while (true) {

            OperatorType operator;
            int num1 = 0;
            int num2;

            if (!calculator.hasResult()) {
                num1 = confirmInt(scanner, "첫 번째 숫자를 입력하세요: ");
            }

            operator = readoperator(scanner);
            num2 = confirmInt(scanner, "두 번째 숫자를 입력하세요: ");

            double result;

            if (!calculator.hasResult()) {
                result = calculator.calculate(operator, num1, num2);
            } else {
                result = calculator.calculate(operator, num2);
            }

            System.out.println("값은 " + result + "입니다.");
            System.out.println("더 계산하시겠습니까? 아무 키 + Enter 입력 시 계속 됩니다. (exit 입력 시 종료)");
            String quit = scanner.next();
            System.out.println("현재 값: " + result);
            if (quit.equals("exit")) {
                System.out.println("계산기를 종료합니다.");
                break;
            }
        }

        System.out.println("누적된 결과 조회: " + calculator.getResults());

        // 가장 먼저 저장된 데이터를 삭제하는 기능
        System.out.println("가장 먼저 저장된 결과를 삭제하시겠습니까? (y: 삭제, any key: 취소)");
        String confirm = scanner.next();

        if (confirm.equals("y")) {
            try {
                double removed = calculator.removeResult();
                System.out.println("가장 먼저 저장된 결과 " + removed + "를 삭제했습니다.");
                System.out.println("현재 남은 결과는 " + calculator.getResults() + " 입니다.");
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("삭제를 취소했습니다.");
        }
    }

    private static int confirmInt(Scanner scanner, String str) {
        while (true) {
            System.out.print(str);
            if (scanner.hasNextInt()) {
                int num = scanner.nextInt();
                if (num >= 0) return num;
            } else {
                scanner.next();
            }
            System.out.println("0 이상의 정수를 입력하세요!");
        }
    }

    private static OperatorType readoperator(Scanner scanner) {
        while (true) {
            System.out.print("사칙 연산 기호(+, -, x, /)를 입력하세요: ");
            String input = scanner.next();
            try {
                return OperatorType.fromSymbol(input);
            } catch (IllegalArgumentException e) {
                System.out.println("유효하지 않은 기호입니다! (+, -, x, /) 중 하나를 입력하세요!");
            }
        }
    }
}
