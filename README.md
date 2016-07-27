# SimpleTargetView
Animation view to highlight a particular goals for Android

<img src="https://github.com/anastr/SimpleTargetView/blob/master/images/ezgif-2555049895.gif" width="250" height=250 />
<img src="https://github.com/anastr/SimpleTargetView/blob/master/images/ezgif-3734696272.gif" width="150" height=150 />
<img src="https://github.com/anastr/SimpleTargetView/blob/master/images/ezgif-4259888620.gif" width="150" height=150 />


# Usage

**add this line to Gradle**

```gradle

dependencies {
	    compile 'com.github.anastr:targetviewlib:1.0.0'
}

```

**in layout**

```xml

<com.github.anastr.targetviewlib.TargetView
        android:id="@+id/mTargetView"
        android:layout_width="200dp"
        android:layout_height="200dp"
        app:targetWidth="10"
        app:targetColor="#6b75ff"
        app:rotateDuration="2000"
        app:targetMode="Target1"
        app:withBackgroundEffect="true"
        app:backgroundEffectColor="#aa3fff1e"
        app:backgroundEffectDuration="500">
           
           <!-- TODO  add your views here -->
           
    </com.github.anastr.targetviewlib.TargetView>

```


# Methods (code)

```java

// Animation starting by defoult
TargetView mTargetView = (TargetView) findViewById(R.id.mTargetView);

// to stop Animation
mTargetView.stopAnimation();

// to start Animation agin
mTargetView.startAnimation();

// check Animation
if (mTargetView.isAnimationRunning() ){
  ....
}

```


# Attributes (in xml)

> app:targetWidth="10"

in pixel
defoult : 10


> app:targetColor="#6b75ff"

defoult : BLACK


> app:rotateDuration="2000"

defoult : 2000 milliSeconds


> app:withBackgroundEffect="true"

defoult : true


> app:backgroundEffectColor="#AA3fff1e"

defoult : Color.CYAN
It is advisable to use *alpha*


> app:backgroundEffectDuration="500"

defoult : 500 milliSeconds


> app:targetMode="Target1"

enum (Target1, Target2, Target3) 
<table style="width:100%">
  <tr>
    <th>targetMode</th>
    <th>note</th> 
    <th>screenshot</th>
  </tr>
  <tr>
    <td>Target1</td>
    <td>---</td> 
    <td><img src="https://github.com/anastr/SimpleTargetView/blob/master/images/layout-2016-07-25-170346.png" width="250" height=170 /></td>
  </tr>
  <tr>
    <td>Target2</td>
    <td>---</td> 
    <td><img src="https://github.com/anastr/SimpleTargetView/blob/master/images/layout-2016-07-25-170333.png" width="250" height=170 /></td>
  </tr>
  <tr>
    <td>Target3</td>
    <td>set targetWidth="80" or more</td> 
    <td><img src="https://github.com/anastr/SimpleTargetView/blob/master/images/layout-2016-07-27-095639.png" width="250" height=170 /></td>
  </tr>
</table>

