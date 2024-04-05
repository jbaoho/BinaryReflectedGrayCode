# BinaryReflectedGrayCode

The purpose of the code is to compute the binary reflected Gray 
codes of order n both recursively and non-recursively.

The recursive algorithm computes the n-1 BRGC bit strings until
the base case of n==1, and uses the recursively computed lists to
compute the new bit strings by adding unique combinations of each order
through reflecting the list and adding either a 0 or 1 to the start of 
each bit string. The non-recursive algorithm uses the BRGC relation to 
ordinary binary to compute the nth order strings by finding the least 
significant one in each binary number up to 2^n and flipping the corresponding
bit in the BRGC representation.

The program uses the ArrayList and Scanner libraries.
