# Aula 09 - Encapsulamento e Modificadores de Acesso

## 📚 Objetivos
- Entender o princípio do encapsulamento
- Usar modificadores public, private, protected
- Criar getters e setters
- Trabalhar com packages

---

## 🔒 Encapsulamento

**Princípio:** Esconder detalhes internos e expor apenas o necessário.

### Python vs Java

**Python** (convenção com _):
```python
class Conta:
    def __init__(self):
        self._saldo = 0  # "privado" por convenção
    
    def get_saldo(self):
        return self._saldo
```

**Java** (enforçado pela linguagem):
```java
public class Conta {
    private double saldo;  // realmente privado
    
    public double getSaldo() {
        return saldo;
    }
}
```

---

## 🔐 Modificadores de Acesso

| Modificador | Mesma Classe | Mesmo Package | Subclasse | Qualquer Lugar |
|-------------|--------------|---------------|-----------|----------------|
| **public** | ✅ | ✅ | ✅ | ✅ |
| **protected** | ✅ | ✅ | ✅ | ❌ |
| **default** | ✅ | ✅ | ❌ | ❌ |
| **private** | ✅ | ❌ | ❌ | ❌ |

---

## 📁 Arquivos desta Aula

1. `Exemplo01_ModificadoresAcesso.java` - Tipos de acesso
2. `Exemplo02_GettersSetters.java` - Métodos de acesso
3. `Exemplo03_Validacao.java` - Validação em setters
4. `Exemplo04_Packages.java` - Organização em pacotes
5. `Exemplo05_Imutabilidade.java` - Classes imutáveis
6. `Exercicio01_Produto.java` - Classe Produto
7. `Exercicio02_Funcionario.java` - Classe Funcionário
8. `Desafio_SistemaBancario.java` - Sistema com encapsulamento

---

## 🎯 Getters e Setters

### Padrão Java Bean:
```java
public class Pessoa {
    private String nome;
    private int idade;
    
    // Getter
    public String getNome() {
        return nome;
    }
    
    // Setter com validação
    public void setNome(String nome) {
        if (nome != null && !nome.isEmpty()) {
            this.nome = nome;
        }
    }
    
    // Getter
    public int getIdade() {
        return idade;
    }
    
    // Setter com validação
    public void setIdade(int idade) {
        if (idade >= 0 && idade <= 150) {
            this.idade = idade;
        }
    }
}
```

---

## 📦 Packages

### Organização:
```
src/
  com/
    empresa/
      modelo/
        Pessoa.java
      servico/
        PessoaService.java
```

### Declaração:
```java
package com.empresa.modelo;

public class Pessoa {
    // ...
}
```

### Importação:
```java
import com.empresa.modelo.Pessoa;
// ou
import com.empresa.modelo.*;
```

---

## 💡 Benefícios do Encapsulamento

1. **Controle** - Validar dados antes de atribuir
2. **Flexibilidade** - Mudar implementação interna sem afetar código externo
3. **Segurança** - Proteger dados sensíveis
4. **Manutenção** - Código mais organizado e fácil de manter

---

## 🎓 Próxima Aula
[Aula 10 - Construtores e Sobrecarga](../Aula10_Construtores/README.md)
