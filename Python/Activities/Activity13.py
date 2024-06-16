
def calculate_sum(numbers):
	sum = 0
	for number in numbers:
		sum += number
	return sum

numList = [127, 322, 12, 324]

result = calculate_sum(numList)

print("The sum of all the elements is: " + str(result))