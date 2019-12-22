"""
    Problem Link: https://www.hackerrank.com/challenges/migratory-birds
    
    Time Complexity :  O(N)
    Space Complexity:  O(M) ; M : Distinct Numbers

"""

def migratoryBirds(arr):
    count = [0]*6
    for i in arr:
        count[i] += 1
    return count.index(max(count))
    # index() considers index of first occurence of the element

if __name__ == "__main__":
    arr = [1,4,4,4,5,5,5,3]
    max_bird = migratoryBirds(arr)
    print("res: ",max_bird)  # 4

