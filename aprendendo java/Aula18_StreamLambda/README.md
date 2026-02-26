# Aula 18 - Stream API e Expressões Lambda (Java 8+)

## 📚 Objetivos
- Dominar expressões lambda
- Usar Stream API
- Entender programação funcional em Java
- Map, filter, reduce e collectors
- Comparar com Python

---

## 🔥 Lambda: Java vs Python

### Python:
```python
# Lambda
quadrado = lambda x: x ** 2

# Map
numeros = [1, 2, 3, 4, 5]
quadrados = list(map(lambda x: x ** 2, numeros))

# Filter
pares = list(filter(lambda x: x % 2 == 0, numeros))

# Reduce
from functools import reduce
soma = reduce(lambda a, b: a + b, numeros)
```

### Java:
```java
// Lambda
Function<Integer, Integer> quadrado = x -> x * x;

// Stream API
List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5);

// Map
List<Integer> quadrados = numeros.stream()
    .map(x -> x * x)
    .collect(Collectors.toList());

// Filter
List<Integer> pares = numeros.stream()
    .filter(x -> x % 2 == 0)
    .collect(Collectors.toList());

// Reduce
int soma = numeros.stream()
    .reduce(0, (a, b) -> a + b);
```

---

## 📁 Arquivos desta Aula

1. `Exemplo01_LambdasBasico.java` - Expressões lambda
2. `Exemplo02_InterfacesFuncionais.java` - Functional interfaces
3. `Exemplo03_StreamBasico.java` - Stream API básica
4. `Exemplo04_MapFilterReduce.java` - Operações principais
5. `Exemplo05_Collectors.java` - Coletar resultados
6. `Exemplo06_StreamAvancado.java` - Operações avançadas
7. `Exemplo07_MethodReference.java` - Referência a métodos
8. `Exercicio01_ProcessarLista.java` - Processar dados
9. `Exercicio02_EstatisticasStream.java` - Análise de dados
10. `Desafio_ProcessadorPedidos.java` - Sistema completo

---

## λ Expressões Lambda

### Sintaxe:
```java
// Sem parâmetros
() -> System.out.println("Olá")

// Um parâmetro (parênteses opcionais)
x -> x * 2
(x) -> x * 2

// Múltiplos parâmetros
(x, y) -> x + y

// Com corpo de bloco
(x, y) -> {
    int resultado = x + y;
    return resultado;
}
```

### Interfaces Funcionais:
```java
// Predicate<T> - retorna boolean
Predicate<Integer> ehPar = x -> x % 2 == 0;
System.out.println(ehPar.test(4));  // true

// Function<T, R> - transforma T em R
Function<String, Integer> tamanho = s -> s.length();
System.out.println(tamanho.apply("Java"));  // 4

// Consumer<T> - consome T sem retornar
Consumer<String> imprimir = s -> System.out.println(s);
imprimir.accept("Olá");

// Supplier<T> - fornece T
Supplier<Double> aleatorio = () -> Math.random();
System.out.println(aleatorio.get());
```

---

## 🌊 Stream API

### Criar Streams:
```java
// De coleção
List<String> lista = Arrays.asList("a", "b", "c");
Stream<String> stream1 = lista.stream();

// De array
String[] array = {"a", "b", "c"};
Stream<String> stream2 = Arrays.stream(array);

// Diretamente
Stream<String> stream3 = Stream.of("a", "b", "c");

// Range
IntStream numeros = IntStream.range(1, 10);  // 1 a 9
```

### Operações Intermediárias (retornam Stream):
```java
List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);

// Filter - filtrar
List<Integer> pares = numeros.stream()
    .filter(n -> n % 2 == 0)
    .collect(Collectors.toList());

// Map - transformar
List<Integer> dobrados = numeros.stream()
    .map(n -> n * 2)
    .collect(Collectors.toList());

// Sorted - ordenar
List<Integer> ordenados = numeros.stream()
    .sorted()
    .collect(Collectors.toList());

// Distinct - remover duplicatas
List<Integer> unicos = numeros.stream()
    .distinct()
    .collect(Collectors.toList());

// Limit - limitar quantidade
List<Integer> primeiros3 = numeros.stream()
    .limit(3)
    .collect(Collectors.toList());

// Skip - pular elementos
List<Integer> semPrimeiros2 = numeros.stream()
    .skip(2)
    .collect(Collectors.toList());
```

