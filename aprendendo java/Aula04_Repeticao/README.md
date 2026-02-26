# Aula 04 - Estruturas de Repetição

## 📚 Objetivos
- Dominar while, do-while e for
- Entender for-each (enhanced for)
- Usar break e continue corretamente
- Trabalhar com loops aninhados

---

## 🔁 Estruturas de Repetição

### Python vs Java

| Estrutura | Python | Java |
|-----------|--------|------|
| **While** | `while condicao:` | `while (condicao) { }` |
| **For range** | `for i in range(10):` | `for (int i = 0; i < 10; i++) { }` |
| **For each** | `for item in lista:` | `for (tipo item : array) { }` |
| **Do-while** | *(não existe)* | `do { } while (condicao);` |

---

## 📁 Arquivos desta Aula

1. `Exemplo01_While.java` - Loop while básico
2. `Exemplo02_DoWhile.java` - Do-while (executa pelo menos uma vez)
3. `Exemplo03_For.java` - Loop for tradicional
4. `Exemplo04_ForEach.java` - Enhanced for
5. `Exemplo05_BreakContinue.java` - Controle de loops
6. `Exemplo06_LoopsAninhados.java` - Loops dentro de loops
7. `Exercicio01_Tabuada.java` - Gerador de tabuada
8. `Exercicio02_Fibonacci.java` - Sequência de Fibonacci
9. `Desafio_JogoAdivinhacao.java` - Jogo interativo

---

## 🎯 Conceitos Importantes

### For Tradicional (Java)
```java
for (inicializacao; condicao; incremento) {
    // código
}
```

### Do-While (não existe em Python)
```java
do {
    // executa pelo menos uma vez
} while (condicao);
```

### Break vs Continue
- **break**: sai completamente do loop
- **continue**: pula para a próxima iteração

---

## 🎓 Próxima Aula
[Aula 05 - Arrays e Matrizes](../Aula05_Arrays/README.md)
