# Aula 01 - Sintaxe Básica e Tipos de Dados

## 🎯 Objetivos da Aula
- Entender a estrutura de um programa Java
- Aprender sobre tipos primitivos
- Compreender o sistema de tipos estático
- Trabalhar com entrada e saída de dados
- Fazer paralelos com Python

---

## 📝 Estrutura Básica de um Programa Java

### Em Python:
```python
# hello.py
print("Hello, World!")
```

### Em Java:
```java
// HelloWorld.java
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}
```

### 🔍 Principais Diferenças:

1. **Java precisa de uma classe**: Todo código fica dentro de classes
2. **Método main**: Ponto de entrada do programa
3. **public static void main**: Assinatura obrigatória
4. **Ponto e vírgula**: Obrigatório no fim de cada instrução
5. **Chaves {}**: Delimitam blocos de código
6. **Nome do arquivo = Nome da classe**: `HelloWorld.java` para `class HelloWorld`

---

## 🔢 Tipos Primitivos

### Comparação Python vs Java:

| Python | Java | Tamanho | Exemplo |
|--------|------|---------|---------|
| `int` | `byte` | 8 bits | `byte idade = 25;` |
| `int` | `short` | 16 bits | `short ano = 2024;` |
| `int` | `int` | 32 bits | `int populacao = 1000000;` |
| `int` | `long` | 64 bits | `long distancia = 9999999999L;` |
| `float` | `float` | 32 bits | `float altura = 1.75f;` |
| `float` | `double` | 64 bits | `double preco = 19.99;` |
| `bool` | `boolean` | 1 bit | `boolean ativo = true;` |
| `str` | `char` | 16 bits | `char letra = 'A';` |

### ⚠️ Pontos Importantes:

- **Java tem tamanhos fixos**: Python se ajusta automaticamente
- **Literais long**: Usar sufixo `L` → `123456789L`
- **Literais float**: Usar sufixo `f` → `3.14f`
- **char usa aspas simples**: `'A'` (não `"A"`)
- **String usa aspas duplas**: `"Texto"` (não é tipo primitivo)

---

## 📚 Arquivos de Exemplo

- [Exemplo01_HelloWorld.java](Exemplo01_HelloWorld.java) - Primeiro programa
- [Exemplo02_TiposPrimitivos.java](Exemplo02_TiposPrimitivos.java) - Todos os tipos
- [Exemplo03_Variaveis.java](Exemplo03_Variaveis.java) - Declaração e inicialização
- [Exemplo04_EntradaSaida.java](Exemplo04_EntradaSaida.java) - Scanner para input
- [Exemplo05_Conversoes.java](Exemplo05_Conversoes.java) - Type casting

---

## 💻 Exercícios Práticos

### Exercício 1: Calculadora de Idade
Crie um programa que peça o ano de nascimento e calcule a idade.

### Exercício 2: Conversor de Temperatura
Converta Celsius para Fahrenheit e Kelvin.

### Exercício 3: Calculadora de IMC
Peça peso e altura, calcule e exiba o IMC.

### Exercício 4: Manipulação de Tipos
Declare variáveis de todos os tipos primitivos e faça conversões.

---

## 🚀 Próxima Aula
[Aula 02 - Operadores e Expressões](../Aula02_Operadores/README.md)
