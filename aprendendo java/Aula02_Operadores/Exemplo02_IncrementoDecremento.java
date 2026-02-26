/*
 * Aula 02 - Incremento e Decremento
 * 
 * COMPARAÇÃO COM PYTHON:
 * Python não tem ++ e --, usa:
 *   x += 1  ou  x -= 1
 * 
 * Java tem operadores específicos:
 *   x++  (pós-incremento)
 *   ++x  (pré-incremento)
 *   x--  (pós-decremento)
 *   --x  (pré-decremento)
 */

public class Exemplo02_IncrementoDecremento {
    public static void main(String[] args) {
        System.out.println("=== INCREMENTO E DECREMENTO ===\n");
        
        // PÓS-INCREMENTO (x++)
        System.out.println("--- Pós-incremento ---");
        int x = 5;
        System.out.println("x inicial: " + x);
        System.out.println("x++: " + x++);  // Usa o valor 5, depois incrementa
        System.out.println("x depois: " + x);  // Agora é 6
        
        System.out.println("\n--- Pré-incremento ---");
        // PRÉ-INCREMENTO (++x)
        int y = 5;
        System.out.println("y inicial: " + y);
        System.out.println("++y: " + ++y);  // Incrementa primeiro, depois usa o valor 6
        System.out.println("y depois: " + y);  // É 6
        
        System.out.println("\n--- Comparação direta ---");
        int a = 10;
        int b = 10;
        
        int resultado1 = a++;  // resultado1 = 10, a = 11
        int resultado2 = ++b;  // b = 11, resultado2 = 11
        
        System.out.println("a++ resultou em: " + resultado1 + ", a agora é: " + a);
        System.out.println("++b resultou em: " + resultado2 + ", b agora é: " + b);
        
        System.out.println("\n=== DECREMENTO ===\n");
        
        // PÓS-DECREMENTO (x--)
        System.out.println("--- Pós-decremento ---");
        int m = 8;
        System.out.println("m inicial: " + m);
        System.out.println("m--: " + m--);  // Usa 8, depois decrementa
        System.out.println("m depois: " + m);  // Agora é 7
        
        System.out.println("\n--- Pré-decremento ---");
        // PRÉ-DECREMENTO (--x)
        int n = 8;
        System.out.println("n inicial: " + n);
        System.out.println("--n: " + --n);  // Decrementa primeiro para 7
        System.out.println("n depois: " + n);  // É 7
        
        System.out.println("\n=== EXEMPLO PRÁTICO: LOOP ===\n");
        
        // Uso comum em loops (você verá mais na aula de repetição)
        int contador = 0;
        System.out.println("Contando de 0 a 4:");
        System.out.println(contador++);  // 0
        System.out.println(contador++);  // 1
        System.out.println(contador++);  // 2
        System.out.println(contador++);  // 3
        System.out.println(contador++);  // 4
        System.out.println("Contador final: " + contador);  // 5
        
        System.out.println("\n=== CUIDADO COM EXPRESSÕES COMPLEXAS ===\n");
        
        int valor = 10;
        // NÃO FAÇA ISSO! É confuso e pode ter resultados inesperados
        int resultado = valor++ + ++valor;
        System.out.println("Expressão confusa: " + resultado);
        System.out.println("Valor final: " + valor);
        
        // MELHOR: Seja explícito
        int valor2 = 10;
        int temp1 = valor2;
        valor2++;
        valor2++;
        int resultado2 = temp1 + valor2;
        System.out.println("Expressão clara: " + resultado2);
        System.out.println("Valor final: " + valor2);
    }
}
