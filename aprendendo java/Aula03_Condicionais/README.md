# Aula 03 - Estruturas Condicionais

## 📚 Objetivos
- Dominar if, else if, else
- Entender o operador ternário
- Aprender switch tradicional e moderno (Java 14+)
- Comparar com estruturas condicionais do Python

---

## 🔀 Estruturas Condicionais

### Python vs Java

**Python:**
```python
if condicao:
    # código
elif outra_condicao:
    # código
else:
    # código
```

**Java:**
```java
if (condicao) {
    // código
} else if (outraCondicao) {
    // código
} else {
    // código
}
```

### Diferenças Principais:
- Java usa **parênteses** `()` na condição
- Java usa **chaves** `{}` no bloco
- Java usa `else if` (duas palavras)
- Python usa `elif` (uma palavra)

---

## 📁 Arquivos desta Aula

1. `Exemplo01_IfElse.java` - Estruturas básicas
2. `Exemplo02_IfAninhado.java` - If dentro de if
3. `Exemplo03_OperadorTernario.java` - Condição inline
4. `Exemplo04_Switch.java` - Switch tradicional
5. `Exemplo05_SwitchModerno.java` - Switch expressions (Java 14+)
6. `Exercicio01_CalculadoraNotas.java` - Sistema de notas
7. `Exercicio02_CalculadoraIMC.java` - Classificação IMC
8. `Desafio_SistemaLogin.java` - Sistema de login completo

---

## 🎯 Conceitos Importantes

### Operador Ternário
```java
variavel = (condicao) ? valorSeTrue : valorSeFalse;
```

### Switch Expressions (Java 14+)
```java
String resultado = switch (valor) {
    case 1 -> "Um";
    case 2 -> "Dois";
    default -> "Outro";
};
```

---

## 🎓 Próxima Aula
[Aula 04 - Estruturas de Repetição](../Aula04_Repeticao/README.md)
