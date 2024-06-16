numberslist = list(input("Enter a sequence of comma separated values: ").split(","))
firstelement = numberslist[0]
lastelement = numberslist[len(numberslist)-1]
if (firstelement==lastelement):
    print(True)
else:
    print(False)