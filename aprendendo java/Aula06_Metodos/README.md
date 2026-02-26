# Aula 06 - Métodos e Funções

## 📚 Objetivos
- Entender métodos em Java vs funções Python
- Criar métodos com e sem retorno
- Trabalhar com parâmetros
- Entender sobrecarga de métodos
- Compreender escopo de variáveis

---

## 🔧 Métodos vs Funções Python

### Python (Função):
```python
def somar(a, b):
    return a + b

resultado = somar(5, 3)
```

### Java (Método):
```java
public static int somar(int a, int b) {
    return a + b;
}

int resultado = somar(5, 3);
```

---

## 📁 Arquivos desta Aula

1. `Exemplo01_MetodosBasicos.java` - Métodos simples
2. `Exemplo02_MetodosComRetorno.java` - Return
3. `Exemplo03_MetodosSemRetorno.java` - Void
4. `Exemplo04_Parametros.java` - Passagem de parâmetros
5. `Exemplo05_Sobrecarga.java` - Overloading
6. `Exemplo06_Escopo.java` - Variáveis locais e de classe
7. `Exemplo07_Recursividade.java` - Métodos recursivos
8. `Exercicio01_Calculadora.java` - Calculadora com métodos
9. `Exercicio02_ValidadorCPF.java` - Validador
10. `Desafio_BibliotecaMatematica.java` - Biblioteca completa

---

## 🎯 Conceitos Importantes

### Assinatura de Método
```java
modificador tipoRetorno nomeMetodo(parametros) {
    // corpo
    return valor; // se não for void
}
```

### Sobrecarga (Overloading)
```java
// Mesmo nome, parâmetros diferentes
int somar(int a, int b) { }
double somar(double a, double b) { }
int somar(int a, int b, int c) { }
```

### Diferenças importantes:
- Java precisa de **tipo de retorno** explícito
- Java tem **sobrecarga** (Python usa *args/**kwargs)
- Java diferencia **void** (sem retorno) de métodos com retorno

---

## 🎓 Próxima Aula
[Aula 07 - Strings e Manipulação](../Aula07_Strings/README.md)
