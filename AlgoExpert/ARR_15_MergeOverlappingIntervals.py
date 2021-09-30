# TC O(nlogn) + O(n) => O(nlogn)
# SC O(n) using sortedIn, Using intervals O(1)

def mergeOverlappingIntervals(intervals):

    # Write your code here.

    sortedInt = sorted(intervals, key=lambda x: x[0])
    i = 0
    while i < len(sortedInt) - 1:
        upperBL = sortedInt[i][1]
        lowerBR = sortedInt[i + 1][0]

        # [3,7] [9,10]

        if upperBL >= lowerBR:

            # Merge ints

            sortedInt[i][1] = max(sortedInt[i + 1][1], sortedInt[i][1])
            sortedInt.pop(i + 1)
        else:
            i += 1
    return sortedInt
