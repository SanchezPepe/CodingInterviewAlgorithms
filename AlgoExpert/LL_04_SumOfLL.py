# This is an input class. Do not edit.
class LinkedList:
    def __init__(self, value):
        self.value = value
        self.next = None

def getValueAndNext(list):
	if(list is None):
		return (0, None)
	else:
		return (list.value, list.next)
	
def sumOfLinkedLists(l1, l2):
	carry = 0
	head = LinkedList(0)
	iterator = head
	while(l1 != None or l2 != None):
		
		tup1 = getValueAndNext(l1)
		val1 = tup1[0]
		l1 = tup1[1]
		
		tup2 = getValueAndNext(l2)
		val2 = tup2[0]
		l2 = tup2[1]
		
		sum = val1 + val2 + carry
		
		carry = 1 if sum > 9 else 0
		
		iterator.next = LinkedList(sum % 10)
		iterator = iterator.next
	
	if(carry == 1):
		iterator.next = LinkedList(1)
		
    return head.next
