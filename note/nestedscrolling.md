# NestedScrolling 嵌套滚动

> 谷歌在L中推出一些类控件的同时，也推出了嵌套滑动机制--NestedScrolling. NestedScrollView就是与之相关的一个控件，官方简介中这样描述道：NestedScrollView就像ScrollView,但是它支持在Android新旧版本中一个嵌套的滚动父和子元素

如果单单聊NestedScrollView，也聊不出什么特别的，所以先来看看NestedScrolling

# NestedScrolling机制能够让父View和子View在滚动式进行配合

## 其基本流程如下：

	1. 当子view开始滚动之前，可以通知父View，让其先于自己进行滚动；
 
 	2. 子View自己进行滚动；

	3. 子view滚动之后，还可以通知父view继续滚动。而要实现这样的
	  交互机制，首先父view要实现NestedScrollingParent接口，而子
	  View需要实现NestedScrollingChild接口，在这套机制中子
	  View是发起者，父view是接受回调并做出响应的。

## 相关接口

> 	//嵌套滑动中子view和父view需实现的接口
> 	NestedScrollingChild
	NestedScrollingParent
	//子view和父view内部滑动处理类
	NestedScrollingChildHelper
	NestedScrollingParentHelper

NestedScrollView已经实现了NestedScrollingChild和NestedScrollingParent两个接口，Recyclerview实现了NestedScrollChild接口等等


## NestedScrollingChild接口
	      
	//开始、停止嵌套滚动
	public boolean startNestedScroll(int axes); public void stopNestedScroll();
	//触摸滚动相关
	public boolean dispatchNestedPreScroll(int dx, int dy, int[] consumed, int[] offsetInWindow);
	public boolean dispatchNestedScroll(int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int[] offsetInWindow);
	//惯性滚动相关 public boolean dispatchNestedPreFling(float velocityX, float velocityY);
	public boolean dispatchNestedFling(float velocityX, float velocityY, boolean consumed);
	 
　　public boolean startNestedScroll(int axes);
 
　　首先子view需要开启整个流程（内部主要是找到合适的能接受nestedScroll的parent），通知父View，我要和你配合处理TouchEvent
 
　　public boolean dispatchNestedPreScroll(int dx, int dy, int[] consumed, int[] offsetInWindow);
 
　　在子View的onInterceptTouchEvent或者onTouch中(一般在 MontionEvent.ACTION_MOVE事件里)，调用该方法通知父View滑动的距离。该方法的第三第四个参数返回父view消费掉的 scroll长度和子View的窗体偏移量。如果这个scroll没有被消费完，则子view进行处理剩下的一些距离，由于窗体进行了移动，如果你记录了手指最后的位置，需要根据第四个参数offsetInWindow计算偏移量，才能保证下一次的touch事件的计算是正确的。
如果父view接受了它的滚动参数，进行了部分消费，则这个函数返回true，否则为false。
这个函数一般在子view处理scroll前调用。
 
　　public boolean dispatchNestedScroll(int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int[] offsetInWindow);
 
　　向父view汇报滚动情况，包括子view消费的部分和子view没有消费的部分。
	如果父view接受了它的滚动参数，进行了部分消费，则这个函数返回true，否则为false。
	这个函数一般在子view处理scroll后调用。
 
　　public void stopNestedScroll();
　　最后，stopNestedScroll()方法与startNestedScroll(int axes)对应，用于结束嵌套滚动流程；而惯性滚动相关的两个方法与触摸滚动相关的两个方法类似，这里不再赘述。
 
## NestedScrollingParent
接口概述

	//当开启、停止嵌套滚动时被调用
	public boolean onStartNestedScroll(View child, View target, int nestedScrollAxes);
	public void onNestedScrollAccepted(View child, View target, int nestedScrollAxes);
	public void onStopNestedScroll(View target);
	//当触摸嵌套滚动时被调用
	public void onNestedPreScroll(View target, int dx, int dy, int[] consumed);
	public void onNestedScroll(View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed);
	//当惯性嵌套滚动时被调用
	public boolean onNestedPreFling(View target, float velocityX, float velocityY);
	public boolean onNestedFling(View target, float velocityX, float velocityY, boolean consumed);
	　　
	
　　从命名可以看出，这几个都是回调方法。当调用NestedScrollingChild中的方法时，NestedScrollingParent中与之相对应的方法就会被回调。方法之间的具体对应关系如下：

![](http://i.imgur.com/vk3UNWi.png)

	　　从上面的接口还有方法我们可以得出一些简单的流程
	调用child的startNestedScroll（）来发起嵌套滑动流程（实质上是寻找能够配合child进行嵌套滚动的parent）。parent的onStartNestedScroll（）会被调用，
	若此方法返回true，则OnNestScrollAccepted（）也会被调用。child每次滚动前，可以先询问parent是否要滚动，即调用dispatchNestedScroll（），这时可以
	回调到parent的OnNestedPreScroll（），parent可以在这个回调中先于child滚动。
	dispatchNestedPreScroll（）之后，child可以进行自己的滚动操作。