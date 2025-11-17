# 2025-11-17 정리본

- ## 정보
    - 과목 : CSS
    - 난이도 : 2.0 / 5.0
    - 메모 : CSS의 다양한 선택자와, 기본적인 스타일 속성

## CSS 캐스케이딩 명시도

- 범위가 좁을수록 명시도가 높아진다.
- `id` 선택자가 가장 효율이 좋은 이유
- `자식 선택자`가 `자손 선택자`보다 좋다.

## 속성 선택자

- `[attribute]` : 지정한 `HTML` 속성이 있는 `HTML` 요소 선택
- `[attribute=value]` : 지정한 `HTML` 속성의 값이 지정한 값과 같은 `HTML` 요소 선택
- `[attribute~=value]` : `HTML` 속성 값이 지정한 값을 단어로 포함하는 `HTML` 요소 선택
    - `-` 을 하나의 단어로 인식 `(ko-kr)`
- `[attribute|=value]` : `HTML` 속성 값이 지정한 값을 단어로 포함하는 `HTML` 요소 선택
    - `-` 으로 단어를 구분해서 인식 `(ko, kr)`
- `[attribute^=value]` : `HTML` 속성 값이 지정한 값으로 시작하는 `HTML` 요소 선택
- `[attribute$=value]` : `HTML` 속성 값이 지정한 값으로 끝나는 `HTML` 요소 선택
- `[attribute*=value]` : `HTML` 속성 값이 지정한 값을 포함하는 `HTML` 요소 선택

## 가상 클래스 선택자

### 반응 선택자

- `selector:hover` : 마우스 커서가  `selector` 요소 위에 올라가있으면 선택
- `selector:actice` : 마우스 커서를 `selector` 요소에 올리고 누르고있으면 선택

### 구조 선택자

- `selector:first-child` : 형제 관계에 있는 `HTML` 요소들 중 첫 번째에 있는 요소를 선택
- `selector:last-child` : 형제 관계에 있는 `HTML` 요소들 중 마지막에 있는 요소를 선택
- `selector:nth-child(수열)` : 형제 관계에 있는 `HTML` 요소들 중 앞에서 수열 번째에 있는 요소를 선택
- `selector:nth-last-child(수열)` : 형제 관계에 있는 `HTML` 요소들 중 뒤에서 수열 번째에 있는 요소를 선택
    - 수열은 `3n`, `2n + 3` 같은 것을 넣을 수 있고, `n`은 0 부터 시작하는 정수이다.

- 형제 관계에 있는 `HTML` 요소들 중 특정 위치에 있는 `HTML` 요소를 선택

### 형태 구조 선택자

- `selector:first-of-type` : 형제 관계에 있는 요소들 중 첫 번째에 나오는 특정 태그를 선택
- `selector:last-of-type` : 형제 관계에 있는 요소들 중  마지막에 나오는 특정 태그를 선택
- `selector:nth-of-type(수열)` : 형제 관계에 있는 요소들 중 앞에서 수열 번째에 나오는 태그를 선택
- `selector:nth-last-of-type(수열)` : 형제 관계에 있는 요소들 중 뒤에서 수열 번째에 나오는 태그를 선택

- 태그 형태를 구분해서 형제 요소들 중에서 특정 위치에 있는 `HTML` 요소를 선택
    - `구조 선택자`와 비슷하지만 태그 형태를 구분한다.

### 링크 선택자

- `selector:link` : `href` 속성이 설정된 `<a>` 요소를 선택
- `selector:visited` : 방문한 적이 있는 페이지의 `URL`이 `href` 속성에 설정된 `<a>` 요소를 선택

### 부정 선택자

- `selector:not(selector)` : 주어진 선택자로 선택되지 않은 `HTML` 요소들을 선택

### 가상 요소 선택자

- `selector:before` : `selector`의 콘탠츠 내부에 첫 번째 요소가 되는 가상 요소를 선택
- `selector:after` : `selector`의 콘탠츠 내부에 마지막 요소가 되는 가상 요소를 선택

### 문자 선택자

- `selector::first-letter` : `HTML` 요소의 내부 텍스트 중에서 첫 번째 글자 선택
- `selector::first-line` : `HTML` 요소의 내부 텍스트 중에서 첫 번째 줄에 표시되는 글자들을 선택

### 반응 문자 선택자

- `selector::selection` : 사용자가 드래그한 글자를 가상요소로 선택

## 효율적인 선택자 작성 방법

