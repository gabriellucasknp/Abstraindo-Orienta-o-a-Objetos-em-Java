# Aula 20 - Projeto Prático: Sistema Bancário Completo

## 🎯 Objetivo do Projeto

Desenvolver um **Sistema Bancário Completo** que integra todos os conceitos aprendidos:
- POO (Classes, Herança, Polimorfismo, Interfaces)
- Encapsulamento e validação
- Collections (List, Map)
- Exceções personalizadas
- Arquivos (persistência)
- Enums e Records
- Stream API

---

## 🏦 Funcionalidades

### 1. Gestão de Clientes
- ✅ Cadastrar cliente
- ✅ Buscar cliente por CPF
- ✅ Listar todos os clientes
- ✅ Atualizar dados do cliente

### 2. Gestão de Contas
- ✅ Criar conta corrente
- ✅ Criar conta poupança
- ✅ Criar conta salário
- ✅ Buscar conta por número
- ✅ Listar contas de um cliente

### 3. Operações Bancárias
- ✅ Depositar
- ✅ Sacar
- ✅ Transferir entre contas
- ✅ Consultar saldo
- ✅ Consultar extrato

### 4. Persistência
- ✅ Salvar dados em arquivo
- ✅ Carregar dados do arquivo

---

## 📁 Estrutura do Projeto

```
Aula20_ProjetoBanco/
├── README.md
├── modelo/
│   ├── Cliente.java
│   ├── Conta.java (abstrata)
│   ├── ContaCorrente.java
│   ├── ContaPoupanca.java
│   ├── ContaSalario.java
│   └── Transacao.java (record)
├── excecao/
│   ├── SaldoInsuficienteException.java
│   ├── ContaNaoEncontradaException.java
│   └── ClienteJaCadastradoException.java
├── servico/
│   ├── BancoService.java
│   ├── ClienteService.java
│   └── ContaService.java
├── repositorio/
│   ├── RepositorioClientes.java
│   └── RepositorioContas.java
├── util/
│   ├── ValidadorCPF.java
│   └── GeradorNumeroConta.java
├── enums/
│   ├── TipoConta.java
│   └── TipoTransacao.java
└── Main.java (interface de usuário)
```

---

## 🔑 Conceitos Aplicados

### POO e Herança
```java
// Classe abstrata base
public abstract class Conta {
    protected String numero;
    protected Cliente titular;
    protected double saldo;
    protected List<Transacao> extrato;
    
    public abstract void sacar(double valor) throws SaldoInsuficienteException;
}

// Contas específicas
public class ContaCorrente extends Conta {
    private double limite;
    private double taxaManutencao;
    
    @Override
    public void sacar(double valor) throws SaldoInsuficienteException {
        if (valor > saldo + limite) {
            throw new SaldoInsuficienteException(...);
        }
        saldo -= valor;
    }
}

public class ContaPoupanca extends Conta {
    private double taxaRendimento;
    
    public void aplicarRendimento() {
        saldo += saldo * taxaRendimento;
    }
}
```

### Enums
```java
public enum TipoConta {
    CORRENTE("Conta Corrente", 100.00),
    POUPANCA("Conta Poupança", 0.00),
    SALARIO("Conta Salário", 0.00);
    
    private final String descricao;
    private final double limiteInicial;
    
    TipoConta(String descricao, double limiteInicial) {
        this.descricao = descricao;
        this.limiteInicial = limiteInicial;
    }
}

public enum TipoTransacao {
    DEPOSITO, SAQUE, TRANSFERENCIA_ENVIADA, 
    TRANSFERENCIA_RECEBIDA, RENDIMENTO
}
```

### Records
```java
public record Transacao(
    LocalDateTime data,
    TipoTransacao tipo,
    double valor,
    double saldoAnterior,
    double saldoPosterior,
    String descricao
) {
    @Override
    public String toString() {
        return String.format("[%s] %s - R$ %.2f - Saldo: R$ %.2f",
            data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")),
            tipo, valor, saldoPosterior);
    }
}
```

