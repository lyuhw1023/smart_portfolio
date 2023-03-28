# Smart Portfolio
2022년도 (주)더존비즈온 Smart Portfolio 프로젝트 & 한림대학교 모바일 프로그래밍  
본선 진출 작품  
***  
<br/>

## ✔개요
자신의포트폴리오를앱으로구현하여, 개발자의 개발 역량과 이력을 제공하는 것을 목표로 한다. 하나의 기능을 제공하는 앱을 구현하고, 내부에서는 화면 간의 이동(이동시 데이터 전달 처리 방안), Thread의 활용, 리스트 및 위젯으로 화면 구성, 앱<->웹 이동 방법 등의 기능을 개발하는 것이 핵심이다.
***  
<br/> 

## ✔개발
- Kotlin
- SQLite
*** 
<br/> 

## 인트로화면 & Splash
<div>
<img src="https://user-images.githubusercontent.com/52669844/207788726-0f155025-5867-486c-96f0-716fc44e8b35.jpg" width="200px"/>
<img src="https://user-images.githubusercontent.com/52669844/207788612-b55faa42-56b7-4983-9e90-36725d29b67d.gif" width="200px"/>
</div>  

- 앱의 Intro화면에서 '보러가기'버튼을 누르면 다음 화면으로 넘어간다.  
- 다음 화면으로 넘어갈 때 splash를 통해 애니메이션을 보여준다.  
- 1초~3초 내에서 랜덤으로 자동 재생되며 splash화면이 끝나면 다음 페이지인 메인페이지로 연결된다.  
- 애니메이션 라이브러리는 lottie를 사용했다.  
<br/>

## Main화면 & 네비게이션
<div>
<img src="https://user-images.githubusercontent.com/52669844/207295389-b06c8a12-cea3-4197-915e-3349b1d9e4b8.jpg" width="200px"/>
<img src="https://user-images.githubusercontent.com/52669844/207295458-bd01c76a-6bb5-4e4f-a6ba-e087d62ef9d4.jpg" width="200px"/>
<img src="https://user-images.githubusercontent.com/52669844/207789015-5e91100d-0fd7-44e0-bfe4-f267e6dd0f35.gif" width="200px"/>
</div>

- 메인화면에서는 간략한 소개를 볼 수 있다.  
- 네비게이션에는 Home, Project, LyuHyeWon, Class, ContactMe, Logout 화면으로 이동할 수 있도록 제공된다.  
- Logout 버튼을 누르면 인트로 화면으로 이동한다.  
<br/>

## Project화면  
<div>
<img src="https://user-images.githubusercontent.com/52669844/207296200-0d32545b-14bc-41cf-ba1f-4f1229ff153d.jpg" width="200px"/>
<img src="https://user-images.githubusercontent.com/52669844/207296274-2ea18a7c-2a96-43fe-bdae-30104b96c8a1.jpg" width="200px"/>
</div>

 - 카트뉴스를 통해 내용 확인 가능
 - '프로젝트 보러가기' 텍스트 클릭 시 상세 페이지 확인 가능
 <br/>

## LyuHyeWon, Class 화면   
<div>
<img src="https://user-images.githubusercontent.com/52669844/207789905-88b16b40-0af1-4f7f-9457-97fd4b07f06f.jpg" width="200px"/>
<img src="https://user-images.githubusercontent.com/52669844/207789969-3d7f6976-5761-43cc-8db3-cb5aa8a72d72.jpg" width="200px"/>
</div>

- 화면 좌우 넘김으로 두 가지 화면 편라하게 확인 가능
- 학교 생활, 수업내용, 수업성적 등에 대한 내용이 담겨있다.
<br/>

## ContactMe  
<div>
<img src="https://user-images.githubusercontent.com/52669844/207790401-84c2a528-df31-4f08-8f57-64d561aa64fc.jpg" width="200px"/>
<img src="https://user-images.githubusercontent.com/52669844/207790467-bf436da5-a3d6-48c0-aa12-1c00d5f8bc28.jpg" width="200px"/>
</div>

- 메시지를 남겨 내용을 확인할 수 있다.
- SQLite 데이터를 사용해 정보를 관리한다.
<br/>

## 내부 / 외부 웹브라우저  
<div>
<img src="https://user-images.githubusercontent.com/52669844/207794986-5fa6d0ea-bfa5-451c-a74f-1cd175dc6014.jpg" width="200px"/>
<img src="https://user-images.githubusercontent.com/52669844/207793544-4b43b3f4-70e0-448d-880b-fba71f2d1656.jpg" width="200px"/>
<img src="https://user-images.githubusercontent.com/52669844/207793602-51a6c823-236f-4c55-a57b-9b45f1b53bda.jpg" width="200px"/>
</div>

- 내부 웹뷰 or 외부 웹브라우저를 선택하는 기능
- (내부) Webview, (외부) Chrome
