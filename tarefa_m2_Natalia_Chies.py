# Menu de opções
name = input("Digite seu nome: ")
option = 0

while True:
    print(f"\nOlá, {name}.")
    print("Digite a opção desejada:")
    print("1) Verificar triângulo")
    print("2) Calcular equação do segundo grau")
    print("3) Conferir data")
    print("4) Verificar tamanho do texto")
    print("5) Analisar CPF")
    print("6) Contar caracteres")
    print("7) Sair")
    option = int(input('Opção: '))

    # Opção 1 - Verificar triângulo
    if option == 1:
        a = int(input("Digite o primeiro lado: "))
        b = int(input("Digite o segundo lado: "))
        c = int(input("Digite o terceiro lado: "))
        if abs(b - c) < a < b + c and abs(a - c) < b < a + c and abs(a - b) < c < a + b:
            if a == b == c:
                print("O triângulo é equilátero.")
            elif a == b or b == c or a == c:
                print("O triângulo é isósceles.")
            else:
                print("O triângulo é escaleno.")
        else:
            print("As medidas informadas não formam um triângulo.")

    # Opção 2 - Calcular equação do segundo grau
    elif option == 2:
        a = float(input("Digite o valor de a: "))
        if a == 0:
            print("Não é uma equação do segundo grau.")
        else:
            b = float(input("Digite o valor de b: "))
            c = float(input("Digite o valor de c: "))
            delta = b ** 2 - 4 * a * c
            if delta < 0:
                print("A equação não possui raízes reais.")
            elif delta == 0:
                x = -b / (2 * a)
                print(f"A equação possui apenas uma raiz real: {x}.")
            else:
                x_one = (-b + delta ** 0.5) / (2 * a)
                x_two = (-b - delta ** 0.5) / (2 * a)
                print(f"A equação possui duas raízes reais: {x_one} e {x_two}.")

    # Opção 3 - Conferir data
    elif option == 3:
        day = int(input("Digite o dia: "))
        month = int(input("Digite o mês: "))
        year = int(input("Digite o ano: "))
        if month < 1 or month > 12:
            print("Data inválida.")
        elif day < 1 or (month == 2 and day > 29) or \
                (month in [4, 6, 9, 11] and day > 30) or \
                (month in [1, 3, 5, 7, 8, 10, 12] and day > 31):
            print("Data inválida.")
        else:
            print("Data válida.")

    # Opção 4 - Verificar tamanho do texto
    elif option == 4:
        text = input("Digite um texto: ")
        size = len(text)

        if size < 5:
            print("O texto é muito pequeno.")
        elif size >= 5 and size < 15:
            print("O texto é de tamanho médio.")
        elif size >= 15 and size < 20:
            print("O texto é grande.")
        else:
            print("O texto é inválido.")
    
    # Opção 5 - Analisar CPF
    elif option == 5:
        cpf = input("Digite o seu CPF (apenas números): ")
        if cpf.isdigit() and len(cpf) == 11:
            print("CPF válido.")
        else:
            print("CPF inválido.")

    # Opção 6 - Contar caracteres
    elif option == 6:
        text = input("Digite um texto: ")
        vowels = 0
        spaces = 0
        others = 0

        for letter in text:
            if letter in ["a","e","i","o","u","A","E","I","O","U"]:
                vowels += 1
            elif letter == " ":
                spaces += 1
            else:
                others += 1

        print(f"O texto contém {vowels} vogais, {spaces} espaços e {others} outros caracteres.")
    
    # Opção 7 - Sair
    elif option == 7:
        print("Obrigado por utilizar nosso sistema.")
        break

    # Opção inválida
    else:
        print('Erro: Opção inválida.')
        break