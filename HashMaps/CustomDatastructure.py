# 
#  Link: https://leetcode.com/problems/insert-delete-getrandom-o1/


import random
class RandomizedSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.arr = []
        self.arrIndexMap = {}

    def insert(self, val: int) -> bool:
        """
        Inserts a value to the set. Returns true if the set did not already contain the specified element.
        """
        if self.arrIndexMap.get(val, None) != None:
            return False
        else:
            self.arr.append(val)
            self.arrIndexMap[val] = len(self.arr) - 1 
            return True    

    def remove(self, val: int) -> bool:
        """
        Removes a value from the set. Returns true if the set contained the specified element.
        """
        xIdx  = self.arrIndexMap.get(val, None)
        if xIdx != None:
            # swap element to be deleted with the last element from the list
            lastIdx = len(self.arr) - 1
            self.arr[xIdx], self.arr[lastIdx] = self.arr[lastIdx], self.arr[xIdx]
            self.arrIndexMap[self.arr[xIdx]] = xIdx
            del self.arr[lastIdx]
            del self.arrIndexMap[val]
            return True
        else:
            return False
        
        

    def getRandom(self) -> int:
        """
        Get a random element from the set.
        """
        if self.arr:
            if len(self.arr) == 1:
                return self.arr[0]
            rIdx = random.randint(0, len(self.arr)-1)
            return self.arr[rIdx]
        else:
            return None
            
            
if __name__ == "__main__":

    obj = RandomizedSet()
    param_1 = obj.insert(1)
    print(param_1)
    param_1 = obj.remove(2)
    print(param_1)
    param_1 = obj.insert(2)
    print(param_1)
    param_1 = obj.getRandom()
    print(param_1)
    param_1 = obj.remove(1)
    print(param_1)
    param_1 = obj.insert(2)
    print(param_1)


