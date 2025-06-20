"""Write a python program to compute the net amount of a bank account based on a transaction log. 
Input Description: The transaction log format is as follows. 
First line : Integer n, which specifies the number of transactions 
Second line onwards: A character and an integer separated by space. Character D indicates deposit(D) and character W indicates withdrawal (W).
The integer part indicates the amount.
 Output Description : For Ex. B 500 which indicates a balance of 500 Rs."""

n=int(input())
transaction_log=[input() for i in range(n) ]


def transac(transactions):
    balance=0
    for transaction in transactions:
        Amount_type, amount=transaction.split()
        if(Amount_type=='D'):
            balance += int(amount)
        elif(Amount_type=='W'):
            balance -= int(amount)
    return balance
print("B ",transac(transaction_log))




