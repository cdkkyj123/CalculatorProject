package com.example.calculator;

public enum OperatorType {

    // 사칙 연산 계산 식 작성
    SUM("+") {
        @Override
        public double apply(double a, double b) {
            return a + b;
        }
    },
    SUB("-") {
        @Override
        public double apply(double a, double b) {
            return a - b;
        }
    },
    MUL("x") {
        @Override
        public double apply(double a, double b) {
            return a * b;
        }
    },
    DIV("/") {
        @Override
        public double apply(double a, double b) {
            if (b == 0) {
                throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
            }
            return a / b;
        }
    };

    private final String symbol; // 외부에서 변경할 수 없게 보호

    OperatorType(String symbol) { // 다른 클래스 들에서 사용 가능(불려다님)
        this.symbol = symbol;
    }

    public abstract double apply(double a, double b); // 꼭 받아야 할 메서드

    public static OperatorType fromSymbol(String symbol) { // 이외의 기호가 들어오면 안됨.
        for (OperatorType type : OperatorType.values()) {
            if (type.symbol.equals(symbol)) {
                return type;
            }
        }
        throw new IllegalArgumentException("잘못된 연산자입니다: " + symbol);
    }

    // 게터
    public String getSymbol() {
        return symbol;
    }
}
