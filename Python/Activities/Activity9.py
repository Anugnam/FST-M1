listone = list(input("Enter first list of numbers separated by comma: ").split(","))
listtwo = list(input("Enter second list of number separated by comma: ").split(","))
listthree = []
for num in listone:
    if int(num)%2!=0:
        listthree.append(num)
for num in listtwo:
    if int(num)%2==0:
        listthree.append(num)
print("Resultant list is: ",listthree)