import time
import random

def insertion_sort(arr):
    for i in range(1, len(arr)):
        key = arr[i]
        j = i - 1
        while j >= 0 and arr[j] > key:
            arr[j + 1] = arr[j]
            j -= 1
        arr[j + 1] = key

n = 10000
arr = [random.randint(0, 100000) for _ in range(n)]

start = time.time()
insertion_sort(arr)
end = time.time()

print("Execution Time:", end - start)
