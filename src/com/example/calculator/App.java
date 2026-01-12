package com.example.calculator;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double result = 0;
        boolean hasResult = false;

        while (true) {
            double i1;
            if (!hasResult) {
                while (true) {
                    System.out.print("첫 번째 숫자를 입력하세요: ");

                    if (scanner.hasNextInt()) {
                        i1 = scanner.nextInt();
                        if (i1 >= 0) {
                            break;
                        } else {
                            System.out.println("0 이상의 정수를 입력하세요!");
                        }
                    } else {
                        System.out.println("0 이상의 정수를 입력하세요!");
                        scanner.next();
                    }
                }
            } else {
                i1 = result;
                System.out.println("현재값: " + i1);
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

            int i2;
            while (true) {
                System.out.print("두 번째 숫자를 입력하세요: ");
                if (scanner.hasNextInt()) {
                    i2 = scanner.nextInt();
                    if (i2 >= 0) {
                        break;
                    } else {
                        System.out.println("0 이상의 정수를 입력하세요!");
                    }
                } else {
                    System.out.println("0 이상의 정수를 입력하세요!");
                    scanner.next();
                }
            }

            if (str.equals("+")) result = i1 + i2;
            else if (str.equals("-")) result = i1 - i2;
            else if (str.equals("x")) result = i1 * i2;
            else {
                if (i2 == 0) {
                    System.out.println("0으로 나눌 수 없습니다.");
                    continue;
                }
                result = i1 / i2;
            }

            hasResult = true;
            System.out.println("값은 " + result + "입니다.");
            System.out.println("더 계산하시겠습니까? 아무 키 + Enter 입력 시 계속 됩니다. (exit 입력 시 종료)");
            String quit = scanner.next();
            if (quit.equals("exit")) {
                System.out.println("계산기를 종료합니다.");
                break;
            } else {
                continue;
            }
        }
    }
}
