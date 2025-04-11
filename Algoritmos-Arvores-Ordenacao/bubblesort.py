RED = "\033[91m"
RESET = "\033[0m"


def print_array_state(arr, step, sorted_tail_size):
    display = []
    for i in range(len(arr)):
        if i < len(arr) - sorted_tail_size:
            display.append(f"{RED}{arr[i]}{RESET}")
        else:
            display.append(str(arr[i]))
    print(f"Após {step}ª iteração: [{', '.join(display)}]")


def bubble_sort_verbose(arr):
    n = len(arr)
    total_trocas = 0
    total_passos = 0

    for i in range(n - 1):
        trocou = False
        for j in range(n - 1 - i):
            if arr[j] > arr[j + 1]:
                arr[j], arr[j + 1] = arr[j + 1], arr[j]
                total_trocas += 1
                trocou = True
        total_passos += 1
        print_array_state(arr, total_passos, total_passos)
        if not trocou:
            break  # otimização: para se já estiver ordenado

    print(f"\nTotal de passagens completas (iterações): {total_passos}")
    print(f"Total de trocas de elementos: {total_trocas}")


# array fornecido
vetor = [
    50,
    34,
    16,
    7,
    80,
    26,
    68,
    9,
    45,
    33,
    18,
    54,
    21,
    79,
    13,
    43,
    69,
    56,
    10,
    98,
    87,
    38,
    62,
    73,
    24,
    83,
    97,
    60,
    31,
    17,
    6,
    48,
    3,
    20,
    41,
    85,
    92,
    40,
    76,
    75,
    77,
    42,
    55,
    36,
    22,
    2,
    1,
    28,
    71,
    91,
    52,
]

print("Array original:")
print(vetor)
print()

bubble_sort_verbose(vetor)