### Exceções Personalizadas
```java
public class SaldoInsuficienteException extends Exception {
    private final double saldoAtual;
    private final double valorSolicitado;
    
    public SaldoInsuficienteException(double saldoAtual, double valorSolicitado) {
        super(String.format("Saldo insuficiente! Saldo: R$ %.2f, Valor solicitado: R$ %.2f",
            saldoAtual, valorSolicitado));
        this.saldoAtual = saldoAtual;
        this.valorSolicitado = valorSolicitado;
    }
}
```

### Collections e Stream API
```java
public class BancoService {
    private Map<String, Cliente> clientes = new HashMap<>();
    private Map<String, Conta> contas = new HashMap<>();
    
    // Buscar contas de um cliente
    public List<Conta> buscarContasCliente(String cpf) {
        return contas.values().stream()
            .filter(conta -> conta.getTitular().getCpf().equals(cpf))
            .collect(Collectors.toList());
    }
    
    // Relatório: Total depositado no banco
    public double totalDepositadoBanco() {
        return contas.values().stream()
            .mapToDouble(Conta::getSaldo)
            .sum();
    }
    
    // Contas com saldo negativo
    public List<Conta> contasComSaldoNegativo() {
        return contas.values().stream()
            .filter(conta -> conta.getSaldo() < 0)
            .sorted((c1, c2) -> Double.compare(c1.getSaldo(), c2.getSaldo()))
            .collect(Collectors.toList());
    }
}
```

### Persistência em Arquivo
```java
public class RepositorioContas {
    private static final String ARQUIVO = "contas.dat";
    
    public void salvar(Map<String, Conta> contas) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(ARQUIVO))) {
            oos.writeObject(contas);
        }
    }
    
    @SuppressWarnings("unchecked")
    public Map<String, Conta> carregar() throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(ARQUIVO))) {
            return (Map<String, Conta>) ois.readObject();
        }
    }
}
```

---

## 🎮 Menu Principal

```
========================================
       SISTEMA BANCÁRIO - v1.0
========================================

1. Gestão de Clientes
   1.1 Cadastrar cliente
   1.2 Buscar cliente
   1.3 Listar clientes
   1.4 Atualizar cliente

2. Gestão de Contas
   2.1 Criar conta
   2.2 Listar contas
   2.3 Buscar conta

3. Operações Bancárias
   3.1 Depositar
   3.2 Sacar
   3.3 Transferir
   3.4 Consultar saldo
   3.5 Extrato

4. Relatórios
   4.1 Total no banco
   4.2 Contas com saldo negativo
   4.3 Maiores saldos

5. Sair (salvar dados)

Escolha uma opção: _
```

---

## ✅ Checklist de Implementação

- [ ] Criar classes de modelo (Cliente, Conta, etc)
- [ ] Implementar exceções personalizadas
- [ ] Criar enums e records
- [ ] Implementar serviços (BancoService, ClienteService, ContaService)
- [ ] Implementar repositórios (persistência)
- [ ] Criar validadores (CPF, etc)
- [ ] Implementar menu interativo
- [ ] Adicionar tratamento de erros
- [ ] Testar todas as funcionalidades
- [ ] Documentar código

---

## 🏆 Desafios Extras

1. **Autenticação**: Adicionar senha para clientes
2. **Empréstimos**: Sistema de empréstimos com juros
3. **Investimentos**: CDB, LCI, LCA
4. **Cartão de Crédito**: Fatura e limite
5. **Relatórios PDF**: Gerar extratos em PDF
6. **Interface Gráfica**: JavaFX ou Swing

---

## 📚 Aprendizados

Ao completar este projeto, você terá:
- ✅ Aplicado POO na prática
- ✅ Usado Collections de forma profissional
- ✅ Trabalhado com exceções de forma adequada
- ✅ Persistido dados em arquivos
- ✅ Usado recursos modernos do Java
- ✅ Desenvolvido um sistema completo funcional

---

## 🎓 Próxima Aula
[Aula 21 - Projeto Prático: Sistema de Biblioteca](../Aula21_ProjetoBiblioteca/README.md)
