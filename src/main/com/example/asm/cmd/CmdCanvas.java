package main.com.example.asm.cmd;

import main.com.example.asm.object.Canvas;

public class CmdCanvas extends Command {
    @Override
    public void execute(String[] parameters) {
        super.canvas = new Canvas(Integer.parseInt(parameters[0]), Integer.parseInt(parameters[1]));
        canvas.printCanvas();
    }
}
