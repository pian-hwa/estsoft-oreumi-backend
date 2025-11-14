# HTML 목록, 표, form 및 CSS 정리 (2025-11-14)

- ## 정보
    - 과목 : HTML, CSS
    - 난이도 : 1.5 / 5.0
    - 메모 : HTML의 목록, 표, form 태그와 CSS의 기본적인 선택자에 대한 정보

- ## 인코딩 개념

    ### 문자 인코딩

    - 컴퓨터에게 문자를 입력하기 위해 2 진수로 변환하는 단계
    - 방식 : `ASCII`, `유니코드`
        - `ASCII` : 영어와 서유럽 언어에 최적화, 모든 언어는 `ASCII`를 기준으로 인코딩.
        - `유니코드` : 영어와 서유럽 언어 이외의 조합, 옥텟 1개가 부족함.
            
    ### 한글

    1. `한글 문자 집합`
        - 초창기에는 N바이트 조합형, 3바이트 조합형, 7비트 완성형, 2바이트 조합형, 2바이트 완성형 등 다양한 형태가 있다.
    2. `EUC-KR`
        - 2바이트 완성형 코드이며, `KS X 1001`과 `KS X 1003` 표준안에서 제정된 문자 집합
    3. `CP949 (MS949)`
        - EUC-KR과 유사한 2바이트 완성형 코드이며, `Microsoft Windows 95`에서 사용하기 위해 만들어졌다.
    4. `유니코드 (UTF-8 또는 UTF-16)`
        - `유니코드`에서는 3바이트 완성형 코드로 한글 11,172 자가 포함되어 있다.

- ## 목록과 관련된 HTML 태그

    ### 태그 정리

    - `<ul>` : unordered list, 순서가 없는 목록
    - `<ol>` : ordered list, 순서가 있는 목록
        - `<li>` : list item, 목록의 항목, `<ul>`이나 `<ol>`의 자식 요소로만 사용된다.
    - `<dl>` : definition list, 정의 목록
        - `<dt>` : definition term, 정의 용어
        - `<dd>` : definition description, 정의 설명
            
            
    - `<li>` 앞에 붙는 기호나 숫자는 marker 라고 부름.
    - `<ul>`, `<ol>`의 자식 요소는 **무조건**`<li>`
        
        

    ### 예시

    ```html
    <h2>Undordered list</h2>

    <ul>
        <li>Apple</li>
        <li>Banana</li>
        <li>Cherry</li>
    </ul>

    <hr>

    <h2>Ordered list</h2>

    <ol>
        <li>Facebook</li>
        <li>Twitter</li>
        <li>Instagram</li>
    </ol>

    <hr>

    <h2>Overlapped list</h2>

    <ol>
        <li>
            HTML

            <ol>
                <li>HTML Tags</li>
                <li>HTML Elements</li>
                <li>Structure and contents</li>
            </ol>
        </li>
        <li>
            css
            
            <ol>
                <li>Style sheets</li>
                <li>CSS blocks</li>
            </ol>
        </li>
        <li>javaScript</li>
    </ol>

    <hr>

    <h2>Definition list</h2>

    <dl>
        <dt>HTML</dt>
        
        <dd>HTML stands for Hyper Text Markup.</dd>
        <dd>...else</dd>
    </dl>
    ```

- ## 표와 관련된 HTML 태그

    ### 태그 정리

    - `<table>` : 표 (table) 를 표현
        - `<thead>` : table header, 표의 제목 행들의 묶음 (생략 가능)
        - `<tbody>` : table body, 표의 본문 행들의 묶음 (생략 불가능)
        - `<tfoot>` : table footer, 표의 푸터 행들의 묶음 (생략 가능)
            - `<tr>` : table rows, 표의 행을 생성
                - `<th>` : table heading, 표의 제목 셀
                - `<td>` : table data, 표의 본문 셀

    ### 속성

    - `colspan` : 셀의 넓이 칸을 지정
    - `rowspan` : 셀의 높이 칸을 지정

    ### 예시

    ```html
    <h2>Definition list</h2>

    <dl>
        <dt>HTML</dt>
        
        <dd>HTML stands for Hyper Text Markup.</dd>
        <dd>...else</dd>
    </dl>

    <hr>

    <h2>Table</h2>

    <table border="1">
        <thead>
            <tr>
                <th>th 1</th>
                <th>th 2</th>
                <th>th 3</th>
                <th>th 4</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>td 1-1</td>
                <td>td 1-2</td>
                <td>td 1-3</td>
                <td>td 1-4</td>
            </tr>
            <tr>
                <td>td 2-2</td>
                <td>td 2-1</td>
                <td>td 2-3</td>
                <td>td 2-4</td>
            </tr>
            <tr>
                <td>td 3-1</td>
                <td>td 3-2</td>
                <td>td 3-3</td>
                <td>td 3-4</td>
            </tr>
        </tbody>
        <!-- <tfoot></tfoot> 생략 가능 -->
    </table>

    <hr>

    <h2>Extend Cells In A Table</h2>

    <table border="1">
        <thead>
            <tr>
                <th>th 1</th>
                <th>th 2</th>
                <th>th 3</th>
                <th>th 4</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>td 1-1</td>
                <td>td 1-2</td>
                <td colspan="2">td 1-3</td>
                <!-- <td>td 1-4</td> -->
            </tr>
            <tr>
                <td rowspan="2">td 2-1</td>
                <td>td 2-2</td>
                <td>td 2-3</td>
                <td>td 2-4</td>
            </tr>
            <tr>
                <!-- <td>td 3-1</td> -->
                <td>td 3-2</td>
                <td>td 3-3</td>
                <td>td 3-4</td>
            </tr>
        </tbody>
    </table>
    ```

