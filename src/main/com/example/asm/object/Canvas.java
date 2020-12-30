package main.com.example.asm.object;

import main.com.example.asm.shape.Shape;

import java.util.ArrayList;
import java.util.List;

public class Canvas {
    private int height;
    private int width;
    private List<Shape> shapes;
    private byte[][] canvasByteArray;

    public Canvas(int width, int height) {
        this.height = height + 2;
        this.width = width + 2;
        this.shapes = new ArrayList<>();
        this.canvasByteArray = new byte[this.height][this.width];
    }

    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    public void printCanvas() {
        // create canvas
        for (int row = 0; row < canvasByteArray.length; row++) {
            for (int col = 0; col < canvasByteArray[row].length; col++) {
                if (row == 0 || row == canvasByteArray.length - 1) {
                    canvasByteArray[row][col] = '-';
                } else if (col == 0 || col == canvasByteArray[row].length - 1) {
                    canvasByteArray[row][col] = '|';
                } else {
                    canvasByteArray[row][col] = ' ';
                }
            }
        }

        // append shapes
        for (Shape shape : shapes) {
            canvasByteArray = shape.draw(canvasByteArray);
        }

        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
                System.out.print((char) canvasByteArray[i][j]);
            }
            System.out.println();
        }
    }
}
