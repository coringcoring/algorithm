# Segement Tree
특정 구간 내 데이터에 대한 연산(쿼리)을 빠르게 구할 수 있는 트리. (ex. 특정 구간 합,최소값,최대값,평균값 등)
* 시간 복잡도: O(logN)

![image](https://github.com/java-coding-test/kjy/assets/65723420/9d86bdb7-9a13-4da0-9e58-0d47ffcef4b7)

* 세그먼트 트리에는 Build, Query, Update 작업이 존재
* 세그먼트 트리는 완전 이진 트리 : 세그먼트 트리를 만드는데 필요한 노드 수
  ![image](https://github.com/java-coding-test/kjy/assets/65723420/2b38e1e0-b77a-43b3-8a5b-921fa2d9a859)

## Build
세그먼트 트리를 만드는 작업. 재귀를 이용하여 구축.<br>
트리를 순회하면서 작업 
* leaf node라면 배열의 요소를 저장
* internal node라면 구간 정보를 저장 (ex. 구간 정보가 구간 합이라면 두 자식 노드의 합을 저장)

## Query
세그먼트 트리에서 구간 정보를 가져옴. <br>
* 노드가 나타내는 범위가 지정된 범위 밖에 있다면 0을 반환합니다.
* 노드가 나타내는 범위가 지정된 범위 내에 있다면 값을 반환합니다.
* 노드가 나타내는 범위가 지정된 범위 일부만 포함한다면 왼쪽 자식과 오른쪽 자식의 합을 반환합니다.
![image](https://github.com/java-coding-test/kjy/assets/65723420/2d618410-69e5-4cce-b1ab-4d81897950fa)
* 배열 A = {1,2,3,4,5}에서 2부터 4까지 구간 합을 구한다면 아래 그림처럼 컬러 노드들을 방문하게 되고 그중 초록색 노드 값을 사용하여 결과를 반환하게 됨

## Update
update는 index가 포함된 구간을 담당하는 노드들만 변경
![image](https://github.com/java-coding-test/kjy/assets/65723420/317eb835-9323-43f7-92b1-c16496b6ef28)
*  A = {1,2,3,4,5} 배열에서 A[2] = 5로 변경할 때, 변경해야 하는 구간은 다음과 같습니다. 색깔 노드는 방문하여 변경하는 노드
* index가 포함된 구간을 가지고 있는 자식 노드로 재귀
* 리프 노드라면 배열 값을 변경
* 내부 노드라면 구간 정보를 저장. (ex. 구간 정보가 구간 합이라면 두 자식 노드의 합을 저장)

<br>
* 변화량을 사용하여 (diff) 구현 가능 
* index 번째 배열 A를 val값으로 변경할 때 변화량은 diff = val - A[index]가 됩니다.
* index가 포함된 구간을 가진 노드들만 diff만큼 증가시키는 방식으로 구현합니다.
![image](https://github.com/java-coding-test/kjy/assets/65723420/c2a91565-8436-43dc-bcd7-599a0f38ffa3)




### References
* https://cano721.tistory.com/38
* https://yoongrammer.tistory.com/103