- 주어진 `HTML` 요소가 적합한지 확인하는 데 고려해야 할 규칙의 수가 적을수록 성능이 좋아진다.

- `전체 선택자`는 사용하지 않는다.
- 불필요한 규칙을 덧붙이지 않는다.
    - `아이디`나 `클래스 선택자`에 특별한 이유 없이 `태그`나 `클래스 선택자`를 덧붙이지 않는다.
- 가장 명확한 선택자를 적용하라.
    - `클래스 선택자`보다는 `아이디 선택자`가 더 효율적이다.
    - `태그 선택자`보다는 `아이디 선택자`가 더 효율적이다.
- `후손 선택자`를 피하라.
    - `후손 선택자`보다는 `자식 선택자`가 더 효율적이다.
- 상속을 적극적으로 사용하라.

## CSS 크기 단위

- 절대적인 크기 단위
    - `px` : 픽셀 (pixel, 1/96 in)
    - `pt` : 포인트 (point, 1/72 in)
    
- 상대적인 크기 단위
    - `%` : 백분율 단위 (스타일이 적용되는 속성의 크기를 기준으로)
    - `em` : 배수 단위 (현재 `HTML` 요소의 글자 크기를 기준으로)
    - `rem` : 배수 단위 (`root` 요소, 즉 `<html>` 요소의 글꼴 크기를 기준으로)
    - `vh`, `vw` : 브라우저 화면(`Viewport`) 높이나 너비의 백분율

## CSS 색상 단위

- `color` : 색상 이름
- `#RRGGBB` : `HEX` 코드 단위 (16진수로 표기)
- `rgb(red, green, blue)` : `RGB` 색상 단위 (10진수로 표기)
- `rgba(red, green, blue, alpha)` : `RGBA` 색상 단위 (`RGB` + 투명도)
- `hsl(hue, saturation, lightness)` : `HSL` 색상 단위 (색상, 채도, 명도)
- `hsla(hue, saturation, lightness, alpha)` : `HSLA` 색상 단위 (`HSL` + 투명도)

## inherit 속성 값과 initial 속성 값

- 스타일 속성의 `inherit` 속성 값과 `initial` 속성 값
    - 이 두 속성 값은 모든 스타일 속성에서 사용한다.
    - `inherit` 속성 값 : 해당 스타일 속성의 값을 부모 요소에게 상속받아 설정한다.
    - `initial` 속성 값 : 해당 스타일 속성의 기본 값으로 설정한다.

## CSS 박스 모델

- `HTML` 요소는 “테두리(border)”를 가진다.
- `HTML` 요소의 테두리 안쪽에 `HTML` 요소의 콘텐츠 (후손 요소와 내부 텍스트) 가 표시되는 “콘텐트 영역(content box)”이 있다.
- `HTML` 요소의 테두리와 콘텐트 영역 사이에는 “내부 여백(padding)”이 있다.
- `HTML` 요소의 테두리 바깥쪽에는 “외부 여백(margin)”이 있다.

## width 스타일 속성과 height 스타일 속성

- `HTML` 요소의 콘텐트 영역 너비 또는 높이를 설정한다.

- `auto` : 상황에 따라 브라우저가 계산해서 설정 (기본 값)
- `length` : 크기 단위를 사용해 설정
- `percentage` : 컨테이닝 블록 (`Containing block`) 너비 또는 높이의 백분율로 설정

## 스타일 속성의 기본 값

- 스타일 속성의 기본 값 (Initial Values)
    - `HTML` 요소에 어떤 스타일 속성을 명시적으로 설정하지 않으면, `HTML` 요소에는 그 스타일 속성의 기본 값이 적용된다.
        - 예를 들어, `HTML` 요소의 명시적으로 `width` 스타일 속성을 설정하지 않으면, 기본 값인 “auto”가 적용된다.
        - `width` 스타일 속성의 값이 `auto`인 경우에는, `HTML` 요소의 공간 차지 형식 (표시 형식) 에 따라 브라우저가 계산해서 설정한다.
- 스타일 속성들의 기본 값을 알고 있으면, `HTML` 요소가 웹 브라우저 화면 (`viewport`)에 어떻게 표현될지 예측할 수 있다.

## margin 속성과 padding 속성

- `margin` 스타일 속성
    - `HTML` 요소의 테두리를 기준으로 바깥쪽 여백의 크기를 설정
- `padding` 스타일 속성
    - `HTML` 요소의 테두리를 기준으로 안쪽 여백의 크기를 설정

