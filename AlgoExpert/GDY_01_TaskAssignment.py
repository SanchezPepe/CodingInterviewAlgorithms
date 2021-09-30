# TC O(n log n) n = 2k
# SC O(4k) = O(2n) = O(n)

def taskAssignment(k, tasks):
    sortedTasks = []
    assignments = []

    for i in range(2 * k):
        sortedTasks.append([i, tasks[i]])

    sortedTasks.sort(key=lambda x: x[1])

    for i in range(k):
        assignments.append([sortedTasks[i][0], sortedTasks[~i][0]])

    return assignments
