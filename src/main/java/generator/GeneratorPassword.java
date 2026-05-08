package generator;

import parser.PasswordConfig;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;

public class GeneratorPassword {

    // declarando os caracaters para cada config
    private String symbols = "!@#$&*";
    private String alphabete = "abcdefghijklmnopqrstuvwxyz";
    private String numbers = "0123456789";
    private PasswordConfig passwordConfig;

    // Instanciando o SecureRandom
    SecureRandom secureRandom = new SecureRandom();


    public GeneratorPassword(PasswordConfig passwordConfig) {
        this.passwordConfig = passwordConfig;
    }

    // Metodo para gerar a senha
    public String generatePassword(){
        ArrayList<Character> characters = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder(characters.size());
        String pool = alphabete;

        if (passwordConfig.isHasCapital()){
            pool += alphabete.toUpperCase();
            int index = secureRandom.nextInt(alphabete.length());
            char character = alphabete.toUpperCase().charAt(index);
            characters.add(character);
        } if(passwordConfig.isHasSymbol()){
            pool += symbols;
            int index = secureRandom.nextInt(symbols.length());
            char character = symbols.charAt(index);
            characters.add(character);
        } if (passwordConfig.isHasNumber()) {
            pool += numbers;
            int index = secureRandom.nextInt(numbers.length());
            char character = numbers.charAt(index);
            characters.add(character);
        }
        int index = secureRandom.nextInt(alphabete.length());
        char character = alphabete.charAt(index);
        characters.add(character);

        int quantity = passwordConfig.getSize() - characters.size();
        for (int i = 0; i < quantity; i++){
            int indexPool = secureRandom.nextInt(pool.length());
            char characterPool = pool.charAt(indexPool);
            characters.add(characterPool);
        }

        Collections.shuffle(characters, secureRandom);

        for (Character ch:  characters){
            stringBuilder.append(ch);
        }

        return stringBuilder.toString();

    }
}
