package com.mycompany.leitorexpressoes;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


public class Leitor {   //Classe que faz a leitura de um arquivo de texto a partir de um Filepath, e armazena o contéudo em uma string.
    private String text;
    private int lineCount;
    private String filePath;

    public Leitor(String filePath) throws Exception {
        this.filePath = filePath;
        List<String> lines = Files.readAllLines(Paths.get(filePath), Charset.forName("UTF-8"));
        StringBuilder textBuilder = new StringBuilder();
        for (String line : lines) {
            textBuilder.append(line).append(System.lineSeparator());
        }
        text = textBuilder.toString();
        lineCount = lines.size();
    }

    public String getText() {
        return text;
    }

    public int getLineCount() {
        return lineCount;
    }

    public String getFilePath() {
        return filePath;
    }
}