# MVVM-Template
## 애플리케이션 설명

- Restful API를 사용하기 위한 안드로이드 MVVM패턴 템플릿

## 기술

- MVVM
- Koin
- Retrofit2
- ReactiveX
- Android AC - DataBinding, ViewMode, LiveData

## 용도

- Restful API를 이용할 수 있는 구조
  - 에러발생시 Event처리
- RecyclerView에 적용되는 DataBinding

## 문제점

- 기능을 추가할수록 ViewModel에 중복코드가 생긴다.
  - usecase를 추가하여 viewModel에 생기는 중복코드를 제거