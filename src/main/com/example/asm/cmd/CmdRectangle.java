package main.com.example.asm.cmd;

import main.com.example.asm.object.Point;
import main.com.example.asm.shape.Shape;
import main.com.example.asm.shape.impl.Line;
import main.com.example.asm.shape.impl.Rectangle;

public class CmdRectangle extends Command {

    @Override
    public void execute(String[] parameters) {
        try {
            Point p1 = new Point(Integer.parseInt(parameters[0]), Integer.parseInt(parameters[1]));
            Point p2 = new Point(Integer.parseInt(parameters[2]), Integer.parseInt(parameters[3]));
            Shape rectangle = new Rectangle(p1, p2);
            canvas.addShape(rectangle);
            canvas.printCanvas();
        } catch (Exception e) {
            System.out.println(super.getErrMessage());
        }
    }
}
