/*
 * Aula 02 - Operadores Relacionais
 * 
 * COMPARAÇÃO COM PYTHON:
 * Os operadores são praticamente iguais, mas com uma exceção importante:
 * 
 * Python:
 *   ==, !=, <, >, <=, >=
 *   Para comparar objetos: is, is not
 * 
 * Java:
 *   ==, !=, <, >, <=, >=
 *   Para comparar Strings: .equals(), não ==
 */

public class Exemplo03_OperadoresRelacionais {
    public static void main(String[] args) {
        System.out.println("=== OPERADORES RELACIONAIS ===\n");
        
        int a = 10;
        int b = 20;
        int c = 10;
        
        System.out.println("Valores: a = " + a + ", b = " + b + ", c = " + c);
        System.out.println();
        
        // IGUALDADE (==)
        System.out.println("a == b: " + (a == b));  // false
        System.out.println("a == c: " + (a == c));  // true
        
        // DIFERENÇA (!=)
        System.out.println("a != b: " + (a != b));  // true
        System.out.println("a != c: " + (a != c));  // false
        
        // MAIOR QUE (>)
        System.out.println("a > b: " + (a > b));   // false
        System.out.println("b > a: " + (b > a));   // true
        
        // MENOR QUE (<)
        System.out.println("a < b: " + (a < b));   // true
        System.out.println("b < a: " + (b < a));   // false
        
        // MAIOR OU IGUAL (>=)
        System.out.println("a >= c: " + (a >= c)); // true (são iguais)
        System.out.println("a >= b: " + (a >= b)); // false
        
        // MENOR OU IGUAL (<=)
        System.out.println("a <= c: " + (a <= c)); // true (são iguais)
        System.out.println("b <= a: " + (b <= a)); // false
        
        System.out.println("\n=== COMPARAÇÕES COM DOUBLES ===\n");
        
        double x = 3.5;
        double y = 7.2;
        
        System.out.println("x = " + x + ", y = " + y);
        System.out.println("x < y: " + (x < y));
        System.out.println("x == y: " + (x == y));
        
        // CUIDADO com comparações de ponto flutuante!
        double resultado = 0.1 + 0.2;
        System.out.println("\nCUIDADO! 0.1 + 0.2 = " + resultado);
        System.out.println("0.1 + 0.2 == 0.3: " + (resultado == 0.3));  // false! Imprecisão
        
        // Solução: usar uma margem de erro (epsilon)
        double epsilon = 0.0001;
        boolean saoIguais = Math.abs(resultado - 0.3) < epsilon;
        System.out.println("Usando epsilon: " + saoIguais);  // true
        
        System.out.println("\n=== COMPARAÇÕES COM CHAR ===\n");
        
        // Chars são comparados por seus valores ASCII/Unicode
        char letra1 = 'A';
        char letra2 = 'B';
        char letra3 = 'a';
        
        System.out.println("'A' < 'B': " + (letra1 < letra2));  // true
        System.out.println("'A' == 'a': " + (letra1 == letra3)); // false (maiúscula ≠ minúscula)
        System.out.println("'A' < 'a': " + (letra1 < letra3));  // true (maiúsculas vêm antes)
        
        System.out.println("\n=== IMPORTANTE: STRINGS ===\n");
        
        String str1 = "Java";
        String str2 = "Java";
        String str3 = new String("Java");
        
        // NUNCA use == para comparar Strings!
        System.out.println("str1 == str2: " + (str1 == str2));  // true (por acaso)
        System.out.println("str1 == str3: " + (str1 == str3));  // false! Objetos diferentes
        
        // USE .equals() para comparar Strings
        System.out.println("str1.equals(str2): " + str1.equals(str2));  // true
        System.out.println("str1.equals(str3): " + str1.equals(str3));  // true
        
        // Comparação case-insensitive
        String str4 = "JAVA";
        System.out.println("str1.equalsIgnoreCase(str4): " + str1.equalsIgnoreCase(str4));  // true
        
        System.out.println("\n=== RESULTADO DE COMPARAÇÕES ===\n");
        
        // Comparações retornam boolean, que pode ser armazenado
        boolean maiorDeIdade = 18 >= 18;
        boolean passou = 7.5 >= 7.0;
        boolean estaAberto = 10 < 22;
        
        System.out.println("É maior de idade: " + maiorDeIdade);
        System.out.println("Passou na prova: " + passou);
        System.out.println("Está aberto: " + estaAberto);
        
        System.out.println("\n=== COMPARAÇÕES ENCADEADAS ===\n");
        
        // Python permite: 10 < x < 20
        // Java NÃO permite isso! Precisa usar operadores lógicos (próximo exemplo)
        
        int numero = 15;
        
        // ERRADO em Java (não compila):
        // boolean dentroFaixa = 10 < numero < 20;
        
        // CORRETO em Java:
        boolean dentroFaixa = (numero > 10) && (numero < 20);
        System.out.println("15 está entre 10 e 20: " + dentroFaixa);
    }
}
