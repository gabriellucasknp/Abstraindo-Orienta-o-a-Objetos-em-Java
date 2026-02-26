# Aula 14 - Collections Framework - Parte 1 (List e Set)

## 📚 Objetivos
- Dominar Collections Framework
- Trabalhar com List (ArrayList, LinkedList)
- Trabalhar com Set (HashSet, TreeSet, LinkedHashSet)
- Iterar coleções
- Comparar com estruturas Python

---

## 📦 Collections vs Python

| Java | Python | Descrição |
|------|--------|-----------|
| `ArrayList<T>` | `list` | Lista dinâmica |
| `LinkedList<T>` | `deque` | Lista encadeada |
| `HashSet<T>` | `set` | Conjunto (não ordenado) |
| `TreeSet<T>` | `sorted(set())` | Conjunto ordenado |
| `LinkedHashSet<T>` | - | Conjunto com ordem de inserção |

---

## 📁 Arquivos desta Aula

1. `Exemplo01_ArrayList.java` - ArrayList básico
2. `Exemplo02_LinkedList.java` - LinkedList
3. `Exemplo03_ComparacaoListas.java` - ArrayList vs LinkedList
4. `Exemplo04_HashSet.java` - HashSet (sem duplicatas)
5. `Exemplo05_TreeSet.java` - TreeSet (ordenado)
6. `Exemplo06_LinkedHashSet.java` - LinkedHashSet
7. `Exemplo07_Iteracao.java` - Formas de iterar
8. `Exemplo08_Comparators.java` - Ordenação personalizada
9. `Exercicio01_AgendaContatos.java` - Agenda com List
10. `Exercicio02_PalavrasUnicas.java` - Análise de texto com Set
11. `Desafio_SistemaEstoque.java` - Sistema completo

---

## 🔑 List Interface

### ArrayList:
```java
import java.util.ArrayList;

ArrayList<String> nomes = new ArrayList<>();
nomes.add("João");           // Adicionar
nomes.add(0, "Maria");       // Adicionar em posição
nomes.get(0);                // Acessar por índice
nomes.set(0, "José");        // Modificar
nomes.remove(0);             // Remover por índice
nomes.remove("João");        // Remover por valor
nomes.size();                // Tamanho
nomes.contains("Maria");     // Verificar existência
nomes.clear();               // Limpar tudo
```

### LinkedList:
```java
import java.util.LinkedList;

LinkedList<Integer> numeros = new LinkedList<>();
numeros.add(10);
numeros.addFirst(5);   // Adicionar no início
numeros.addLast(15);   // Adicionar no fim
numeros.removeFirst(); // Remover do início
numeros.removeLast();  // Remover do fim
```

### Quando usar cada uma?
- **ArrayList**: Acesso por índice frequente
- **LinkedList**: Muitas inserções/remoções no início/meio

---

## 🔑 Set Interface

### HashSet (mais rápido):
```java
import java.util.HashSet;

HashSet<String> frutas = new HashSet<>();
frutas.add("Maçã");
frutas.add("Banana");
frutas.add("Maçã");  // Não adiciona (duplicata)
System.out.println(frutas.size());  // 2
```

### TreeSet (ordenado):
```java
import java.util.TreeSet;

TreeSet<Integer> numeros = new TreeSet<>();
numeros.add(5);
numeros.add(2);
numeros.add(8);
// Ordem: [2, 5, 8]
```

### LinkedHashSet (mantém ordem de inserção):
```java
import java.util.LinkedHashSet;

LinkedHashSet<String> palavras = new LinkedHashSet<>();
palavras.add("Java");
palavras.add("Python");
palavras.add("C++");
// Ordem: [Java, Python, C++]
```

---

## 🔄 Formas de Iterar

```java
ArrayList<String> lista = new ArrayList<>();
// ... adicionar elementos

// 1. For tradicional
for (int i = 0; i < lista.size(); i++) {
    System.out.println(lista.get(i));
}

// 2. For-each
for (String item : lista) {
    System.out.println(item);
}

// 3. Iterator
Iterator<String> it = lista.iterator();
while (it.hasNext()) {
    System.out.println(it.next());
}

// 4. forEach com lambda (Java 8+)
lista.forEach(item -> System.out.println(item));

// 5. Stream (Java 8+)
lista.stream().forEach(System.out::println);
```

---

## 🎓 Próxima Aula
[Aula 15 - Collections Framework - Parte 2](../Aula15_Collections2/README.md)