- ## 이미지 태그 및 파일 경로

    ### 태그 정리

    - `<img>` : 이미지를 생성

    ### 속성 정리

    - `src` : 표시할 이미지의 경로를 지정
    - `alt` : 이미지가 표시되지 않을 시, 대신 표시될 텍스트 지정

    ### 경로 정리

    - `/` : 디렉터리
    - `./` : 현재 디렉터리
    - `../` : 부모 디렉터리

    ### 예시

    - 파일 경로
        
        ```markdown
        image/sample.jpg
        index.html
        ```
        

    - 사용 예시 (img, 파일 경로)
        
        ```html
        <h2>Image</h2>
        
        <img src="./image/sample.jpg" alt="testing image" width="200">
        ```
    

- ## 입력 양식 태그

    ### 태그 정리

    - `<form>` : 입력 양식
        - `<input>` : 입력 요소 (type 속성에 따라 여러 기능을 수행)
        - `<select>` : 선택 입력 요소
            - `<option>` : 선택 입력 요소의 항목
            - `<optgroup>` : 선택 입력 요소 항목의 그룹
        - `<textarea>` : 여러 줄을 입력할 수 있는 글 상자
        - `<button>` : 버튼 입력 요소
        - `<label>` : 입력 요소의 캡션
        - `<fieldset>` : 입력 요소의 그룹
        - `<lable>` : 입력 요소와 함께 표시할 텍스트 콘탠츠, 클릭시 지정된 입력요소가 `focus` 됨

    ### 속성 정리

    - `<form>`
        - `action` : submit 했을 때, 값을 보낼 파일의 주소를 지정
        - `method` : 값을 서버로 전송하는 방식을 지정
            - `GET` : 주소창 뒤에 파라미터가 붙는 방식, 해당 페이지의 파라미터만 알고 있어도 해당 페이지로 이동 가능, 하이퍼링크도 가능
            - `POST` : `HTTP` 프로토콜의 body 에 파라미터가 넘어가는 방식, 보이지 않기에 보안 상승
    - `<input>`
        - `name` : 값이 파라미터로 넘어갈 때, 값의 이름을 지정
        - `type` : 해당 `<input>`의 역할을 지정
            - `hidden` : 사용자에게 보이지 않지만, 폼 데이터가 서버로 제출될 때, 같이 제출됩니다.
            - `text` : 한 줄의 텍스트를 입력할 수 있습니다. (개행할 수 없음)
            - `search` : 검색상자 역할을 합니다. 잘 사용하지 않습니다.
            - `tel` : 전화번호를 입력할 수 있습니다.
            - `url` : URL 주소를 입력할 수 있습니다.
            - `email` : 이메일 주소를 입력할 수 있습니다. "@"가 들어간 이메일 형식인지를 검사합니다.
            - `password` : 비밀번호를 입력할 수 있습니다. 입력한 문자가 "•" 기호로 필터링됩니다.
            - `number` : 숫자를 올리고 내리는 화살표가 추가됩니다. 숫자만 입력할 수 있습니다.
            - `range` : 숫자 범위를 조절하여 선택할 수 있는 슬라이드 막대입니다.
            - `color` : 색상표를 통하여 색상을 선택할 수 있습니다.
            - `checkbox` : 다중 선택 체크박스입니다.
            - `radio` : 단일 선택 체크박스입니다.
            - `datetime` : 국제 표준시(UTC)로 설정된 날짜와 시간을 입력할 수 있습니다. (YYYY-MM-DDTHH:mm 형식)
            - `datetime-local` : 사용자 지역을 기준으로 한 날짜와 시간을 입력할 수 있습니다. (YYYY-MM-DDTHH:mm 형식)
            - `date` : 사용자 지역을 기준으로 한 날짜를 입력할 수 있습니다. (YYYY-MM-DD 형식)
            - `month` : 사용자 지역을 기준으로 한 날짜의 년도와 월을 입력할 수 있습니다. (YYYY-MM 형식)
            - `week` : 사용자 지역을 기준으로 한 날짜의 년도와 주를 입력할 수 있습니다. (YYYY-Www 형식 / ex: 2025-W39)
            - `time` : 사용자 지역을 기준으로 한 시간을 입력할 수 있습니다. (hh:mm 형식) step을 0.01로 지정하여 밀리 초까지 선택 가능
            - `button` : 버튼을 생성합니다. 이벤트 onclick을 지정하여 함수를 호출할 수 있습니다.
            - `file` : 파일을 첨부할 수 있습니다. accept를 사용하여 파일의 확장자를 지정할 수 있습니다. webkitdirectory를 사용하여 구글 크롬 환경의 브라우저에서 폴더를 선택하여 첨부할 수 있습니다.
            - `submit` : 클릭시 서버에 폼 데이터를 전송하는 버튼을 생성합니다.
            - `image` : `submit` 버튼 대신 사용할 수 있는 이미지를 생성합니다.
            - `reset` : 해당 `<form>`에 입력했던 모든 정보를 지웁니다.
        - `value` : 해당 입력 요소의 값을 지정
        - `placeholder` : 텍스트 입력 요소에 연한 텍스트 추가
        - `autocomplete` : on / off 를 지정하여 자동 입력 기능을 토글
        - `checked` , `selected` : `checkbox` 나 `<option>`에 속성을 추가하여 미리 선택
        - `cols` , `rows` : `<textarea>`에 가로칸, 세로칸을 지정
    - `<label>`
        - `for` : 입력 요소를 지정하여 연결

