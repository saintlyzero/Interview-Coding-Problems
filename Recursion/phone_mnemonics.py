
# Time Complexity : O(4^n)
# 4 corresponds to maximum characters mapped to a number
# n corresponds to number of digits in the phone_number

def phoneMnemonic(p_number:int, number_char_map:dict):
    p_number = str(p_number)
    mnemonics = []
    partial_mnemonic = [0] * len(p_number)
    phoneMnemonicHelper(p_number, 0, partial_mnemonic, mnemonics, number_char_map)
    return mnemonics


def phoneMnemonicHelper(p_number:str, index:int, partial_mnemonic:list, mnemonics:list, number_char_map:dict):
    if index == len(p_number):
        mnemonics.append([el for el in partial_mnemonic]) # Create a DeepCopy of partial_mnemonic
    else:
        cur_digit = int(p_number[index])
        for char in number_char_map[cur_digit]:
            partial_mnemonic[index] = char
            phoneMnemonicHelper(p_number, index+1, partial_mnemonic, mnemonics, number_char_map)


if __name__ == "__main__":
    
    number_char_map = {
        0: [0],
        1: [1],
        2: ['a','b','c'],
        3: ['d','e','f'],
        4: ['g','h','i'],
        5: ['j','k','l'],
        6: ['m','n','o'],
        7: ['p','q','r','s'],
        8: ['t','u','v'],
        9: ['w','x','y','z']
    }

    p_number = 5634
    res = phoneMnemonic(p_number, number_char_map)
    for i in res:
        print(i)
