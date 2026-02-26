/*
 * Aula 02 - Operadores Aritméticos
 * 
 * COMPARAÇÃO COM PYTHON:
 * Em Python:
 *   resultado = 10 + 5
 *   potencia = 2 ** 3
 *   divisao_inteira = 10 // 3
 * 
 * Em Java:
 *   int resultado = 10 + 5;
 *   double potencia = Math.pow(2, 3);
 *   int divisaoInteira = 10 / 3;
 */

public class Exemplo01_OperadoresAritmeticos {
    public static void main(String[] args) {
        System.out.println("=== OPERADORES ARITMÉTICOS ===\n");
        
        // Declaração de variáveis
        int a = 10;
        int b = 3;
        
        // ADIÇÃO
        int soma = a + b;
        System.out.println("Adição: " + a + " + " + b + " = " + soma);
        
        // SUBTRAÇÃO
        int subtracao = a - b;
        System.out.println("Subtração: " + a + " - " + b + " = " + subtracao);
        
        // MULTIPLICAÇÃO
        int multiplicacao = a * b;
        System.out.println("Multiplicação: " + a + " * " + b + " = " + multiplicacao);
        
        // DIVISÃO (Atenção: divisão de inteiros!)
        int divisaoInteira = a / b;
        System.out.println("Divisão inteira: " + a + " / " + b + " = " + divisaoInteira);
        
        // DIVISÃO REAL (precisa de pelo menos um double)
        double divisaoReal = (double) a / b;
        System.out.println("Divisão real: " + a + " / " + b + " = " + divisaoReal);
        
        // MÓDULO (resto da divisão)
        int modulo = a % b;
        System.out.println("Módulo: " + a + " % " + b + " = " + modulo);
        
        System.out.println("\n=== POTENCIAÇÃO ===\n");
        
        // POTÊNCIA (não existe operador ** como em Python)
        double potencia = Math.pow(2, 3);
        System.out.println("Potência: 2³ = " + potencia);
        
        // Raiz quadrada
        double raiz = Math.sqrt(16);
        System.out.println("Raiz quadrada de 16 = " + raiz);
        
        System.out.println("\n=== OPERAÇÕES COMBINADAS ===\n");
        
        // Expressões mais complexas
        int resultado1 = (a + b) * 2;
        System.out.println("(" + a + " + " + b + ") * 2 = " + resultado1);
        
        double resultado2 = (a + b) / 2.0;  // Média
        System.out.println("Média de " + a + " e " + b + " = " + resultado2);
        
        // Precedência de operadores (igual à matemática)
        int resultado3 = 10 + 5 * 2;  // Multiplicação primeiro
        System.out.println("10 + 5 * 2 = " + resultado3);  // 20, não 30
        
        int resultado4 = (10 + 5) * 2;  // Parênteses primeiro
        System.out.println("(10 + 5) * 2 = " + resultado4);  // 30
        
        System.out.println("\n=== OPERADORES DE ATRIBUIÇÃO COMPOSTOS ===\n");
        
        int x = 10;
        System.out.println("Valor inicial de x: " + x);
        
        x += 5;  // x = x + 5
        System.out.println("x += 5: " + x);
        
        x -= 3;  // x = x - 3
        System.out.println("x -= 3: " + x);
        
        x *= 2;  // x = x * 2
        System.out.println("x *= 2: " + x);
        
        x /= 4;  // x = x / 4
        System.out.println("x /= 4: " + x);
        
        x %= 3;  // x = x % 3
        System.out.println("x %= 3: " + x);
        
        System.out.println("\n=== OUTRAS FUNÇÕES MATEMÁTICAS ===\n");
        
        System.out.println("Valor absoluto de -15: " + Math.abs(-15));
        System.out.println("Máximo entre 10 e 20: " + Math.max(10, 20));
        System.out.println("Mínimo entre 10 e 20: " + Math.min(10, 20));
        System.out.println("Arredondamento de 3.7: " + Math.round(3.7));
        System.out.println("Arredondamento para cima de 3.2: " + Math.ceil(3.2));
        System.out.println("Arredondamento para baixo de 3.9: " + Math.floor(3.9));
        System.out.println("Número aleatório entre 0 e 1: " + Math.random());
    }
}
