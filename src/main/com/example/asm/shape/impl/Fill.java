package main.com.example.asm.shape.impl;

import main.com.example.asm.object.Point;
import main.com.example.asm.shape.Shape;

import java.util.LinkedList;
import java.util.Queue;

public class Fill implements Shape {
    private Point p;
    private byte color;
    private byte oldColor;
    private static Fill instance;

    private Fill() {
    }

    public static Fill getInstance() {
        if (instance == null) {
            synchronized (Fill .class) {
                if (instance == null) {
                    instance = new Fill();
                }
            }
        }
        return instance;
    }

    public Point getP() {
        return p;
    }

    public void setP(Point p) {
        this.p = p;
    }

    public byte getColor() {
        return color;
    }

    public void setColor(byte color) {
        this.color = color;
    }

    public byte getOldColor() {
        return oldColor;
    }

    public void setOldColor(byte oldColor) {
        this.oldColor = oldColor;
    }

    public byte[][] draw(byte[][] output) {
        bucketFillQueue(output, this.p);
        return output;
    }

    private void bucketFillRecursive(byte[][] output, Point p) {
        int currentColor = output[p.getY()][p.getX()];
        if (currentColor == ' ' || (currentColor == oldColor && color != oldColor)) {
            output[p.getY()][p.getX()] = this.color;
            bucketFillRecursive(output, new Point(p.getX()+1, p.getY()));
            bucketFillRecursive(output, new Point(p.getX()-1, p.getY()));
            bucketFillRecursive(output, new Point(p.getX(), p.getY()+1));
            bucketFillRecursive(output, new Point(p.getX(), p.getY()-1));
        }
    }

    private void bucketFillQueue(byte[][] output, Point point) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(point);

        while (!queue.isEmpty()) {
            Point p = queue.remove();
            int currentColor = output[p.getY()][p.getX()];

            if (currentColor == ' ' || (currentColor == oldColor && color != oldColor)) {
                output[p.getY()][p.getX()] = this.color;
                queue.add(new Point(p.getX() + 1, p.getY()));
                queue.add(new Point(p.getX() - 1, p.getY()));
                queue.add(new Point(p.getX(), p.getY() + 1));
                queue.add(new Point(p.getX(), p.getY() - 1));
            }
        }
    }
}
