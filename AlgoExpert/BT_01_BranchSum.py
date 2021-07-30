# Notes: https://snchzpepe.notion.site/Branch-Sums-64bcc063fc2448b38db2cb7a93bcf1f6

# This is the class of the input root. Do not edit it.
class BinaryTree:
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None

def branchSums(root):
    sums = []
    branchDepth(sums, 0, root)
    return sums
    
def branchDepth(sums, sum, node):
    if node.left is None and node.right is None:
        sums.append(sum + node.value)
    else:
        sum += node.value
        if(node.left is not None):
            branchDepth(sums, sum, node.left)
        if(node.right is not None):
            branchDepth(sums, sum, node.right)
