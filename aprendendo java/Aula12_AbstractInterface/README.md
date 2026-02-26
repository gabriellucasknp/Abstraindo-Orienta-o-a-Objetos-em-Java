# Aula 12 - Classes Abstratas e Interfaces

## 📚 Objetivos
- Entender classes abstratas
- Dominar interfaces
- Saber quando usar cada uma
- Implementação múltipla com interfaces
- Comparar com Python (ABC e duck typing)

---

## 🎨 Classes Abstratas vs Interfaces

### Classe Abstrata:
```java
public abstract class Forma {
    protected String cor;
    
    public abstract double calcularArea();  // Método abstrato
    
    public void setCor(String cor) {  // Método concreto
        this.cor = cor;
    }
}

public class Circulo extends Forma {
    private double raio;
    
    @Override
    public double calcularArea() {
        return Math.PI * raio * raio;
    }
}
```

### Interface:
```java
public interface Desenhavel {
    void desenhar();  // Público e abstrato por padrão
    void colorir(String cor);
}

public class Quadrado implements Desenhavel {
    @Override
    public void desenhar() {
        System.out.println("Desenhando quadrado");
    }
    
    @Override
    public void colorir(String cor) {
        System.out.println("Colorindo de " + cor);
    }
}
```

---

## 📁 Arquivos desta Aula

1. `Exemplo01_ClasseAbstrata.java` - Classes abstratas
2. `Exemplo02_Interface.java` - Interfaces básicas
3. `Exemplo03_ImplementacaoMultipla.java` - Múltiplas interfaces
4. `Exemplo04_DefaultMethods.java` - Métodos default (Java 8+)
5. `Exemplo05_ComparacaoAbstractInterface.java` - Quando usar
6. `Exercicio01_SistemaAnimais.java` - Hierarquia com abstract
7. `Exercicio02_Pagamentos.java` - Interfaces de pagamento
8. `Desafio_SistemaGrafico.java` - Sistema completo

---

## 🔑 Diferenças Principais

| Aspecto | Classe Abstrata | Interface |
|---------|----------------|-----------|
| **Herança** | Simples (1 pai) | Múltipla |
| **Métodos** | Abstratos + Concretos | Abstratos (+ default) |
| **Atributos** | Qualquer tipo | public static final |
| **Construtor** | Sim | Não |
| **Palavra-chave** | `extends` | `implements` |

---

## 🎯 Quando Usar?

### Use Classe Abstrata quando:
- Quer compartilhar código entre classes relacionadas
- Precisa de atributos não-estáticos
- Precisa de métodos private ou protected
- Classes são relacionadas hierarquicamente

### Use Interface quando:
- Quer especificar comportamento sem implementação
- Precisa de implementação múltipla
- Classes não relacionadas precisam do mesmo comportamento
- Quer definir um contrato

---

## 💡 Default Methods (Java 8+)

```java
public interface Voador {
    void voar();
    
    // Método default (com implementação)
    default void pousar() {
        System.out.println("Pousando...");
    }
}
```

---

## 🐍 Comparação com Python

**Python** usa ABC (Abstract Base Classes) e "duck typing":
```python
from abc import ABC, abstractmethod

class Animal(ABC):
    @abstractmethod
    def fazer_som(self):
        pass
```

**Java** é mais rígido e enforçado em tempo de compilação.

---

## 🎓 Próxima Aula
[Aula 13 - Exceções](../Aula13_Excecoes/README.md)
