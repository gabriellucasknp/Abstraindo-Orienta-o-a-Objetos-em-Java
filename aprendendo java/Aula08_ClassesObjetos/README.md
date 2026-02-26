# Aula 08 - Classes e Objetos (Introdução a POO)

## 📚 Objetivos
- Entender o paradigma Orientado a Objetos
- Criar classes e instanciar objetos
- Trabalhar com atributos e métodos
- Usar a palavra-chave `this`
- Comparar com classes Python

---

## 🎯 POO: Java vs Python

### Python:
```python
class Pessoa:
    def __init__(self, nome, idade):
        self.nome = nome
        self.idade = idade
    
    def apresentar(self):
        print(f"Olá, sou {self.nome}")

pessoa = Pessoa("João", 25)
pessoa.apresentar()
```

### Java:
```java
public class Pessoa {
    String nome;
    int idade;
    
    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }
    
    public void apresentar() {
        System.out.println("Olá, sou " + this.nome);
    }
}

// Usar:
Pessoa pessoa = new Pessoa("João", 25);
pessoa.apresentar();
```

---

## 📁 Arquivos desta Aula

1. `Exemplo01_PrimeiraClasse.java` - Classe básica
2. `Exemplo02_AtributosMetodos.java` - Membros da classe
3. `Exemplo03_MultiploObjetos.java` - Várias instâncias
4. `Exemplo04_PalavraThis.java` - Uso do this
5. `Exemplo05_MetodosComObjetos.java` - Métodos que retornam objetos
6. `Exercicio01_Carro.java` - Classe Carro
7. `Exercicio02_ContaBancaria.java` - Conta bancária simples
8. `Desafio_SistemaLivraria.java` - Sistema com várias classes

---

## 🔑 Conceitos Fundamentais

### Classe
Template/molde para criar objetos. Define atributos e métodos.

### Objeto
Instância de uma classe. Uma variável concreta criada a partir do molde.

### Atributos (Fields)
Variáveis que pertencem ao objeto (características).

### Métodos
Funções que pertencem ao objeto (comportamentos).

### This
Referência ao objeto atual.

---

## ⚡ Diferenças Python → Java

| Aspecto | Python | Java |
|---------|--------|------|
| **Construtor** | `__init__` | Nome da classe |
| **Self/This** | `self` (parâmetro) | `this` (palavra-chave) |
| **Instanciar** | `obj = Classe()` | `Classe obj = new Classe()` |
| **Atributos** | Dinâmicos | Declarados na classe |
| **Tipagem** | Dinâmica | Estática |

---

## 💡 Boas Práticas

- Uma classe por arquivo
- Nome do arquivo = nome da classe
- Usar PascalCase para nomes de classes
- Usar camelCase para atributos e métodos
- Sempre use modificadores de acesso (próxima aula)

---

## 🎓 Próxima Aula
[Aula 09 - Encapsulamento e Modificadores de Acesso](../Aula09_Encapsulamento/README.md)