- `auto` : 상황에 따라 브라우저가 계산해서 설정
- `length` : 크기 단위를 사용해 설정 (기본 값은 0)
- `percentage` : 컨테이닝 블록 (`Containing block`) 너비의 백분율로 설정

- `margin` 속성과 `padding` 속성은 상, 우, 하, 좌 방향의 값을 따로 지정할 수 있다.
    - `margin: 20px;`
    - `margin: 10px 20px 30px 40px;`
    - `margin: 10px 30px;`
    - `margin: 20px 40px 30px;`

- `margin-top`, `margin-right`, `margin-bottom`, `margin-left`

## margin 중첩

- 인접한 `HTML` 요소들의 외부 여백 (margin) 이 맞닿으면 요소들의 외부 여백은 겹친다.

## box-sizing 스타일 속성

- `width` 스타일 속성과 `height` 스타일 속성이 어떤 영역의 크기를 설정한 것인지를 지정한다.

- `content-box` : `width` 속성과 `height` 속성이 콘텐트 영역의 크기를 지정 (기본 값)
- `border-box` : `width` 속성과 `height` 속성이 테두리를 포함한 영역의 크기를 지정

## HTML 요소의 공간 차지 형식

- `HTML` 요소가 브라우저 화면 (`viewport`) 에 표시될 때 공간을 차지하는 방식

- `HTML` 요소의 공간 차지 형식
    - 블록 (Block) 형식
        - `HTML` 요소가 콘테이닝 블록 (`containing block`) 너비 전체를 상자 형태로 차지
        - 안쪽 여백 (padding), 바깥쪽 여백 (margin) 을 가진다.
        - 스타일 속성으로 위치와 여백, 너비, 높이를 설정할 수 있다.
        - `<div>` 요소, 제목 요소, `<p>`요소, 목록 요소, `<form>` 요소 등
    - 인라인 (Inline) 형식
        - `HTML` 요소가 문장 내에서 텍스트처럼 영역을 차지
        - 줄을 바꾸지 않고 다른 인라인 요소나 내부 텍스트와 함께 한 행에 위치한다.
        - 상하 외부 여백 (margin) 을 가지지 않으며, 너비, 높이를 설정할 수 없다.
        - `<span>` 요소, `<a>` 요소, 글자 형식 요소 등
    - 인라인 블록 (Inline-block) 형식
        - 인라인 형식의 특징을 기본으로 하며, 블록 형식의 특징을 **같이** 가진다.
        - 문장 내에 텍스트처럼 영역을 차지하며, 위치를 설정할 수 없다.
        - 스타일 속성으로 여백 (padding, margin) 과 너비와 높이를 설정할 수 있다.
        - `<img>` 요소, `<input>` 요소 등

## 컨테이닝 블록

- `HTML` 요소가 브라우저 화면 (`viewport`) 에 표시될 때, `HTML` 요소는 컨테이닝 블록을 기준으로 배치된다.
    - 따라서 `HTML` 요소를 원하는 위치에 배치하려면, 그 `HTML` 요소의 컨테이닝 블록이 어떤 영역인지 알아야 한다. 그렇지 않으면 `HTML` 요소를 원하는 위치에 배치할 수 없다.
- `HTML` 요소의 컨테이닝 블록은 `position` 스타일 속성에 따라 결정된다.
    - `position` 스타일 속성의 값이 기본 값인 “static”인 경우, `HTML` 요소의 컨테이닝 블록은 “그 요소와 가장 가까운 블록 레벨 조상 요소의 콘텐트 영역 (content box)” 이다.

## 문서의 일반적인 흐름

- 문서의 일반적인 흐름 (Normal Flow; 일반 대열)
    - 가장 기본적인 `HTML` 요소 배치 방식으로, `HTML` 요소가 공간 차지 형식 (표시 형식) 에 따라 `DOM`에 나온 순서대로 차근차근 브라우저 화면 (`viewport`) 에 배치되는 형식
    - 자식 요소와 내부 텍스트는 컨테이닝 블록 (`containing block`) 안에 배치되며, 컨테이닝 블록의 좌상단을 기준으로 배치된다.
- 문서의 일반적인 흐름에서 블록 형식 요소의 배치
    - `블록 형식 요소`는 컨테이닝 블록의 맨 위에서부터 아래로 하나씩 배치된다.
    - `블록 형식 요소`는 컨테이닝 블록의 왼쪽에서부터 공간을 차지하며, 수평 방향에 포함된 모든 빈 공간을 차지한다. 그래서 컨테이닝 블록 내부를 최대한 차지하게 된다.
