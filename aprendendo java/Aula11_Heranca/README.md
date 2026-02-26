# Aula 11 - Herança e Polimorfismo

## 📚 Objetivos
- Dominar herança em Java
- Entender polimorfismo
- Usar super e extends
- Sobrescrever métodos (@Override)
- Trabalhar com upcasting e downcasting

---

## 🧬 Herança

### Python:
```python
class Animal:
    def __init__(self, nome):
        self.nome = nome
    
    def fazer_som(self):
        pass

class Cachorro(Animal):
    def fazer_som(self):
        return "Au au!"
```

### Java:
```java
public class Animal {
    protected String nome;
    
    public Animal(String nome) {
        this.nome = nome;
    }
    
    public void fazerSom() {
        System.out.println("Som genérico");
    }
}

public class Cachorro extends Animal {
    public Cachorro(String nome) {
        super(nome);  // Chama construtor da classe pai
    }
    
    @Override
    public void fazerSom() {
        System.out.println("Au au!");
    }
}
```

---

## 📁 Arquivos desta Aula

1. `Exemplo01_HerancaBasica.java` - Extends básico
2. `Exemplo02_Super.java` - Palavra-chave super
3. `Exemplo03_Override.java` - Sobrescrita de métodos
4. `Exemplo04_Polimorfismo.java` - Polimorfismo em ação
5. `Exemplo05_Casting.java` - Upcasting e downcasting
6. `Exemplo06_Final.java` - Palavra-chave final
7. `Exercicio01_Funcionarios.java` - Hierarquia de funcionários
8. `Exercicio02_FormasGeometricas.java` - Formas geométricas
9. `Desafio_SistemaVeiculos.java` - Sistema completo

---

## 🔑 Conceitos Fundamentais

### Herança
- Classe filha herda atributos e métodos da classe pai
- Usa `extends` (Java) vs parênteses (Python)
- Java permite apenas herança simples (uma classe pai)

### Polimorfismo
```java
Animal animal1 = new Cachorro("Rex");
Animal animal2 = new Gato("Mimi");

animal1.fazerSom();  // "Au au!"
animal2.fazerSom();  // "Miau!"
```

### Super
- `super()` - chama construtor da classe pai
- `super.metodo()` - chama método da classe pai

### @Override
- Anotação que indica sobrescrita
- Ajuda a evitar erros (compilador verifica)

### Final
- `final class` - não pode ser herdada
- `final method` - não pode ser sobrescrito
- `final variable` - constante

---

## 🎓 Próxima Aula
[Aula 12 - Classes Abstratas e Interfaces](../Aula12_AbstractInterface/README.md)
