import pandas

dataframe = pandas.read_csv("sample.csv")

print("Full Data: ")
print(dataframe)
#Print the values only in the Usernames column
print("Usernames:")
print(dataframe["Usernames"])
#Print the username and password of the second row
print("Username: ", dataframe["Usernames"][1], " | ", "Password: ", dataframe["Passwords"][1])

#Sort the Usernames column data in ascending order and print data

print("Data sorted in ascending order of Usernames:")
print(dataframe.sort_values('Usernames'))

#Sort the Passwords column in descending order and print data
print("Data sorted in descending order of Passwords:")
print(dataframe.sort_values('Passwords', ascending=False))