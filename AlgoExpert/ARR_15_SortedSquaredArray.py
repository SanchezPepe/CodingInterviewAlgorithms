def sortedSquaredArray(array):
    squared = []
    p1 = 0
    p2 = len(array) - 1
    while p1 <= p2:
        left = array[p1]
        right = array[p2]
        if abs(left) > abs(right):
            squared.insert(0, left * left)
            p1 += 1
        else:
            squared.insert(0, right * right)
            p2 -= 1
    return squared
