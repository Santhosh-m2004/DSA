def print_unique_even_numbers(nums):
    unique_even_numbers = set()
    
    # Iterate through the list of integers
    for num in nums:
        # Check if the number is even
        if num % 2 == 0:
            unique_even_numbers.add(num)
    
    # If there are no even numbers present
    if len(unique_even_numbers) == 0:
        print("nil")
    else:
        # Sort the unique even numbers in ascending order
        sorted_unique_even_numbers = sorted(unique_even_numbers)
        # Print the sorted unique even numbers
        print(*+sorted_unique_even_numbers)

# Take input manually as a list
nums = list(map(int, input().split()))

# Call the function with the input list
print_unique_even_numbers(nums)
