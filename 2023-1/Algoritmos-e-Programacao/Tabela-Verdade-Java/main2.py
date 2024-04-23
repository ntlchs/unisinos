import numpy as np
import re

def nand(a, b):
    return int(not (a and b))

def nor(a, b):
    return int(not (a or b))

def xnor(a, b):
    return int(np.logical_not(np.logical_xor(a, b)))

def generate_truth_table(expression):
    variable_dict = {}
    variables = sorted(set(re.findall(r'\b[A-Z]\b', expression)))
    header = " ".join(variables + [expression])
    print(f"Truth Table for: {expression}")
    print(header)

    for i in range(2**len(variables)):
        variable_values = list(format(i, f"0{len(variables)}b"))
        for j in range(len(variables)):
            variable_dict[variables[j]] = int(variable_values[j])
        result = eval(expression, {"nand": nand, "nor": nor, "xnor": xnor, **variable_dict})
        print(" ".join(map(str, variable_values + [result])))

print("Instructions: Use the following syntax for writing logical expressions:")
print("  - Use parentheses to group expressions")
print("  - Use '&' for logical AND")
print("  - Use '|' for logical OR")
print("  - Use '~' for logical NOT")
print("  - Use '^' for logical XOR")
print("  - Use 'nand(A, B)' for logical NAND")
print("  - Use 'nor(A, B)' for logical NOR")
print("  - Use 'xnor(A, B)' for logical XNOR")

expression = input("Enter logical expression: ")
generate_truth_table(expression)