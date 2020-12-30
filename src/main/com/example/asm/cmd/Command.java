package main.com.example.asm.cmd;

import main.com.example.asm.object.Canvas;

public abstract class Command {
    protected Canvas canvas;

    public Canvas getCanvas() {
        return canvas;
    }

    public void setCanvas(Canvas canvas) {
        this.canvas = canvas;
    }

    public abstract void execute(String[] parameters);

    public String getErrMessage() {
        return "Cannot execute command due to some err or invalid params";
    }
}
