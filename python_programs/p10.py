"""Write a Python program to create a class called 'Complex'. Each Complex object should have real part and imaginary part. 
Include method to add two complex numbers. Input Description : First line contains real part and imaginary part of the first complex number. 
Second line contains real part and imaginary part of the second complex number. Sample input 2,4 1,3 Sample output 3 7"""
class Complex:
    def __init__(self,real,imag):
        self.real=real
        self.imag=imag

    def add(self,other):
        real_sum=self.real+other.real
        imag_sum=self.imag+other.imag
        return Complex(real_sum,imag_sum)

def parse_complex(input_str):
    real,imag=map(int,input_str.split(','))
    return Complex(real,imag)

complex1_input=input().strip()
complex2_input=input().strip()

complex1=parse_complex(complex1_input)
complex2=parse_complex(complex2_input)

result=complex1.add(complex2)

print(result.real,result.imag)