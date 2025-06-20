list1 = input()
a, b = map(int, list1.split())

def gcd(a, b):
    """Compute the Greatest Common Divisor (GCD) of two integers."""
    while b != 0:
        a, b = b, a % b
    return a

def lcm(a, b):
    """Compute the Least Common Multiple (LCM) of two integers."""
    return abs(a * b) // gcd(a, b)  # Calculate LCM using GCD



print(lcm(a, b))
