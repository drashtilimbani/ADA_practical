import time
import random

def selection_sort(arr):
    n = len(arr)
    for i in range(n):
        min_idx = i
        for j in range(i+1, n):
            if arr[j] < arr[min_idx]:
                min_idx = j
        arr[i], arr[min_idx] = arr[min_idx], arr[i]

data = [random.randint(0, 1000000) for _ in range(10000)]

start = time.time()
selection_sort(data)
end = time.time()

print("Execution Time:", end - start, "seconds")
