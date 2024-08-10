# HASH(해시) 

## Hash?
해시(hash)란 임의의 길이의 데이터를 고정된 길이의 데이터로 매핑한 값 
* 해시 함수(hash function): 해시 함수가 임의의 길이의 데이터를 고정된 길이의 데이터로 매핑해줌
  * 매핑 전 데이터 = key(키)
  * 해시함수를 적용하여 나온 고정된 길이의 값 = 해시값 or 해시   
![image](https://github.com/user-attachments/assets/78ab361c-c3d8-4ded-8765-87bc292822ae)

* 만약 위처럼, John Smith와 Sandra Dee가 똑같이 02로 매핑된다면 -> `해시 충돌` 현상 발생
  * 해결 방법1 chaining 기법: 해시 테이블에서 인덱스끼리는 배열로 저장, 같은 인덱스끼리는 LinkedList로 구현 (같은 인덱스가 생길때마다 노드 추가)    
    ![image](https://github.com/user-attachments/assets/269aafff-fec5-46b1-bb3d-f2efa3341d51)
  * 해결 방법2 linear probing 기법: 해시 함수를 통해 얻은 인덱스에 이미 데이터가 있다면, 다음 주소를 체크 -> 체크했을때 데이터가 없다면 해당 자리에 저장   
    ![image](https://github.com/user-attachments/assets/4f676bc6-db43-434a-ac3e-106479b4700a)
 


## Hash Table
해시 테이블은 해시 함수를 이용하여 키와 값을 매핑하는 자료구조.    
![image](https://github.com/user-attachments/assets/424ab4e9-5fe0-4e33-9cf8-dca564fcf114)
* 키(이름)을 해시함수를 통해 해시값(0~15사이의 수)로 매핑
* 이 해시값을 index로 하여 버킷에 전화번호와 같은 정보를 저장 가능

### 시간 복잡도 
![image](https://github.com/user-attachments/assets/41f04b5c-2767-4b44-9074-9d4b0e6b26e6)

* 충돌이 일어나지 않은 경우(평균적인 경우)
  * 탐색: O(1)
  * 삽입: O(1)
  * 삭제: O(1)
* 충돌이 일어날 경우(최악의 경우)
  * 탐색: O(N)
    * 인덱스로 값을 탐색한 후 -> linkedlist를 순차 탐색 필요
    * linkedlist의 길이 N만큼 소요
  * 삽입: O(N)
    * linkedlist 탐색 필요
  * 삭제: O(N)
    * linkedlist 탐색 필요 


## Hashing
해싱(hashing)은 해시 함수를 사용하여 주어진 값을 변환한 뒤, 해시 테이블에 저장하고 검색하는 기법. 
* 일반적으로는 특정 데이터가 저장된 위치 찾기 위해서는 데이터가 저장된 자료구조에서 반복 비교를 통해 원하는 데이터인지 확인하는 방법이 필요
* 그러나 해시 함수를 통해 저장할 경우 해시 함수에서의 계산(해싱)으로 바로 데이터가 저장된 위치 찾아낼 수 있음 

### 1. division (제산법)
제산법(division)은 나머지 연산을 통해서 해시값 계산하는 방법 
```
키 값 % 전체 버킷의 크기 = 인덱스
```
* 키 값을 특정 정수로 나눈 나머지를 인덱스로 하여 해시 테이블에 키 갑을 저장
  * 해시 충돌을 피하기 위해 키값을 나누는 정수가 소수이면 좋음 

### 2. mid-square(중간제곱법)
중간제곱법(mid-square)는 키 값을 제곱한 결과의 중간 부분 몇 비트를 인덱스로 사용함    
![image](https://github.com/user-attachments/assets/9a7ffda1-6708-47c3-8400-16faa12caceb)   
* 제곱한 값의 중간 비트들은 키의 모든 비트의 영향을 받으므로 서로 다른 키는 서로 다른 결과값을 도출할 확률이 높음
* 인덱스로 사용하는 비트수는 전체 버킷의 크기에 따라 달라짐 

### 3. folding(폴딩법)
폴딩법(folding)은 키 값을 여러 부분으로 나눈 후, 각 부분의 값을 더하거나 XOR연산을 한 값을 인덱스로 함    
![image](https://github.com/user-attachments/assets/560c1eb7-cb51-4cec-9487-1648ad96ff6f)   
* 이동 폴딩(shift folding): 각 부분의 값들을 좌측 or 우측 끝자리에 맞춰 더함
  * 우측 끝자리에 맞춘 경우: P1+P2+P3+P4+P5 = 301+230+123+213+30 = 897
* 경계 폴딩(boundary folding): 각 부분의 경계선을 역으로 정렬하여 더함
  * P1+P2(역)+P3+P4(역)+P5 = 301+032+123+312+30 = 798

### 4. digit-analysis(숫자분석법) 
숫자분석법(digit-analysis)는 키를 구성하는 숫자가 모든 키들 내에서 어떻게 분포되어있는지 조사 후 숫자가 고르게 분포되어 있는 자리를 필요한만큼 선택해 인덱스로 사용
* 만약 전화번호를 키 값으로 하고 인덱스를 3자리 수라 정의한다면   
  ![image](https://github.com/user-attachments/assets/9ffb18a4-b523-4239-b712-63ff7362d651)   
* 1~3번째 자리수는 012로 동일하므로 제외   
* 5,7,9번째 자리수 또한 같은 수가 많이 분포되어 있음
* 따라서 4,8,10번째 자리수를 선택하여 인덱스로 사용

### 5. radix-exchange(기수변환법)
기수변환법(radix-exchange)는 키를 다른 진법으로 간주하고 키를 변환해 인덱스를 얻음 
* 변환된 인덱스가 전체 버킷의 크기를 초과시, 인덱스의 최하위 자리부터 전체 버킷의 크기가 허용하는 자릿수만큼 취해 인덱스로 사용 




### References
* https://ablue-1.tistory.com/68
* https://velog.io/@letskuku/%EC%9E%90%EB%A3%8C%EA%B5%AC%EC%A1%B0-%ED%95%B4%EC%8B%9CHash
* https://ratsgo.github.io/data%20structure&algorithm/2017/10/25/hash/
