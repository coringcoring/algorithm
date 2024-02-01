# WEEK 1: 정렬
알고리즘 수업 때 배웠었던 내용들 바탕 + 추가적으로 구글링하여 공부한 내용 중심으로 정리합니다. 추가적으로 찾은 내용은 모두 출처를 표기합니다. 

## 삽입 정렬 Insertion Sort
* 현재 선택된 원소의 앞 원소와 비교를 하면서 현재 원소의 적절한 위치를 찾는 방식
* 삽입 정렬의 특징
    * 안정적인 정렬: 같은 값의 원소들은 정렬 과정에서 상대적인 순서가 변경되지 않음
    * 제자리 정렬: 추가적인 메모리를 사용하지 않음
    * 시간 복잡도
        * 평균: O(n^2)
        * 최악: O(n^2)
        * 최선(이미 정렬된 경우): O(n)
    * 적응 정렬: 이미 정렬된 부분에 대해 빠르게 수행 가능
    * 교환비용: 삽입정렬은 원소들을 올바른 위치에 삽입하는 과정에서 교환을 수행. 교환 비용이 높은 상황이라면 다른 정렬 알고리즘 사용 필요.
        * **`작은` 데이터셋**이나 **`거의 정렬된`** 데이터셋에서 효율적으로 작동함
        * 큰 데이터셋에서는 더 효율적인 알고리즘 사용이 좋음 (퀵,병합,힙 정렬 등) 

