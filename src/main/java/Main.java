import generator.GeneratorPassword;
import parser.ParserArguments;
import parser.PasswordConfig;
import picocli.CommandLine;

public class Main {

    public static void main(String[] args) {

        ParserArguments arguments = new ParserArguments();

        try {
            CommandLine.populateCommand(arguments, args);
            PasswordConfig passwordConfig = new PasswordConfig(
                    arguments.getSize(),
                    arguments.isHasSymbol(),
                    arguments.isHasCapital(),
                    arguments.isHasNumber()
            );

            GeneratorPassword generatorPassword = new GeneratorPassword(passwordConfig);
            String password = generatorPassword.generatePassword();
            System.out.println("Senha Gerada: \033[1;32m" + password + "\033[0m");

        } catch (CommandLine.ParameterException ex) {
            System.err.println(ex.getMessage());
            ex.getCommandLine().usage(System.err);
        }
    }

}
