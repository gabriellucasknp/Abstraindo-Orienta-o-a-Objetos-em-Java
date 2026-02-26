# Aula 21 - Projeto Prático: Sistema de Biblioteca

## 🎯 Objetivo do Projeto

Desenvolver um **Sistema de Gerenciamento de Biblioteca** completo, aplicando todos os conceitos de Java nível júnior, incluindo herança complexa, interfaces, collections avançadas e I/O.

---

## 📚 Funcionalidades

### 1. Gestão de Acervo
- ✅ Cadastrar livros, revistas, DVDs
- ✅ Buscar por título, autor, ISBN
- ✅ Categorizar por gênero
- ✅ Listar disponíveis/emprestados

### 2. Gestão de Usuários
- ✅ Cadastrar bibliotecário
- ✅ Cadastrar membros (estudante, professor, público geral)
- ✅ Diferentes privilégios por tipo
- ✅ Histórico de empréstimos

### 3. Sistema de Empréstimos
- ✅ Emprestar item
- ✅ Devolver item
- ✅ Renovar empréstimo
- ✅ Calcular multas por atraso
- ✅ Reservar item emprestado

### 4. Relatórios
- ✅ Itens mais emprestados
- ✅ Usuários com multas pendentes
- ✅ Itens atrasados
- ✅ Estatísticas gerais

### 5. Persistência
- ✅ Salvar em arquivos
- ✅ Carregar dados
- ✅ Backup automático

---

## 📁 Estrutura do Projeto

```
Aula21_ProjetoBiblioteca/
├── README.md
├── modelo/
│   ├── item/
│   │   ├── ItemBiblioteca.java (abstrato)
│   │   ├── Livro.java
│   │   ├── Revista.java
│   │   ├── DVD.java
│   │   └── ItemDigital.java
│   ├── usuario/
│   │   ├── Usuario.java (abstrato)
│   │   ├── Bibliotecario.java
│   │   ├── Estudante.java
│   │   ├── Professor.java
│   │   └── MembroPublico.java
│   ├── Emprestimo.java
│   ├── Reserva.java
│   └── Multa.java
├── interface/
│   ├── Emprestavel.java
│   ├── Renovavel.java
│   └── Reservavel.java
├── excecao/
│   ├── ItemIndisponivelException.java
│   ├── LimiteEmprestimosException.java
│   ├── MultaPendenteException.java
│   └── ItemJaEmprestadoException.java
├── servico/
│   ├── BibliotecaService.java
│   ├── EmprestimoService.java
│   ├── MultaService.java
│   └── RelatorioService.java
├── repositorio/
│   ├── RepositorioItens.java
│   ├── RepositorioUsuarios.java
│   └── RepositorioEmprestimos.java
├── enums/
│   ├── StatusItem.java
│   ├── TipoUsuario.java
│   ├── GeneroLivro.java
│   └── StatusEmprestimo.java
└── Main.java
```

---

## 🔑 Conceitos Aplicados

### Hierarquia de Classes

```java
// Interface
public interface Emprestavel {
    boolean podeSerEmprestado();
    int getDiasEmprestimo();
    double getMultaDiaria();
}

// Classe abstrata
public abstract class ItemBiblioteca implements Emprestavel {
    protected String id;
    protected String titulo;
    protected int anoPublicacao;
    protected StatusItem status;
    
    public abstract String getDetalhes();
}

// Implementações
public class Livro extends ItemBiblioteca {
    private String isbn;
    private String autor;
    private int numeroPaginas;
    private GeneroLivro genero;
    
    @Override
    public String getDetalhes() {
        return String.format("Livro: %s - Autor: %s - ISBN: %s",
            titulo, autor, isbn);
    }
    
    @Override
    public boolean podeSerEmprestado() {
        return status == StatusItem.DISPONIVEL;
    }
    
    @Override
    public int getDiasEmprestimo() {
        return 14;  // 14 dias para livros
    }
}

public class DVD extends ItemBiblioteca {
    private int duracao;  // minutos
    private String diretor;
    private List<String> atores;
    
    @Override
    public int getDiasEmprestimo() {
        return 7;  // 7 dias para DVDs
    }
}
```

### Polimorfismo com Usuários

