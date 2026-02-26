# Aula 07 - Strings e Manipulação

## 📚 Objetivos
- Entender a classe String em Java
- Manipular strings eficientemente
- Usar StringBuilder e StringBuffer
- Comparar com strings Python

---

## 📝 Strings em Java vs Python

| Operação | Python | Java |
|----------|--------|------|
| **Criar** | `s = "texto"` | `String s = "texto";` |
| **Concatenar** | `s1 + s2` | `s1 + s2` ou `s1.concat(s2)` |
| **Tamanho** | `len(s)` | `s.length()` |
| **Maiúscula** | `s.upper()` | `s.toUpperCase()` |
| **Minúscula** | `s.lower()` | `s.toLowerCase()` |
| **Substring** | `s[1:4]` | `s.substring(1, 4)` |
| **Comparar** | `s1 == s2` | `s1.equals(s2)` |
| **Split** | `s.split()` | `s.split()` |

---

## 📁 Arquivos desta Aula

1. `Exemplo01_StringBasico.java` - Criação e básicos
2. `Exemplo02_MetodosString.java` - Métodos principais
3. `Exemplo03_Comparacao.java` - Comparar strings
4. `Exemplo04_StringBuilder.java` - Concatenação eficiente
5. `Exemplo05_Formatacao.java` - String.format e printf
6. `Exemplo06_RegularExpressions.java` - Regex básico
7. `Exercicio01_InverterString.java` - Inverter string
8. `Exercicio02_Palindromo.java` - Verificar palíndromo
9. `Exercicio03_ContarVogais.java` - Contar caracteres
10. `Desafio_AnalisadorTexto.java` - Análise completa de texto

---

## 🎯 Conceitos Importantes

### String é Imutável
```java
String s = "Java";
s.toUpperCase();  // Cria nova string, não modifica s
System.out.println(s);  // Ainda "Java"

// Correto:
s = s.toUpperCase();  // Agora s é "JAVA"
```

### StringBuilder para Concatenação
```java
// Ineficiente (cria muitas strings):
String resultado = "";
for (int i = 0; i < 1000; i++) {
    resultado += i;
}

// Eficiente:
StringBuilder sb = new StringBuilder();
for (int i = 0; i < 1000; i++) {
    sb.append(i);
}
String resultado = sb.toString();
```

### Métodos Importantes
- `charAt(index)` - caractere em posição
- `substring(start, end)` - extrair parte
- `indexOf(string)` - encontrar posição
- `replace(old, new)` - substituir
- `trim()` - remover espaços
- `split(regex)` - dividir em array

---

## 🎓 Próxima Aula
[Aula 08 - Classes e Objetos (Introdução a POO)](../Aula08_ClassesObjetos/README.md)
