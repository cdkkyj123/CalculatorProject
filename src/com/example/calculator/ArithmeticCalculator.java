package com.example.calculator;

import java.util.ArrayList;

public class ArithmeticCalculator {

    private double currentResult = 0; // 누적 결과
    private boolean hasResult = false; // App에 있던 '첫 계산인지 확인'을 Calculator에서 하기
    private ArrayList<Double> results = new ArrayList<>();

    // OperatorType에게 계산 맡기기
    public double calculate(OperatorType operator, int a, int b) {
        double result = operator.apply(a, b); // 나눗셈의 결과가 '실수'일 수 있기에 double로 표현
        save(result);
        return result; // 결과 값 반환
    }
    public double calculate(OperatorType operator, int b) {
        if (!hasResult) {
            throw new IllegalArgumentException("첫 계산이 아직 없습니다.");
        }
        double result = operator.apply(currentResult, b);
        save(result);
        return result;

        }

        private void save(double result) {
            currentResult = result;
            hasResult = true;
            results.add(result);
        }

        public boolean hasResult() {
        return hasResult;
        }

    // Getter 결과 조회
    public ArrayList<Double> getResults() {
        return results;
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
