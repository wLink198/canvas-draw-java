package main.com.example.asm.factory;

import main.com.example.asm.cmd.*;

import java.util.Objects;

public class CommandFactory {
    private static final char CANVAS = 'C';
    private static final char LINE = 'L';
    private static final char RECTANGLE = 'R';
    private static final char BUCKET_FILL = 'B';

    public Command getCommand(Character cmd) {
        if(Objects.isNull(cmd)){
            return null;
        }
        if (cmd.equals(CANVAS)){
            return new CmdCanvas();
        }
        if (cmd.equals(LINE)){
            return new CmdLine();
        }
        if (cmd.equals(RECTANGLE)){
            return new CmdRectangle();
        }
        if (cmd.equals(BUCKET_FILL)){
            return new CmdFill();
        }

        return null;
    }
}
