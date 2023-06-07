#include <iostream>
#include <string.h>
using namespace std;

void lcs(char *S1, char *S2, int m, int n) {
  int dp[m + 1][n + 1];

  // Building the mtrix in bottom-up way
  for (int i = 0; i <= m; i++) {
    for (int j = 0; j <= n; j++) {
      if (i == 0 || j == 0)
        dp[i][j] = 0;
      else if (S1[i - 1] == S2[j - 1])
        dp[i][j] = dp[i - 1][j - 1] + 1;
      else
        dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]);
    }
  }

  int index = dp[m][n];
  char str[index + 1];
  str[index] = '\0';

  int i = m, j = n;
  while (i > 0 && j > 0) {
    if (S1[i - 1] == S2[j - 1]) {
      str[index - 1] = S1[i - 1];
      i--;
      j--;
      index--;
    }

    else if (dp[i - 1][j] > dp[i][j - 1])
      i--;
    else
      j--;
  }

    // Printing the sub sequences and length
    cout<<dp[m][n]<<endl;
    cout << str<<endl;
}

int main() {
    int m,n;
    char S1[50];
    cin>>S1;
    char S2[50];
    cin>>S2;

    lcs(S1, S2, strlen(S1), strlen(S2));
}