- 문서의 일반적인 흐름에서 인라인 형식 요소의 배치
    - `인라인 형식 요소`는 컨테이닝 블록의 상단에서 수평으로 하나씩 배치된다.

## HTML 요소의 너비와 높이

- `width` 스타일 속성과 `height` 스타일 속성의 값이 기본 값인 `auto`인 경우
    - `HTML` 요소의 공간 차지 형식 (표시 형식) 에 따라 브라우저가 계산해서 설정한다.
    
- 속성 : 너비, 높이

    - `block` : 컨테이닝 블록의 너비, `HTML` 요소의 콘텐츠에 따라 결정
    
    - `inline-block` : `HTML` 요소의 콘텐츠에 따라 결정, `HTML` 요소의 콘텐츠에 따라 결정
    
    - `inline` : `HTML` 요소의 콘텐츠에 따라 결정, `HTML` 요소의 콘텐츠에 따라 결정
    
- `인라인 형식 요소`의 기본 크기
    - `width` 스타일 속성과 `height` 스타일 속성으로 요소의 크기를 설정할 수 없다.
    - `인라인 형식 요소`의 너비와 높이는 `HTML` 요소의 콘텐츠에 의해 결정된다.
        - `HTML` 요소의 콘텐츠는 내부 텍스트와 후손 요소를 말한다.
        - `인라인 형식 요소`는 문장 내에서 문자처럼 배치되기 때문에, 콘텐츠가 많으면 두 줄 이상으로 표시될 수 있다.

## HTML 공간 분할 태그

- 웹 페이지의 논리적인 영역 (division) 을 정리하기 위해 사용하는 `HTML` 태그
- 구역을 나누고, `CSS`를 이용해 적절하게 배치해서 레이아웃 (`layout`) 을 구성한다.
- `<div>` 태그와 `<span>` 태그가 대표적인 공간 분할 태그이다.

- `<div>` : 블록 (Block) 형식으로 공간을 분할
- `<span>` : 인라인 (Inline) 형식으로 공간을 분할

## HTML 5 시맨틱 구조 태그

- `<header>` : 문서 구조에서 상단 영역을 의미
- `<nav>` : 문서 구조에서 내비게이션 (페이지 사이를 탐색할 수 있는 링크들의 집합) 을 의미
- `<aside>` : 문서 구조에서 주요 콘텐츠 부분 이외의 콘텐츠를 의미
- `<main>` : 문서 구조에서 주요 콘텐츠 (`contents`) 를 의미
- `<section>` : 문서 구조에서 문서의 전체적인 내용과 관련이 있는 콘텐츠들의 집합을 의미
- `<article>` : 문서 구조에서 하나의 독립적인 콘텐츠를 의미
- `<footer>` : 문서 구조에서 하단 영역을 의미
- `<address>` : 문서 구조에서 주소 영역을 의미 (주로 `<footer>` 영역에 포함)

- `HTML 5` `시맨틱 구조 태그`들 (`semantic structure tags`) 은 `<div>` 태그로 대체할 수 있다.
- `시맨틱 구조 태그`를 사용하면 문서의 구조를 더 쉽게 파악할 수 있다.

## CSS 가시 스타일 속성

### display 스타일 속성

- `HTML` 요소의 표시 형식 (공간 차지 형식) 을 설정한다.

- `none` : `HTML` 요소를 브라우저 화면 (`viewport`) 에서 제거
- `block` : `HTML` 요소를 블록 형식으로 지정
- `inline` : `HTML` 요소를 인라인 형식으로 지정 (기본 값)
- `inline-block` : `HTML` 요소를 인라인 블록 형식으로 지정

### visibility 스타일 속성

- `HTML` 요소의 표시 여부를 설정한다.

- `visible` : `HTML` 요소를 브라우저 화면에 표시한다. (기본 값)
- `hidden` : `HTML` 요소를 브라우저 화면에서 숨긴다.

### opacity 스타일 속성

- `HTML` 요소의 투명도를 설정한다.

- `0 ~ 1` : 0 에 가까울수록 투명해진다.

### 비교

- `display: none;` : 화면 영역에서 요소 자체를 없앰.
- `visible: hidden;` : 화면 영역에는 안보이지만 존재하긴 함.
- `opacity: 0;` : 완전 투명해져서 화면 영역에 안보일 뿐 존재함.

## border 스타일 속성

- `border: [ <border-width> || <border-style> || <border-color> ] | inherit;`

```css
p { border: thin solid red; }
h2 { border-left: 4px solid green; }
#box { border: solid; }
```

