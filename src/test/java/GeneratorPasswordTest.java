import generator.GeneratorPassword;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import parser.PasswordConfig;

public class GeneratorPasswordTest {

    private PasswordConfig passwordConfigAllTrue;
    private PasswordConfig passwordConfigNotNumbers;
    private PasswordConfig passwordConfigNotCapital;
    private PasswordConfig passwordConfigNotSymbols;
    private GeneratorPassword generatorPasswordAllTrue;
    private GeneratorPassword generatorPasswordNotNumbers;
    private GeneratorPassword generatorPasswordNotCapital;
    private GeneratorPassword generatorPasswordNotSymbols;

    @BeforeEach
    public void setUp() {
        passwordConfigAllTrue = new PasswordConfig(19,true, true, true);
        passwordConfigNotNumbers = new PasswordConfig(19,true, true, false);
        passwordConfigNotSymbols = new PasswordConfig(19,false, true, true);
        passwordConfigNotCapital = new PasswordConfig(19,true, false, true);

        generatorPasswordAllTrue = new GeneratorPassword(passwordConfigAllTrue);
        generatorPasswordNotNumbers = new GeneratorPassword(passwordConfigNotNumbers);
        generatorPasswordNotCapital = new GeneratorPassword(passwordConfigNotCapital);
        generatorPasswordNotSymbols = new GeneratorPassword(passwordConfigNotSymbols);
    }


    @Test
    public void shouldGeneratePasswordWithCorrectLength() {
        String password = generatorPasswordAllTrue.generatePassword();
        System.out.println("Senha: \033[1;32m" + password + "\033[0m");
        Assertions.assertEquals(19, password.length());
    }

    @Test
    public void mustGeneratePasswordWithUppercaseLetters() {
        String password = generatorPasswordAllTrue.generatePassword();
        boolean isUppercase = false;
        System.out.println("\nSenha: \033[1;32m" + password + "\033[0m");
        for (int i = 0; i < password.length(); i++) {
            String letter = String.valueOf(password.charAt(i));
            if (letter.matches("[A-Z]")) {
                isUppercase = true;
            }
        }
        Assertions.assertTrue(isUppercase);;
    }
    
    @Test
    public void mustGeneratePasswordWithSymbols() {
        String password = generatorPasswordAllTrue.generatePassword();
        boolean isSymbol = false;
        System.out.println("\nSenha: \033[1;32m" + password + "\033[0m");
        for (int i = 0; i < password.length(); i++) {
            String letter = String.valueOf(password.charAt(i));
            if (letter.matches("[^a-zA-Z0-9]")) {
                isSymbol = true;
            }
        }
        Assertions.assertTrue(isSymbol);
    }

    @Test
    public void mustGeneratePasswordNotWithSymbols() {
        String password = generatorPasswordNotSymbols.generatePassword();
        boolean isNotSymbol = true;
        System.out.println("\nSenha: \033[1;32m" + password + "\033[0m");
        for (int i = 0; i < password.length(); i++) {
            String letter = String.valueOf(password.charAt(i));
            if (letter.matches("[^a-zA-Z0-9]")) {
                isNotSymbol = false;
            }
        }
        Assertions.assertTrue(isNotSymbol);;
    }

    @Test
    public void mustGeneratePasswordNotWithUppercaseLetters() {
        String password = generatorPasswordNotCapital.generatePassword();
        boolean isNotUppercase = false;
        System.out.println("\nSenha: \033[1;32m" + password + "\033[0m");
        for (int i = 0; i < password.length(); i++) {
            String letter = String.valueOf(password.charAt(i));
            if (letter.matches("[^A-Z]")) {
                isNotUppercase = true;
            }
        }
        Assertions.assertTrue(isNotUppercase);;
    }

    @Test
    public void mustGeneratePasswordWithNumbers(){
        String password = generatorPasswordAllTrue.generatePassword();
        boolean isNumber = false;
        System.out.println("\nSenha: \033[1;32m" + password + "\033[0m");
        for (int i = 0; password.length() > i; i++) {
            String letter = String.valueOf(password.charAt(i));
            if (letter.matches("[0-9]")) {
                isNumber = true;
            }
        }
        Assertions.assertTrue(isNumber);
    }

    @Test
    public void mustGeneratePasswordNotWithNumbers(){
        String password = generatorPasswordNotNumbers.generatePassword();
        boolean isNotNumber = false;

        System.out.println("\nSenha: \033[1;32m" + password + "\033[0m");
        for (int i = 0; i < password.length(); i++) {
            String letter = String.valueOf(password.charAt(i));
            if (letter.matches("[^0-9]")) {
                isNotNumber = true;
            }
        }
        Assertions.assertTrue(isNotNumber);
    }

}
