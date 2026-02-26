# Aula 05 - Arrays e Matrizes

## 📚 Objetivos
- Entender arrays em Java vs listas Python
- Trabalhar com arrays unidimensionais e multidimensionais
- Introdução ao ArrayList
- Manipular e percorrer arrays

---

## 📊 Arrays vs Listas Python

| Característica | Python List | Java Array | Java ArrayList |
|----------------|-------------|------------|----------------|
| **Tamanho** | Dinâmico | Fixo | Dinâmico |
| **Tipos** | Qualquer | Um tipo | Um tipo |
| **Declaração** | `lista = []` | `int[] arr = new int[5]` | `ArrayList<Integer> list = new ArrayList<>()` |
| **Acesso** | `lista[0]` | `arr[0]` | `list.get(0)` |

---

## 📁 Arquivos desta Aula

1. `Exemplo01_ArraysBasicos.java` - Declaração e inicialização
2. `Exemplo02_PercorrendoArrays.java` - For e for-each
3. `Exemplo03_ArraysMultidimensionais.java` - Matrizes
4. `Exemplo04_ArrayList.java` - ArrayList dinâmico
5. `Exemplo05_OperacoesArrays.java` - Busca, ordenação, etc
6. `Exercicio01_MediaNotas.java` - Calcular média
7. `Exercicio02_MaiorMenor.java` - Encontrar maior e menor
8. `Exercicio03_MatrizTransposta.java` - Transpor matriz
9. `Desafio_JogoDaVelha.java` - Jogo da velha completo

---

## 🎯 Conceitos Importantes

### Declaração de Arrays
```java
// Declarar e criar
int[] numeros = new int[5];

// Declarar e inicializar
int[] numeros = {1, 2, 3, 4, 5};

// Matriz
int[][] matriz = new int[3][3];
```

### ArrayList (mais parecido com Python)
```java
ArrayList<Integer> lista = new ArrayList<>();
lista.add(10);        // Adicionar
lista.remove(0);      // Remover por índice
int valor = lista.get(0);  // Acessar
```

---

## 🎓 Próxima Aula
[Aula 06 - Métodos e Funções](../Aula06_Metodos/README.md)
