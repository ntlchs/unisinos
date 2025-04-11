import sys

RED = "\033[91m"
RESET = "\033[0m"


def is_sorted_until(arr, h):
    sorted_end = len(arr)
    for i in range(1, len(arr)):
        if arr[i - 1] > arr[i]:
            sorted_end = i
            break
    return sorted_end


def print_array_colored(arr, h):
    sys.stdout.write(f"Após h = {h}: [")
    sorted_limit = is_sorted_until(arr, 1) if h == 1 else len(arr)
    for i, val in enumerate(arr):
        if i < sorted_limit:
            sys.stdout.write(f"{val}")
        else:
            sys.stdout.write(f"{RED}{val}{RESET}")
        if i < len(arr) - 1:
            sys.stdout.write(", ")
    sys.stdout.write("]\n")


def shell_sort_verbose_colored(arr, gaps):
    n = len(arr)
    arr = arr.copy()
    for h in gaps:
        for i in range(h, n):
            temp = arr[i]
            j = i
            while j >= h and arr[j - h] > temp:
                arr[j] = arr[j - h]
                j -= h
            arr[j] = temp
        print_array_colored(arr, h)


vetor = [40, 15, 20, 90, 10, 85, 60, 30, 5, 50, 25, 70, 55, 35]
gaps = [7, 3, 1]

print("Array original:")
print(vetor)
print()
shell_sort_verbose_colored(vetor, gaps)
