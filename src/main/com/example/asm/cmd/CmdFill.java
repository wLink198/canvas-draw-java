package main.com.example.asm.cmd;

import main.com.example.asm.object.Point;
import main.com.example.asm.shape.impl.Fill;

public class CmdFill extends Command {

    @Override
    public void execute(String[] parameters) {
        Point p = new Point(Integer.parseInt(parameters[0]), Integer.parseInt(parameters[1]));
        Fill fill = Fill.getInstance();
        fill.setP(p);
        fill.setColor((byte)parameters[2].charAt(0));
        canvas.addShape(fill);
        canvas.printCanvas();
        fill.setOldColor((byte)parameters[2].charAt(0));
    }
}
