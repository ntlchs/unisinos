.data
number1: .asciiz "Digite o valor do primeiro número:"
number2: .asciiz "Digite o valor do segundo número:"
result: .asciiz "O resultado da soma é: "
line: .asciiz "\n"

.text
main:

    # lê e armazena 1º inteiro
    li $v0, 4       # código para imprimir uma string
    la $a0, number1     # carrega o endereço da mensagem em $a0
    syscall         # chamada do sistema para $v0 que contém 4 (imprimir string)
    jal le_inteiro_do_teclado  # chama função
    move $t0, $v0  # armazena inteiro lido em $t0  
    
    li $v0, 4       # código para imprimir uma string
    la $a0, line
    
    # lê e armazena 2º inteiro
    li $v0, 4       
    la $a0, number2     
    syscall         
    jal le_inteiro_do_teclado
    move $t1, $v0 
    
    li $v0, 4       # código para imprimir uma string
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
    jr $ra            # retorna endereço de retorno armazenado em $ra
    
imprime_inteiro:
    li $v0, 1          # imprimir inteiro
    syscall            # chamada do sistema para imprimir inteiro
    jr $ra             # retorna endereço de retorno armazenado em $ra
