# TC O(n)
# SC O(n)

def hasSingleCycle(array):
    seen = set()
    i = 0
    while i not in seen:
        seen.add(i)
        i = (array[i] + i) % len(array)

    if len(seen) == len(array):
        return i == 0
    else:
        return False
