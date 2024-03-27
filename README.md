# 리니어 레이아웃

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:weightSum="2">

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="0dp"
        android:layout_weight="1"
        android:background="@color/purple_200" />

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="0dp"
        android:layout_weight="1"
        android:background="@color/teal_200"
        android:orientation="horizontal"
        android:weightSum="4">

        <LinearLayout
            android:layout_width="0dp"
            android:layout_height="match_parent"
            android:layout_weight="1"
            android:background="#FF9800"
            tools:ignore="NestedWeights" />

        <LinearLayout
            android:layout_width="0dp"
            android:layout_height="match_parent"
            android:layout_weight="1"
            android:background="#FFC107" />

        <LinearLayout
            android:layout_width="0dp"
            android:layout_height="match_parent"
            android:layout_weight="2"
            android:orientation="vertical"
            android:weightSum="2">

            <LinearLayout
                android:layout_width="match_parent"
                android:layout_height="0dp"
                android:layout_weight="1"
                android:background="#2196F3" />

            <LinearLayout
                android:layout_width="match_parent"
                android:layout_height="0dp"
                android:layout_weight="1"
                android:background="#4CAF50" />
        </LinearLayout>
    </LinearLayout>

</LinearLayout>
```
# Widget

# TextView

## autoLink

**`android:autoLink="email"`**

autoLink는 앱으로 넘어가지게 해주는 속성이다

## layout_gravity

**`android:layout_gravity="right"`**

컴포넌트를 정렬시켜주는 기능 like css’s flex or grid

## text

**`android:text="관리자"`**

TextView에 내용을 적는 칸

## textColor

**`android:textColor="@color/teal_200"`**

텍스트 색 지정

## textStyle

**`android:textStyle="bold"`**

텍스트 스타일 지정

전체 소스코드

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:orientation="vertical"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:padding="20dp">

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="서울로봇고등학교"
        android:layout_marginBottom="30dp"
        android:textSize="40dp"
        android:textColor="#E91E63"
        android:layout_gravity="center"
        />
    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="첨단로봇시스템"
        android:textSize="20dp"
        android:textStyle="bold"
        android:textColor="#3F51B5"
        />
    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="융합적 공학 교육을 통한 \n로봇소프트웨어분야의 영 마이스터 양성"
        android:textColor="@color/teal_200"
        android:textSize="16dp"/>
    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="20dp"
        android:text="연락처"
        android:layout_gravity="right"
        />
    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="02-2226-2146"
        android:layout_gravity="right"
        android:autoLink="phone"
        />
    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="20dp"
        android:text="관리자"
        android:layout_gravity="right"
        />
    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="robot@seoulrobot.hs.kr"
        android:layout_gravity="right"
        android:autoLink="email"
        />
    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="horizontal"
        android:layout_marginTop="20dp"
        android:gravity="center"
        >
        <Button
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="이전"
            android:backgroundTint="#4CAF50"
            android:layout_margin="2dp"
            android:textColor="@color/black"/>
        <Button
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="다음"
            android:backgroundTint="#4CAF50"
            android:layout_margin="2dp"
            android:textColor="@color/black"/>
        <Button
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_margin="2dp"
            android:text="종료"
            android:backgroundTint="#4CAF50"
            android:textColor="@color/black"/>
    </LinearLayout>
</LinearLayout>

```
# Button Event

# 버튼 이벤트

```xml
<Button
android:id="@+id/btn_prev"
android:layout_width="wrap_content"
android:layout_height="wrap_content"
android:text="이전"
android:backgroundTint="#4CAF50"
android:layout_margin="2dp"
android:textColor="@color/black"/>
```

id 지정해준 다음

`Button **btn_prev**, **btn_next**, **btn_exit**; *//선언*`

```java
btn_prev= findViewById(R.id.btn_prev);
btn_next= findViewById(R.id.btn_next);
btn_exit= findViewById(R.id.btn_exit);//연결
```

```java
btn_prev.setOnClickListener(this);
btn_next.setOnClickListener(this);
btn_exit.setOnClickListener(this);//리스너등록
```

```java
@Override
public voidonClick(View view) {//이벤트처리
switch(view.getId()){
caseR.id.btn_prev:
            Toast.makeText(this,"이전 버튼 클릭.", Toast.LENGTH_SHORT).show();
break;
caseR.id.btn_next:
            String str_id =edit_id.getText().toString();
            String str_pwd =edit_pwd.getText().toString();

if(str_id.length()<1 || str_pwd.length()<1)
                Toast.makeText(this,"아아디와 비번을 확인하세요.", Toast.LENGTH_SHORT).show();
else
Toast.makeText(this,"아아디는 "+str_id+"이고,비번은 "+str_pwd+"입니다.", Toast.LENGTH_SHORT).show();
break;
caseR.id.btn_exit:
            Toast.makeText(this,"종료 버튼 클릭.", Toast.LENGTH_SHORT).show();
break;
    }
}
```

이런식으로 이벤트 처리를 할 수 있다.

![Untitled](Button%20Event%20dd26c82973fb4e449b890db2bb36d45e/Untitled.png)

# Edit Text

```xml
<EditText
android:id="@+id/edit_id"
android:layout_width="match_parent"
android:layout_height="wrap_content"
android:hint="아이디"/>
<EditText
android:id="@+id/edit_pwd"
android:layout_width="match_parent"
android:layout_height="wrap_content"
android:inputType="numberPassword"
android:hint="비밀번호"/>
```

이런식으로 html input처럼 쓰면된다.

`EditText **edit_id**, **edit_pwd**;`

```java
edit_id= findViewById(R.id.edit_id);
edit_pwd= findViewById(R.id.edit_pwd);
```

```java
String str_id =edit_id.getText().toString();
String str_pwd =edit_pwd.getText().toString();
```

이런식으로 입력받은걸 변수에 넣을 수 있다.

![Untitled](Button%20Event%20dd26c82973fb4e449b890db2bb36d45e/Untitled%201.png)

![Untitled](Widget%2028608b879e36418cba14a0290e1388c8/Untitled.png)

![Untitled](%E1%84%85%E1%85%B5%E1%84%82%E1%85%B5%E1%84%8B%E1%85%A5%20%E1%84%85%E1%85%A6%E1%84%8B%E1%85%B5%E1%84%8B%E1%85%A1%E1%84%8B%E1%85%AE%E1%86%BA%20a4603a87c74d437b971b82f45977b2d2/Untitled.png)

Linear Layout

![Untitled](%E1%84%85%E1%85%B5%E1%84%82%E1%85%B5%E1%84%8B%E1%85%A5%20%E1%84%85%E1%85%A6%E1%84%8B%E1%85%B5%E1%84%8B%E1%85%A1%E1%84%8B%E1%85%AE%E1%86%BA%20a4603a87c74d437b971b82f45977b2d2/Untitled%201.png)

레이아웃 만들때 쓰는 형식임
