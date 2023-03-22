price = int(input('Digite oo preço do produto: '))


if price <= 0:
    print('Preço inválido')
elif 0 < price <= 30:
    print('Preço baixo')
elif 30 < price <= 50:
    print('Preço médio')
else:
    print('Preço alto')