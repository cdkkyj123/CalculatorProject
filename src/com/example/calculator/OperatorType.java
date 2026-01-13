package com.example.calculator;

public enum OperatorType {

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

    private final String symbol;

    OperatorType(String symbol) {
        this.symbol = symbol;
    }

    public abstract double apply(double a, double b);

    public static OperatorType fromSymbol(String symbol) {
        for (OperatorType type : OperatorType.values()) {
            if (type.symbol.equals(symbol)) {
                return type;
            }
        }
        throw new IllegalArgumentException("잘못된 연산자입니다: " + symbol);
    }

    public String getSymbol() {
        return symbol;
    }
}
