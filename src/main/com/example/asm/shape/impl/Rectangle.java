package main.com.example.asm.shape.impl;

import main.com.example.asm.object.Point;
import main.com.example.asm.shape.Shape;

public class Rectangle implements Shape {
    private Point startPoint;
    private Point endPoint;

    public Rectangle() {
    }

    public Rectangle(Point startPoint, Point endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    public Point getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(Point startPoint) {
        this.startPoint = startPoint;
    }

    public Point getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(Point endPoint) {
        this.endPoint = endPoint;
    }

    @Override
    public byte[][] draw(byte[][] output) {
        return drawRectangle(startPoint.getX(), startPoint.getY(), endPoint.getX(), endPoint.getY(), output);
    }

    private byte[][] drawRectangle(int x0, int y0, int x1, int y1, byte[][] output) {
        if (x0 > x1) {
            int tmp = x0;
            x0 = x1;
            x1 = tmp;
        }
        if (y0 > y1) {
            int tmp = y0;
            y0 = y1;
            y1 = tmp;
        }
        for (int i=y0; i<=y1; i++) {
            for (int j=x0; j<=x1; j++) {
                if (i==y0 || j==x0 || i==y1 || j==x1) {
                    output[i][j] = 'x';
                }
            }
        }
        return output;
    }
}
