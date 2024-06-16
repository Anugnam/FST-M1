import pandas

users = pandas.read_excel("sample.xlsx")

#Print the number of rows and columns
print("Number of rows and columns are:",users.shape)

#Print the data in the emails column only
print("Values in email",users["Email"])

#Sort the data based on FirstName in ascending order and print the data
print("Values after sorting first names in descending order: ",users.sort_values("FirstName",ascending=False))