### Operações Terminais (retornam resultado):
```java
List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5);

// forEach - iterar
numeros.stream().forEach(n -> System.out.println(n));

// collect - coletar em coleção
List<Integer> lista = numeros.stream().collect(Collectors.toList());

// reduce - reduzir a um valor
int soma = numeros.stream().reduce(0, (a, b) -> a + b);
Optional<Integer> max = numeros.stream().reduce(Integer::max);

// count - contar
long quantidade = numeros.stream().count();

// anyMatch / allMatch / noneMatch
boolean temPar = numeros.stream().anyMatch(n -> n % 2 == 0);
boolean todosPares = numeros.stream().allMatch(n -> n % 2 == 0);
boolean naoTemNegativo = numeros.stream().noneMatch(n -> n < 0);

// findFirst / findAny
Optional<Integer> primeiro = numeros.stream().findFirst();
Optional<Integer> qualquer = numeros.stream().findAny();

// min / max
Optional<Integer> minimo = numeros.stream().min(Integer::compareTo);
Optional<Integer> maximo = numeros.stream().max(Integer::compareTo);
```

---

## 🎯 Exemplo Completo:
```java
class Pessoa {
    String nome;
    int idade;
    // construtor, getters...
}

List<Pessoa> pessoas = Arrays.asList(
    new Pessoa("João", 25),
    new Pessoa("Maria", 30),
    new Pessoa("Pedro", 20),
    new Pessoa("Ana", 35)
);

// Filtrar pessoas com mais de 25 anos,
// ordenar por nome,
// pegar os 2 primeiros,
// coletar os nomes
List<String> resultado = pessoas.stream()
    .filter(p -> p.getIdade() > 25)
    .sorted((p1, p2) -> p1.getNome().compareTo(p2.getNome()))
    .limit(2)
    .map(Pessoa::getNome)
    .collect(Collectors.toList());
```

---

## 📦 Collectors

```java
List<String> nomes = Arrays.asList("João", "Maria", "Pedro");

// Para List
List<String> lista = nomes.stream().collect(Collectors.toList());

// Para Set
Set<String> set = nomes.stream().collect(Collectors.toSet());

// Joining (concatenar)
String junto = nomes.stream().collect(Collectors.joining(", "));
// "João, Maria, Pedro"

// Grouping By
Map<Integer, List<String>> porTamanho = nomes.stream()
    .collect(Collectors.groupingBy(String::length));

// Partitioning By (true/false)
Map<Boolean, List<Integer>> nums = Arrays.asList(1,2,3,4,5).stream()
    .collect(Collectors.partitioningBy(n -> n % 2 == 0));

// Counting
Long count = nomes.stream().collect(Collectors.counting());

// Statistics
IntSummaryStatistics stats = Arrays.asList(1,2,3,4,5).stream()
    .collect(Collectors.summarizingInt(Integer::intValue));
System.out.println("Média: " + stats.getAverage());
```

---

## 🔗 Method Reference

```java
// Referência a método estático
Function<String, Integer> parseInt1 = s -> Integer.parseInt(s);
Function<String, Integer> parseInt2 = Integer::parseInt;  // Equivalente

// Referência a método de instância
Consumer<String> print1 = s -> System.out.println(s);
Consumer<String> print2 = System.out::println;  // Equivalente

// Referência a construtor
Supplier<ArrayList<String>> list1 = () -> new ArrayList<>();
Supplier<ArrayList<String>> list2 = ArrayList::new;  // Equivalente
```

---

## 🎓 Próxima Aula
[Aula 19 - Enums e Records](../Aula19_EnumsRecords/README.md)
