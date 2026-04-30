import random
import time

def bubble_sort(arr):
    n = len(arr)
    for i in range(n):
        for j in range(0, n - i - 1):
            if arr[j] > arr[j + 1]:
                arr[j], arr[j + 1] = arr[j + 1], arr[j]

size = 10000
data = [random.randint(1, 100000) for _ in range(size)]

start = time.time()
bubble_sort(data)
end = time.time()

print("Execution Time:", end - start, "seconds")
