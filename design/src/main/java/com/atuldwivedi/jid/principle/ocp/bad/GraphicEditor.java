package com.atuldwivedi.jid.principle.ocp.bad;

public class GraphicEditor {

    public void drawShape(Shape shape) {
        if (shape.getType().equals("Rectangle")) {
            drawRectangle();
        } else if (shape.getType().equals("Circle")) {
            drawCircle();
        }
    }

    private void drawCircle() {
        System.out.println("Drawing Circle");
    }

    private void drawRectangle() {
        System.out.println("Drawing Rectangle");
    }
}
