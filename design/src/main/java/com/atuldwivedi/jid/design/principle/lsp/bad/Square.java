package com.atuldwivedi.jid.design.principle.lsp.bad;

public class Square extends Rectangle {

    private int width;

    private int height;

    @Override
    public void setWidth(int width) {
        this.width = width;
        this.height = width;
    }

    @Override
    public void setHeight(int height) {
        this.height = height;
        this.width = height;
    }

    @Override
    public int getArea() {
        return width * height;
    }
}
