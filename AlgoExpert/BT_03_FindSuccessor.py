class BinaryTree:
    def __init__(
        self,
        value,
        left=None,
        right=None,
        parent=None,
        ):
        self.value = value
        self.left = left
        self.right = right
        self.parent = parent

def findSuccessor(tree, node):
    stack = []
    inOrder(tree, stack)

    i = 0
    prev = None
    while len(stack) != 0:
        current = stack.pop()
        print (current.value, 'prev: ', prev)
        if current.value == node.value:
            return prev
        else:
            prev = current

    return None

def inOrder(root, stack):
    if root:
        inOrder(root.left, stack)
        stack.append(root)
        inOrder(root.right, stack)
