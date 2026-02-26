# Aula 02 - Operadores e Expressões

## 📚 Objetivos da Aula
- Compreender os diferentes tipos de operadores em Java
- Dominar operadores aritméticos, relacionais e lógicos
- Entender precedência de operadores
- Comparar com operadores do Python

---

## 🔢 Operadores Aritméticos

### Java vs Python

| Operação | Python | Java | Descrição |
|----------|--------|------|-----------|
| Adição | `+` | `+` | Soma |
| Subtração | `-` | `-` | Subtração |
| Multiplicação | `*` | `*` | Multiplicação |
| Divisão | `/` | `/` | Divisão |
| Divisão inteira | `//` | *(cast para int)* | Divisão inteira |
| Módulo | `%` | `%` | Resto da divisão |
| Potência | `**` | `Math.pow()` | Potenciação |
| Incremento | `+=1` | `++` | Incremento |
| Decremento | `-=1` | `--` | Decremento |

### Arquivos desta aula:
1. `Exemplo01_OperadoresAritmeticos.java` - Operadores básicos
2. `Exemplo02_IncrementoDecremento.java` - ++ e --
3. `Exemplo03_OperadoresRelacionais.java` - Comparações
4. `Exemplo04_OperadoresLogicos.java` - &&, ||, !
5. `Exemplo05_OperadorTernario.java` - Condição inline
6. `Exercicio01_Calculadora.java` - Calculadora simples
7. `Exercicio02_ParImpar.java` - Verificação par/ímpar
8. `Desafio_ExpressoesComplexas.java` - Expressões combinadas

---

## ⚠️ Diferenças Importantes

### 1. Divisão
```python
# Python
10 / 3  # = 3.333...
10 // 3 # = 3
```

```java
// Java
10 / 3      // = 3 (divisão inteira quando ambos são int)
10.0 / 3    // = 3.333... (divisão real)
10 / 3.0    // = 3.333... (divisão real)
```

### 2. Potência
```python
# Python
2 ** 3  # = 8
```

```java
// Java
Math.pow(2, 3)  // = 8.0
```

### 3. Operadores Lógicos
```python
# Python
True and False  # False
True or False   # True
not True        # False
```

```java
// Java
true && false   // false
true || false   // true
!true           // false
```

---

## 📝 Exercícios

1. ✅ Criar calculadora com todas as operações
2. ✅ Verificar se número é par ou ímpar
3. ✅ Calcular média de 3 números
4. ✅ Verificar se ano é bissexto
5. ✅ Converter temperatura (Celsius ↔ Fahrenheit)

---

## 🎯 Próxima Aula
[Aula 03 - Estruturas Condicionais](../Aula03_Condicionais/README.md)
