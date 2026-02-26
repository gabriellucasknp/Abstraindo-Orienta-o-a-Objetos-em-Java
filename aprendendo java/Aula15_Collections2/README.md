# Aula 15 - Collections Framework - Parte 2 (Map, Queue, Stack)

## 📚 Objetivos
- Dominar Map (HashMap, TreeMap, LinkedHashMap)
- Trabalhar com Queue e Deque
- Usar Stack
- Operações avançadas com Collections

---

## 🗺️ Map vs Python Dict

### Python:
```python
pessoa = {
    "nome": "João",
    "idade": 25
}
pessoa["nome"]  # Acessar
pessoa["email"] = "joao@email.com"  # Adicionar
```

### Java:
```java
HashMap<String, Object> pessoa = new HashMap<>();
pessoa.put("nome", "João");
pessoa.put("idade", 25);
pessoa.get("nome");  // Acessar
pessoa.put("email", "joao@email.com");  // Adicionar
```

---

## 📁 Arquivos desta Aula

1. `Exemplo01_HashMap.java` - HashMap básico
2. `Exemplo02_TreeMap.java` - TreeMap ordenado
3. `Exemplo03_LinkedHashMap.java` - LinkedHashMap
4. `Exemplo04_Queue.java` - Fila (Queue)
5. `Exemplo05_Deque.java` - Deque (fila dupla)
6. `Exemplo06_Stack.java` - Pilha
7. `Exemplo07_CollectionsUtility.java` - Métodos utilitários
8. `Exercicio01_Dicionario.java` - Dicionário de palavras
9. `Exercicio02_AtendimentoFila.java` - Sistema de fila
10. `Desafio_CacheMemoria.java` - Sistema de cache

---

## 🗺️ Map Interface

### HashMap (mais usado):
```java
import java.util.HashMap;

HashMap<String, Integer> idades = new HashMap<>();
idades.put("João", 25);
idades.put("Maria", 30);
idades.put("Pedro", 28);

// Acessar
int idade = idades.get("João");  // 25

// Verificar
boolean existe = idades.containsKey("Maria");  // true

// Remover
idades.remove("Pedro");

// Iterar
for (String nome : idades.keySet()) {
    System.out.println(nome + ": " + idades.get(nome));
}

// Ou com Entry
for (Map.Entry<String, Integer> entry : idades.entrySet()) {
    System.out.println(entry.getKey() + ": " + entry.getValue());
}
```

### TreeMap (chaves ordenadas):
```java
import java.util.TreeMap;

TreeMap<String, String> capitais = new TreeMap<>();
capitais.put("Brasil", "Brasília");
capitais.put("Argentina", "Buenos Aires");
// Ordenado por chave alfabeticamente
```

### LinkedHashMap (mantém ordem de inserção):
```java
import java.util.LinkedHashMap;

LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
// Mantém ordem de inserção
```

---

## 📋 Queue (Fila - FIFO)

```java
import java.util.Queue;
import java.util.LinkedList;

Queue<String> fila = new LinkedList<>();
fila.offer("Primeiro");  // Adicionar (offer é mais seguro que add)
fila.offer("Segundo");
fila.offer("Terceiro");

String primeiro = fila.poll();  // Remove e retorna (null se vazia)
String proximo = fila.peek();   // Apenas visualiza (não remove)
```

---

## 🔄 Deque (Fila Dupla)

```java
import java.util.Deque;
import java.util.ArrayDeque;

Deque<Integer> deque = new ArrayDeque<>();
deque.offerFirst(1);  // Adicionar no início
deque.offerLast(2);   // Adicionar no fim
deque.pollFirst();    // Remover do início
deque.pollLast();     // Remover do fim
```

---

## 📚 Stack (Pilha - LIFO)

```java
import java.util.Stack;

Stack<String> pilha = new Stack<>();
pilha.push("A");  // Empilhar
pilha.push("B");
pilha.push("C");

String topo = pilha.pop();   // Desempilhar (remove)
String ver = pilha.peek();   // Ver topo (não remove)
boolean vazia = pilha.isEmpty();
```

---

## 🛠️ Collections Utility Class

```java
import java.util.Collections;
import java.util.ArrayList;

ArrayList<Integer> numeros = new ArrayList<>();
// ... adicionar elementos

// Ordenar
Collections.sort(numeros);

// Reverter
Collections.reverse(numeros);

// Embaralhar
Collections.shuffle(numeros);

// Máximo e mínimo
int max = Collections.max(numeros);
int min = Collections.min(numeros);

// Frequência
int freq = Collections.frequency(numeros, 5);

// Preencher
Collections.fill(numeros, 0);

// Lista imutável
List<String> imutavel = Collections.unmodifiableList(lista);
```

---

## 📊 Resumo das Collections

| Tipo | Ordenado | Duplicatas | Null | Uso |
|------|----------|------------|------|-----|
| **ArrayList** | Inserção | Sim | Sim | Lista geral |
| **LinkedList** | Inserção | Sim | Sim | Inserções frequentes |
| **HashSet** | Não | Não | Sim (1) | Elementos únicos |
| **TreeSet** | Natural | Não | Não | Únicos ordenados |
| **HashMap** | Não | Valores sim | Sim | Chave-valor geral |
| **TreeMap** | Por chave | Valores sim | Não | Chave-valor ordenado |
| **Queue** | FIFO | Sim | Depende | Fila |
| **Stack** | LIFO | Sim | Sim | Pilha |

---

## 🎓 Próxima Aula
[Aula 16 - Generics](../Aula16_Generics/README.md)
