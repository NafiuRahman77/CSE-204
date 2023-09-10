#include <iostream>
#include <cstring>
#include <climits>
using namespace std;
int cities[10][10];  // Visit Cost holder
int dp[10][1 << 10]; // Sequence holder

int minimum_cost(int stop, int mask, int n)
{
    // Base Case reached the final city
    if (stop == n)
    {
        return 0;
    }
    // Backtracking previously visited city in the sequence holder
    if (dp[stop][mask] != -1)
    {
        return dp[stop][mask];
    }
    // Calculation of already visited cities and cost
    int temp_ans = INT_MAX;
    int temp;
    for (int i = 0; i < n; i++)
    {
        temp = 0;
        // Checking whether the city is visited before using mask and adding relative cost to temp
        for (int j = 0; j < n; j++)
        {
            if (!(mask & (1 << j)))
            {
                temp += cities[i][j];
            }
        }
        // Recursive call till end is reached
        if (mask & (1 << i))
        {
            temp_ans = min(temp_ans, (cities[i][i] + temp + minimum_cost(stop + 1, (mask ^ (1 << i)), n)));
        }
    }
    // return Answer
    return dp[stop][mask] = temp_ans;
}
int main()
{
    int n, result;
    cin >> n;
    memset(dp, -1, sizeof(dp));
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < n; j++)
        {
            cin >> cities[i][j];
        }
    }

    result = minimum_cost(0, (1 << n) - 1, n);
    cout << result;
    return 0;
}
