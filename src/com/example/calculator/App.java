package com.example.calculator;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int result = 0;

        int i1;
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

        while (true) {
            if (str.equals("+")) {
                int sum = i1 + i2;
                System.out.println("값은: " + sum + "입니다.");
            } else {
                if (str.equals("-")) {
                    int sub = i1 - i2;
                    System.out.println("값은: " + sub + "입니다.");
                } else {
                    if (str.equals("x")) {
                        int mul = i1 * i2;
                        System.out.println("값은: " + mul + "입니다.");
                    } else {
                        if (str.equals("/")) {
                            double div = (double) i1 / i2;
                            System.out.println("값은: " + div + "입니다.");
                        }
                    }
                }
            } break;
        }


    }
}
