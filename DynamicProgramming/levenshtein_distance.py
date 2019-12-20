def editDistance(str1:str, str2:str):
    m = len(str1)
    n = len(str2)

    table = [[0 for x in range(n+1)] for x in range(m+1)]


    for i in range(m+1):
        for j in range(n+1):


            if min(i,j) == 0:
                table[i][j] = max(i,j)


            elif str1[i-1] == str2[j-1]:
                table[i][j] = table[i-1][j-1]


            else:
                table[i][j] = 1 + min(
                    table[i-1][j],
                    table[i][j-1],
                    table[i-1][j-1])


    return table[i][j]


if __name__ == "__main__":

    str1 = "abc"
    str2 = "abed"
    print(editDistance(str1, str2))