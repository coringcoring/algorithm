# WEEK2: 스택, 큐, 덱 
알고리즘 수업 때 배웠었던 내용들 바탕 + 추가적으로 구글링하여 공부한 내용 중심으로 정리합니다. 추가적으로 찾은 내용은 모두 출처를 표기합니다.

## 스택 (Stack)
![image](https://github.com/java-coding-test/kjy/assets/65723420/3d092e37-b034-49fc-a9bf-b9d3f5f55b7c)
* **후입선출(`LIFO`: Last In First Out)**
* 삽입과 삭제를 리스트의 한쪽(Top)에서 함
* 출력 순서가 입력 순의 반대로 될 때 자주 사용됨 
* 스택의 동적 구현: 연결 리스트
  * 장점: 크기 제한 x
  * 단점: 구현 복잡, 삽입/삭제 시간이 오래 걸림 

## 큐 (Queue)
![image](https://github.com/java-coding-test/kjy/assets/65723420/7c8174f7-018c-4a0b-98f3-83cc5b3ae29f)
* **선입선출(`FIFO`: First In First Out)**
* 구현
  * 배열 사용
    * 장점 : 구현하기 쉬움.
    * 단점 : 크기가 동적이 아님. 런타임 시 필요에 따라 늘어나거나 줄어들지 않음.
  * 연결 리스트 사용
    * 장점 : 크기가 동적임. 런타임시 필요에 따라 크기가 확장 및 축소될 수 있음.
    * 단점 : 포인터를 위한 추가 메모리 공간이 필요함.

### References
* https://roi-data.com/entry/%EC%9E%90%EB%A3%8C%EA%B5%AC%EC%A1%B0-4-%EC%8A%A4%ED%83%9DStack%EC%9D%B4%EB%9E%80-%EC%97%B0%EC%82%B0-%EA%B5%AC%ED%98%84%EB%B0%A9%EB%B2%95
* https://yoongrammer.tistory.com/46
