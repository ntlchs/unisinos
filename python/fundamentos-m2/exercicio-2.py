value1 = int(input('Digite o valor do primeiro número: '))
value2 = int(input('Digite o valor do segundo número: '))

if value1 > value2:
    print(value1,'>', value2,'- O primeiro número é maior')
elif value1 < value2:
    print(value2,'>', value1, '- O segundo número é maior')
else:
    print('Os números são iguais')