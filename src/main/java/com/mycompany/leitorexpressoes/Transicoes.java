
package com.mycompany.leitorexpressoes;

/**
 *
 * @author Fernando Teixeira
 */

public class Transicoes {
    public char getTransicao(char estado, char simbolo) {
        if (estado == '$') {
            if (Character.isLetter(simbolo)) {
                return 'V'; // Variável
            } else {
                return 'I'; // Erro: símbolo inválido no início da expressão
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
            } else if (simbolo == '(') {                    
                return 'F'; // Erro: parênteses logo após uma letra, sem operadores
            } else if (simbolo == ')') {                    
                return ')'; // Próximo estado é '('
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
            } else if (Character.isLetter(simbolo)){
                return 'V'; // Próximo estado é variável ou parêntese aberto
            } else if (simbolo == '(') {                    
                return '('; // Próximo estado é '('
            } else if (simbolo == '+' || simbolo == '-' || simbolo == '*' || simbolo == '/') {
                return 'Z'; // Erro: operador diretamente após simbolo de igual.
            } else {
                return 'R'; // Erro: símbolo inválido após '='
            }
        } else if (estado == 'C') {
            if (Character.isDigit(simbolo) || simbolo == '.') {
                return 'C'; // Continua na constante numérica
            } else if (simbolo == '+' || simbolo == '-' || simbolo == '*' || simbolo == '/') {
                return 'O'; // Operador
            } else if (simbolo == '(') {                    
                return 'F'; // Erro: parênteses logo após uma constante, sem operadores
            } else if (simbolo == ')') {                    
                return ')'; // Próximo estado é '('
            } else if (simbolo == ';') {
                return ';'; // Próximo estado é ';'
            } else if (Character.isLetter(simbolo)) {
                return 'L'; // Erro: letra no meio de uma constante    
            } else {
                return 'R'; // Erro: símbolo inválido após constante numérica
            }
        } else if (estado == '(') {
            if (Character.isLetter(simbolo)) {
                return 'V'; // Variável ou parêntese aberto
            } else if (Character.isDigit(simbolo)) {
                return 'C'; // Continua na constante numérica
            } else if (simbolo == '(') {                    
                return '('; // Próximo estado é '('
            } else if (simbolo == ')') {                    
                return 'W'; // Erro: parênteses vazio.
            } else {
                return 'R'; // Erro: símbolo inválido após '('
            }
        } else if (estado == ')') {
            if (simbolo == '+' || simbolo == '-' || simbolo == '*' || simbolo == '/') {
                return 'O'; // Operador
            } else if (simbolo == ')') {                    
                return ')'; // Próximo estado é ')'
            } else if (simbolo == ';') {
                return ';'; // Próximo estado é ';'
            } else {
                return 'R'; // Erro: símbolo inválido após ')'
            }
        } else if (estado == 'O') {
            if (Character.isDigit(simbolo)) {
                return 'C'; // Constante numérica
            } else if (Character.isLetter(simbolo)) {
                return 'V'; // Próximo estado é variável ou parêntese aberto
            } else if (simbolo == '+' || simbolo == '-' || simbolo == '*' || simbolo == '/') {
                return 'X'; // Erro: multiplos operadores em sequência
            } else if (simbolo == '(') {                    
                return '('; // Próximo estado é '('
            } else if (simbolo == ';') {
                return 'Y'; // Erro: expressão termina com operador
            } else {
                return 'R'; // Erro: símbolo inválido após operador
            }
        } else {
            return 'E'; // Erro: estado inválido
        }
    }
}











