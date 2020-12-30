package main.com.example.asm.cmd;

import main.com.example.asm.object.Point;
import main.com.example.asm.shape.Shape;
import main.com.example.asm.shape.impl.Line;

public class CmdLine extends Command {

    @Override
    public void execute(String[] parameters) {
        try {
            int x0 = Integer.parseInt(parameters[0]);
            int y0 = Integer.parseInt(parameters[1]);
            int x1 = Integer.parseInt(parameters[2]);
            int y1 = Integer.parseInt(parameters[3]);
            if (x0 != x1 && y0 != y1) {
                System.out.println("Only horizontal or vertical lines are supported");
            } else {
                Point p1 = new Point(x0, y0);
                Point p2 = new Point(x1, y1);
                Shape line = new Line(p1, p2);
                canvas.addShape(line);
                canvas.printCanvas();
            }
        } catch (Exception e) {
            System.out.println(super.getErrMessage());
        }
    }
}
