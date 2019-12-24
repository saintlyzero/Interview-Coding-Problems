"""
    Space Complexity : O(M * N)
    Time Complexity : O(M * N)
"""


def number_of_ways(n: int, m:int):
    numberOfWays = [[0 for j in range(m)] for i in range(n)]
    return number_of_ways_to_XY(n-1, m-1, numberOfWays)


def number_of_ways_to_XY(n: int, m:int, numberOfWays:list):
    
    if n == 0 or m == 0:
        return 1

    if(numberOfWays[n][m] == 0):
        waysToTop =  number_of_ways_to_XY(n-1, m, numberOfWays)
        waysToLeft = number_of_ways_to_XY(n, m-1, numberOfWays)
        numberOfWays[n][m] = waysToLeft + waysToTop
    
    return numberOfWays[n][m]


if __name__ == "__main__":
    n = 3
    m = 3

    ways = number_of_ways(n, m)
    print("Number of ways: ",ways)