# Aula 19 - Enums e Records (Java Moderno)

## 📚 Objetivos
- Criar e usar Enumerações (Enums)
- Trabalhar com Records (Java 14+)
- Entender pattern matching
- Sealed classes (Java 17+)
- Comparar com Python

---

## 📋 Enums

### Python:
```python
from enum import Enum

class DiaSemana(Enum):
    SEGUNDA = 1
    TERCA = 2
    QUARTA = 3
```

### Java:
```java
public enum DiaSemana {
    SEGUNDA, TERCA, QUARTA, QUINTA, SEXTA, SABADO, DOMINGO
}

// Usar:
DiaSemana dia = DiaSemana.SEGUNDA;
System.out.println(dia);  // SEGUNDA
```

---

## 📁 Arquivos desta Aula

1. `Exemplo01_EnumBasico.java` - Enum simples
2. `Exemplo02_EnumComMetodos.java` - Enum com comportamento
3. `Exemplo03_EnumComConstrutores.java` - Enum com atributos
4. `Exemplo04_RecordBasico.java` - Record simples (Java 14+)
5. `Exemplo05_RecordAvancado.java` - Record com métodos
6. `Exemplo06_SealedClass.java` - Sealed classes (Java 17+)
7. `Exercicio01_StatusPedido.java` - Enum para status
8. `Exercicio02_Coordenadas.java` - Record para dados
9. `Desafio_SistemaPedidos.java` - Sistema completo

---

## 🔢 Enumerações

### Enum Básico:
```java
public enum StatusPedido {
    PENDENTE,
    PROCESSANDO,
    ENVIADO,
    ENTREGUE,
    CANCELADO
}

// Usar:
StatusPedido status = StatusPedido.PENDENTE;

// Comparar
if (status == StatusPedido.PENDENTE) {
    System.out.println("Aguardando processamento");
}

// Switch
switch (status) {
    case PENDENTE:
        System.out.println("Pendente");
        break;
    case PROCESSANDO:
        System.out.println("Processando");
        break;
    // ...
}

// Iterar todos os valores
for (StatusPedido s : StatusPedido.values()) {
    System.out.println(s);
}
```

### Enum com Atributos e Métodos:
```java
public enum Planeta {
    MERCURIO(3.303e+23, 2.4397e6),
    VENUS(4.869e+24, 6.0518e6),
    TERRA(5.976e+24, 6.37814e6),
    MARTE(6.421e+23, 3.3972e6);
    
    private final double massa;  // em kg
    private final double raio;   // em metros
    
    // Construtor (sempre private)
    Planeta(double massa, double raio) {
        this.massa = massa;
        this.raio = raio;
    }
    
    public double getMassa() { return massa; }
    public double getRaio() { return raio; }
    
    // Método
    public double gravidadeSuperficial() {
        final double G = 6.67300E-11;
        return G * massa / (raio * raio);
    }
}

// Usar:
Planeta p = Planeta.TERRA;
System.out.println("Massa: " + p.getMassa());
System.out.println("Gravidade: " + p.gravidadeSuperficial());
```

### Enum com Métodos Abstratos:
```java
public enum Operacao {
    SOMA {
        @Override
        public double aplicar(double x, double y) {
            return x + y;
        }
    },
    SUBTRACAO {
        @Override
        public double aplicar(double x, double y) {
            return x - y;
        }
    },
    MULTIPLICACAO {
        @Override
        public double aplicar(double x, double y) {
            return x * y;
        }
    },
    DIVISAO {
        @Override
        public double aplicar(double x, double y) {
            return x / y;
        }
    };
    
    public abstract double aplicar(double x, double y);
}

// Usar:
double resultado = Operacao.SOMA.aplicar(5, 3);  // 8.0
```

---

## 📦 Records (Java 14+)

### O que são Records?
Classes imutáveis para armazenar dados (similar a dataclasses Python ou NamedTuple).

### Python (dataclass):
```python
from dataclasses import dataclass

@dataclass
class Pessoa:
    nome: str
    idade: int
```

### Java (Record):
```java
public record Pessoa(String nome, int idade) {
    // Construtor, getters, equals, hashCode e toString
    // são gerados automaticamente!
}

// Usar:
Pessoa p = new Pessoa("João", 25);
System.out.println(p.nome());   // Acesso automático
System.out.println(p.idade());
System.out.println(p);  // toString automático
```

### Record com Validação:
```java
public record Pessoa(String nome, int idade) {
    // Construtor compacto (validação)
    public Pessoa {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome inválido");
        }
        if (idade < 0 || idade > 150) {
            throw new IllegalArgumentException("Idade inválida");
        }
    }
}
```

### Record com Métodos Adicionais:
```java
public record Ponto(double x, double y) {
    // Método adicional
    public double distanciaOrigem() {
        return Math.sqrt(x * x + y * y);
    }
    
    // Método estático
    public static Ponto origem() {
        return new Ponto(0, 0);
    }
}

// Usar:
Ponto p = new Ponto(3, 4);
System.out.println(p.distanciaOrigem());  // 5.0
```

---

## 🔒 Sealed Classes (Java 17+)

### O que são?
Classes que controlam quem pode estendê-las ou implementá-las.

```java
// Classe selada
public sealed class Forma
    permits Circulo, Quadrado, Triangulo {
    // ...
}

// Apenas estas classes podem estender Forma
public final class Circulo extends Forma {
    // final = não pode ser estendida
}

public final class Quadrado extends Forma {
    // ...
}

public non-sealed class Triangulo extends Forma {
    // non-sealed = pode ser estendida por qualquer um
}
```

### Pattern Matching com Sealed Classes:
```java
public static double calcularArea(Forma forma) {
    return switch (forma) {
        case Circulo c -> Math.PI * c.getRaio() * c.getRaio();
        case Quadrado q -> q.getLado() * q.getLado();
        case Triangulo t -> t.getBase() * t.getAltura() / 2;
        // Não precisa de default - compilador sabe que cobriu todos!
    };
}
```

---

## 🎯 Switch Expressions (Java 14+)

### Antes (switch statement):
```java
String resultado;
switch (dia) {
    case SEGUNDA:
    case TERCA:
    case QUARTA:
    case QUINTA:
    case SEXTA:
        resultado = "Dia útil";
        break;
    case SABADO:
    case DOMINGO:
        resultado = "Fim de semana";
        break;
    default:
        resultado = "Inválido";
}
```

### Depois (switch expression):
```java
String resultado = switch (dia) {
    case SEGUNDA, TERCA, QUARTA, QUINTA, SEXTA -> "Dia útil";
    case SABADO, DOMINGO -> "Fim de semana";
};
// Sem break! Sem variável temporária!
```

---

## 📊 Benefícios

### Enums:
- ✅ Type-safe (seguro em compilação)
- ✅ Podem ter métodos e atributos
- ✅ Namespace próprio
- ✅ Podem implementar interfaces

### Records:
- ✅ Código conciso
- ✅ Imutáveis por padrão
- ✅ Equals/hashCode automático
- ✅ Perfeito para DTOs (Data Transfer Objects)

### Sealed Classes:
- ✅ Controle de hierarquia
- ✅ Pattern matching exhaustivo
- ✅ Melhor modelagem de domínio

---

## 🎓 Próxima Aula
[Aula 20 - Projeto Prático: Sistema Bancário](../Aula20_ProjetoBanco/README.md)
