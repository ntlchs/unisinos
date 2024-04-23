def xor(a, b):
    return a ^ b

def nand(a, b):
    return not (a & b)

def nor(a, b):
    return not (a | b)

def xnor(a, b):
    return not (a ^ b)

def calculate(a, b, c, d):
    return int(a & b | b ^ xnor((b | c), d))

print('a b c d output')
for a in [0, 1]:
    for b in [0, 1]:
        for c in [0, 1]:
            for d in [0, 1]:
                print(a, b, c, d, calculate(a, b, c, d))
