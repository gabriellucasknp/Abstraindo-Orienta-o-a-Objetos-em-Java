/*
 * EXEMPLO 03 - VARIÁVEIS E DECLARAÇÕES
 * 
 * Diferenças importantes entre Python e Java na declaração de variáveis
 */

public class Exemplo03_Variaveis {
    
    public static void main(String[] args) {
        
        System.out.println("=== DECLARAÇÃO E INICIALIZAÇÃO ===\n");
        
        // Python: x = 10
        // Java: você deve declarar o tipo
        int x = 10;
        System.out.println("x = " + x);
        
        // Declarar sem inicializar (Python não permite)
        int y;
        y = 20; // Inicializa depois
        System.out.println("y = " + y);
        
        // Declarar múltiplas variáveis do mesmo tipo
        int a = 1, b = 2, c = 3;
        System.out.println("a=" + a + ", b=" + b + ", c=" + c);
        
        // Declarar várias, inicializar depois
        int m, n, p;
        m = 100;
        n = 200;
        p = 300;
        System.out.println("m=" + m + ", n=" + n + ", p=" + p);
        
        System.out.println("\n=== CONSTANTES ===\n");
        
        // Python: CONSTANTE = 3.14 (convenção, não obrigatório)
        // Java: final (valor não pode mudar)
        final double PI = 3.141592653589793;
        final int DIAS_SEMANA = 7;
        final String NOME_EMPRESA = "Tech Corp";
        
        System.out.println("PI = " + PI);
        System.out.println("DIAS_SEMANA = " + DIAS_SEMANA);
        System.out.println("NOME_EMPRESA = " + NOME_EMPRESA);
        
        // PI = 3.14; // ERRO! Não pode modificar constante
        
        System.out.println("\n=== VAR (Java 10+) ===\n");
        
        // var permite inferência de tipo (mais parecido com Python!)
        var idade = 25;           // Java infere: int
        var nome = "Maria";       // Java infere: String
        var preco = 99.99;        // Java infere: double
        var ativo = true;         // Java infere: boolean
        
        System.out.println("var idade = " + idade + " (tipo: int)");
        System.out.println("var nome = " + nome + " (tipo: String)");
        System.out.println("var preco = " + preco + " (tipo: double)");
        System.out.println("var ativo = " + ativo + " (tipo: boolean)");
        
        // MAS: var só funciona com inicialização
        // var z; // ERRO! Não pode inferir sem valor inicial
        
        System.out.println("\n=== CONVENÇÕES DE NOMES ===\n");
        
        // camelCase para variáveis e métodos
        int minhaIdade = 30;
        String meuNomeCompleto = "João da Silva";
        
        // UPPER_SNAKE_CASE para constantes
        final int NUMERO_MAXIMO = 100;
        final String MENSAGEM_ERRO = "Erro crítico";
        
        System.out.println("minhaIdade = " + minhaIdade);
        System.out.println("meuNomeCompleto = " + meuNomeCompleto);
        System.out.println("NUMERO_MAXIMO = " + NUMERO_MAXIMO);
        
        System.out.println("\n=== ESCOPO DE VARIÁVEIS ===\n");
        
        int variavelGlobal = 100;
        
        if (true) {
            int variavelLocal = 200;
            System.out.println("Dentro do if: " + variavelLocal);
            System.out.println("Acessa global: " + variavelGlobal);
        }
        
        // System.out.println(variavelLocal); // ERRO! Fora do escopo
        System.out.println("Fora do if: " + variavelGlobal);
        
        System.out.println("\n" + "=".repeat(50));
        System.out.println("DICAS:");
        System.out.println("1. Sempre declare o tipo (ou use var)");
        System.out.println("2. Use final para constantes");
        System.out.println("3. camelCase para variáveis");
        System.out.println("4. UPPER_SNAKE_CASE para constantes");
        System.out.println("5. Inicialize variáveis antes de usar");
        System.out.println("=".repeat(50));
    }
}
