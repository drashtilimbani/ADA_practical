import random
import time

def quick_sort(arr):
    if len(arr) <= 1:
        return arr
    pivot = arr[len(arr) // 2]
    left = [x for x in arr if x < pivot]
    middle = [x for x in arr if x == pivot]
    right = [x for x in arr if x > pivot]
    return quick_sort(left) + middle + quick_sort(right)

n = int(input())
arr = [random.randint(1, 1000000) for _ in range(n)]

start = time.time()
sorted_arr = quick_sort(arr)
end = time.time()

print(end - start)