```java
public abstract class Usuario {
    protected String id;
    protected String nome;
    protected String email;
    protected List<Emprestimo> historicoEmprestimos;
    
    public abstract int getLimiteEmprestimos();
    public abstract int getDiasMaximoEmprestimo();
}

public class Estudante extends Usuario {
    private String matricula;
    private String curso;
    
    @Override
    public int getLimiteEmprestimos() {
        return 3;  // Estudantes podem pegar 3 itens
    }
    
    @Override
    public int getDiasMaximoEmprestimo() {
        return 14;
    }
}

public class Professor extends Usuario {
    private String departamento;
    
    @Override
    public int getLimiteEmprestimos() {
        return 10;  // Professores podem pegar 10 itens
    }
    
    @Override
    public int getDiasMaximoEmprestimo() {
        return 30;
    }
}

public class Bibliotecario extends Usuario {
    private String cargo;
    private boolean administrador;
    
    @Override
    public int getLimiteEmprestimos() {
        return Integer.MAX_VALUE;  // Sem limite
    }
}
```

### Records para Dados Imutáveis

```java
public record Emprestimo(
    String id,
    Usuario usuario,
    ItemBiblioteca item,
    LocalDate dataEmprestimo,
    LocalDate dataPrevistaDevolucao,
    LocalDate dataDevolucaoReal,
    StatusEmprestimo status
) {
    // Método auxiliar
    public boolean estaAtrasado() {
        if (dataDevolucaoReal != null) {
            return dataDevolucaoReal.isAfter(dataPrevistaDevolucao);
        }
        return LocalDate.now().isAfter(dataPrevistaDevolucao);
    }
    
    public long diasAtraso() {
        LocalDate dataComparacao = dataDevolucaoReal != null 
            ? dataDevolucaoReal 
            : LocalDate.now();
        return ChronoUnit.DAYS.between(dataPrevistaDevolucao, dataComparacao);
    }
}

public record Multa(
    String id,
    Usuario usuario,
    Emprestimo emprestimo,
    double valor,
    boolean paga,
    LocalDate dataCriacao,
    LocalDate dataPagamento
) {
    public static Multa calcular(Emprestimo emprestimo, double valorDiario) {
        long dias = emprestimo.diasAtraso();
        double valor = dias * valorDiario;
        return new Multa(
            UUID.randomUUID().toString(),
            emprestimo.usuario(),
            emprestimo,
            valor,
            false,
            LocalDate.now(),
            null
        );
    }
}
```

### Stream API para Relatórios

```java
public class RelatorioService {
    private List<Emprestimo> emprestimos;
    private List<ItemBiblioteca> itens;
    
    // Top 10 livros mais emprestados
    public List<ItemBiblioteca> itensMaisEmprestados() {
        return emprestimos.stream()
            .collect(Collectors.groupingBy(
                Emprestimo::item,
                Collectors.counting()
            ))
            .entrySet().stream()
            .sorted(Map.Entry.<ItemBiblioteca, Long>comparingByValue().reversed())
            .limit(10)
            .map(Map.Entry::getKey)
            .collect(Collectors.toList());
    }
    
    // Empréstimos atrasados
    public List<Emprestimo> emprestimosAtrasados() {
        return emprestimos.stream()
            .filter(e -> e.status() == StatusEmprestimo.ATIVO)
            .filter(Emprestimo::estaAtrasado)
            .sorted((e1, e2) -> Long.compare(e2.diasAtraso(), e1.diasAtraso()))
            .collect(Collectors.toList());
    }
    
    // Usuários com mais empréstimos
    public Map<Usuario, Long> rankingUsuarios() {
        return emprestimos.stream()
            .collect(Collectors.groupingBy(
                Emprestimo::usuario,
                Collectors.counting()
            ));
    }
    
    // Estatísticas por gênero
    public Map<GeneroLivro, DoubleSummaryStatistics> estatisticasPorGenero() {
        return itens.stream()
            .filter(item -> item instanceof Livro)
            .map(item -> (Livro) item)
            .collect(Collectors.groupingBy(
                Livro::getGenero,
                Collectors.summarizingDouble(livro -> 
                    contarEmprestimos(livro))
            ));
    }
}
```

### Sistema de Reservas

