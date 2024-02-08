#include <iostream>
using namespace std;

// int GB2UFT8(int); .. error: expected unqualified-id
// Main.cpp:5:5: error: expected unqualified-id int 256bit_count(double)
void josephus(){
  int n=10, s = 1, m = 5;
  int i, a[100], j[100];
  for (i = 0; i < n; i++)
  {
    a[i] = i + 1;
  }
  int t = 0, x = 0, k = 0;
  s = s-1;
  while (t < n) 
  {
    if (a[s] != 0)
      k++;
    if (k == m) 
    {
      j[x] = a[s];
      a[s] = 0;
      t++;
      x++;
      k = 0;
    }
    s++;
    if (s == n)
      s==0;

    for (i = 0; i< n; i++)
    {
      cout << j[i] << " ";
    }
  }
}
void SelectionSort(int cards[], int n);
void SelectionSort(int [], int);
int main(){
  cout << "Hello nvim, Hollo CPP" <<endl;
  double d[4 * 3 + 2];
  cout << "1. d[4 * 3 + 2] test successfully." <<endl;
  
  int A[10] = {0}, B[20] = {0};
  for (auto i:A)
    cout<< " " << A[i] << " ";
  cout<<endl;
  cout<<"2.A[10] from start to end test successfully" << endl;

  int i = 2, j = 3, k = 5;
  A[i + j + k] = 10;
  cout<<"3.A[i + j + k] = 10 test okey."<<endl;

  cout<< "4. test functions define finished: GB2UTF8 and 256bit_count cannot be the names." << endl;
  josephus();
  cout<<"5. test Josephus problem." << endl;


  return 0;

}
