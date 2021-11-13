ViewModel이란?

- Android Jepack의 구성요소 중 하나로, 본재 ViewModel이란 이름은 소프트웨어 개발 디자인 패턴중 하나인 MVVM으로부터 파생
- MVVM 관점에서 부르는 ViewModel
- Android Jetpack에 포함된 ViewModel ( AAC ViewModel )


# ViewModel의 필요성
- MVVM 관점에서 ViewModel은 View로부터 독립적이며, View가 필요한 데이터만 소유
- MVVM 디자인 패턴을 적용하면, Activity, Fragment와 같은 UI컨트롤러의 과도한 책임을 부담하여 클래스가 거대해지는것 방지
- 유지보수, 재사용성, 테스트 용이

# ViewModel의 특징
- ViewModel은 Activity에서는 Activity가 완전히 종료될 때가지 메로리에 남아있다.
- ViewModel은 Fragment에서는 Fragment가 분리될 때까지 메모리에 남아있다.

- 액티비티가 최초 생성될 때 일반적으로 ViewModel을 인스턴스화 하여 생명주기를 함께 시작
- Activit의 finish() 호출등에 의해 액티비티가 종료됨에 따라 내부 LifeCycleEventObserver를 통해 ViewModel도 onCleared() 콜백 호출 후 종료

# 요청 프로세스
- ViewModelProvider를 토해 ViewModel 인스턴스 요청
- ViewModelProvider 내부에서는 ViewModelStoreOwner를 참조하여 ViewModelStore를 가져온다.
- ViewModelStore에게 이미 생성된 ViewModel 인스턴스 요청
- 만약 ViewModelStore가 적합한 ViewModel 인스턴스를 가지고 있지 않다면 Factory를 통해 ViewModel인스턴스 생성
- 생성한 ViewModel 인스턴스를 ViewModelStore에 저장하고 만들어진 ViewModel 인스턴스를 클라이언트에게 반환
- 똑같은 ViewModel 인스턴스 요청이 들어온다면, 1~3번 과정 반복

# ViewModel 구현
- ViewModel 클래스를 상속하는 서브 클래스를 정의
class MainViewModel : ViewModel() {

}
- ViewModel 인스턴스에 접근
class MainActivity : AppCompatActivity() {
    private lateinit var viewModel : MainViewModel
    oncreate(){
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(MainViewModel::class.java)
    }
}

- ViewModel을 생성하기 위해선 ViewModelProvider 객체가 필요
- ComponentActivity가 ViewModelStoreOwner 인터페이스를 구현하고 있으므로, ComponentActivitiy의 서브클래스인 AppCompatActivity를 사용하고 있아면
    별보 ViewModelStoreOwner 구현 필요 없음
