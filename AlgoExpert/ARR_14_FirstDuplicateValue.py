# O(n) TC - Where n is the lenght of the array
# O(n) SC

def firstDuplicateValue(array):
    map = [0 for _ in range(len(array) + 1)]
    for i in range(len(array)):
        if map[array[i]] != 0:
            return array[i]
        else:
            map[array[i]] = 1
    return -1
