#ifndef HEAPSORT_HEAP_H
#define HEAPSORT_HEAP_H

#include <algorithm>
#include <cassert>

using namespace std;


template<typename Item>
class MaxHeap {

private:
	Item * data;
	int count;
	int capacity;

	void shiftUp(int k) {
		Item e = data[k];
		while (k > 1 && data[k / 2] < e) {
			//swap(data[k / 2], data[k]);
			data[k] = data[k / 2];
			k /= 2;
		}
		data[k] = e;
	}

	void shiftDown(int k) {
		Item e = data[k];
		while (2 * k <= count) {

			int j = 2 * k;//在此轮循环中，data[k]和data[j]交换位置
			if (j + 1 <= count && data[j + 1] > data[j])
				j += 1;

			if (e >= data[j]) {
				break;
			}

			//swap(data[k],data[j]);
			data[k] = data[j];
			k = j;
		}
		data[k] = e;
	}

public:

	MaxHeap(int capacity) {
		data = new Item[capacity + 1];
		count = 0;
		this->capacity = capacity;
	}

	MaxHeap(Item arr[], int n) {
		data = new Item[n + 1];
		capacity = n;

		for (int i = 0; i < n; i++)
			data[i + 1] = arr[i];
		count = n;

		for (int i = count / 2; i >= 1; i--)
			shiftDown(i);
	}

	~MaxHeap() {
		delete[] data;
	}

	int size() {
		return count;
	}

	bool isEmpty() {
		return count == 0;
	}

	void insert(Item item) {
		assert(count + 1 <= capacity);
		data[count + 1] = item;
		shiftUp(count + 1);
		count++;
	}

	Item extractMax() {
		assert(count > 0);
		Item ret = data[1];
		swap(data[1], data[count]);
		count--;
		shiftDown(1);
		return ret;
	}

	Item getMax() {
		assert(count > 0);
		return data[1];
	}
};

#endif //HEAPSORT_HEAP_H
