# from cgitb import small
# import numbers


# def getSum(n):
# 	sum1 = 0;
# 	while (n != 0):
# 		sum1 = sum1 + n % 10;
# 		n = n // 10
# 	return sum1

# def smallestNumber(N):
# 	i = 1
# 	while True:
# 		if (getSum(i) == N):
# 			return i
		# i += 1
	
# print(smallestNumber(16))
# print(smallestNumber(19))
# print(smallestNumber(7))



def smallestNumber(N):
    no_of_nines = N // 9
    remainder = N % 9
    return int(str(remainder) + "9"*no_of_nines)

for i in range(0, 51):
    print(smallestNumber(i))