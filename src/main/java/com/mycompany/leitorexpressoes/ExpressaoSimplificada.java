
package com.mycompany.leitorexpressoes;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpressaoSimplificada {
    public String converterExpressao(String expressao) {
        String[] partes = expressao.split("=");
        String variavel = converterVariavel(partes[0].trim());
        String expressaoMatematica = partes[1].replace(";", "").trim();

        List<String> palavras = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\b[a-zA-Z]\\w*\\b|\\d+(?:\\.\\d+)?");
        Matcher matcher = pattern.matcher(expressaoMatematica);

        while (matcher.find()) {
            palavras.add(matcher.group());
        }

        StringBuilder expressaoSimplificada = new StringBuilder();
        Stack<Character> parenteses = new Stack<>();

        for (int i = 0; i < expressaoMatematica.length(); i++) {
            char caracter = expressaoMatematica.charAt(i);

            if (Character.isLetter(caracter) || Character.isDigit(caracter)) {
                String palavraAtual = palavras.remove(0);
                expressaoSimplificada.append(converterPalavra(palavraAtual));
                i += palavraAtual.length() - 1;
            } else if (caracter == '+' || caracter == '-' || caracter == '*' || caracter == '/') {
                expressaoSimplificada.append("o");
            } else if (caracter == '(') {
                parenteses.push(caracter);
                expressaoSimplificada.append(caracter);
            } else if (caracter == ')') {
                if (!parenteses.isEmpty()) {
                    parenteses.pop();
                }
                expressaoSimplificada.append(caracter);
            }
        }

        while (!parenteses.isEmpty()) {
            expressaoSimplificada.append(")");
            parenteses.pop();
        }

        return variavel + "=" + expressaoSimplificada.toString() + ";";
    }

    private String converterVariavel(String variavel) {
        StringBuilder variavelSimplificada = new StringBuilder();
        boolean primeiraLetra = true;

        for (int i = 0; i < variavel.length(); i++) {
            char caracter = variavel.charAt(i);

            if (Character.isLetterOrDigit(caracter)) {
                if (primeiraLetra) {
                    variavelSimplificada.append("v");
                    primeiraLetra = false;
                }
            }
        }

        return variavelSimplificada.toString();
    }

    private String converterPalavra(String palavra) {
        if (Character.isLetter(palavra.charAt(0))) {
            return "v";
        } else {
            return "c";
        }
    }
}


