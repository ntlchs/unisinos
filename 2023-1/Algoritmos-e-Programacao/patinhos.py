def song(number):
    for i in range(number, 0, -1):
        print(f"{i} patinhos foram passear")
        print("Além das montanhas")
        print("Para brincar")
        print("A mamãe gritou: Quá, quá, quá, quá")
        if i == 1:
            print("Mas nenhum patinho voltou de lá\n")
        else:
            print(f"Mas só {i-1} patinhos voltaram de lá\n")
    print("A mamãe patinha foi procurar")
    print("Além das montanhas")
    print("Na beira do mar")
    print("A mamãe gritou: Quá, quá, quá, quá")
    print(f"E os {number} patinhos voltaram de lá")

number = int(input("Digite o número de patinhos: \n"))
song(number)