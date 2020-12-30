package main.com.example.asm;

import main.com.example.asm.cmd.Command;
import main.com.example.asm.factory.CommandFactory;
import main.com.example.asm.object.Canvas;
import main.com.example.asm.validator.InputValidator;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Canvas canvas = null;
        Scanner console = new Scanner(System.in);

        while (true) {
            System.out.println("Please enter commands: ");
            String input = console.nextLine().trim();
            if (!StringUtils.isEmpty(input)) {
                String[] cmdArr = input.split(" ");
                char cmd = cmdArr[0].toUpperCase().charAt(0);
                String[] parameters = Arrays.copyOfRange(cmdArr, 1, cmdArr.length);

                if (cmd == 'Q') System.exit(0);

                if (InputValidator.validParams(parameters, cmd)) {
                    if (cmd != 'C' && Objects.isNull(canvas)) {
                        System.out.println("U need to draw a canvas first");
                        continue;
                    }

                    CommandFactory commandFactory = new CommandFactory();
                    Command command = commandFactory.getCommand(cmd);
                    command.setCanvas(canvas);
                    command.execute(parameters);
                    canvas = command.getCanvas();
                }
            }
        }
    }
}
