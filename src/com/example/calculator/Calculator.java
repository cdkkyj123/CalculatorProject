package com.example.calculator;

import java.util.ArrayList;

public class Calculator {
    private ArrayList<Double> results = new ArrayList<>();

    public double calculate(int a, String operator, int b) {
        double result; // 나눗셈의 결과가 '실수'일 수 있기에 double로 표현

        // 조건이 아닌 선택이기에 switch 사용
        switch (operator) {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "x":
                result = a * b;
                break;
            case "/":
                if (b == 0) { // 분모가 0이라면 경고
                    throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
                }
                result = a / b;
                break;
            default: // 위 4개의 기호가 아니라면 경고
                throw new IllegalArgumentException("유효하지 않은 기호입니다! (+, -, x, /) 중 하나를 입력하세요!");
        }

        results.add(result); // 해당 결과를 results 컬렉션에 저장

        return result; // 결과 값 반환
    }
}
