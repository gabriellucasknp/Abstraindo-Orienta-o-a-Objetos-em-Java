/*
 * Aula 08 - Primeira Classe em Java
 * 
 * Este é um exemplo completo de classe em Java
 * comparado com Python para facilitar o entendimento
 */

/*
 * EM PYTHON, VOCÊ FARIA:
 * 
 * class Pessoa:
 *     def __init__(self, nome, idade):
 *         self.nome = nome
 *         self.idade = idade
 *         self.email = None
 *     
 *     def apresentar(self):
 *         print(f"Olá, meu nome é {self.nome} e tenho {self.idade} anos")
 *     
 *     def fazer_aniversario(self):
 *         self.idade += 1
 *         print(f"Feliz aniversário! Agora tenho {self.idade} anos")
 * 
 * # Criar objeto
 * pessoa1 = Pessoa("João", 25)
 * pessoa1.apresentar()
 * pessoa1.fazer_aniversario()
 */

public class Exemplo01_PrimeiraClasse {
    public static void main(String[] args) {
        System.out.println("=== CRIANDO E USANDO OBJETOS ===\n");
        
        // Criar objetos (instâncias da classe Pessoa)
        Pessoa pessoa1 = new Pessoa("João", 25);
        Pessoa pessoa2 = new Pessoa("Maria", 30);
        Pessoa pessoa3 = new Pessoa("Pedro", 22);
        
        // Usar métodos dos objetos
        pessoa1.apresentar();
        pessoa2.apresentar();
        pessoa3.apresentar();
        
        System.out.println("\n=== MODIFICANDO ATRIBUTOS ===\n");
        
        // Modificar atributos (por enquanto são públicos)
        pessoa1.email = "joao@email.com";
        System.out.println("Email de " + pessoa1.nome + ": " + pessoa1.email);
        
        System.out.println("\n=== CHAMANDO MÉTODOS ===\n");
        
        pessoa1.fazerAniversario();
        pessoa1.apresentar();
        
        pessoa2.fazerAniversario();
        pessoa2.fazerAniversario();
        pessoa2.apresentar();
        
        System.out.println("\n=== MÚLTIPLOS OBJETOS ===\n");
        
        // Cada objeto tem suas próprias características
        System.out.println("Pessoa 1: " + pessoa1.nome + ", " + pessoa1.idade + " anos");
        System.out.println("Pessoa 2: " + pessoa2.nome + ", " + pessoa2.idade + " anos");
        System.out.println("Pessoa 3: " + pessoa3.nome + ", " + pessoa3.idade + " anos");
        
        System.out.println("\n=== VERIFICAÇÕES ===\n");
        
        pessoa1.verificarMaiorIdade();
        pessoa3.verificarMaiorIdade();
        
        System.out.println("\n=== COMPARANDO OBJETOS ===\n");
        
        System.out.println("pessoa1 == pessoa2: " + (pessoa1 == pessoa2));  // false
        System.out.println("pessoa1 == pessoa1: " + (pessoa1 == pessoa1));  // true
        
        // Criar nova referência para o mesmo objeto
        Pessoa pessoa4 = pessoa1;
        System.out.println("pessoa4 == pessoa1: " + (pessoa4 == pessoa1));  // true (mesma referência)
        
        pessoa4.nome = "João Silva";
        System.out.println("Nome de pessoa1: " + pessoa1.nome);  // "João Silva" (mesma referência!)
    }
}

// DEFINIÇÃO DA CLASSE PESSOA
// Em Java, geralmente cada classe fica em seu próprio arquivo
// Mas para este exemplo, está no mesmo arquivo
class Pessoa {
    // ATRIBUTOS (características do objeto)
    // Em Python seria: self.nome, self.idade, self.email
    String nome;
    int idade;
    String email;
    
    // CONSTRUTOR (equivalente ao __init__ do Python)
    // É chamado automaticamente quando criamos um objeto
    public Pessoa(String nome, int idade) {
        this.nome = nome;      // this é como self em Python
        this.idade = idade;
        this.email = null;     // Inicializado como null
    }
    
    // MÉTODOS (comportamentos do objeto)
    
    // Método sem retorno (void)
    public void apresentar() {
        System.out.println("Olá, meu nome é " + this.nome + 
                          " e tenho " + this.idade + " anos");
    }
    
    // Método que modifica o objeto
    public void fazerAniversario() {
        this.idade++;
        System.out.println("🎉 Feliz aniversário, " + this.nome + 
                          "! Agora você tem " + this.idade + " anos!");
    }
    
    // Método com condicional
    public void verificarMaiorIdade() {
        if (this.idade >= 18) {
            System.out.println(this.nome + " é maior de idade");
        } else {
            System.out.println(this.nome + " é menor de idade");
        }
    }
    
    // Método que retorna um valor (boolean)
    public boolean eMaiorDeIdade() {
        return this.idade >= 18;
    }
    
    // Método que recebe parâmetros
    public void definirEmail(String novoEmail) {
        if (novoEmail != null && novoEmail.contains("@")) {
            this.email = novoEmail;
            System.out.println("Email definido com sucesso!");
        } else {
            System.out.println("Email inválido!");
        }
    }
    
    // Método que retorna String
    public String obterInformacoes() {
        String info = "Nome: " + this.nome + "\n";
        info += "Idade: " + this.idade + " anos\n";
        info += "Email: " + (this.email != null ? this.email : "Não cadastrado");
        return info;
    }
}

/*
 * CONCEITOS IMPORTANTES:
 * 
 * 1. CLASSE: É um molde/template para criar objetos
 *    - Define quais atributos o objeto terá
 *    - Define quais métodos o objeto terá
 * 
 * 2. OBJETO: É uma instância da classe
 *    - Cada objeto tem suas próprias cópias dos atributos
 *    - Todos compartilham os mesmos métodos
 * 
 * 3. ATRIBUTOS: Variáveis que pertencem ao objeto
 *    - Armazenam o estado do objeto
 *    - Cada objeto tem seus próprios valores
 * 
 * 4. MÉTODOS: Funções que pertencem ao objeto
 *    - Definem o comportamento do objeto
 *    - Podem acessar e modificar os atributos
 * 
 * 5. THIS: Referência ao objeto atual
 *    - Como self em Python
 *    - Usado para acessar atributos e métodos do próprio objeto
 * 
 * 6. CONSTRUTOR: Método especial para inicializar o objeto
 *    - Tem o mesmo nome da classe
 *    - Chamado automaticamente com new
 *    - Como __init__ em Python
 * 
 * DIFERENÇAS PYTHON → JAVA:
 * 
 * Python                    | Java
 * --------------------------|---------------------------
 * def __init__(self, ...)   | public ClassName(...)
 * self                      | this
 * def metodo(self):         | public void metodo()
 * self.atributo             | this.atributo
 * objeto = Classe(...)      | Classe objeto = new Classe(...)
 * True/False                | true/false
 * None                      | null
 * 
 * PRÓXIMOS PASSOS:
 * - Aula 09: Encapsulamento (atributos private)
 * - Aula 10: Construtores múltiplos
 * - Aula 11: Herança
 */
