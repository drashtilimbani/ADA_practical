#include <iostream>
#include <vector>
#include <climits>
using namespace std;

int main() {
    int n = 5;
    vector<vector<int>> graph = {
        {0, 2, 0, 6, 0},
        {2, 0, 3, 8, 5},
        {0, 3, 0, 0, 7},
        {6, 8, 0, 0, 9},
        {0, 5, 7, 9, 0}
    };

    vector<int> key(n, INT_MAX);
    vector<bool> mstSet(n, false);
    vector<int> parent(n);

    key[0] = 0;
    parent[0] = -1;

    for (int count = 0; count < n - 1; count++) {
        int u = -1, minKey = INT_MAX;

        for (int v = 0; v < n; v++) {
            if (!mstSet[v] && key[v] < minKey) {
                minKey = key[v];
                u = v;
            }
        }

        mstSet[u] = true;

        for (int v = 0; v < n; v++) {
            if (graph[u][v] && !mstSet[v] && graph[u][v] < key[v]) {
                parent[v] = u;
                key[v] = graph[u][v];
            }
        }
    }

    for (int i = 1; i < n; i++) {
        cout << parent[i] << " - " << i << " : " << graph[i][parent[i]] << endl;
    }

    return 0;
}
