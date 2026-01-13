package com.example.calculator;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ArithmeticCalculator calculator = new ArithmeticCalculator(); // Calculator 인스턴스 생성

        Scanner scanner = new Scanner(System.in);

        boolean isFirstCalculation = true; // 첫 계산인지 확인

        while (true) {

            int num1 = 0; // num1 초기화

            if (isFirstCalculation) {
                while (true) {
                    System.out.print("첫 번째 숫자를 입력하세요: ");
                    if (scanner.hasNextInt()) {
                        num1 = scanner.nextInt();
                        if (num1 >= 0) {
                            break;
                        } else {
                            System.out.println("0 이상의 정수를 입력하세요!");
                        }
                    } else {
                        System.out.println("0 이상의 정수를 입력하세요!");
                        scanner.next();
                    }
                }
            }

            String str;
            while (true) {
                System.out.print("사칙 연산 기호(+, -, x, /)를 입력하세요: ");
                str = scanner.next();

                if (str.equals("+") || str.equals("-") || str.equals("x") || str.equals("/")) {
                    break;
                } else {
                    System.out.println("유효하지 않은 기호입니다! (+, -, x, /) 중 하나를 입력하세요!");
                }
            }

            int num2;
            while (true) {
                System.out.print("두 번째 숫자를 입력하세요: ");

                if (scanner.hasNextInt()) {
                    num2 = scanner.nextInt();
                    if (num2 >= 0) {
                        break;
                    } else {
                        System.out.println("0 이상의 정수를 입력하세요!");
                    }
                } else {
                    System.out.println("0 이상의 정수를 입력하세요!");
                    scanner.next();
                }
            }

            double result; // 계산은 Calculator가 수행

            if (isFirstCalculation) { // 첫 계산이면 num1 사용, 아니면 누적 계산
                result = calculator.calculate(OperatorType.fromSymbol(str), num1, num2);
                isFirstCalculation = false; // 이후부터는 누적 계산
            } else {
                result = calculator.calculate(OperatorType.fromSymbol(str), num2);
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
}
