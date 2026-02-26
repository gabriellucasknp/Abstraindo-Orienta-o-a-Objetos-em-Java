# Aula 16 - Generics (Tipos Genéricos)

## 📚 Objetivos
- Entender Generics em Java
- Criar classes e métodos genéricos
- Usar bounded types
- Trabalhar com wildcards
- Comparar com Python (tipagem dinâmica)

---

## 🎯 Por que Generics?

### Sem Generics (Java antigo):
```java
ArrayList lista = new ArrayList();
lista.add("String");
lista.add(123);  // Aceita qualquer coisa!

String s = (String) lista.get(0);  // Cast necessário
String s2 = (String) lista.get(1); // ERRO em runtime!
```

### Com Generics:
```java
ArrayList<String> lista = new ArrayList<>();
lista.add("String");
// lista.add(123);  // ERRO em compile-time!

String s = lista.get(0);  // Sem cast necessário
```

---

## 📁 Arquivos desta Aula

1. `Exemplo01_GenericsBasico.java` - Conceitos básicos
2. `Exemplo02_ClasseGenerica.java` - Criar classe genérica
3. `Exemplo03_MetodoGenerico.java` - Métodos genéricos
4. `Exemplo04_BoundedTypes.java` - Tipos limitados
5. `Exemplo05_Wildcards.java` - Curingas (?, extends, super)
6. `Exemplo06_GenericsMultiplos.java` - Múltiplos tipos
7. `Exercicio01_Caixa.java` - Classe Box genérica
8. `Exercicio02_Par.java` - Par de valores
9. `Desafio_RepositorioGenerico.java` - CRUD genérico

---

## 🔧 Classe Genérica

```java
// Classe genérica com tipo T
public class Caixa<T> {
    private T conteudo;
    
    public void colocar(T item) {
        this.conteudo = item;
    }
    
    public T retirar() {
        return this.conteudo;
    }
}

// Uso:
Caixa<String> caixaTexto = new Caixa<>();
caixaTexto.colocar("Java");
String texto = caixaTexto.retirar();

Caixa<Integer> caixaNumero = new Caixa<>();
caixaNumero.colocar(123);
Integer numero = caixaNumero.retirar();
```

---

## 🔨 Método Genérico

```java
public class Utilidades {
    // Método genérico
    public static <T> void imprimir(T item) {
        System.out.println(item);
    }
    
    // Método genérico com retorno
    public static <T> T obterPrimeiro(T[] array) {
        return array[0];
    }
}

// Uso:
Utilidades.imprimir("Texto");
Utilidades.imprimir(123);
Utilidades.imprimir(3.14);

String[] nomes = {"João", "Maria"};
String primeiro = Utilidades.obterPrimeiro(nomes);
```

---

## 🎯 Bounded Types (Tipos Limitados)

```java
// T deve ser Number ou subclasse
public class CalculadoraNumerica<T extends Number> {
    public double somar(T a, T b) {
        return a.doubleValue() + b.doubleValue();
    }
}

// Uso:
CalculadoraNumerica<Integer> calcInt = new CalculadoraNumerica<>();
calcInt.somar(5, 10);

CalculadoraNumerica<Double> calcDouble = new CalculadoraNumerica<>();
calcDouble.somar(5.5, 10.3);

// CalculadoraNumerica<String> calc = ...  // ERRO! String não é Number
```

---

## ❓ Wildcards (Curingas)

### Unbounded Wildcard `<?>`
```java
public void imprimirLista(List<?> lista) {
    for (Object item : lista) {
        System.out.println(item);
    }
}
```

### Upper Bounded `<? extends Tipo>`
```java
// Aceita Number e subclasses (Integer, Double, etc)
public double somar(List<? extends Number> numeros) {
    double soma = 0;
    for (Number num : numeros) {
        soma += num.doubleValue();
    }
    return soma;
}

List<Integer> ints = Arrays.asList(1, 2, 3);
List<Double> doubles = Arrays.asList(1.5, 2.5);
somar(ints);     // OK
somar(doubles);  // OK
```

### Lower Bounded `<? super Tipo>`
```java
// Aceita Integer e superclasses (Number, Object)
public void adicionarNumeros(List<? super Integer> lista) {
    lista.add(1);
    lista.add(2);
    lista.add(3);
}

List<Number> numbers = new ArrayList<>();
List<Object> objects = new ArrayList<>();
adicionarNumeros(numbers);  // OK
adicionarNumeros(objects);  // OK
```

---

## 🔑 Múltiplos Tipos Genéricos

```java
public class Par<K, V> {
    private K chave;
    private V valor;
    
    public Par(K chave, V valor) {
        this.chave = chave;
        this.valor = valor;
    }
    
    public K getChave() { return chave; }
    public V getValor() { return valor; }
}

// Uso:
Par<String, Integer> par1 = new Par<>("idade", 25);
Par<Integer, String> par2 = new Par<>(1, "Primeiro");
```

---

## 📝 Convenções de Nomenclatura

- **E** - Element (usado em collections)
- **K** - Key
- **V** - Value
- **N** - Number
- **T** - Type
- **S, U, V** etc. - 2º, 3º, 4º tipos

---

## 🐍 Comparação com Python

Python não tem Generics nativos (usa duck typing):
```python
# Python aceita qualquer tipo
def imprimir(item):
    print(item)

# Type hints (Python 3.5+) são apenas sugestões
from typing import TypeVar, Generic

T = TypeVar('T')

class Caixa(Generic[T]):
    def __init__(self, conteudo: T):
        self.conteudo = conteudo
```

Java enforça tipos em compile-time, Python em runtime (ou não enforça).

---

## 🎓 Próxima Aula
[Aula 17 - Arquivos e I/O](../Aula17_Arquivos/README.md)
