.data
number1: .asciiz "Digite o valor do primeiro n�mero:"
number2: .asciiz "Digite o valor do segundo n�mero:"
result: .asciiz "O resultado da soma �: "
line: .asciiz "\n"

.text
main:

    # l� e armazena 1� inteiro
    li $v0, 4       # c�digo para imprimir uma string
    la $a0, number1     # carrega o endere�o da mensagem em $a0
    syscall         # chamada do sistema para $v0 que cont�m 4 (imprimir string)
    jal le_inteiro_do_teclado  # chama fun��o
    move $t0, $v0  # armazena inteiro lido em $t0  
    
    li $v0, 4       # c�digo para imprimir uma string
    la $a0, line
    
    # l� e armazena 2� inteiro
    li $v0, 4       
    la $a0, number2     
    syscall         
    jal le_inteiro_do_teclado
    move $t1, $v0 
    
    li $v0, 4       # c�digo para imprimir uma string
    la $a0, number1  

    # soma
    add $t2, $t0, $t1
    li $v0, 4          
    la $a0, result     
    syscall             
    move $a0, $t2     
    jal imprime_inteiro  

    # finaliza programa
    li $v0, 10          # encerrar o programa
    syscall             
	
le_inteiro_do_teclado: 
    li $v0, 5         # ler inteiro
    syscall           # chamada do sistema para ler inteiro
    jr $ra            # retorna endere�o de retorno armazenado em $ra
    
imprime_inteiro:
    li $v0, 1          # imprimir inteiro
    syscall            # chamada do sistema para imprimir inteiro
    jr $ra             # retorna endere�o de retorno armazenado em $ra
