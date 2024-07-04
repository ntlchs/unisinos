# li: losd immediate
# li <registrador>, <valor>
# 1: Imprimir um inteiro.
# 4: Imprimir uma string.
# 5: Ler um inteiro.
# 8: Ler uma string.
# 10: Encerrar o programa.
# Exemplo: li $v0, 4       # carrega valor 4 no registrador $v0

# la: load address
# la <registrador>, <r�tulo>
# Exemplo: la $a0, msg     # carrega endere�o da string `msg` no registrador $a0

# syscall: chamada de sistema
# syscall
# Exemplo: syscall         # executa chamada de sistema com c�digo em $v0

# jal: jump and link
# jal <r�tulo>
# Exemplo: jal le_inteiro_do_teclado  # salta para r�tulo `le_inteiro_do_teclado` e armazena endere�o de retorno em $ra

# move: move conte�do entre registradores
# move <destino>, <origem>
# Exemplo: move $t0, $v0  # move valor do registrador $v0 para registrador $t0

# add: soma dois registradores
# add <destino>, <origem1>, <origem2>
# Exemplo: add $t2, $t0, $t1  # soma $t0 e $t1, resultado em $t2

# sub: subtrai dois registradores
# sub <destino>, <origem1>, <origem2>
# Exemplo: sub $t3, $t0, $t1  # subtrai $t1 de $t0, resultado em $t3

# mul: multiplica dois registradores
# mul <destino>, <origem1>, <origem2>
# Exemplo: mul $t4, $t0, $t1  # multiplica $t0 por $t1, resultado em $t4

# div: divide dois registradores
# div <origem1>, <origem2>
# div armazena 2 valores em $lo (quociente) e $hi (resto)
# Exemplo: div $t0, $t1       # divide $t0 por $t1

# mflo: move from LO (valor do registrador especial LO para registrador geral)
# mflo <destino>              # move quociente da divis�o para <destino>
# Exemplo: mflo $t5           # move quociente (resultado da divis�o) para $t5

# mfhi: move from HI
# mfhi <destino> 
# Exemplo: mfhi $t6       # move resto de $hi para $t5

.data
# Dados
msg: .asciiz "Digite um valor inteiro: "
msg2: .asciiz "O valor inteiro digitado foi: "
msg_soma: .asciiz "Resultado da soma: "
msg_sub: .asciiz "Resultado da subtracao: "
msg_mul: .asciiz "Resultado da multiplicacao: "
msg_div: .asciiz "Resultado da divisao: "

.text
# Instru��es
.globl inicio

inicio:
    # exibe mensagem e l� 1� n�mero
    li $v0, 4       # c�digo para imprimir uma string
    la $a0, msg     # carrega o endere�o da mensagem em $a0
    syscall         # chamada do sistema para $v0 que cont�m 4 (imprimir string)
    jal le_inteiro_do_teclado  # chama fun��o
    move $t0, $v0  # armazena inteiro lido em $t0
    li $v0, 4          
    la $a0, msg2       
    syscall
    move $a0, $t0   #a0 � o 1� srgumento de syscall
    jal imprime_inteiro            
    
    # exibe mensagem e l� 2� n�mero
    li $v0, 4       
    la $a0, msg     
    syscall         
    jal le_inteiro_do_teclado
    move $t1, $v0 
    li $v0, 4          
    la $a0, msg2       
    syscall
    move $a0, $t1
    jal imprime_inteiro              
    
    # Soma
    add $t2, $t0, $t1  # soma $t0 e $t1 e armazena resultado em $t2
    li $v0, 4          
    la $a0, msg_soma   
    syscall            
    move $a0, $t2   
    jal imprime_inteiro       
    
    # Subtra��o
    sub $t3, $t0, $t1  # subtrai $t1 de $t0 e armazena resultado em $t3
    li $v0, 4          
    la $a0, msg_sub    
    syscall            
    move $a0, $t3      
    jal imprime_inteiro          
    
    # Multiplica��o
    mul $t4, $t0, $t1  # multiplica $t0 por $t1 e armazena resultado em $t4
    li $v0, 4          
    la $a0, msg_mul    
    syscall            
    move $a0, $t4      
    jal imprime_inteiro             
    
    # Divis�o
    div $t0, $t1       # divide $t0 por $t1
    mflo $t5           # move quociente de $lo para $t2 
    li $v0, 4          
    la $a0, msg_div    
    syscall            
    move $a0, $t5      # move o resultado da divis�o para $a0
    jal imprime_inteiro             

    # Fim do programa
    li $v0, 10         # encerrar o programa
    syscall            # chamada do sistema para encerrar

# fun��es
le_inteiro_do_teclado: 
    li $v0, 5         # ler inteiro
    syscall           # chamada do sistema para ler inteiro
    jr $ra            # retorna endere�o de retorno armazenado em $ra
    
imprime_inteiro:
    li $v0, 1          # imprimir inteiro
    syscall            # chamada do sistema para imprimir inteiro
    jr $ra             # retorna endere�o de retorno armazenado em $ra