```java
public class EmprestimoService {
    private Map<String, Queue<Reserva>> filaReservas = new HashMap<>();
    
    public void reservarItem(Usuario usuario, ItemBiblioteca item) 
            throws ItemDisponivelException {
        if (item.getStatus() == StatusItem.DISPONIVEL) {
            throw new ItemDisponivelException(
                "Item disponível! Faça o empréstimo diretamente.");
        }
        
        Queue<Reserva> fila = filaReservas.computeIfAbsent(
            item.getId(), k -> new LinkedList<>());
        
        Reserva reserva = new Reserva(
            UUID.randomUUID().toString(),
            usuario,
            item,
            LocalDateTime.now()
        );
        
        fila.offer(reserva);
    }
    
    public void notificarProximoReserva(ItemBiblioteca item) {
        Queue<Reserva> fila = filaReservas.get(item.getId());
        if (fila != null && !fila.isEmpty()) {
            Reserva proxima = fila.poll();
            // Notificar usuário que item está disponível
            System.out.println("Notificando " + proxima.usuario().getNome() +
                " que " + item.getTitulo() + " está disponível!");
        }
    }
}
```

---

## 🎮 Menu do Sistema

```
========================================
   SISTEMA DE BIBLIOTECA - v1.0
========================================

1. Gestão de Acervo
   1.1 Adicionar item (Livro/Revista/DVD)
   1.2 Buscar item
   1.3 Listar todos os itens
   1.4 Listar por categoria

2. Gestão de Usuários
   2.1 Cadastrar usuário
   2.2 Buscar usuário
   2.3 Listar usuários
   2.4 Histórico de usuário

3. Empréstimos
   3.1 Realizar empréstimo
   3.2 Devolver item
   3.3 Renovar empréstimo
   3.4 Listar empréstimos ativos

4. Reservas
   4.1 Reservar item
   4.2 Listar reservas
   4.3 Cancelar reserva

5. Multas
   5.1 Consultar multas
   5.2 Pagar multa
   5.3 Listar inadimplentes

6. Relatórios
   6.1 Itens mais emprestados
   6.2 Empréstimos atrasados
   6.3 Ranking de usuários
   6.4 Estatísticas gerais

7. Sistema
   7.1 Salvar dados
   7.2 Backup
   7.3 Sair

Escolha uma opção: _
```

---

## ✅ Checklist de Implementação

- [ ] Criar hierarquia de itens (ItemBiblioteca e subclasses)
- [ ] Criar hierarquia de usuários
- [ ] Implementar interfaces (Emprestavel, Reservavel)
- [ ] Criar records (Emprestimo, Multa, Reserva)
- [ ] Implementar enums (Status, Tipos, Gêneros)
- [ ] Criar exceções personalizadas
- [ ] Implementar serviços principais
- [ ] Sistema de fila de reservas
- [ ] Cálculo automático de multas
- [ ] Relatórios com Stream API
- [ ] Persistência em arquivos
- [ ] Menu interativo completo
- [ ] Tratamento robusto de erros
- [ ] Testes de todas as funcionalidades

---

## 🏆 Desafios Avançados

1. **API REST**: Criar API com Spring Boot
2. **Banco de Dados**: Migrar de arquivos para JDBC/JPA
3. **Email**: Enviar lembretes de devolução
4. **Multas Automáticas**: Cron job para calcular multas
5. **Interface Web**: Frontend com HTML/CSS/JS
6. **Busca Avançada**: Elasticsearch para busca
7. **Relatórios PDF**: JasperReports

---

## 📊 Conceitos Nível Júnior Aplicados

- ✅ POO Completa (Herança, Polimorfismo, Interfaces, Abstração)
- ✅ Collections Avançadas (List, Map, Queue, Set)
- ✅ Stream API e Lambdas
- ✅ Generics
- ✅ Exceções customizadas
- ✅ Enums e Records
- ✅ I/O e Serialização
- ✅ Arquitetura em camadas
- ✅ Design Patterns básicos (Repository, Service)

---

## 🎓 Parabéns!

Ao completar ambos os projetos (Banco + Biblioteca), você terá **nível júnior sólido em Java** e estará pronto para:
- Processos seletivos para vaga júnior
- Contribuir em projetos reais
- Aprender frameworks (Spring, Hibernate)
- Avançar para tópicos intermediários

**Próximos Passos:**
- Spring Boot e Spring Framework
- Testes Unitários (JUnit)
- Bancos de Dados (JDBC/JPA)
- APIs REST
- Design Patterns
