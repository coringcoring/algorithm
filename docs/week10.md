# Union-Find, MST

## Union-Find
* Disjoint set?: 서로 중복되지 않는 부분 집합들로 나눠진 원소들에 대한 정보를 저장하고 조작하는 자료구조
  ![image](https://github.com/java-coding-test/kjy/assets/65723420/1c485b18-fb3b-4268-993d-5faea1f027b8)
  * 공통 원소가 없는 상호 배타적인 부분 집합들로 나눠진 원소들에 대한 자료구조
  * 서로소 집합 자료구조 
* Union Find?: Disjoint set을 표현할 때 사용하는 알고리즘 
* 집합 구현 방법: 비트 벡터, 배열, 연결 리스트, `트리 구조` -> 트리구조가 가장 효율적
### Union, Find 연산 
* Find 연산: 어떤 원소가 속한 그룹을 찾아내는 연산 -> 루트 노드를 찾아내는 것 
* Union 연산: 2개의 그룹을 1개의 그룹으로 합치는 작업 
### Union-Find 과정 
![image](https://github.com/java-coding-test/kjy/assets/65723420/86dc9a9f-39b9-4581-b028-0dbc11944f03)
### Union-Find 사용 
전체 집합이 있을때 구성 원소들이 **겹치지 않도록 분할 partition**하는데 자주 사용됨
* 예시
  * Kruskal MST 알고리즘에서 새로 추가할 간선의 양끝 정점이 같은 집합에 속해 있는지(사이클 형성 여부 확인)에 대해 검사하는 경우
  * 초기에 {0}, {1}, {2}, … {n} 이 각각 n+1개의 집합을 이루고 있다. 여기에 합집합 연산과, 두 원소가 같은 집합에 포함되어 있는지를 확인하는 연산을 수행하려는 경우
  * 어떤 사이트의 친구 관계가 생긴 순서대로 주어졌을 때, 가입한 두 사람의 친구 네트워크에 몇 명이 있는지 구하는 프로그램을 작성하는 경우
* 분할(partition)? : 집합을 분할한다 == 각 부분집합이 조건 2가지를 만족하는 disjoint set이 되도록 쪼개는 것
  * 조건1: 분할된 부분 집합을 합치면 원래의 전체집합이 됨
  * 조건2: 분할된 부분 집합끼리는 겹치는 원소가 없음 

### References
* https://todaycode.tistory.com/108
* https://gmlwjd9405.github.io/2018/08/31/algorithm-union-find.html
