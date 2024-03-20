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

![Untitled](Widget%2028608b879e36418cba14a0290e1388c8/Untitled.png)

![Untitled](%E1%84%85%E1%85%B5%E1%84%82%E1%85%B5%E1%84%8B%E1%85%A5%20%E1%84%85%E1%85%A6%E1%84%8B%E1%85%B5%E1%84%8B%E1%85%A1%E1%84%8B%E1%85%AE%E1%86%BA%20a4603a87c74d437b971b82f45977b2d2/Untitled.png)

Linear Layout

![Untitled](%E1%84%85%E1%85%B5%E1%84%82%E1%85%B5%E1%84%8B%E1%85%A5%20%E1%84%85%E1%85%A6%E1%84%8B%E1%85%B5%E1%84%8B%E1%85%A1%E1%84%8B%E1%85%AE%E1%86%BA%20a4603a87c74d437b971b82f45977b2d2/Untitled%201.png)

레이아웃 만들때 쓰는 형식임
