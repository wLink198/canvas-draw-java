package main.com.example.asm.validator;

import java.util.Objects;

public class InputValidator {
    private static final String validCmd = "CLRBQ";

    public static boolean validParams(String[] parameters, Character cmd) {
        if (validCmd.indexOf(cmd) < 0) {
            System.out.println("Unsupported command");
            return false;
        }
        if (Objects.isNull(parameters)) {
            System.out.println("Parameters are missing");
            return false;
        }
        for (String param : parameters) {
            if (!isPositiveInteger(param) && !isColor(parameters, cmd, param)) {
                System.out.println("Parameter (" + param + ") is not a positive integer");
                return false;
            }
        }
        return true;
    }

    private static boolean isColor(String[] parameters, Character cmd, String param) {
        return cmd=='B' &&parameters.length==3 && param.equals(parameters[2]);
    }

    public static boolean isPositiveInteger(String s) {
        try {
            return Integer.parseInt(s) > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
