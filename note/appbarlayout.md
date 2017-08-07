# AppBarLayout 应用栏布局

> <font size = 3>google在L中推出了新的安卓设计理念-Material Design,同时也推出了不少的新控件，AppBarLayout就是其中之一。AppBarLayout继承自**垂直方向**的LinearLayout,不过在此基础上添加了滑动手势的处理，以便开发者结合其他控件实现更好的交互。通常内部设置一个子View，设置scrollflags值，结合可滑动的view（NestedScrollView,RecyclerView等）滑动的改变，响应预期中的动作Behavior.

<font size = 3> <b/>  在开发中，通常至少会结合CoordinatorLayout，Toolbar+一个可滑动的view来使用，需要注意的是appbarlayout的使用离不开CoordinatorLayout,必须作为CoordinatorLayout的子布局使用，appbarlayout的子view通过xml属性app:layout_scrollFlags或者代码setScrollFlags(int flag)来设置相应的滑动标记

> 在开发中要想快速成长，更多是靠个人的理解及总结，对某个知识点理解透彻了，稍加总结会发现知识点长时间也不会忘记。就像对于appbarlayout，我个人目前的对其理解就是，能够让子view在CoordinatorLayout（协调布局）这个根布局中完成很好的滑动联动效果，也就是内部处理了手势滑动，根据子view的scrollflag来操作子view。

# 关联点

	主要讲下继承，api，scrollflag

## 继承

![](http://i.imgur.com/AFjvMzv.png)

## api

	void	addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener listener)
	//添加一个偏移量改变监听
	AppBarLayout.LayoutParams	generateLayoutParams(AttributeSet attrs)
	//基于提供的属性集返回一个新的布局参数
	float	getTargetElevation()
	//获取appbarlayout的高度值
	final int	getTotalScrollRange()
	/获得所有子控件的滑动范围
	void	removeOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener listener)
	//移除偏移量改变监听
	void	setExpanded(boolean expanded)
	设置此appbarlayou是否展开
	void	setExpanded(boolean expanded, boolean animate)
	//设置appbarlayou是否展开，如果已经设置了动画，animate代表是否设置转换动画
	void	setOrientation(int orientation)
	//设置布局方向
	void	setTargetElevation(float elevation)
	//当appbarlayout需要高于内容时，可设置其高度

## scrollflag

	对于设置子view的scrollflag有两种方法，代码setScrollFlag（int）或者xml文件中设置子view的属性：app:layout_scrollFlags

	取值一共有5中类型：scroll,enterAlways,enterAlwaysCollapsed,exitUntilCollapsed,snap 
	
		1, scroll :这个子View将会随着可滚动View（如：NestedScrollView,以下都会用NestedScrollView 来代替可滚动的View ）一起滚动，就
	好像子View 是属于NestedScrollView的一部分一样。

		2, enterAlways :CoordinatorLayout中可滚动子view（例如NestedScrollView，recyclerview） 向下滑动时，子View 马上向下滑动，
	向上滑动时子view马上滑动，结合scroll一起使用

		3, enterAlwaysCollapsed ： enterAlwaysCollapsed 是对enterAlways 的补充，当ScrollView 向下滑动的时候，
	滑动View（也就是设置了enterAlwaysCollapsed 的View）下滑至折叠的高度，当ScrollView 到达滑动范围的结束值的时候，滑动View剩下的部分
	开始滑动。这个折叠的高度是通过View的minimum height （最小高度）指定的结合scrol或者加入其他值一起使用

		4,exitUntilCollapsed： 当ScrollView 滑出屏幕时（也就时向上滑动时），滑动View先响应滑动事件，滑动至折叠高度，
	也就是通过minimum height 设置的最小高度后，就固定不动了，再把滑动事件交给 scrollview 继续滑动，结合scroll一起使用

		5, snap：在滚动结束后，如果子view的可见部分大于50%，则子view将自动展开，反之，将折叠起来，结合scroll一起使用

	从上面可以看到都设置了“scroll”值

# 基本使用	

## scroll	
> scroll :这个子View将会随着可滚动View（如：NestedScrollView,以下都会用NestedScrollView 来代替可滚动的View ）一起滚动，就好像子View 是属于NestedScrollView的一部分一样。

效果如下：