- ## HTML 엔티티 (entity)

    ### 개념 정리

    - HTML 문서에서 특별한 용도로 쓰이는 문자나 키보드로 입력할 수 없는 문자를 표기하는 방법

    - `&` : `&amp;` , Ampersand
    - `<` : `&lt;` , Less than
    - `>` : `&gt;` , Greater than
    - `` : `&nbsp;` , Non-breaking space
    - `ⓒ` : `&copy;` , Copyright
    - `§` : `&sect;`  , Section

- ## CSS

    ### 개념 정리

    - Cascading Style Sheets
    - 문서에 스타일을 지정하는 언어

    - `<link>`
        - `HTML` 문서와 외부 리소스의 관계를 명시하는 `HTML` 요소
        - 사이트의 파비콘이나 아이콘을 지정하기 위해 사용되기도 함
        - 속성 정리
            - `rel` : stylesheet 로 `CSS` 파일임을 지정
            - `href` : 외부 파일 경로를 지정하여 `CSS` 파일을 가져옮
    - `<style>`
        - `HTML` 파일 내부에서 `CSS` 작성 가능

    - `<link>` → `<style>` → `<script>` 순으로 작성해야 브라우저에서 해석하기 효율적

    ### 구조 정리

    ```css
    selector {
        style: value;
        style: value;
        /* ... 이런 식으로 주석을 달 수 있음. */
    }
    ```

    - 각 문장의 끝에는 `;` 을 입력하여 문장이 끝났음을 표현

    ### 문서 객체 모델 DOM

    - `HTML` 문서를 브라우저가 tree 형태로 만드는 것
    - `CSS` 는 `HTML` 요소들로 만들어진 `DOM`에 스타일을 적용한다.

    ### CSS 캐스케이딩 (cascading)

    - `HTML` 문서에 적용되는 `CSS` 우선 순위

    - 기본적인 순서 [ 아래에서 위로 우선 순위가 점점 높아짐 ]
        1. `Element.style` : `HTML`에서 `style` 속성으로 직접 지정한 스타일
        2. `.css` : `CSS` 파일로 지정되거나 `<style>` 블록으로 지정된 스타일
        3. `user agent stylesheet` : 브라우저 (user agent) 에서 기본적으로 주어진 스타일
    - 추가적인 순서 규칙
        1. 같은 방식으로 요소를 지정한다면, 여러 개가 있을 때, `CSS` 파일에 나중에 (아래에) 지정된 것이 우선 순위가 높다.
        2. 선택자의 선택 범위를 좁힐수록, 우선순위가 높다.

    ### 선택자 (selectors)

    - `DOM`의 요소 상관 관계를 이용하여 요소를 지정하는 문자열

    - `HTML` 요소의 `id` 속성과 `class` 속성

    - 태그 선택자
        - 말 그대로 지정한 태그를 선택
    - 고유 혹은 그룹을 선택하는 선택자
        - `#id` : `DOM`요소에서 `id`가 “id” 인 요소를 선택
        - `.class` : `DOM`요소에서 `class`가 “class” 인 요소를 선택
    - 상관 관계 선택자
        - `parent element`   : 자손 선택자,  `` 로 지정하며, 요소 `parent` 안에 들어가있는 모든 요소
        - `parent > element`   : 자식 선택자, `>` 로 지정하며, 요소 `parent` 바로 아래에 있는 요소들
        
        - `selector1, selector2`   : 다중 조건 선택자 or, `,` 로 지정하며, 선택자 `selector1` 와 선택자 `selector2` 를 모두 선택한다.
        - `selector1selector2`   : 다중 조건 선택자 and,  선택자를 이어붙여 지정하며, 선택자 `selector1` 와 선택자 `selector2` 를 모두 충족하는 요소를 선택한다.
            - 예시 : `div.class`