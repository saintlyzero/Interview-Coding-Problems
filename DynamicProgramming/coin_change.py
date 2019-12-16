def count_combinations_recurssive(coins:list, coin_number:int, target:int):
    
    # If target is 0 then there is 1 
    # solution : do not include any coin
    if target == 0:
        return 1
    
    if coin_number < 0 and target >= 1:
        return 0
    
    if target < 0:
        return 0
    
    ways_without_current_coin = count_combinations_recurssive(coins, coin_number-1, target)
    ways_with_current_coin = count_combinations_recurssive(coins, coin_number, target - coins[coin_number])

    return ways_without_current_coin + ways_with_current_coin

if __name__ == "__main__":
    coins = [1,2,3]
    coin_number = len(coins) - 1
    target = 4
    combinations = count_combinations_recurssive(coins, coin_number, target)
    print(combinations)