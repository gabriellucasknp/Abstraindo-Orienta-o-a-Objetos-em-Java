# Aula 17 - Arquivos e Entrada/Saída (I/O)

## 📚 Objetivos
- Ler e escrever arquivos de texto
- Trabalhar com BufferedReader/Writer
- Usar try-with-resources
- Serialização básica
- Comparar com Python

---

## 📄 Arquivos: Java vs Python

### Python:
```python
# Ler arquivo
with open('arquivo.txt', 'r') as f:
    conteudo = f.read()

# Escrever arquivo
with open('arquivo.txt', 'w') as f:
    f.write('Olá Mundo!')
```

### Java:
```java
// Ler arquivo
try (BufferedReader br = new BufferedReader(new FileReader("arquivo.txt"))) {
    String linha;
    while ((linha = br.readLine()) != null) {
        System.out.println(linha);
    }
}

// Escrever arquivo
try (BufferedWriter bw = new BufferedWriter(new FileWriter("arquivo.txt"))) {
    bw.write("Olá Mundo!");
}
```

---

## 📁 Arquivos desta Aula

1. `Exemplo01_LerArquivo.java` - Leitura básica
2. `Exemplo02_EscreverArquivo.java` - Escrita básica
3. `Exemplo03_BufferedReaderWriter.java` - I/O eficiente
4. `Exemplo04_TryWithResources.java` - Gerenciamento automático
5. `Exemplo05_Files.java` - API moderna (Java NIO)
6. `Exemplo06_Serializacao.java` - Serializar objetos
7. `Exercicio01_CopiadorArquivos.java` - Copiar arquivo
8. `Exercicio02_ContadorPalavras.java` - Analisar texto
9. `Exercicio03_AgendaArquivo.java` - Persistir dados
10. `Desafio_EditorTexto.java` - Editor simples

---

## 📖 Leitura de Arquivos

### FileReader (básico):
```java
try (FileReader fr = new FileReader("arquivo.txt")) {
    int c;
    while ((c = fr.read()) != -1) {
        System.out.print((char) c);
    }
} catch (IOException e) {
    e.printStackTrace();
}
```

### BufferedReader (recomendado):
```java
try (BufferedReader br = new BufferedReader(new FileReader("arquivo.txt"))) {
    String linha;
    while ((linha = br.readLine()) != null) {
        System.out.println(linha);
    }
} catch (IOException e) {
    e.printStackTrace();
}
```

### Scanner (alternativa):
```java
try (Scanner scanner = new Scanner(new File("arquivo.txt"))) {
    while (scanner.hasNextLine()) {
        String linha = scanner.nextLine();
        System.out.println(linha);
    }
} catch (FileNotFoundException e) {
    e.printStackTrace();
}
```

---

## ✏️ Escrita de Arquivos

### FileWriter (básico):
```java
try (FileWriter fw = new FileWriter("arquivo.txt")) {
    fw.write("Olá Mundo!\n");
    fw.write("Segunda linha");
} catch (IOException e) {
    e.printStackTrace();
}
```

### BufferedWriter (recomendado):
```java
try (BufferedWriter bw = new BufferedWriter(new FileWriter("arquivo.txt"))) {
    bw.write("Primeira linha");
    bw.newLine();
    bw.write("Segunda linha");
} catch (IOException e) {
    e.printStackTrace();
}
```

### Append (adicionar ao final):
```java
try (FileWriter fw = new FileWriter("arquivo.txt", true)) {  // true = append
    fw.write("Nova linha\n");
} catch (IOException e) {
    e.printStackTrace();
}
```

---

## 🆕 Java NIO (New I/O) - Moderno

### Files e Paths (Java 7+):
```java
import java.nio.file.*;
import java.util.List;

// Ler todas as linhas
List<String> linhas = Files.readAllLines(Paths.get("arquivo.txt"));

// Escrever lista
Files.write(Paths.get("arquivo.txt"), linhas);

// Verificar existência
boolean existe = Files.exists(Paths.get("arquivo.txt"));

// Criar diretório
Files.createDirectory(Paths.get("nova_pasta"));

// Copiar arquivo
Files.copy(Paths.get("origem.txt"), Paths.get("destino.txt"));

// Deletar arquivo
Files.delete(Paths.get("arquivo.txt"));
```

---

## 🔄 Serialização

### Serializar objeto:
```java
import java.io.*;

// Classe deve implementar Serializable
class Pessoa implements Serializable {
    private String nome;
    private int idade;
    // ... construtores, getters, setters
}

// Salvar objeto
try (ObjectOutputStream oos = new ObjectOutputStream(
        new FileOutputStream("pessoa.dat"))) {
    Pessoa p = new Pessoa("João", 25);
    oos.writeObject(p);
}

// Ler objeto
try (ObjectInputStream ois = new ObjectInputStream(
        new FileInputStream("pessoa.dat"))) {
    Pessoa p = (Pessoa) ois.readObject();
    System.out.println(p.getNome());
}
```

---

## 🛡️ Try-with-Resources

### Antes (Java 6):
```java
BufferedReader br = null;
try {
    br = new BufferedReader(new FileReader("arquivo.txt"));
    // usar br
} catch (IOException e) {
    e.printStackTrace();
} finally {
    if (br != null) {
        try {
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

### Depois (Java 7+):
```java
try (BufferedReader br = new BufferedReader(new FileReader("arquivo.txt"))) {
    // usar br
} catch (IOException e) {
    e.printStackTrace();
}
// br é fechado automaticamente!
```

---

## 📊 Comparação de Métodos

| Método | Velocidade | Uso | Recomendado para |
|--------|------------|-----|------------------|
| **FileReader** | Lento | Simples | Arquivos pequenos |
| **BufferedReader** | Rápido | Linha a linha | Arquivos texto grandes |
| **Scanner** | Médio | Parsing | Arquivos estruturados |
| **Files (NIO)** | Rápido | Moderno | Tudo (Java 7+) |

---

## 🎓 Próxima Aula
[Aula 18 - Stream API e Expressões Lambda](../Aula18_StreamLambda/README.md)
