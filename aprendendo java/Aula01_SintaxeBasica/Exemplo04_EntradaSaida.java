/*
 * EXEMPLO 04 - ENTRADA E SAÍDA DE DADOS
 * 
 * Python: input() é simples e direto
 * Java: precisa da classe Scanner
 */

import java.util.Scanner;

public class Exemplo04_EntradaSaida {
    
    public static void main(String[] args) {
        
        // Criar objeto Scanner para ler entrada
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== LENDO DADOS DO USUÁRIO ===\n");
        
        // Ler String
        System.out.print("Digite seu nome: ");
        String nome = scanner.nextLine();
        
        // Ler int
        System.out.print("Digite sua idade: ");
        int idade = scanner.nextInt();
        
        // Ler double
        System.out.print("Digite sua altura (ex: 1.75): ");
        double altura = scanner.nextDouble();
        
        // Ler boolean
        System.out.print("É estudante? (true/false): ");
        boolean estudante = scanner.nextBoolean();
        
        // Limpar buffer (importante após ler números!)
        scanner.nextLine();
        
        System.out.print("Digite sua cidade: ");
        String cidade = scanner.nextLine();
        
        System.out.println("\n=== DADOS DIGITADOS ===\n");
        
        // Saída simples
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Altura: " + altura);
        System.out.println("Estudante: " + estudante);
        System.out.println("Cidade: " + cidade);
        
        System.out.println("\n=== FORMATAÇÃO COM PRINTF ===\n");
        
        // printf - similar ao Python
        System.out.printf("Nome: %s%n", nome);
        System.out.printf("Idade: %d anos%n", idade);
        System.out.printf("Altura: %.2f metros%n", altura);
        System.out.printf("Estudante: %b%n", estudante);
        
        // Formatação avançada
        System.out.printf("%nOlá, %s!%n", nome);
        System.out.printf("Você tem %d anos e mede %.2f metros.%n", idade, altura);
        
        // String.format (retorna String ao invés de imprimir)
        String mensagem = String.format(
            "%s, %d anos, %.2f m, estudante: %b",
            nome, idade, altura, estudante
        );
        System.out.println("\n" + mensagem);
        
        System.out.println("\n=== COMPARAÇÃO COM PYTHON ===\n");
        
        System.out.println("PYTHON:");
        System.out.println("  nome = input('Nome: ')");
        System.out.println("  idade = int(input('Idade: '))");
        System.out.println("  altura = float(input('Altura: '))");
        System.out.println();
        System.out.println("JAVA:");
        System.out.println("  Scanner sc = new Scanner(System.in);");
        System.out.println("  String nome = sc.nextLine();");
        System.out.println("  int idade = sc.nextInt();");
        System.out.println("  double altura = sc.nextDouble();");
        
        // Fechar scanner (boa prática)
        scanner.close();
        
        System.out.println("\n" + "=".repeat(50));
        System.out.println("MÉTODOS DO SCANNER:");
        System.out.println("- nextLine()  -> String completa");
        System.out.println("- next()      -> String até espaço");
        System.out.println("- nextInt()   -> int");
        System.out.println("- nextDouble()-> double");
        System.out.println("- nextBoolean() -> boolean");
        System.out.println("- nextFloat() -> float");
        System.out.println("- nextLong()  -> long");
        System.out.println("=".repeat(50));
    }
}

/*
 * IMPORTANTE: 
 * 
 * 1. Sempre importar: import java.util.Scanner;
 * 2. Criar objeto: Scanner sc = new Scanner(System.in);
 * 3. Usar método apropriado: nextInt(), nextDouble(), etc.
 * 4. Limpar buffer com nextLine() após números
 * 5. Fechar scanner: sc.close();
 */
