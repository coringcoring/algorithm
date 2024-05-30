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

## MST(Minimum Spanning Tree) 
* Spanning Tree(=신장트리)? : 그래프 내의 모든 정점을 포함하는 트리
  ![image](https://github.com/java-coding-test/kjy/assets/65723420/a85de42e-8c61-43a6-96f9-6b07b49e7c01)
  * 그래프의 최소 연결(간선 수가 가장 작음) 부분 그래프(일부 간선을 선택) 
  * n개의 정점을 가지는 그래프의 최소 간선의 수는 (n-1)개 -> (n-1)개의 간선으로 연결되어 있으면 필연적으로 트리 형태 -> Spanning Tree
  * 사이클을 포함해선 안됨
  * 모든 정점들이 연결되어 있어야함 
  * 하나의 그래프에는 많은 신장 트리 존재 가능
* MST(Minimum Spanning Tree)(=최소 신장 트리): Spanning tree 중 사용된 간선들의 가중치 합이 최소인 트리
  * 간선의 가중치 합이 최소여야 함
  * n개의 정점을 가지는 그래프에 대해 반드시 n-1개의 간선만을 사용해야함
  * 사이클이 포함되어선 안됨 
### Kruskal MST 알고리즘 
그리디 방법을 사용해서 그래프의 모든 정점을 최소 비용으로 연결하는 최적 해답을 구하는 것 
* 과정
  1. 그래프의 간선들을 가중치의 오름차순으로 정렬
  2. 정렬된 간선 리스트에서 순서대로 사이클을 형성하지 않는 간선을 선택
  3. 해당 간선을 현재의 MST 집합에 추가

#### 예시) 초기 집합 
![image](https://github.com/java-coding-test/kjy/assets/65723420/cf2aa1fc-98e9-4def-9b4b-cd36ccc7d512)

#### 예시) 진행 과정 
![image](https://github.com/java-coding-test/kjy/assets/65723420/ab5d8db8-d285-49e6-b516-0782b47a2cae)
비용이 적은 간선의 양 끝 노드를 선택하면서 사이클이 존재하지 않는다면(find(a)!=find(b) -> 부모가 같지 않다면, 독립된 집합(or 노드)이라면) union+해당 간선 선택(이미 존재하면 skip) -> 모든 간선에 대해 탐색이 끝날때까지 동작을 반복 
![image](https://github.com/java-coding-test/kjy/assets/65723420/42784c35-f717-437c-8d11-fcf240838822)
![image](https://github.com/java-coding-test/kjy/assets/65723420/22c2860e-df31-496f-9fd4-6ebdebb78c35)
![image](https://github.com/java-coding-test/kjy/assets/65723420/28fa369f-3d95-4150-a439-5183e5598c37)
![image](https://github.com/java-coding-test/kjy/assets/65723420/95cd0b38-a579-4b21-83f9-1b8877b49cea)
![image](https://github.com/java-coding-test/kjy/assets/65723420/f26f3be4-2a9a-4845-87fe-8ac1afd91829)
![image](https://github.com/java-coding-test/kjy/assets/65723420/6399a73f-ec03-470a-8585-0178f95de00c)

#### Kruskal 알고리즘 시간 복잡도 
**O(ElogV)** 
* 가중치 정렬하는데 걸리는 시간: O(ElogE)
* 간선의 수가 최대 V^2가 될 수 있으므로 -> O(logE)=O(logV^2)=O(2logV)=O(logV) => 따라서 O(ElogV) 

### Prim MST 알고리즘
시작 정점에서 출발하여 신장트리 집합을 단계적으로 확장하는 방법 
* 정점 선택을 기반으로 하는 알고리즘
* 과정
  1. 시작 단계에서는 시작 정점만이 MST(최소 비용 신장 트리) 집합에 포함된다.
  2. 앞 단계에서 만들어진 MST 집합에 인접한 정점들 중에서 최소 간선으로 연결된 정점을 선택하여 트리를 확장 -> 가장 낮은 가중치를 먼저 선택한다
  3. 위의 과정을 트리가 (N-1)개의 간선을 가질 때까지 반복한다.

#### 예시 ) 진행 과정 
![image](https://github.com/java-coding-test/kjy/assets/65723420/ab896862-bd78-40a0-b558-ec087aafc49e)
![image](https://github.com/java-coding-test/kjy/assets/65723420/90802c34-236d-4527-b854-ae6d736cbf4b)
![image](https://github.com/java-coding-test/kjy/assets/65723420/d045796d-6482-47e4-86ac-ae1e0c4e9489)
![image](https://github.com/java-coding-test/kjy/assets/65723420/993fd052-85a8-480c-9ba1-d96c8385f8d9)
![image](https://github.com/java-coding-test/kjy/assets/65723420/8eaa04b6-e1e9-40b7-afa7-4ad5b4e84980)
![image](https://github.com/java-coding-test/kjy/assets/65723420/d2d0c3bf-c79e-4320-b8eb-089718f96309)
![image](https://github.com/java-coding-test/kjy/assets/65723420/8d5989d4-da6c-47ba-a74e-71ae9be31e5d)
![image](https://github.com/java-coding-test/kjy/assets/65723420/068daf17-86bd-495b-b9a3-de4f1346e648)
![image](https://github.com/java-coding-test/kjy/assets/65723420/3c55b611-f10c-43f4-b10a-3fd1734ca718)

#### Prim 알고리즘 시간복잡도 
우선순위큐로 구현하면: O(ElogV)
* 모든 노드에 대해 탐색 진행: O(V)
* 노드마다 최소 간선을 찾는 시간: O(logV)
* 따라서 탐색과정: `O(VlogV)`
* 각 노드의 인접 간선을 찾는 시간 = 모든 노드의 차수와 같으므로 : O(2E)=O(E)
* 각 간선에 대해 힙에 넣는 과정: O(logV)
* 우선순위 큐 구성 시간: `O(ElogV)`
* O(VlogV+ElogV) => O(`ElogV`) 

인접행렬로 구현하면: O(V^2)
* 각 정점에 최소 간선을 갖는 정점 탐색을 매번 정점마다 수행: O(|V|^2) 소요
* 탐색 결과를 기반으로 각 정점의 최소비용연결 정점 탐색: O(1) 소요
* 따라서 `O(V^2)`

### Kruskal vs Prim
![image](https://github.com/java-coding-test/kjy/assets/65723420/000466ea-fc9e-4033-9a0f-de1e70df20f2)


### References
* https://todaycode.tistory.com/108
* https://gmlwjd9405.github.io/2018/08/31/algorithm-union-find.html
* https://gmlwjd9405.github.io/2018/08/28/algorithm-mst.html
* https://sskl660.tistory.com/72
* https://velog.io/@suk13574/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98Java-%ED%94%84%EB%A6%BCPrim-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98
* https://kwin0825.tistory.com/77
* https://loosie.tistory.com/159#%ED%81%AC%EB%A3%A8%EC%8A%A4%EC%B9%BC_vs_%ED%94%84%EB%A6%BC
* https://8iggy.tistory.com/159
