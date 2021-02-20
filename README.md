# MVVM-Template
## 애플리케이션 설명

- Restful API를 사용하기 위한 안드로이드 MVVM패턴 템플릿

## 기술

- MVVM
- Koin
- Retrofit2
- ReactiveX
- Android AC - DataBinding, ViewMode, LiveData

## 템플릿 용도

- Restful API를 이용
  - 에러발생시 Event처리
- RecyclerView에 적용되는 DataBinding
- 양방향 데이터바인딩

## 문제점

- 기능을 추가할수록 ViewModel에 중복코드가 생긴다.
  - remoteRepository를 이용하여 보완함

