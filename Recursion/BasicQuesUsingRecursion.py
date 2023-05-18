'''Function to print  number from 1 to n using recursion'''
def printtillN(n:int):
    if n==0:
        return
    else:
        printtillN(n-1)
        print(n,end=" ")
#-----------------------------------------------------------------------------------------------
'''Function to print  number from n to 1 using recursion'''
def reversetill1(n:int):
    if n==0:
        return
    else:
        print(n,end=" ")
        reversetill1(n-1)
#-------------------------------------------------------------------------------------------
'''Function to print the maximum of an element in the array using recursion'''
def maxi(arr,i):
    if i==len(arr)-1:
        return arr[i]
    else:
        max1=max(arr[i],maxi(arr,i+1))
    return max1
# ---------------------------------------------------------------------------------------------------------------
'''Function to print the minimum of an element in the array using recursion'''
def mini(arr,i):
    if i==len(arr)-1:
        return arr[i]
    else:
        min1=min(arr[i],mini(arr,i+1))
    return min1
# ---------------------------------------------------------------------------------------
'''Function to print the element of the array as it is'''
def printasitis(arr,i):
    if (i==len(arr)):
        return
    else:
        print(arr[i],end=" ")
        printasitis(arr,i+1)
    return

#-------------------------------------------------------------------------------------------------
'''Functions to print the array elements in reverse order'''
def reverse(arr,i):
    if (i==len(arr)):
        return
    else:
        reverse(arr,i+1)
        print(arr[i],end=" ")
    return
# Driver code
if __name__=='__main__':
    num=int(input("Enter a number to print from 1 to n: "))
    printtillN(num)
    print()
    num1=int(input("Enter a number to print from n to 1: "))
    reversetill1(num1)
    print()
    print("Array to print as it is using recursion:")
    arr=[1,2,3,4,5]
    printasitis(arr,0)
    print()
    print("Array in  reverse order using recursion")
    reverse(arr,0)
    print()
    print("Maximum Element of the array is")
    print(maxi(arr,0))
    print("Minimum Element of the array is")
    print(mini(arr,0))






