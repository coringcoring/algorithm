# Topology Sorting (위상정렬) 
위상정렬은 비순환 방향 그래프(사이클이 없는)(DAG)에서 정점을 선형으로 정렬하는 것. 
* ex) 대학교 특정 수강과목에 선수강 과목이 있다면, 그 선수강 과목부터 먼저 수강해야함 -> 선수강 과목을 정렬한다

## 진입차수&진출차수? 
* 진입차수(indegree): 특정 노드로 들어오는 간선의 개수
* 진출차수(outdegree): 특정 노드에서 나가는 간선의 개수     
  ![image](https://github.com/user-attachments/assets/da8669b2-f17f-46d5-82eb-9f11f670fa40)

## 구현방법- BFS
구현은 BFS나 DFS를 사용하여 구현이 가능하다. 먼저 BFS 방법으로 구현할시 로직 흐름이 어떻게 되는지 보자. 
```
1. 모든 정점의 in_degree(진입차수)를 설정 -> in_degree[N] 배열을 구현하여 진입차수를 저장한다 
2. indegree가 0인 정점(=진입차수가 0인 노드)는 방문한 것으로 표시하고, 큐에 해당 노드를 추가
3. 큐가 빌 때까지 순회하며 아래 작업을 수행
  3-1. 큐의 맨 앞 요소를 가져와 T[]라는 배열에 append -> T[] 배열은 위상정렬 결과 저장 
  3-2. 큐에서 꺼내온 정점에 인접한 정점 중 방문하지 않은 정점의 in_degree를 1 감소시킴
  3-3. in_degree 감소 후 값이 0이면 해당 정점을 큐에 넣고, 방문처리함 
```
![image](https://github.com/user-attachments/assets/dc24b227-3510-48c9-8f67-2a5d808a60f3)
     
![image](https://github.com/user-attachments/assets/1366815a-15b9-4eaf-9ab7-d2cc1dd555b1)     
      
![image](https://github.com/user-attachments/assets/903b5e78-42da-486d-a59c-3b18e0b8baee)
     
![image](https://github.com/user-attachments/assets/0b118268-b503-459e-8680-82d55d39e0c3)
     
![image](https://github.com/user-attachments/assets/204a361b-a3f1-4cab-84d5-13058e71048c)
      
![image](https://github.com/user-attachments/assets/93ac39fd-b250-4392-9c0e-4820a7b9bf52)
      
![image](https://github.com/user-attachments/assets/faa27511-cb55-427f-873a-8f32175dc172)
      
![image](https://github.com/user-attachments/assets/0236e8ed-b033-417e-a3ba-7247e5dbf9fa)
      
![image](https://github.com/user-attachments/assets/87fc63ee-fbb2-4a8d-a2ee-2f5519571bc9)


## 구현 방법- DFS 
```
1. 모든 정점을 순회하여 방문하지 않은 정점에 대해서 DFS를 수행
2. DFS 순회방식
  2-1. 하나의 정점에서 시작
  2-2. 방문표시를 하면서 간선을 따라 다음 정점 방문
  2-3. 더 이상 방문할 간선이 없으면 리스트 앞에 정점을 추가하고 백트래킹을 통해 이전 정점으로 이동하면서 방문하지 않은 간선이 있는지 확인
  2-4. 방문 가능한 간선이 있다면 다시 간선을 따라 다음 정점으로 이동
  2-5. 모든 정점을 탐색할 때까지 2-2~2-4를 반복 
```
![image](https://github.com/user-attachments/assets/16e93bab-2851-4262-a1df-ff7eac34a1de)
      
![image](https://github.com/user-attachments/assets/c254c888-9187-491d-9c03-10601756349b)






### References 
* https://velog.io/@kimdukbae/%EC%9C%84%EC%83%81-%EC%A0%95%EB%A0%AC-Topological-Sorting
* https://yoongrammer.tistory.com/86
