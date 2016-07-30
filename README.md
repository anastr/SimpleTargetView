# TargetView
Animation View to Highlight particular Views for Android, it can be Used with Views that you see important (Like CountDownTimer), And also to attract the user's attention to something interesting.

`minSdkVersion=11`

# Preview
<img src="https://github.com/anastr/SimpleTargetView/blob/master/images/gif0.gif" width="225" height=274 /><br/>
<img src="https://github.com/anastr/SimpleTargetView/blob/master/images/gif2.gif" width="150" height=150 />
<img src="https://github.com/anastr/SimpleTargetView/blob/master/images/gif3.gif" width="150" height=150 />


# Usage

**add this line to** `build.gradle`

```gradle

dependencies {
	    compile 'com.github.anastr:targetviewlib:1.0.2'
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

start and stop Animation

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

<img src="https://github.com/anastr/SimpleTargetView/blob/master/images/gif1.gif" width="250" height=250 />

Another Methods

```java

// Change target color
mTargetView.setTargetColor(Color.parseColor(#aa009900));

// Change target Width
mTargetView.setTargetWidth(15);

// Change Background Effect Color
mTargetView.setBackgroundEffectColor(Color.RED);

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

enum (Target1, Target2, Target3, Target4, Target5, Target6, Target7, Target8) 
<table style="width:100%">
  <tr>
    <th>targetMode</th>
    <th>note</th> 
    <th>screenshot</th>
  </tr>
  <tr>
    <td>Target1</td>
    <td>---</td> 
    <td><img src="https://github.com/anastr/SimpleTargetView/blob/master/images/Target1.png" width="320" height=230 /></td>
  </tr>
  <tr>
    <td>Target2</td>
    <td>---</td> 
    <td><img src="https://github.com/anastr/SimpleTargetView/blob/master/images/Target2.png" width="320" height=230 /></td>
  </tr>
  <tr>
    <td>Target3</td>
    <td>set targetWidth="80" or more</td> 
    <td><img src="https://github.com/anastr/SimpleTargetView/blob/master/images/Target3.png" width="320" height=230 /></td>
  </tr>
  <tr>
    <td>Target4</td>
    <td>---</td> 
    <td><img src="https://github.com/anastr/SimpleTargetView/blob/master/images/Target4.png" width="320" height=230 /></td>
  </tr>
  <tr>
    <td>Target5</td>
    <td>---</td> 
    <td><img src="https://github.com/anastr/SimpleTargetView/blob/master/images/Target5.png" width="320" height=230 /></td>
  </tr>
  <tr>
    <td>Target6</td>
    <td>set targetWidth="10" or less</td> 
    <td><img src="https://github.com/anastr/SimpleTargetView/blob/master/images/Target6.png" width="320" height=230 /></td>
  </tr>
  <tr>
    <td>Target7</td>
    <td>---</td> 
    <td><img src="https://github.com/anastr/SimpleTargetView/blob/master/images/Target7.png" width="320" height=230 /></td>
  </tr>
  <tr>
    <td>Target8</td>
    <td>set targetWidth="15" or less</td> 
    <td><img src="https://github.com/anastr/SimpleTargetView/blob/master/images/Target8.png" width="320" height=230 /></td>
  </tr>
</table>


#
```

Copyright 2016 Anas ALtair

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

```
