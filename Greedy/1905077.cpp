#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;
int main()
{
    int N, K, a, j = 0;
    long long int result = 0;
    cin >> N;
    cin >> K;
    vector<int> plants(N), friends(K);
    for (int i = 0; i < N; i++)
    {
        cin >> plants[i];
    }
    for (int i = 0; i < K; i++)
    {
        friends[i] = 0;
    }
    sort(plants.begin(), plants.end()); // Greedy approach, expensive plants are brought fewer times than less expensive ones
    for (int i = N - 1; i >= 0; i--)
    {
        result += (friends[j] + 1) * plants[i];
        friends[j]++;
        j = (j + 1) % K;
    }
    cout << result;
}
