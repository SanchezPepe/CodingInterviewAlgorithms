def findClosestValueInBst(tree, target):
    return findClosestValueInBstRC(tree, target, tree.value)

def findClosestValueInBstRC(tree, target, closest):
    if tree is None:
        return closest
    if abs(tree.value - target) < abs(closest - target):
        closest = tree.value
    if tree.value > target:
        return findClosestValueInBstRC(tree.left, target, closest)
    elif tree.value < target:
        return findClosestValueInBstRC(tree.right, target, closest)
    else:
        return closest

# This is the class of the input tree. Do not edit.
class BST:

    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None
