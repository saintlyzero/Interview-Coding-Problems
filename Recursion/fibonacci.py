def fibonacci(num: int, data: dict) -> int:
    """
    Compute Fibonacci number using DP

    Args:
        num (int): index
        data (dict): DP dict

    Returns:
        int: res
    """
    if num <= 1:
        return num
    
    # check if we already have fibonacci number at index(num)
    if data.get(num):
        return data.get(num)
    
    # if not, add entry to the DP dict
    else:
        res = fibonacci(num-1, data) + fibonacci(num-2, data)
        data[num] = res
        return res 

if __name__ == "__main__":
    N = 19
    res = fibonacci(N, dict())
    print(res)
    