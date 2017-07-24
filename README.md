# AndroidMaterialDesignUI


Android 5.0推出市场已经有很久了，最大特色就是材料设计，L中增添了不少的新控件。此次创建此库为了便于学习新控件，对新控件做一个归纳。
Material Design材料设计，是的一种新的设计风格，谷歌希望寄由此来统一各种平台上的应用外观和用户体验。

#主要介绍一下控件使用:

    提示条                 Snackbar

    工具栏                 Toolbar

    应用栏布局             AppBarLayout

    循环视图               RecyclerView

    卡片视图               CardView

    标签布局               TabLayout

    导航视图               NavigationView

    协调布局               CoordinatorLayout

    悬浮按钮               FloatingActionButton

    下拉刷新布局           SwipeRefreshLayout

    嵌套滚动视图           NestedScrollView

    可折叠工具栏布局       CollapsingToolbarLayout

    文本输入布局           TextInputLayout

    文本输入编辑框         TextInputEditText


#类:

    底部弹窗               BottomSheetBehavior



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


#替代关系:

    Toolbar：替代ActionBar

    RecyclerView：替代ListView和GridView

    NestedScrollView：替代ScrollView

    Snackbar：替代Toast

    FloatingActionButton：替代ImageButton
    
    TextInputEditText：替代EditText