## border-radius 스타일 속성

- `HTML` 요소의 모서리를 둥근 형태로 만들기 위한 원의 반지름을 지정
    - 모서리가 둥근 사각형 또는 원을 만들 수 있다.
- 기본 값은 0

- `border-radius: <border-top-left-radius> || <border-top-right-radius> || <border-bottom-right-radius> || <border-bottom-left-radius>;`

## 블록 형식 요소의 기본 크기

- `width`, `height` 스타일 속성으로 크기를 지정하지 않은 경우, `블록 형식 요소`의 크기
    - 너비는 컨테이닝 블록 (`containing block`) 의 너비로 설정된다.
    - 높이는 `HTML` 요소의 콘텐츠에 의해 결정된다.

## 각 스타일 속성의 % 단위의 기준

- `width` : 컨테이닝블록 (`Containing block`)의 너비
- `height` : 컨테이닝블록의 높이
- `margin` : 컨테이닝블록의 너비
- `padding` : 컨테이닝블록의 너비
- `border-radius` : 방향에 따라, `HTML` 요소의 너비 또는 높이

## CSS 배경 스타일 속성

### background-image 스타일 속성

- 배경에 넣을 이미지를 지정한다.

- `none` : 배경 이미지를 지정하지 않음 (기본 값)
- `url(file-url)` : 배경 이미지의 `URL` 지정
    - 여러 개의 파일을 배경으로 지정하면 레이어처럼 쌓인다.
    - 앞에 지정된 파일이 뒷 파일보다 앞에 온다.
    
    ```css
    button { background-image: url("button.png"); }
    body { background-image: url("bird.png"), url("background.png"); }
    ```
    

### background-repeat 스타일 속성

- 배경 이미지가 배경 영역보다 작은 경우, 배경 이미지를 반복해서 표시할지 지정한다.

- `repeat` : 배경 이미지를 반복해서 나오도록지정 (기본 값)
- `no-repeat` : 배경 이미지가 반복되지 않도록 지정
- `repeat-x` : 배경 이미지가 옆으로만 반복하도록 지정
- `repeat-y` : 배경 이미지가 위 아래로만 반복하도록 지정
    
    ```css
    body {
    		background-image: url("background.jpg");
    		background-repeat: no-repeat;
    }
    ```
    

### background-size 스타일 속성

- 배경 이미지의 크기를 지정한다.

- `auto` : 배경 이미지의 원래 크기대로 지정 (기본 값)
- `length` : 배경 이미지의 크기를 크기 단위로 지정 (`width height`)
- `percentage` : 배경 이미지의 크기를 `HTML` 요소 크기의 백분율로 지정 (`width height`)
- `cover` : 배경 이미지가 요소의 배경 영역을 가득 채우도록 지정 (`bg-image` ≥ `element`)
- `contain` : 배경 이미지가 요소의 배경 영역에 들어가도록 지정 (`bg-image` ≤ `element`)
    
    ```css
    button { background-size: 100%; }
    ```
    

### background-attachment 스타일 속성

- 배경 이미지를 어떤 방식으로 브라우저 화면에 넣을 것인지 지정한다.

- `scroll` : 배경 이미지가 `HTML` 요소를 따라 스크롤 되도록 지정 (기본 값)
- `fixed` : 배경 이미지가 스크롤 되지 않도록 지정
- `local` : 배경 이미지가 `HTML` 요소의 콘텐트를 따라 스크롤 되도록 지정
    
    ```css
    body {
    		background-image: url("background.jpg");
    		background-repeat: no-repeat;
    		background-attachment: fixed;
    }
    ```
    

### background-position 스타일 속성

- 배경 영역의 좌상단을 기준으로 이미지의 위치를 지정한다.

- `pos` : 크기 단위로 배경 이미지의 위치를 지정 (`xpos ypos`, 기본 값은 `0% 0%`)
- `percentage` : 배경 이미지의 위치를 `HTML` 요소의 크기의 백분율로 지정 (`xpos ypos`)
- `bottom` : 배경 이미지를 아래쪽에 배치
- `center` : 배경 이미지를 가운데에 배치
- `left` : 배경 이미지를 왼쪽에 배치
- `right` : 배경 이미지를 오른쪽에 배치
- `top` : 배경 이미지를 위쪽에 배치

### background 스타일 속성

- `background: <bg-image> || <bg-position> || [ / <bg-size> ] || <bg-repeat> || <bg-attachment> || <bg-color>;`

