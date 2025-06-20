"""Given two strings needle and haystack, return the index of the first occurrence of needle in haystack,
or -1 if needle is not part of haystack.  
Input: haystack = "sadbutsad", needle = "sad"
Output: 0
Explanation: "sad" occurs at index 0 and 6. The first occurrence is at index 0, so we return 0."""


def find_first_occurrence(needle, haystack):
    n = len(needle)
    h = len(haystack)
    
    for i in range(h - n + 1):  # Iterate through possible start positions in haystack
        if haystack[i:i + n] == needle:  # Check if the substring matches needle
            return i
    
    return -1  # Return -1 if needle is not found in haystack

# Example usage:
haystack = input("Enter haystack string: ")
needle = input("Enter needle string: ")

index = find_first_occurrence(needle, haystack)
print(f"The index of the first occurrence of '{needle}' in '{haystack}' is: {index}")
