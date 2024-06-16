username1 = input("Enter 1st player name:")
username2 = input("Enter 2nd player name:")

while True:
    user1_answer = input(username1 + " chooses: ").lower()
    user2_answer = input(username2 + " chooses: ").lower()
    if user1_answer == "rock":
       if user2_answer == "scissor":
            print("Rocks win")
       else:
           print("Papers win")
    elif user1_answer == "scissor":
        if user2_answer == "paper":
            print("Scissors win")
        else:
            print("Rocks win")
    elif user1_answer == "paper":
        if user2_answer == "rock":
            print("Papers win")
        else:
            print("Scissors win")
    elif user1_answer == user2_answer:
        print("Its a tie")
    else:
        print("Invalid input")
    
    repeat = input("Do you want play another round? Yes/No: ").lower()

    if(repeat=="yes"):
        pass
    elif(repeat=="no"):
        raise SystemExit
    else:
        print("Invalid option. Exiting now")
        raise SystemExit


