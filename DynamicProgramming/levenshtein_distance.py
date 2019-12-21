"""
Time Complexity: O(N*M)
Space Complexity: O(N*M)
"""

def editDistance(str1:str, str2:str):
    m = len(str1)
    n = len(str2)

    table = [[0 for x in range(n+1)] for x in range(m+1)]


    for i in range(m+1):
        for j in range(n+1):

            """
                If anyone of the string is empty,
                then the number of edits required
                equals the lenght of the non-empty 
            """
            if min(i,j) == 0:
                table[i][j] = max(i,j)

            # If last character of both strings are same
            elif str1[i-1] == str2[j-1]:
                table[i][j] = table[i-1][j-1]


            # If characters are different
            else:
                table[i][j] = 1 + min(
                    table[i-1][j],    #Delete
                    table[i][j-1],    #Insert
                    table[i-1][j-1])  #Replace


    return table[i][j]


if __name__ == "__main__":

    str1 = "abc"
    str2 = "abed"
    print(editDistance(str1, str2)) # op: 2