
package com.mycompany.leitorexpressoes;

import java.util.Stack;

public class Automato {
    private Stack<Character> pilha;

    public Automato() {
        pilha = new Stack<>();
    }

    public boolean reconhecerExpressao(String expressao) {
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
                return false; // Erro de sintaxe
            } else if (proximoEstado == 'E') {
                return false; // Erro: transição não definida
            } else if (proximoEstado == ';') {
                if(!equalPresent){
                    return false; // Erro: simbolo "=" não presente
                }
                return i == entrada.length - 1 && pilha.isEmpty(); // Verifica se chegou ao fim da expressão
            } else {
                if (proximoEstado == '(') {
                    pilha.push('('); // Empilha o parêntese aberto
                } else if (proximoEstado == ')') {
                    if (pilha.isEmpty() || pilha.pop() != '(') {
                        return false; // Erro: parêntese não fechado corretamente
                    }
                } else if (proximoEstado == '=') {
                equalPresent = true; // Valida a presença do "="
                }

                i++; // Avança para o próximo símbolo
                estado = proximoEstado;
            }
        }

        return false; //Erro: expressão finalizada sem ';'
    }
}
