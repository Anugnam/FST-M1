numberslist = list(input("Enter a sequence of comma separated values: ").split(","))
sum = 0
for number in numberslist:
  sum += int(number)
print("Sum of the numbers in the list is",sum)