# AndroidMaterialDesignUI


Android 5.0推出市场已经有很久了，最大特色就是材料设计，L中增添了不少的新控件。此次创建此库为了便于学习新控件，对5.0及以后的部分新控件做一个归纳。
Material Design材料设计，是的一种新的设计风格，谷歌希望寄由此来统一各种平台上的应用外观和用户体验。

# 主要介绍一下控件使用:
             
- [Snackbar](http://blog.csdn.net/hj2drf/article/details/76060109) 提示条    

- [Toolbar](https://github.com/Kriy/AndroidMaterialDesignUI/blob/master/note/toolbar.md) 工具栏

- [AppBarLayout](http://blog.csdn.net/hj2drf/article/details/76595191) 应用栏布局

- RecyclerView 循环器视图

- [CardView](http://blog.csdn.net/hj2drf/article/details/76472508) 卡片视图

- [TabLayout](http://blog.csdn.net/hj2drf/article/details/76405469) 标签布局

- [NavigationView](http://blog.csdn.net/hj2drf/article/details/77017284) 导航视图          
     
- CoordinatorLayout 协调布局               

- [FloatingActionButton](http://blog.csdn.net/hj2drf/article/details/76358786)    悬浮按钮               

- [SwipeRefreshLayout](https://github.com/Kriy/AndroidMaterialDesignUI/blob/master/note/swiperefreshlayout.md) 下拉刷新布局              

- CollapsingToolbarLayout    可折叠工具栏布局       

- TextInputLayout    文本输入布局           

- TextInputEditText    文本输入编辑框         


# 类:

  >  底部弹窗               BottomSheetBehavior
  >  
  >  嵌套滚动				NestedScrolling



1、toolBar
用来取代actionbar

2、android.support.design.widget.AppBarLayout
用来和toolbar联合使用，达到Material Design效果

3、android.support.v7.widget.RecyclerView
该控件用来替代ListView，具有高度的松耦合性，主要不同就是省去了我们自己去创建ViewHolder类

4、android.support.v7.widget.CardView
该控件是一个卡片布局，继承FrameLayout

5、android.support.design.widget.TabLayout
用来和Viewpager结合使用来作为Viewpager的选项卡

6、android.support.design.widget.NavigationView
在Material Design中，Navigation drawer导航抽屉，被设计用于应用导航，提供了一种通用的导航方式，体现了设计的一致性。
而NavigationView的典型用途就是配合之前v4包的DrawerLayout，作为其中的Drawer部分，即导航菜单的本体部分。NavigationView是一个导航菜单框架，
使用menu资源填充数据，使我们可以更简单高效的实现导航菜单。它提供了不错的默认样式、选中项高亮、分组单选、分组子标题、以及可选的Header。

7、android.support.design.widget.CoordinatorLayout
该控件和新发布的这些控件联合使用，只要把他作为一个容器类使用就好了，一边用作跟布局

8、android.support.design.widget.FloatingActionButton
用来在界面上显示一个悬浮的按钮，有大小两种尺寸

9、android.support.v4.widget.SwipeRefreshLayout
继承自ViewGroup，通常使用只有一个子控件，如存在多个只会显示第一个，不仅支持listview和recyclerview,还支持包裹所有控件下拉刷新操作

10、android.support.design.widget.CollapsingToolbarLayout
CollapsingToolbarLayout作用是提供了一个可以折叠的Toolbar，它继承至FrameLayout，给它设置layout_scrollFlags，它可以控制包含在
CollapsingToolbarLayout中的控件(如：ImageView、Toolbar)在响应layout_behavior事件时作出相应的scrollFlags滚动事件(移除屏幕或固定在屏幕顶端)

11、android.support.design.widget.TextInputLayout
一般嵌套一个EditText，用来在输入内容后提示内容显示在外面，还具有空校验


# 替代关系:

    Toolbar：替代ActionBar

    RecyclerView：替代ListView和GridView

    NestedScrollView：替代ScrollView

    Snackbar：替代Toast

    FloatingActionButton：替代ImageButton

    TextInputEditText：替代EditText



# 动态替换Theme

	MaterialTheme配色方案：http://www.materialpalette.com
	修改状态栏，ActionBar，界面背景，NavigationBar的颜色。让Activity使用自定义的Theme。
	<style name="AppTheme" parent="@android:style/Theme.Material">
	    <!--状态栏颜色-->
	    <item name="android:colorPrimaryDark">#f00</item>
	    <!--ActionBar颜色-->
	    <item name="android:colorPrimary">#ff0</item>
	    <!--界面背景颜色-->
	    <item name="android:windowBackground">@color/colorWindowBackground</item>
	    <!--导航栏颜色-->
	    <item name="android:navigationBarColor">#00f</item>
	</style>

	动态替换Theme的步骤：
	定义至少2套theme
	调用setTheme方法设置当前的theme，但是该方法要在setContentView之前，如:
		setTheme(mTheme);
		setContentView(R.layout.activity_main);
	设置了Theme，需要finish当前Activity，然后重启当前Activity，让Theme生效
		Intent intent = getActivity().getIntent();
		getActivity().finish();//结束当前的Activity
		getActivity().overridePendingTransition(0,0);//不要动画
		startActivity(intent);

# View的高度与阴影

	官网介绍：https://developer.android.com/intl/zh-tw/training/material/shadows-clipping.html

	View新增属性z轴，用来体现Material Design中的层次，影响因素2个：elevation 和 translationZ
		View高度 = elevation + translationZ
	elevation表示view的高度，高度越大，阴影越大，可以在xml中直接使用属性， 也可以在代码中使用view.setEvelvation();
		android:elevation="10dp"

	transtionZ属性表示view在Z方向移动的距离，一般用于属性动画中
		android:translationZ="10dp"

	高度影响View的绘制顺序，过去是按View添加顺序绘制，先添加的先绘制，现在高度小的先绘制，因为高度小的，层级低，在下面， 高度相同的，按添加顺序绘制
	注意：
		如果View的背景色为透明，则不会显示出阴影效果
		只有子View的大小比父View小时，阴影才能显示出来

# 水波纹动画，自定义水波纹动画以及状态选择器动画

- 首先，在Android5.0以上，点击效果默认自带水波纹效果，并且有2种选择：

	//矩形边框水波纹
	android:background="?android:attr/selectableItemBackground"

	//无边框限制水波纹
	android:background="?android:attr/selectableItemBackgroundBorderless"

- 自定义水波纹动画

	使用ViewAnimationUtils创建圆形水波纹动画，注意该动画不能在Activity的onCreate方法中执行：

	Animator circularReveal = ViewAnimationUtils.createCircularReveal(text, 0, text.getHeight() , 1f, text.getWidth()*2);
	circularReveal.setDuration(1000);
	circularReveal.start();

	使用ripple标签或者RippleDrawable可以更改控件水波纹动画颜色：

	<ripple xmlns:android="http://schemas.android.com/apk/res/android" android:color="#00ff00">
	<item android:id="@android:id/mask" ><color android:color="#0000ff" />
 
- 定义带有属性动画的状态选择器

	通过stateListAnimator属性指定状态选择器的动画：
	android:stateListAnimator="@drawable/selector_anim"
	状态选择器文件中需要加入objectAnimator标签：

		<selector  xmlns:android = "http://schemas.android.com/apk/res/android" >
		<item  android:statepressed = "true" >
		<objectAnimator  android:propertyName = "scaleX"
		        android:duration = "@android:integer/configshortAnimTime"
		        android:valueTo = "0.2"
		        android:valueFrom = "1"
		        android:valueType = "floatType" >
			//...
	同样，状态选择器动画可以用代码方式加载

	//加载动画

	AnimatorInflater.loadStateListAnimator();

	//设置动画

	View.setStateListAnimator();

	定义带有帧动画的状态选择器，需要设置给background属性，不是stateListAnimator，如下所示:

		<animated-selector  xmlns:android = "http://schemas.android.com/apk/res/android" > 
		<item  android:id = "@+id/pressed"  android:drawable = "@drawable/drawableP" 
		    android:state_pressed = "true" /> 
		<item  android:id = "@id/default" 
		    android:drawable = "@drawable/drawableD" /> 
		<!-- 指定帧动画 - -> 
		<transition  android:fromId = "@+id/default"  android:toId = "@+id/pressed" > 
		    <animation-list> 
		        <item  android:duration = "15"  android:drawable = "@drawable/dt1 " /> 
		        <item  android:duration = "15"  android:drawable = "@drawable/dt2" /> 
		        ... 
		    </animation-list> 
		 </animated-selector>