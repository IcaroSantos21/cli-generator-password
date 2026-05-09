# cli-password-generator

Gerador de senhas seguras via linha de comando, desenvolvido em Java utilizando `SecureRandom` para geração criptograficamente segura.

## Tecnologias

- Java 17
- Maven
- Picocli
- JUnit 5
## Estrutura do projeto

```
src/
  main/java/
    generator/        # Lógica de geração da senha
    parser/           # Leitura e validação dos argumentos
    Main.java
  test/java/
    GeneratorPasswordTest.java
```

## Pré-requisitos

- Java 17+
- Maven 3.8+
## Como rodar

Clone o repositório:

```bash
git clone https://github.com/IcaroSantos21/cli-generator-password.git
cd cli-generator-password
```

Compile o projeto:

```bash
mvn compile
```

Execute:

```bash
mvn exec:java -Dexec.mainClass="Main" -Dexec.args="--size 16 --hasCapital --hasNumber --hasSymbol"
```

Ou gere o JAR executável:

```bash
mvn package
java -jar target/cli-password-generator.jar --size 16 --hasCapital --hasNumber --hasSymbol
```

## Flags disponíveis

| Flag | Alternativa | Descrição |
|------|-------------|-----------|
| `--size` | `-s`, `--tamanho`, `-t` | Tamanho da senha (obrigatório) |
| `--hasCapital` | `-hC`, `--temMaiuscula`, `-tM` | Incluir letras maiúsculas |
| `--hasNumber` | `-hN`, `--temNumero`, `-tN` | Incluir números |
| `--hasSymbol` | `-hS`, `--temSimbolo`, `-tS` | Incluir símbolos (`!@#$&*`) |
| `--help` | `-h` | Exibe ajuda |

## Exemplos de uso

Senha com 20 caracteres, apenas letras minúsculas:
```bash
... --size 20
```

Senha com 16 caracteres com todos os tipos:
```bash
... --size 16 --hasCapital --hasNumber --hasSymbol
```

Senha com 32 caracteres com números e maiúsculas:
```bash
... --size 32 --hasCapital --hasNumber
```

## Rodando os testes

```bash
mvn test
```

## Como a geração funciona

1. Monta um pool de caracteres com base nas opções do usuário
2. Garante pelo menos um caractere de cada tipo solicitado
3. Preenche o restante sorteando aleatoriamente do pool via `SecureRandom`
4. Embaralha a senha com `Collections.shuffle()` para eliminar padrões previsíveis
