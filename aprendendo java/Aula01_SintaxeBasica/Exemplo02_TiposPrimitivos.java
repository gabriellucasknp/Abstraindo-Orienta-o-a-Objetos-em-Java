/*
 * EXEMPLO 02 - TIPOS PRIMITIVOS
 * 
 * Java é estaticamente tipado - você DEVE declarar o tipo.
 * Python é dinamicamente tipado - o tipo é inferido.
 * 
 * PYTHON:          JAVA:
 * x = 10           int x = 10;
 * y = 3.14         double y = 3.14;
 * nome = "José"    String nome = "José";
 */

public class Exemplo02_TiposPrimitivos {
    
    public static void main(String[] args) {
        
        System.out.println("=== TIPOS INTEIROS ===\n");
        
        // byte: -128 a 127 (8 bits)
        byte idade = 25;
        System.out.println("byte idade = " + idade);
        System.out.println("Tamanho: " + Byte.BYTES + " bytes");
        System.out.println("Min: " + Byte.MIN_VALUE + ", Max: " + Byte.MAX_VALUE);
        System.out.println();
        
        // short: -32.768 a 32.767 (16 bits)
        short ano = 2026;
        System.out.println("short ano = " + ano);
        System.out.println("Tamanho: " + Short.BYTES + " bytes");
        System.out.println("Min: " + Short.MIN_VALUE + ", Max: " + Short.MAX_VALUE);
        System.out.println();
        
        // int: -2 bilhões a 2 bilhões (32 bits) - MAIS USADO
        int populacao = 1_000_000; // Pode usar _ para separar (Java 7+)
        System.out.println("int populacao = " + populacao);
        System.out.println("Tamanho: " + Integer.BYTES + " bytes");
        System.out.println("Min: " + Integer.MIN_VALUE + ", Max: " + Integer.MAX_VALUE);
        System.out.println();
        
        // long: números muito grandes (64 bits) - sufixo L obrigatório
        long distanciaEstrelas = 9_460_730_472_580_800L; // Ano-luz em km
        System.out.println("long distanciaEstrelas = " + distanciaEstrelas);
        System.out.println("Tamanho: " + Long.BYTES + " bytes");
        System.out.println("Min: " + Long.MIN_VALUE);
        System.out.println("Max: " + Long.MAX_VALUE);
        System.out.println();
        
        System.out.println("=== TIPOS DECIMAIS ===\n");
        
        // float: precisão simples (32 bits) - sufixo f obrigatório
        float altura = 1.75f;
        System.out.println("float altura = " + altura);
        System.out.println("Tamanho: " + Float.BYTES + " bytes");
        System.out.println();
        
        // double: precisão dupla (64 bits) - MAIS USADO para decimais
        double preco = 19.99;
        double pi = 3.141592653589793;
        System.out.println("double preco = " + preco);
        System.out.println("double pi = " + pi);
        System.out.println("Tamanho: " + Double.BYTES + " bytes");
        System.out.println();
        
        System.out.println("=== TIPOS CARACTERE E BOOLEANO ===\n");
        
        // char: um único caractere Unicode (16 bits) - aspas simples!
        char letra = 'A';
        char simbolo = '@';
        char unicode = '\u0041'; // 'A' em Unicode
        System.out.println("char letra = " + letra);
        System.out.println("char simbolo = " + simbolo);
        System.out.println("char unicode = " + unicode);
        System.out.println();
        
        // boolean: true ou false (Python usa True/False com maiúscula)
        boolean ativo = true;
        boolean maiorDeIdade = false;
        System.out.println("boolean ativo = " + ativo);
        System.out.println("boolean maiorDeIdade = " + maiorDeIdade);
        System.out.println();
        
        System.out.println("=== STRING (não é primitivo!) ===\n");
        
        // String: sequência de caracteres - aspas duplas!
        String nome = "João Silva";
        String mensagem = "Olá, mundo!";
        System.out.println("String nome = " + nome);
        System.out.println("String mensagem = " + mensagem);
        System.out.println("Tamanho do nome: " + nome.length() + " caracteres");
        
        System.out.println("\n" + "=".repeat(50));
        System.out.println("IMPORTANTE: Em Python, tudo é objeto.");
        System.out.println("Em Java, há tipos primitivos (mais rápidos)");
        System.out.println("e objetos (como String).");
        System.out.println("=".repeat(50));
    }
}

/*
 * RESUMO PARA QUEM VEM DO PYTHON:
 * 
 * 1. DECLARE O TIPO: int x = 10; (não apenas x = 10)
 * 2. USE PONTO E VÍRGULA: Sempre!
 * 3. boolean (minúsculo), não Boolean
 * 4. true/false (minúsculo), não True/False
 * 5. char usa 'A' (aspas simples)
 * 6. String usa "texto" (aspas duplas)
 * 7. Sufixo L para long: 123L
 * 8. Sufixo f para float: 3.14f
 */
