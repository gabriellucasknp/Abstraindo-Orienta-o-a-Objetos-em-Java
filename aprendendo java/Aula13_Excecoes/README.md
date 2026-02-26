# Aula 13 - Exceções e Tratamento de Erros

## 📚 Objetivos
- Entender o sistema de exceções em Java
- Usar try-catch-finally
- Criar exceções personalizadas
- Entender checked vs unchecked exceptions
- Comparar com Python

---

## ⚠️ Exceções: Java vs Python

### Python:
```python
try:
    resultado = 10 / 0
except ZeroDivisionError as e:
    print(f"Erro: {e}")
finally:
    print("Sempre executa")
```

### Java:
```java
try {
    int resultado = 10 / 0;
} catch (ArithmeticException e) {
    System.out.println("Erro: " + e.getMessage());
} finally {
    System.out.println("Sempre executa");
}
```

---

## 📁 Arquivos desta Aula

1. `Exemplo01_TryCatch.java` - Try-catch básico
2. `Exemplo02_MultiplasExcecoes.java` - Múltiplos catches
3. `Exemplo03_Finally.java` - Bloco finally
4. `Exemplo04_ThrowThrows.java` - Lançar exceções
5. `Exemplo05_ExcecoesPersonalizadas.java` - Criar exceções
6. `Exemplo06_TryWithResources.java` - Try-with-resources
7. `Exercicio01_ValidadorIdade.java` - Validação com exceções
8. `Exercicio02_SistemaLogin.java` - Sistema com tratamento
9. `Desafio_SistemaBancarioSeguro.java` - Sistema robusto

---

## 🔑 Conceitos Fundamentais

### Hierarquia de Exceções:
```
Throwable
├── Error (erros do sistema - não tratar)
└── Exception
    ├── RuntimeException (unchecked)
    │   ├── NullPointerException
    │   ├── ArrayIndexOutOfBoundsException
    │   └── ArithmeticException
    └── IOException (checked)
        ├── FileNotFoundException
        └── SQLException
```

### Checked vs Unchecked:

**Checked** (obrigatório tratar):
```java
public void lerArquivo() throws IOException {
    FileReader fr = new FileReader("arquivo.txt");
    // Deve declarar throws ou usar try-catch
}
```

**Unchecked** (opcional):
```java
public void dividir(int a, int b) {
    int resultado = a / b;  // Pode dar ArithmeticException
    // Não precisa declarar throws
}
```

---

## 🎯 Try-Catch-Finally

### Sintaxe Completa:
```java
try {
    // Código que pode lançar exceção
} catch (TipoExcecao1 e) {
    // Tratar exceção tipo 1
} catch (TipoExcecao2 e) {
    // Tratar exceção tipo 2
} finally {
    // Sempre executa (opcional)
    // Usado para liberar recursos
}
```

### Try-with-Resources (Java 7+):
```java
try (FileReader fr = new FileReader("arquivo.txt")) {
    // Usa o recurso
} catch (IOException e) {
    e.printStackTrace();
}
// Recurso é fechado automaticamente!
```

---

## 🛠️ Criar Exceções Personalizadas

```java
public class SaldoInsuficienteException extends Exception {
    public SaldoInsuficienteException(String mensagem) {
        super(mensagem);
    }
}

public class ContaBancaria {
    private double saldo;
    
    public void sacar(double valor) throws SaldoInsuficienteException {
        if (valor > saldo) {
            throw new SaldoInsuficienteException(
                "Saldo insuficiente. Saldo: " + saldo + ", Valor: " + valor
            );
        }
        saldo -= valor;
    }
}
```

---

## 💡 Boas Práticas

1. ✅ Sempre trate exceções específicas primeiro
2. ✅ Use finally para liberar recursos
3. ✅ Ou use try-with-resources
4. ✅ Nunca deixe catch vazio
5. ✅ Log de exceções para debug
6. ❌ Não use exceções para fluxo normal
7. ❌ Não capture Exception genérico sem motivo

---

## 🎓 Próxima Aula
[Aula 14 - Collections Framework - Parte 1](../Aula14_Collections1/README.md)
