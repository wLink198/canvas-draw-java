package main.com.example.asm.shape.impl;

import main.com.example.asm.object.Point;
import main.com.example.asm.shape.Shape;

public class Line implements Shape {
    private Point startPoint;
    private Point endPoint;

    public Line() {
    }

    public Line(Point startPoint, Point endPoint) {
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
        return drawLine(startPoint.getX(), startPoint.getY(), endPoint.getX(), endPoint.getY(), output);
    }

    private byte[][] drawLine(int x0, int y0, int x1, int y1, byte[][] output) {
        if (x0 == x1) {
            if (y0 > y1) {
                int tmp = y0;
                y0 = y1;
                y1 = tmp;
            }
            for (int i=y0; i<=y1; i++) {
                output[i][x0] = 'x';
            }
        } else if (y0 == y1) {
            if (x0 > x1) {
                int tmp = x0;
                x0 = x1;
                x1 = tmp;
            }
            for (int i=x0; i<=x1; i++) {
                output[y0][i] = 'x';
            }
        }
        return output;
    }
}
