# FloatingActionButton  悬浮按钮


FAB的出现在一些产品经理看来其不算一个太友好的交互控件，因为使用过后你会发现FAB在某些应用场景会挡住下一层界面的展示，可能是遮挡内容， 可能是无法点击，，，所以在考虑使用此控件时就要从良好的交互作为出发点，考虑是否会带来不好的交互。

关于填充色，有两个重要的属性:backgroundTint和rippleColor，分别表示普通状态和点击状态下的填充色(普通状态下浮起的状态会有阴影，点击之后阴影范围会变大)。其中，backgroundTint的默认值是theme中的colorAccent(colorAccent 对应EditText编辑时、RadioButton选中、CheckBox等选中时的颜色)，所以你可以在style中修改colorAccent的值来自动改变这个属性，但我们一般不这么做；而rippleColor默认值是theme中的colorControlHighlight。一般的做法是直接在布局中指定这两个颜色:

1 <android.support.design.widget.FloatingActionButton
2 ...
3         app:backgroundTint="#FFC125"
4         app:rippleColor="#FFD700"/>
 

FloatActinButton最大的特点是其悬浮的效果，所以关于其立体感的属性当然也重要。这里也是要涉及两个属性: elevation和pressedTranslationZ，分别为普通状态下的阴影大小和点击时阴影的大小，设置好之后，最终的布局如下:

复制代码
 1 <?xml version="1.0" encoding="utf-8"?>
 2 <RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
 3     xmlns:app="http://schemas.android.com/apk/res-auto"
 4     android:orientation="vertical"
 5     android:layout_width="match_parent"
 6     android:layout_height="match_parent">
 7     <android.support.design.widget.FloatingActionButton
 8         android:id="@+id/bMain_Float"
 9         app:fabSize="normal"
10         android:layout_width="wrap_content"
11         android:layout_height="wrap_content"
12         android:layout_alignParentRight="true"
13         android:layout_alignParentBottom="true"
14         android:src="@android:drawable/ic_dialog_email"
15         app:backgroundTint="#FFC125"
16         app:rippleColor="#FFD700"
17         app:elevation="6dp"
18         app:pressedTranslationZ="12dp"/>
19 </RelativeLayout>

> app:fabSize="normal"//2个取值，normal=56dp,mini=48dp

> app:elevation="10dp"//高度
 
> app:rippleColor="#0000ff"//按下水波纹颜色

>app:backgroundTint	按钮颜色

> app:pressedTranslationZ="20dp"//按下Z轴移动距离  
 注意：设置android:clickable="true"才有按下的效果