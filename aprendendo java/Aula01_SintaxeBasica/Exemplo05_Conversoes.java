/*
 * EXEMPLO 05 - CONVERSÕES DE TIPOS (CASTING)
 * 
 * Python faz muitas conversões automáticas
 * Java é mais rigoroso e exige conversões explícitas
 */

public class Exemplo05_Conversoes {
    
    public static void main(String[] args) {
        
        System.out.println("=== CONVERSÃO IMPLÍCITA (WIDENING) ===\n");
        
        // Conversão automática de menor para maior
        // byte -> short -> int -> long -> float -> double
        
        int numeroInt = 100;
        long numeroLong = numeroInt; // Conversão automática
        float numeroFloat = numeroInt; // Conversão automática
        double numeroDouble = numeroInt; // Conversão automática
        
        System.out.println("int: " + numeroInt);
        System.out.println("long: " + numeroLong);
        System.out.println("float: " + numeroFloat);
        System.out.println("double: " + numeroDouble);
        
        System.out.println("\n=== CONVERSÃO EXPLÍCITA (NARROWING) ===\n");
        
        // Conversão de maior para menor precisa de cast
        double valorDouble = 9.99;
        int valorInt = (int) valorDouble; // Perde a parte decimal!
        
        System.out.println("double: " + valorDouble);
        System.out.println("int (cast): " + valorInt);
        
        // Cuidado com overflow!
        long valorGrande = 9_000_000_000L;
        int valorPequeno = (int) valorGrande; // Pode dar problema!
        
        System.out.println("long: " + valorGrande);
        System.out.println("int (cast): " + valorPequeno + " <- OVERFLOW!");
        
        System.out.println("\n=== CONVERSÃO ENTRE TIPOS ===\n");
        
        // int para char
        int codigo = 65;
        char letra = (char) codigo;
        System.out.println("int 65 -> char: " + letra); // 'A'
        
        // char para int
        char letraA = 'A';
        int codigoA = letraA;
        System.out.println("char 'A' -> int: " + codigoA); // 65
        
        System.out.println("\n=== CONVERSÃO DE/PARA STRING ===\n");
        
        // String para primitivos
        String textoNumero = "123";
        String textoDecimal = "45.67";
        String textoBoolean = "true";
        
        int numero = Integer.parseInt(textoNumero);
        double decimal = Double.parseDouble(textoDecimal);
        boolean bool = Boolean.parseBoolean(textoBoolean);
        
        System.out.println("String '123' -> int: " + numero);
        System.out.println("String '45.67' -> double: " + decimal);
        System.out.println("String 'true' -> boolean: " + bool);
        
        // Primitivos para String
        int valor = 100;
        String texto1 = String.valueOf(valor);
        String texto2 = Integer.toString(valor);
        String texto3 = "" + valor; // Concatenação (mais simples)
        
        System.out.println("\nint 100 -> String:");
        System.out.println("  String.valueOf(): " + texto1);
        System.out.println("  Integer.toString(): " + texto2);
        System.out.println("  Concatenação: " + texto3);
        
        System.out.println("\n=== OPERAÇÕES MISTAS ===\n");
        
        // Operações com tipos diferentes
        int inteiro = 10;
        double decimal2 = 3.5;
        
        double resultado = inteiro + decimal2; // int promovido a double
        System.out.println("int + double = double: " + resultado);
        
        int resultado2 = inteiro + (int) decimal2; // Conversão explícita
        System.out.println("int + (int)double = int: " + resultado2);
        
        // Divisão inteira vs divisão real
        int a = 10;
        int b = 3;
        
        System.out.println("\nDivisão inteira: " + (a / b)); // 3
        System.out.println("Divisão real: " + ((double) a / b)); // 3.333...
        
        System.out.println("\n=== COMPARAÇÃO COM PYTHON ===\n");
        
        System.out.println("PYTHON:");
        System.out.println("  # Conversões automáticas e flexíveis");
        System.out.println("  x = 10 / 3      # 3.333... (sempre float)");
        System.out.println("  x = 10 // 3     # 3 (divisão inteira)");
        System.out.println("  s = str(123)    # '123'");
        System.out.println("  n = int('123')  # 123");
        System.out.println();
        System.out.println("JAVA:");
        System.out.println("  // Mais rigoroso, precisa de cast");
        System.out.println("  int x = 10 / 3;        // 3");
        System.out.println("  double y = 10.0 / 3;   // 3.333...");
        System.out.println("  String s = String.valueOf(123);");
        System.out.println("  int n = Integer.parseInt(\"123\");");
        
        System.out.println("\n=== TRATAMENTO DE ERROS ===\n");
        
        try {
            String textoInvalido = "abc";
            int numeroInvalido = Integer.parseInt(textoInvalido);
            System.out.println(numeroInvalido);
        } catch (NumberFormatException e) {
            System.out.println("ERRO: Não é possível converter 'abc' para int");
            System.out.println("Exceção: " + e.getMessage());
        }
        
        System.out.println("\n" + "=".repeat(50));
        System.out.println("CONVERSÕES PRINCIPAIS:");
        System.out.println();
        System.out.println("String -> Primitivo:");
        System.out.println("  Integer.parseInt(str)");
        System.out.println("  Double.parseDouble(str)");
        System.out.println("  Boolean.parseBoolean(str)");
        System.out.println();
        System.out.println("Primitivo -> String:");
        System.out.println("  String.valueOf(valor)");
        System.out.println("  Integer.toString(valor)");
        System.out.println("  \"\" + valor");
        System.out.println();
        System.out.println("Cast explícito:");
        System.out.println("  (tipo) valor");
        System.out.println("=".repeat(50));
    }
}