![](http://i.imgur.com/RVYoTZR.gif)

从动画中可以看出此时toolbar相当和nestedscrollview是一个可滑动的整体布局，这个时候滑动toolbar也是可以滑动的，有可能有的程序猿会遇到无法滚动的情况，**注意下NestedScrollView的高度属性，应该设置为match_parent**

代码：

	<?xml version="1.0" encoding="utf-8"?>
		<android.support.design.widget.CoordinatorLayout
	    xmlns:android="http://schemas.android.com/apk/res/android"
	    xmlns:app="http://schemas.android.com/apk/res-auto"
	    android:id="@+id/coordinator"
	    android:layout_width="match_parent"
	    android:layout_height="match_parent"
	    android:fitsSystemWindows="true">
	
		    <android.support.design.widget.AppBarLayout
		        android:id="@+id/appbar"
		        android:layout_width="match_parent"
		        android:layout_height="wrap_content">
		        <android.support.v7.widget.Toolbar
		            android:id="@+id/toolbar"
		            android:layout_width="match_parent"
		            android:layout_height="?attr/actionBarSize"
		            android:background="?attr/colorPrimary"
		            app:title="appbarlayout"
		            app:layout_scrollFlags="scroll" />
		    </android.support.design.widget.AppBarLayout>
		
		    <android.support.v4.widget.NestedScrollView
		        android:layout_width="match_parent"
		        android:layout_height="match_parent"
		        app:layout_behavior="@string/appbar_scrolling_view_behavior">
		
		        <TextView
		            android:lineSpacingMultiplier="2"
		            android:layout_width="match_parent"
		            android:layout_height="match_parent"
		            android:text="@string/scroll_content"/>
		
		    </android.support.v4.widget.NestedScrollView>

	</android.support.design.widget.CoordinatorLayout>

这里顺便讲下android:fitsSystemWindows这个属性


	如果某个View 的fitsSystemWindows 设为true，那么该View的padding属性将由系统设置，用户在布局文件中设置的
	padding会被忽略。系统会为该View设置一个paddingTop，值为statusbar的高度。fitsSystemWindows默认为false。

	注意点：
	
		只有将statusbar设为透明，或者界面设为全屏显示（设置View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN flag)时，fitsSystemWindows
		才会起作用。不然statusbar的空间轮不到用户处理，这时会由ContentView的
		父控件处理，如果用HierarchyView 工具查看，将会看到，ContentView的父控件的paddingTop将会被设置。
	
		如果多个view同时设置了fitsSystemWindows，只有第一个会起作用。这是一般情况，后面会介绍特殊情况。

	

## enterAlways
> enterAlways:CoordinatorLayout中可滚动子view（例如NestedScrollView，recyclerview） 向下滑动时，子View 马上向下滑动，向上滑动时子view马上滑动，结合scroll一起使用

效果如下

![](http://i.imgur.com/DUJ7Xtd.gif)

可以看到这个是下滚动马上带出了toolbar,上滚动时toolbar马上向上滚动直至不可见

主要修改代码：

	        <android.support.v7.widget.Toolbar
	            android:id="@+id/toolbar"
	            android:layout_width="match_parent"
	            android:layout_height="?attr/actionBarSize"
	            android:background="?attr/colorPrimary"
	            app:title="appbarlayout"
	            app:layout_scrollFlags="scroll|enterAlways" />


## enterAlwaysCollapsed

> enterAlwaysCollapsed :是对enterAlways 的补充，当ScrollView 向下滑动的时候，滑动View（也就是设置了enterAlwaysCollapsed 的View）下
滑至折叠的高度，当nestedscrollview 到达滑动范围的结束值的时候，滑动View剩下的部分开始滑动。这个折叠的高度是通过View的minimum height （最小高度）指定的,结合scrol或者加入其他值一起使用
，这个取值如果单单结合scroll使用，实现的效果不太好，还要结合enterAlways，通过这个值得命名似乎也可以看出什么来

先贴出两段代码看下：


    <android.support.v7.widget.Toolbar
        android:id="@+id/toolbar"
        android:layout_width="match_parent"
		//设置toolbar的高度
        android:layout_height="150dp"
		//设置最小高度，使其可以实现折叠的效果
        android:minHeight="?attr/actionBarSize"
		//内部空间放置底部，保证界面协调
        android:gravity="bottom"
		//设置底部外边距，保证对称
        android:layout_marginBottom="25dp"
        android:background="?attr/colorPrimary"
        app:title="appbarlayout"
        app:layout_scrollFlags="scroll|enterAlwaysCollapsed" />

    <android.support.v7.widget.Toolbar
        。。。。
        app:layout_scrollFlags="scroll|enterAlways|enterAlwaysCollapsed" />
	
	区别也就最后一句话

效果如下：

没加 enterAlways

![](http://i.imgur.com/r6yUMkh.gif)

加了 enterAlways

![](http://i.imgur.com/5TZSImg.gif)

从结果来看两者的效果差别很大


## exitUntilCollapsed

> exitUntilCollapsed: 当NestedScrollView 滑出屏幕时（也就时向上滑动时），滑动View先响应滑动事件，滑动至折叠高度，也就是通过minimum height 设置的最小高度后，就固定不动了，
再把滑动事件交给 NestedScrollView 继续滑动，结合scroll一起使用

效果如下：

![](http://i.imgur.com/mdxay8F.gif)

可以看出toolbar总是可见的，只是折叠与展开

## snap

> snap: 在滚动结束后，如果子view的可见部分大于50%，则子view将自动展开，反之，将折叠起来，结合scroll一起使用

效果如下：

![](http://i.imgur.com/zuiQYNa.gif)


总体上来讲对toolbar的操作还是借助CollapsingToolbarLayout这个控件实现起来效果要好些。

以上就是对AppBarLayout的简单的讲解，Demo已传github

Star地址：https://github.com/Kriy/AndroidMaterialDesignUI  ,谢谢支持