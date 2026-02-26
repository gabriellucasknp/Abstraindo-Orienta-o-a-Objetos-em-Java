/*
 * Aula 02 - Operadores Lógicos
 * 
 * COMPARAÇÃO COM PYTHON:
 * Python:          Java:
 * and          →   &&
 * or           →   ||
 * not          →   !
 * 
 * Java também tem: & e | (sem short-circuit)
 */

public class Exemplo04_OperadoresLogicos {
    public static void main(String[] args) {
        System.out.println("=== OPERADORES LÓGICOS ===\n");
        
        boolean verdadeiro = true;
        boolean falso = false;
        
        System.out.println("=== OPERADOR E (&&) - AND ===");
        System.out.println("Retorna true APENAS se AMBOS forem true\n");
        
        System.out.println("true && true: " + (verdadeiro && verdadeiro));   // true
        System.out.println("true && false: " + (verdadeiro && falso));       // false
        System.out.println("false && true: " + (falso && verdadeiro));       // false
        System.out.println("false && false: " + (falso && falso));           // false
        
        System.out.println("\n=== OPERADOR OU (||) - OR ===");
        System.out.println("Retorna true se PELO MENOS UM for true\n");
        
        System.out.println("true || true: " + (verdadeiro || verdadeiro));   // true
        System.out.println("true || false: " + (verdadeiro || falso));       // true
        System.out.println("false || true: " + (falso || verdadeiro));       // true
        System.out.println("false || false: " + (falso || falso));           // false
        
        System.out.println("\n=== OPERADOR NÃO (!) - NOT ===");
        System.out.println("Inverte o valor booleano\n");
        
        System.out.println("!true: " + !verdadeiro);   // false
        System.out.println("!false: " + !falso);       // true
        System.out.println("!!true: " + !!verdadeiro); // true (dupla negação)
        
        System.out.println("\n=== EXEMPLOS PRÁTICOS ===\n");
        
        int idade = 25;
        boolean temCarteira = true;
        double saldo = 1500.0;
        
        // Pode dirigir? (precisa ser maior de 18 E ter carteira)
        boolean podeDirigir = (idade >= 18) && temCarteira;
        System.out.println("Pode dirigir: " + podeDirigir);
        
        // Pode comprar? (precisa ser maior de 18 OU ter mais de 1000 no saldo)
        boolean podeComprar = (idade >= 18) || (saldo > 1000);
        System.out.println("Pode comprar: " + podeComprar);
        
        // Precisa de autorização? (menor de 18 E sem carteira)
        boolean precisaAutorizacao = (idade < 18) && !temCarteira;
        System.out.println("Precisa de autorização: " + precisaAutorizacao);
        
        System.out.println("\n=== SHORT-CIRCUIT EVALUATION ===\n");
        System.out.println("&& e || fazem avaliação preguiçosa (short-circuit)");
        System.out.println("Se o resultado já é conhecido, não avalia o resto\n");
        
        int x = 5;
        int y = 0;
        
        // Com && se o primeiro é false, não avalia o segundo
        boolean resultado1 = (y != 0) && (x / y > 0);
        System.out.println("(y != 0) && (x / y > 0): " + resultado1);
        System.out.println("Não deu erro de divisão por zero!\n");
        
        // Se usar & (sem short-circuit), daria erro!
        // boolean resultado2 = (y != 0) & (x / y > 0); // ERRO!
        
        // Com || se o primeiro é true, não avalia o segundo
        boolean resultado3 = (x > 0) || (x / y > 0);
        System.out.println("(x > 0) || (x / y > 0): " + resultado3);
        System.out.println("Também não avaliou a divisão!");
        
        System.out.println("\n=== OPERADORES & e | (SEM SHORT-CIRCUIT) ===\n");
        System.out.println("Sempre avaliam ambos os lados\n");
        
        int a = 10;
        int b = 5;
        
        // Com &&: se primeiro é false, não incrementa b
        boolean teste1 = (a < 5) && (++b > 0);
        System.out.println("Com &&: " + teste1 + ", b = " + b);  // b continua 5
        
        b = 5;  // resetar
        // Com &: sempre incrementa b
        boolean teste2 = (a < 5) & (++b > 0);
        System.out.println("Com &: " + teste2 + ", b = " + b);   // b vira 6
        
        System.out.println("\n=== EXPRESSÕES COMPLEXAS ===\n");
        
        int nota = 7;
        int frequencia = 80;
        boolean trabalhoEntregue = true;
        
        // Aprovado se: (nota >= 7 E frequência >= 75) OU trabalho entregue
        boolean aprovado = ((nota >= 7) && (frequencia >= 75)) || trabalhoEntregue;
        System.out.println("Aprovado: " + aprovado);
        
        // Negação de expressão complexa
        boolean reprovado = !aprovado;
        System.out.println("Reprovado: " + reprovado);
        
        System.out.println("\n=== TABELA VERDADE COMPLETA ===\n");
        
        System.out.println("AND (&&):");
        System.out.println("T && T = " + (true && true));
        System.out.println("T && F = " + (true && false));
        System.out.println("F && T = " + (false && true));
        System.out.println("F && F = " + (false && false));
        
        System.out.println("\nOR (||):");
        System.out.println("T || T = " + (true || true));
        System.out.println("T || F = " + (true || false));
        System.out.println("F || T = " + (false || true));
        System.out.println("F || F = " + (false || false));
        
        System.out.println("\nNOT (!):");
        System.out.println("!T = " + !true);
        System.out.println("!F = " + !false);
        
        System.out.println("\n=== LEIS DE DE MORGAN ===\n");
        
        boolean p = true;
        boolean q = false;
        
        // !(p && q) é o mesmo que (!p || !q)
        System.out.println("!(p && q) = " + !(p && q));
        System.out.println("(!p || !q) = " + (!p || !q));
        System.out.println("São iguais: " + (!(p && q) == (!p || !q)));
        
        // !(p || q) é o mesmo que (!p && !q)
        System.out.println("\n!(p || q) = " + !(p || q));
        System.out.println("(!p && !q) = " + (!p && !q));
        System.out.println("São iguais: " + (!(p || q) == (!p && !q)));
    }
}
