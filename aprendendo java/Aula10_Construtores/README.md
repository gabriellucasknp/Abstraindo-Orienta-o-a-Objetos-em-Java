# Aula 10 - Construtores e Sobrecarga

## 📚 Objetivos
- Entender construtores em Java
- Trabalhar com sobrecarga de construtores
- Usar sobrecarga de métodos
- Comparar com `__init__` do Python

---

## 🏗️ Construtores

### Python:
```python
class Pessoa:
    def __init__(self, nome, idade=18):
        self.nome = nome
        self.idade = idade
```

### Java:
```java
public class Pessoa {
    private String nome;
    private int idade;
    
    // Construtor padrão
    public Pessoa() {
        this.nome = "Sem nome";
        this.idade = 18;
    }
    
    // Construtor com parâmetros
    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }
    
    // Sobrecarga de construtor
    public Pessoa(String nome) {
        this.nome = nome;
        this.idade = 18;
    }
}
```

---

## 📁 Arquivos desta Aula

1. `Exemplo01_ConstrutorPadrao.java` - Construtor sem parâmetros
2. `Exemplo02_ConstrutorParametrizado.java` - Com parâmetros
3. `Exemplo03_SobrecargaConstrutores.java` - Múltiplos construtores
4. `Exemplo04_ThisConstrutor.java` - Chamar outro construtor
5. `Exemplo05_SobrecargaMetodos.java` - Overloading de métodos
6. `Exercicio01_Retangulo.java` - Classe com construtores
7. `Exercicio02_Data.java` - Classe Data completa
8. `Desafio_SistemaVeiculos.java` - Sistema com hierarquia

---

## 🔑 Conceitos

### Sobrecarga (Overloading)
Mesmo nome, parâmetros diferentes:
```java
public class Calculadora {
    public int somar(int a, int b) {
        return a + b;
    }
    
    public double somar(double a, double b) {
        return a + b;
    }
    
    public int somar(int a, int b, int c) {
        return a + b + c;
    }
}
```

### Chamar Construtor de Outro Construtor:
```java
public Pessoa(String nome) {
    this(nome, 18);  // Chama construtor com 2 parâmetros
}
```

---

## 🎓 Próxima Aula
[Aula 11 - Herança e Polimorfismo](../Aula11_Heranca/README.md)
