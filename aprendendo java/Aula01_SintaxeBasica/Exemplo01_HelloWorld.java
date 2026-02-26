/*
 * EXEMPLO 01 - HELLO WORLD
 * 
 * Este é o programa mais simples em Java.
 * Comparando com Python, há muito mais "cerimônia".
 * 
 * PYTHON:
 * print("Hello, World!")
 * 
 * JAVA:
 * - Precisa de uma classe
 * - Precisa do método main
 * - Precisa de ponto e vírgula
 */

public class Exemplo01_HelloWorld {
    
    // Método main - ponto de entrada do programa
    public static void main(String[] args) {
        
        // Imprimindo com quebra de linha
        System.out.println("Hello, World!");
        
        // Imprimindo sem quebra de linha
        System.out.print("Olá, ");
        System.out.print("Java!");
        System.out.println(); // Apenas quebra linha
        
        // Imprimindo várias linhas
        System.out.println("=".repeat(40));
        System.out.println("Bem-vindo ao Java!");
        System.out.println("Vindo do Python? Você vai se adaptar!");
        System.out.println("=".repeat(40));
        
        // Formatação com printf (similar ao Python)
        String nome = "Programador";
        int ano = 2026;
        System.out.printf("Olá, %s! Estamos em %d%n", nome, ano);
    }
}

/*
 * COMO COMPILAR E EXECUTAR:
 * 
 * 1. Compilar:
 *    javac Exemplo01_HelloWorld.java
 * 
 * 2. Executar:
 *    java Exemplo01_HelloWorld
 * 
 * 3. Ou direto (Java 11+):
 *    java Exemplo01_HelloWorld.java
 */