![image](https://github.com/coringcoring/java-algorithm-study/assets/65723420/ba4c2325-67e9-450b-938d-f287e9765fcf)

* 구현 코드(java)
  ```java
    class Main {
      public static int[] arr = new int[5];
  
      public static void main(String[] args) {
  
          arr = new int[]{5, 4, 1, 3, 2};
  
          insertionSort(arr);
          for(int i=0; i<arr.length; i++) {
              System.out.print(arr[i] + " " );
          }
      }
  
      public static void insertionSort(int[] arr) {
          for (int i = 1; i < arr.length; i++) {
              // 선택 데이터
              int key = arr[i];
              //비교 데이터
              int j = i - 1;
  
              // 이전의 원소가 더 크다면 데이터는 하나씩 밀려난다.
              while (j >= 0 && arr[j] > key) {
                  arr[j + 1] = arr[j];
                  j--;
              }
              arr[j + 1] = key;
          }
      }
  }
  ```

## 선택 정렬 Selection Sort
* 현재 위치에 들어갈 데이터를 찾아 선택하는 알고리즘
* 특징
  * 데이터를 비교하면서 찾기 때문에 비교정렬
  * 추가적인 메모리 공간이 필요 없는 제자리 정렬(임시 변수 필요하나, 충분히 무시할만큼 적은 양이기 때문에 제자리 정렬로 봐도 됨)
  * 시간복잡도: O(n^2) 
  * 불안정 정렬
      * 정렬 규칙이 다수이거나 특정 순서를 유지해야할 때 문제가 될 수 있음
        * ex. 성적순이되, 성적이 같다면 이름순으로 정렬하고 싶을 때 

![image](https://github.com/coringcoring/java-algorithm-study/assets/65723420/14fd75e4-49a8-45a9-baa0-aedbc7f50d43)

* 코드
  ```java
    public class Selection_Sort {
   
  	public static void selection_sort(int[] a) {
  		selection_sort(a, a.length);
  	}
  	
  	private static void selection_sort(int[] a, int size) {
  		
  		for(int i = 0; i < size - 1; i++) {
  			int min_index = i;	
  			
  			// 최솟값을 갖고있는 인덱스 찾기 
  			for(int j = i + 1; j < size; j++) {
  				if(a[j] < a[min_index]) {
  					min_index = j;
  				}
  			}
  			
  			// i번째 값과 찾은 최솟값을 서로 교환 
  			swap(a, min_index, i);
  		}
  	}
  	
  	private static void swap(int[] a, int i, int j) {
  		int temp = a[i];
  		a[i] = a[j];
  		a[j] = temp;
  	}
  	
  }
  ```

## 교환 정렬 Exchange Sort(=버블 정렬 Bubble Sort) 
* 단순히 하나씩 교환하면서 정렬하는 알고리즘
* 시간복잡도: O(n^2)
* 배열 내에서 정렬이 일어나므로 제자리 정렬
* 추가적인 저장장소 사용 o
  * 사용량: O(1)

![image](https://github.com/coringcoring/java-algorithm-study/assets/65723420/98261080-ce30-4926-8d94-22ce68e9b665)

* 코드
  ```java
    public class Exchange {
  
  	public static void exchangesort(int n, int[] S) {
  		
  		for(int i = 0; i < n - 1; i++) {
  			for(int j = i + 1; j < n; j++) {
  				if(S[i] > S[j]) {			// 키 비교횟수의 모든 경우 시간복잡도의 단위연산
  					int temp = S[i];		// 레코드 지정횟수의 최악의 경우 시간복잡도의 단위연산
  					S[i] = S[j];		// 레코드 지정횟수의 최악의 경우 시간복잡도의 단위연산
  					S[j] = temp;		// 레코드 지정횟수의 최악의 경우 시간복잡도의 단위연산
  				}
  			}
  		}
  	}
  }
  ```

## 합병 정렬 Merge Sort
* 분할정복(Divide and Conquer) 알고리즘을 기반으로 정렬되는 방식
* 특징
    * 비교 정렬: 데이터를 비교하면서 찾음
    * 제자리 정렬이 아님: 추가적인 데이터 공간 필요
      * 제자리 정렬로 구현할 수 있으나 성능을 일부 포기해야함
    * 안정 정렬
 
![image](https://github.com/coringcoring/java-algorithm-study/assets/65723420/bbcd8d0b-0242-4ee0-a411-9e3049d1cd4e)

* 코드
  ```java
      public class Merge_Sort {
     
    	private static int[] sorted;		// 합치는 과정에서 정렬하여 원소를 담을 임시배열
    	
    	public static void merge_sort(int[] a) {
    		
    		sorted = new int[a.length];
    		merge_sort(a, 0, a.length - 1);
    		sorted = null;
    	}
    	
    	// Top-Down 방식 구현
    	private static void merge_sort(int[] a, int left, int right) {
    		
    		/*
    		 *  left==right 즉, 부분리스트가 1개의 원소만 갖고있는경우 
    		 *  더이상 쪼갤 수 없으므로 return한다.
    		 */
    		if(left == right) return;
    		
    		int mid = (left + right) / 2;	// 절반 위치 
    		
    		merge_sort(a, left, mid);		// 절반 중 왼쪽 부분리스트(left ~ mid)
    		merge_sort(a, mid + 1, right);	// 절반 중 오른쪽 부분리스트(mid+1 ~ right)
    		
    		merge(a, left, mid, right);		// 병합작업
    		
    	}
    	
    	/**
    	 * 합칠 부분리스트는 a배열의 left ~ right 까지이다. 
    	 * 
    	 * @param a		정렬할 배열
    	 * @param left	배열의 시작점
    	 * @param mid	배열의 중간점
    	 * @param right	배열의 끝 점
    	 */
    	private static void merge(int[] a, int left, int mid, int right) {
    		int l = left;		// 왼쪽 부분리스트 시작점
    		int r = mid + 1;	// 오른쪽 부분리스트의 시작점 
    		int idx = left;		// 채워넣을 배열의 인덱스
    		
    		
    		while(l <= mid && r <= right) {
    			/*
    			 *  왼쪽 부분리스트 l번째 원소가 오른쪽 부분리스트 r번째 원소보다 작거나 같을 경우
    			 *  왼쪽의 l번째 원소를 새 배열에 넣고 l과 idx를 1 증가시킨다.
    			 */
    			if(a[l] <= a[r]) {
    				sorted[idx] = a[l];
    				idx++;
    				l++;
    			}
    			/*
    			 *  오른쪽 부분리스트 r번째 원소가 왼쪽 부분리스트 l번째 원소보다 작거나 같을 경우
    			 *  오른쪽의 r번째 원소를 새 배열에 넣고 r과 idx를 1 증가시킨다.
    			 */
    			else {
    				sorted[idx] = a[r];
    				idx++;
    				r++;
    			}
    		}
    		
    		/*
    		 * 왼쪽 부분리스트가 먼저 모두 새 배열에 채워졌을 경우 (l > mid)
    		 * = 오른쪽 부분리스트 원소가 아직 남아있을 경우
    		 * 오른쪽 부분리스트의 나머지 원소들을 새 배열에 채워준다.
    		 */
    		if(l > mid) {
    			while(r <= right) {
    				sorted[idx] = a[r];
    				idx++;
    				r++;
    			}
    		}
    		
    		/*
    		 * 오른쪽 부분리스트가 먼저 모두 새 배열에 채워졌을 경우 (r > right)
    		 * = 왼쪽 부분리스트 원소가 아직 남아있을 경우
    		 * 왼쪽 부분리스트의 나머지 원소들을 새 배열에 채워준다.
    		 */
    		else {
    			while(l <= mid) {
    				sorted[idx] = a[l];
    				idx++;
    				l++;
    			}
    		}
    		
    		/*
    		 * 정렬된 새 배열을 기존의 배열에 복사하여 옮겨준다.
    		 */
    		for(int i = left; i <= right; i++) {
    			a[i] = sorted[i];
    		}
    	}
    }
  ```

## 퀵 정렬 Quick Sort
* 마찬가지로 분할 정복 알고리즘을 기반으로 정렬되는 방식
* 특징
  * 합병정렬과 달리 리스트가 비균등하게 나뉘어짐 (피벗을 기준으로 나뉘기 때문)
  * 비교정렬: 데이터를 비교하면서 찾음
  * 제자리 정렬: 추가적인 공간 필요하지 않음
  * 불안정 정렬: 두 개의 부분 리스트를 만들때 서로 떨어진 원소끼리 교환이 일어나기 때문

* 코드
  ```java
    public class QuickSort {
  	
  	public static void sort(int[] a) {
  		l_pivot_sort(a, 0, a.length - 1);
  	}
  	
  	/**
  	 *  왼쪽 피벗 선택 방식
  	 * @param a		정렬할 배열
  	 * @param lo	현재 부분배열의 왼쪽
  	 * @param hi	현재 부분배열의 오른쪽
  	 */
  	private static void l_pivot_sort(int[] a, int lo, int hi) {
  		
  		/*
  		 *  lo가 hi보다 크거나 같다면 정렬 할 원소가 
  		 *  1개 이하이므로 정렬하지 않고 return한다.
  		 */
  		if(lo >= hi) {
  			return;
  		}

  		int pivot = partition(a, lo, hi);	
  		
  		l_pivot_sort(a, lo, pivot - 1);
  		l_pivot_sort(a, pivot + 1, hi);
  	}
  	
  	
  	
  	/**
  	 * pivot을 기준으로 파티션을 나누기 위한 약한 정렬 메소드
  	 * 
  	 * @param a		정렬 할 배열 
  	 * @param left	현재 배열의 가장 왼쪽 부분
  	 * @param right	현재 배열의 가장 오른쪽 부분
  	 * @return		최종적으로 위치한 피벗의 위치(lo)를 반환
  	 */
  	private static int partition(int[] a, int left, int right) {
  		
  		int lo = left;
  		int hi = right;
  		int pivot = a[left];		// 부분리스트의 왼쪽 요소를 피벗으로 설정
  		
  		// lo가 hi보다 작을 때 까지만 반복한다.
  		while(lo < hi) {
  			
  			/*
  			 * hi가 lo보다 크면서, hi의 요소가 pivot보다 작거나 같은 원소를
  			 * 찾을 떄 까지 hi를 감소시킨다.
  			 */
  			while(a[hi] > pivot && lo < hi) {
  				hi--;
  			}
  			
  			/*
  			 * hi가 lo보다 크면서, lo의 요소가 pivot보다 큰 원소를
  			 * 찾을 떄 까지 lo를 증가시킨다.
  			 */
  			while(a[lo] <= pivot && lo < hi) {
  				lo++;
  			}
  			
  			// 교환 될 두 요소를 찾았으면 두 요소를 바꾼다.
  			swap(a, lo, hi);
  		}
  		
  		
  		/*
  		 *  마지막으로 맨 처음 pivot으로 설정했던 위치(a[left])의 원소와 
  		 *  lo가 가리키는 원소를 바꾼다.
  		 */
  		swap(a, left, lo);
  		
  		// 두 요소가 교환되었다면 피벗이었던 요소는 lo에 위치하므로 lo를 반환한다.
  		return lo;
  	}
   
  	private static void swap(int[] a, int i, int j) {
  		int temp = a[i];
  		a[i] = a[j];
  		a[j] = temp;
  	}
  }
  ```


## 힙 정렬 Heap Sort
* 힙(heap) 자료구조를 사용
  * 우선순위 큐를 사용한다
 
* 코드
  ```java
  import java.util.PriorityQueue;
   
  public class test {
  	public static void main(String[] args) {
      
  		int[] arr = {3, 7, 5, 4, 2, 8};
  		System.out.print(" 정렬 전 original 배열 : ");
  		for(int val : arr) {
  			System.out.print(val + " ");
  		}
  		
  		PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
  		
  		// 배열을 힙으로 만든다.
  		for(int i = 0; i < arr.length; i++) {
  			heap.add(arr[i]);
  		}
  		
  		// 힙에서 우선순위가 가장 높은 원소(root노드)를 하나씩 뽑는다.
  		for(int i = 0; i < arr.length; i++) {
  			arr[i] = heap.poll();
  		}
  		
  		
  		System.out.print("\n 정렬 후 배열 : ");
  		for(int val : arr) {
  			System.out.print(val + " ");
  		}
  		
  	}
  }
  ```

## 정렬 알고리즘 시간복잡도 비교 
![image](https://github.com/coringcoring/java-algorithm-study/assets/65723420/978e21e3-f495-49a0-ac17-aacbddec5f63)

### References
* https://moneylogging.tistory.com/entry/%EC%9E%90%EB%B0%94-%EC%82%BD%EC%9E%85%EC%A0%95%EB%A0%AC
* https://sfida.tistory.com/32
* https://st-lab.tistory.com/168
* https://somethoughts.tistory.com/20
* https://st-lab.tistory.com/195
* https://st-lab.tistory.com/233
* https://st-lab.tistory.com/250
* https://st-lab.tistory.com/225
