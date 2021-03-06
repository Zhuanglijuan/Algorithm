// MergeSort.cpp: 定义控制台应用程序的入口点。
//

#include "stdafx.h"
#include<algorithm>
#include"SortTestHelper.h"
#include"MergeSort.h"
using namespace std;

void test() {
	int n = 50000;

	// 测试1 一般性测试
	cout << "Test for Random Array, size = " << n << ", random range [0, " << n << "]" << endl;
	int* arr1 = SortTestHelper::generateRandomArray(n, 0, n);
	int* arr2 = SortTestHelper::copyIntArray(arr1, n);

	SortTestHelper::testSort("Insertion Sort", insertionSort, arr1, n);
	SortTestHelper::testSort("Merge Sort", mergeSort, arr2, n);

	delete[] arr1;
	delete[] arr2;
	cout << endl;

	// 测试2 测试近乎有序的数组
	int swapTimes = 100;
	cout << "Test for Random Nearly Ordered Array, size = " << n << ", swap time = " << swapTimes << endl;
	arr1 = SortTestHelper::generateNearlyOrderedArray(n, swapTimes);
	arr2 = SortTestHelper::copyIntArray(arr1, n);

	SortTestHelper::testSort("Insertion Sort", insertionSort, arr1, n);
	SortTestHelper::testSort("Merge Sort", mergeSort, arr2, n);

	delete(arr1);
	delete(arr2);
	return;
}

template<typename T>
void mergeSortBottomUp(T arr[], int n) {
	for (int size = 1; size <= n; size += size) {
		for (int i = 0; i + size < n; i += size + size) {
			//对arr[i...i + size -1] 和arr[i + size...i + 2 * size -1]进行归并
			__merge(arr, i, i + size - 1,min( i + size + size - 1,n-1));
		}
	}
}

int main()
{
	//test();

    return 0;
}

