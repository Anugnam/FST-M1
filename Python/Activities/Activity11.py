fruits = {
    "apple": 10,
    "banana": 15,
    "orange": 8,
    "peaches": 15
}

fruitToCheck = input("What are you looking for? ").lower()

if(fruitToCheck in fruits):
    print("Yes",fruitToCheck," is available")
else:
    print("No",fruitToCheck," is not available")