```css
body {
		background: url("background.jpg") 50% 70% / 100% no-repeat fixed #eee;
}
/*
background 스타일 속성에서 background-size 스타일 속성을 설정할 때는
background-position 스타일 속성의 값을 생략할 수 없다.
background-size 스타일 속성의 값은 background-position 스타일
속성의 값 다음에 /를 넣고 설정해야 한다.
*/

body {
		background: url("background.jpg") no-repeat fixed;
}

body { background: url("background.jpg"); }
body { background: #eee; }
```

### background-clip 스타일 속성

- 배경색을 넣을 영역을 지정한다.

- `border-box` : 테두리, 내부 여백, 콘텐트 영역을 포함하는 영역을 배경으로 지정 (기본 값)
- `padding-box` : 내부 여백, 콘텐트 영역을 포함하는 영역을 배경으로 지정
- `content-box` : 콘텐트 영역만 배경으로 지정

### background-origin 스타일 속성

- 배경 이미지를 넣을 영역을 지정한다.
    - `background-attachment` 스타일 속성의 값이 “`fixed`”이면 효과가 없다.

- `border-box` : 테두리의 좌상단 점을 기준으로 배경 이미지 배치
- `padding-box` : 내부 여백의 좌상단 점을 지준으로 배경 이미지 배치 (기본 값)
- `content-box` : 콘텐트 영역의 좌상단 점을 기준으로 배경 이미지 배치

## CSS 글자 스타일 속성

### CSS 스타일의 상속

- HTML 요소에 설정한 스타일 속성이 그 요소의 후손 요소들에게 영향을 미치는 것을 “스타일의 상속”이라고 한다.
- font, color, text-align 스타일 속성 등 주로 글자와 관련된 스타일들이 상속된다.
    - 그래서 브라우저 화면에 표시되는 HTML 요소들의 글자와 관련된 기본적인 스타일 속성은 <body> 요소에 설정하고, 필요에 따라 개별 요소에 따로 설정한다.

### font-size 스타일 속성

- 내부 텍스트의 글자 크기를 지정한다.

- `size` : 크기 단위로 글자 크기 지정
- `percentage` : 부모 요소 글자 크기의 백분율로 글자 크기 지정
- `x-large` : 아주 크게 글자 크기 지정 (1.5rem, 24px)
- `large` : 크게 글자 크기 지정 (1.125rem, 18px)
- `medium` : 중간 정도의 글자 크기 지정 (기본 값, 1rem, 16px)
- `small` : 작은 글자 크기 지정 (0.8125rem, 13px)
- `x-small` : 아주 작게 글자 크기 지정 (0.625rem, 10px)
- `larger` : 부모 요소의 글자 크기보다 조금 더 크게 글자 크기 지정 (120%)
- `smaller` : 부모 요소의 글자 크기보다 조금 더 작게 글자 크기 지정 (83.33%)

### font-family 스타일 속성

- `font-family` 스타일 속성
    - 내부 텍스트의 글꼴을 지정하는 스타일 속성
    - 컴퓨터에 설치된 글꼴 이름을 속성 값으로 한다.
        - 여러 단어로 이루어진 글꼴 이름은 따옴표로 묶는다.
        - 지정한 글꼴이 사용자의 컴퓨터에 설치되어 있다고 장담할 수 없으므로, 여러 글꼴을 같이 지정한다.
    - `font-family` 스타일 속성의 마지막에는 반드시 기본 글꼴 (generic-family) 를 지정
        - `serif` : 명조체
        - `san-serif` : 고딕체
        - `monospace` : 고정 폭 글꼴

```css
h1, h2 { font-family: "Times New Roman", Century, serif; }
p { font-family: Tahoma, Verdana, sans-serif; }
```

### font-style 스타일 속성

- 내부 텍스트의 글자 기울기를 지정한다.

- `normal` : 보통 글자로 지정 (기본 값)
- `italic` : 기울여진 글자로 지정
- `oblique` : 완만하게 기울어진 글자로지정 (고급 글꼴, 지원하지 않는 글꼴이 많음)

### font-weight 스타일 속성

- 내부 텍스트의 글자 두께를 지정한다.

- `normal` : 보통 두께로 지정 (기본 값)
- `bold` : 굵은 글씨체로 지정
- `bolder` : 부모 요소보다 더 굵은 글씨체로 지정
- `lighter` : 부모 요소보다 얇은 글씨체로 지정
- `100 ~ 900` : 100부터 900까지의 100 단위 숫자 (400 = normal, 700 = bold)