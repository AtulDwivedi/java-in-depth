package com.atuldwivedi.jid.design.principle.lsp.bad;

public class Test {

    private static Rectangle getRectangle() {
        return new Square();
    }

    public static void main(String[] args) {
        Rectangle rectangle = getRectangle();
        rectangle.setHeight(10);
        rectangle.setWidth(5);
        int area = rectangle.getArea();
        System.out.println(area);
    }
}
