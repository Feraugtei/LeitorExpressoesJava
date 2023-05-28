
package com.mycompany.leitorexpressoes;

import java.util.Stack;

public class Automato {
    private Stack<Character> pilha;

    public Automato() {
        pilha = new Stack<>();
    }

    public String reconhecerExpressao(String expressao) {
        Transicoes transicoes = new Transicoes();
        boolean equalPresent = false;

        pilha.clear();
        char[] entrada = expressao.toCharArray();

        int i = 0;
        char estado = '$'; // Estado inicial

        while (i < entrada.length) {
            char simbolo = entrada[i];
            char proximoEstado = transicoes.getTransicao(estado, simbolo);

            if (proximoEstado == 'R') {
                return "Sentença não reconhecida.\nErro de Sintaxe"; // Erro de sintaxe
            } else if (proximoEstado == 'E') {
                return "Sentença não reconhecida.\nTransição não definida"; // Erro: transição não definida
            } else if (proximoEstado == 'I') {
                return "Sentença não reconhecida.\nSímbolo inválido no início da expressão"; // Erro: transição não definida
            } else if (proximoEstado == 'X') {
                return "Sentença não reconhecida.\nMultiplos operadores em sequência"; // Erro: transição não definida
            } else if (proximoEstado == 'Y') {
                return "Sentença não reconhecida.\nExpressão termina com um operador antes do ponto e virgula."; // Erro: transição não definida
            } else if (proximoEstado == 'Z') {
                return "Sentença não reconhecida.\nOperador diretamente após simbolo de igual.";    
            } else if (proximoEstado == ';') {
                if(!equalPresent){
                    return "Sentença não reconhecida.\nExpressão sem o símbolo de igual, assim não sendo uma expressão matematica."; // Erro: simbolo "=" não presente
                } else if(i == entrada.length - 1 && pilha.isEmpty()){
                    return "Sentença Reconhecida.\nA expressão está correta.";
                } else {
                    return "Sentença não Reconhecida.\nO simbolo ';' não está no final da expressão, ou parêntese não foi fechado corretamente";
                }
                  // Verifica se chegou ao fim da expressão
            } else {
                if (proximoEstado == '(') {
                    pilha.push('('); // Empilha o parêntese aberto
                } else if (proximoEstado == ')') {
                    if (pilha.isEmpty() || pilha.pop() != '(') {
                        return "Sentença não reconhecida.\nParêntese sendo fechado sem ser aberto"; // Erro: parêntese não fechado corretamente
                    }
                } else if (proximoEstado == '=') {
                equalPresent = true; // Valida a presença do "="
                }

                i++; // Avança para o próximo símbolo
                estado = proximoEstado;
            }
        }

        return "Sentença não reconhecida.\nExpressão finalizada sem ';'."; //Erro: expressão finalizada sem ';'
    }
}
