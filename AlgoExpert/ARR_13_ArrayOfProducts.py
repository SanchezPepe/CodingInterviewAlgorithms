# TC O(n) where n is the lenght of the array 
# SC O(n)

def arrayOfProducts(array):
    prods = [1]
    j = len(array)
    aux = array[0]

    # From left to right

    for i in range(1, j):
        prods.append(aux)
        aux *= array[i]
        print ('izq ', aux)

    print ('l to r', prods)

    # From right to left

    aux = array[j - 1]
    for i in range(2, j + 1):
        print ('aux antes ', aux, array[-i])

        prods[-i] *= aux
        aux *= array[-i]
        print ('der ', aux)

    return prods
