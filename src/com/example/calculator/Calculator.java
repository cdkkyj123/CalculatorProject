package com.example.calculator;

import java.util.ArrayList;

public class Calculator {

    private double currentResult = 0; // 누적 결과
    private boolean hasResult = false; // App에 있던 '첫 계산인지 확인'을 Calculator에서 하기
    private ArrayList<Double> results = new ArrayList<>();

    public double calculate(String operator, int a, int b) {
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
                if (b == 0) { // 분모가 0이라면 예외 처리
                    throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
                }
                result = (double) a / b; // double 선언해주기
                break;
            default: // 위 4개의 기호가 아니라면 예외 처리
                throw new IllegalArgumentException("잘못된 기호입니다.");
        }

        currentResult = result; // 최근의 결과값으로 result를 갱신
        hasResult = true; // 이미 계산이 수행된 내용임을 표시
        results.add(result); // 해당 결과를 results 컬렉션에 저장

        return result; // 결과 값 반환
    }
    public double calculate(String operator, int b) {
        double result;

        double a;
        if (hasResult) {
            a = currentResult; // 저장된 결과값 사용
        } else {
            a = 0;
        }

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
                if (b == 0) {
                    throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
                }
                result = a / b;
                break;
            default:
                throw new IllegalArgumentException("잘못된 기호입니다.");
        }

        currentResult = result;
        hasResult = true;
        results.add(result);

        return result;

        }

    // Getter 결과 조회
    public ArrayList<Double> getResults() {
        return new ArrayList<>(results);
    }

    // Setter
    public void setResults(ArrayList<Double> results) {
        this.results = results;
    }

    // 가장 먼저 저장된 데이터를 삭제하는 기능
    public Double removeResult() {
        // 결과 상자가 비어있는 예외 처리
        if (results.isEmpty()) {
            throw new IllegalArgumentException("결과가 비어있습니다.");
        }
        return results.remove(0);
    }
}
