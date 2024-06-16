numtuple = tuple(input("Enter number tuples separated by comma: ").split(","))
print("Numbers divisible by 5 are: ")
for number in numtuple:
    if int(number)%5==0:
        print(number," ")
