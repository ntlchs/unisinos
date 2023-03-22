a = int(input('Digite o valor de A: '))
b = int(input('Digite o valor de B: '))
c = int(input('Digite o valor de C: '))

if a > c and a > b:
    print('A é o maior')
elif b > c and b > a:
    print('B é o maior')
elif c > b and c > a:
    print('C é o maior')
else:
    print('Erro: os valores são todos iguais')