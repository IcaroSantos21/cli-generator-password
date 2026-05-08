package parser;

import picocli.CommandLine.Option;
import picocli.CommandLine.Command;


@Command(name = "generator", mixinStandardHelpOptions = true, description = "Gera senha com base nas configurações que o usuário passa")
public class ParserArguments {
    @Option(names = {"--size", "-s", "--tamanho", "-t"}, description = "Tamanho da senha", required = true)
    private int size;

    @Option(names = {"--hasSymbol", "-hS", "--temSimbolo", "-tS"}, description = "Gostaria de que tenha simbolo? (s/n) ou (y/n)", required = true)
    private boolean hasSymbol;

    @Option(names = {"--hasCapital", "-hC", "--temMaiuscula", "-tM"}, description = "Gostaria de simbolos? (s/n) ou (y/n)", required = true)
    private boolean hasCapital;

    @Option(names = {"--hasNumber", "-hN", "--temNumero", "-tN"}, description = "Gostaria de numeros na senha? (s/n) ou (y/n)", required = true)
    private boolean hasNumber;

   public ParserArguments() {}

    public int getSize() {
        return size;
    }

    public boolean isHasSymbol() {
        return hasSymbol;
    }

    public boolean isHasCapital() {
        return hasCapital;
    }

    public boolean isHasNumber() {
        return hasNumber;
    }
}
