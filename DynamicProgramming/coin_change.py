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



def count_combinations_dp(coins:list, total_coins:int, target:int):
    
    table = [0 for i in range(target+1)]
    table[0] = 1

    for coin in coins:
        for j in range(coin,target+1):
            table[j] += table[j-coin]
    
    return table[target]


if __name__ == "__main__":
    coins = [1,2,3]
    coin_number = len(coins) - 1
    target = 10
    # combinations = count_combinations_recurssive(coins, coin_number, target)
    # print(combinations)
    
    
    combinations = count_combinations_dp(coins, coin_number, target)
    print(combinations)