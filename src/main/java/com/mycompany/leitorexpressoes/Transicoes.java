/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.leitorexpressoes;

/**
 *
 * @author User
 */
public class Transicoes {
    public char getTransicao(char estado, char simbolo) {
        if (estado == '$') {
            if (Character.isLetter(simbolo)) {
                return 'V'; // Variável
            } else {
                return 'R'; // Erro: símbolo inválido no início da expressão
            }
            
        } else if (estado == ';') {
            return 'R'; // Erro: símbolo após ';' 
            
        }else if (simbolo == ' '){
            return estado; // Continua no estado atual (ignora espaço em branco)
            
        } else if (estado == 'V') {
            if (Character.isLetterOrDigit(simbolo)) {
                return 'V'; // Continua na variável
            } else if (simbolo == '=') {
                return '='; // Próximo estado é '='
            } else if (simbolo == '(') {                    // quais estados aceitam parenteses ?
                return '('; // Próximo estado é '('
            } else if (simbolo == '+' || simbolo == '-' || simbolo == '*' || simbolo == '/') {
                return 'O'; // Próximo estado é 'O'
            } else if (simbolo == ';') {
                return ';'; // Próximo estado é ';'
            } else {
                return 'R'; // Erro: símbolo inválido após a variável
            }
        } else if (estado == '=') {
            if (Character.isDigit(simbolo)) {
                return 'C'; // Constante numérica
            } else if (Character.isLetter(simbolo) || simbolo == '(') {
                return 'V'; // Próximo estado é variável ou parêntese aberto
            } else {
                return 'R'; // Erro: símbolo inválido após '='
            }
        } else if (estado == 'C') {
            if (Character.isDigit(simbolo) || simbolo == '.') {
                return 'C'; // Continua na constante numérica
            } else if (Character.isLetter(simbolo) || simbolo == '(') {
                return 'V'; // Próximo estado é variável ou parêntese aberto
            } else if (simbolo == '+' || simbolo == '-' || simbolo == '*' || simbolo == '/') {
                return 'O'; // Operador
            } else if (simbolo == ';') {
                return ';'; // Próximo estado é ';'
            } else {
                return 'R'; // Erro: símbolo inválido após constante numérica
            }
        } else if (estado == '(') {
            if (Character.isLetter(simbolo) || simbolo == '(') {
                return 'V'; // Variável ou parêntese aberto
            } else {
                return 'R'; // Erro: símbolo inválido após '('
            }
        } else if (estado == 'O') {
            if (Character.isDigit(simbolo)) {
                return 'C'; // Constante numérica
            } else if (Character.isLetter(simbolo) || simbolo == '(') {
                return 'V'; // Próximo estado é variável ou parêntese aberto
            } else if (simbolo == '+' || simbolo == '-' || simbolo == '*' || simbolo == '/') {
                return 'R'; // Erro: multiplos operadores em sequência
            } else if (simbolo == ';') {
                return 'R'; // Erro: expressão termina com operador
            } else {
                return 'R'; // Erro: símbolo inválido após operador
            }
        } else {
            return 'R'; // Erro: estado inválido
        }
    }
}











