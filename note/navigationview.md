# NavigationView 导航视图

> 导航视图(NavigationView)通常与抽屉布局(DrawerLayout)结合使用,实现了良好的侧滑交互体验。从常规开发来说，侧滑一般都是左侧实现侧滑，抽屉布局可有三个子布局。（注意：第一个子布局一定要是主界面，其次的两个子布局就是左右两侧的布局，左右两侧只放一个也可）

# 关联点
	主要讲下继承，api,属性等等
## 继承(sdk25)

![](http://i.imgur.com/YafzRmx.png)

## api
	
	void	addHeaderView(View view)
	//Adds a View as a header of the navigation menu.
	void	draw(Canvas canvas)
	//Manually render this view (and all of its children) to the given Canvas.
	int	getHeaderCount()
	//Gets the number of headers in this NavigationView.
	View	getHeaderView(int index)
	//Gets the header view at the specified position.
	Drawable	getItemBackground()
	//Returns the background drawable for our menu items.
	ColorStateList	getItemIconTintList()
	//Returns the tint which is applied to our menu items' icons.
	ColorStateList	getItemTextColor()
	//Returns the tint which is applied to our menu items' icons.
	Menu	getMenu()
	//Returns the Menu instance associated with this navigation view.
	View	inflateHeaderView(int res)
	//Inflates a View and add it as a header of the navigation menu.
	void	inflateMenu(int resId)
	//Inflate a menu resource into this navigation view.
	void	removeHeaderView(View view)
	//Removes a previously-added header view.
	void	setCheckedItem(int id)
	//Sets the currently checked item in this navigation menu.
	void	setItemBackground(Drawable itemBackground)
	//Set the background of our menu items to a given resource.
	void	setItemBackgroundResource(int resId)
	//Set the background of our menu items to the given resource.
	void	setItemIconTintList(ColorStateList tint)
	//Set the tint which is applied to our menu items' icons.
	void	setItemTextAppearance(int resId)
	//Set the text appearance of the menu items to a given resource.
	void	setItemTextColor(ColorStateList textColor)
	//Set the text color to be used on our menu items.
	void	setNavigationItemSelectedListener(NavigationView.OnNavigationItemSelectedListener listener)
	//Set a listener that will be notified when a menu item is selected.

## 属性

	1.Android:layout_gravity="left"属性表示布局自身在父布局的那个位置，对于Drawerlayout来说，是指其子布局从其那边滑出
	NavigationView通常设置 android:layout_gravity="start"
	2.app:headerLayout="@layout/header_layout"表示引用一个头布局文件，用来展示NavigationView的头布局
	3.app:menu="@menu/main"表示引用一个menu作为下面的点击项

## 基本使用
1.在应用的build.gradle中添加support:design支持库,版本就看自己的了
> compile 'com.android.support:design:25.3.1'

2.布局

	<?xml version="1.0" encoding="utf-8"?>
	<LinearLayout
	    xmlns:android="http://schemas.android.com/apk/res/android"
	    xmlns:app="http://schemas.android.com/apk/res-auto"
	    xmlns:tools="http://schemas.android.com/tools"
	    android:orientation="vertical"
	    android:layout_width="match_parent"
	    android:layout_height="match_parent">
	
	    <android.support.v7.widget.Toolbar
	        android:id="@+id/toolbar"
	        android:layout_width="match_parent"
	        android:layout_height="?attr/actionBarSize"
	        android:background="?attr/colorPrimary"/>
	    
	    <android.support.v4.widget.DrawerLayout
	        android:id="@+id/drawer_layout"
	        android:layout_width="match_parent"
	        android:layout_height="match_parent"
	        tools:openDrawer="start">
	
	        <FrameLayout
	            android:id="@+id/container"
	            android:layout_width="match_parent"
	            android:layout_height="match_parent" >
	
	            <TextView
	                android:text="NavigationView在Toolbar下方"
	                android:gravity="center"
	                android:layout_width="match_parent"
	                android:layout_height="match_parent" />
	        </FrameLayout>
	
	        <android.support.design.widget.NavigationView
	            android:id="@+id/nav_view"
	            android:layout_width="wrap_content"
	            android:layout_height="match_parent"
	            android:layout_gravity="start"
	            android:fitsSystemWindows="true"
	            app:headerLayout="@layout/nav_header_navi"
	            app:menu="@menu/activity_navi2_drawer"/>
	
	        <android.support.design.widget.NavigationView
	            android:layout_width="wrap_content"
	            android:layout_height="match_parent"
	            android:layout_gravity="end"
	            android:fitsSystemWindows="true"
	            app:headerLayout="@layout/nav_header_navi"
	            app:menu="@menu/activity_navi2_drawer"/>
	    
	    </android.support.v4.widget.DrawerLayout>
	</LinearLayout>

navigationview的头布局

	<?xml version="1.0" encoding="utf-8"?>
	<LinearLayout
	    xmlns:android="http://schemas.android.com/apk/res/android"
	    xmlns:app="http://schemas.android.com/apk/res-auto"
	    android:layout_width="match_parent"
	    android:layout_height="@dimen/nav_header_height"
	    android:background="@drawable/side_nav_bar"
	    android:gravity="bottom"
	    android:orientation="vertical"
	    android:paddingBottom="@dimen/activity_vertical_margin"
	    android:paddingLeft="@dimen/activity_horizontal_margin"
	    android:paddingRight="@dimen/activity_horizontal_margin"
	    android:paddingTop="@dimen/activity_vertical_margin"
	    android:theme="@style/ThemeOverlay.AppCompat.Dark">
	
	    <ImageView
	        android:id="@+id/imageView"
	        android:layout_width="wrap_content"
	        android:layout_height="wrap_content"
	        android:paddingTop="@dimen/nav_header_vertical_spacing"
	        app:srcCompat="@android:drawable/sym_def_app_icon"/>
	
	    <TextView
	        android:layout_width="match_parent"
	        android:layout_height="wrap_content"
	        android:paddingTop="@dimen/nav_header_vertical_spacing"
	        android:text="Android Studio"
	        android:textAppearance="@style/TextAppearance.AppCompat.Body1"/>
	
	    <TextView
	        android:id="@+id/textView"
	        android:layout_width="wrap_content"
	        android:layout_height="wrap_content"
	        android:text="android.studio@android.com"/>

	</LinearLayout>

navigationview的menu

	<?xml version="1.0" encoding="utf-8"?>
	<menu xmlns:android="http://schemas.android.com/apk/res/android">
	
	    <group android:checkableBehavior="single">
	        <item
	            android:id="@+id/nav_camera"
	            android:icon="@drawable/ic_menu_camera"
	            android:title="Import"/>
	        <item
	            android:id="@+id/nav_gallery"
	            android:icon="@drawable/ic_menu_gallery"
	            android:title="Gallery"/>
	        <item
	            android:id="@+id/nav_slideshow"
	            android:icon="@drawable/ic_menu_slideshow"
	            android:title="Slideshow"/>
	        <item
	            android:id="@+id/nav_manage"
	            android:icon="@drawable/ic_menu_manage"
	            android:title="Tools"/>
	    </group>
	
	    <item android:title="Communicate">
	        <menu>
	            <item
	                android:id="@+id/nav_share"
	                android:icon="@drawable/ic_menu_share"
	                android:title="Share"/>
	            <item
	                android:id="@+id/nav_send"
	                android:icon="@drawable/ic_menu_send"
	                android:title="Send"/>
	        </menu>
	    </item>
	
	</menu>

代码：

	public class NavigationActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
	
	    private DrawerLayout mDrawerLayout;
	
	    @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_navi2);

	        init();
	    }
	
	    private void init() {
	        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
	        setSupportActionBar(toolbar);
	
	        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
			//下面的代码主要通过actionbardrawertoggle将toolbar与drawablelayout关联起来
	        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
	                this, mDrawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
	        mDrawerLayout.addDrawerListener(toggle);
	        toggle.syncState();
	
	        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
			//设置navigationview的menu监听
	        navigationView.setNavigationItemSelectedListener(this);
	    }
	
	    @Override
	    public void onBackPressed() {
	        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
	            mDrawerLayout.closeDrawer(GravityCompat.START);
	        } else {
	            super.onBackPressed();
	        }
	    }
	
	    @Override
	    public boolean onCreateOptionsMenu(Menu menu) {
	        // Inflate the menu; this adds items to the action bar if it is present.
	        getMenuInflater().inflate(R.menu.navi, menu);
	        return true;
	    }
	
	    @Override
	    public boolean onOptionsItemSelected(MenuItem item) {
	        // Handle action bar item clicks here. The action bar will
	        // automatically handle clicks on the Home/Up button, so long
	        // as you specify a parent activity in AndroidManifest.xml.
	        int id = item.getItemId();
	
	        //noinspection SimplifiableIfStatement
	        if (id == R.id.action_settings) {
	            return true;
	        }
	
	        return super.onOptionsItemSelected(item);
	    }
	
	    @SuppressWarnings("StatementWithEmptyBody")
	    @Override
	    public boolean onNavigationItemSelected(MenuItem item) {
	        // Handle navigation view item clicks here.
	        int id = item.getItemId();
	
	        if (id == R.id.nav_camera) {
	            // Handle the camera action
	        } else if (id == R.id.nav_gallery) {
	
	        } else if (id == R.id.nav_slideshow) {
	
	        } else if (id == R.id.nav_manage) {
	
	        } else if (id == R.id.nav_share) {
	
	        } else if (id == R.id.nav_send) {
	
	        }
	
	        mDrawerLayout.closeDrawer(GravityCompat.START);
	        return true;
	    }
	}

效果：
	![](http://i.imgur.com/AoHjqQ5.gif)

体验起来效果还是很好的，建议学习新知识，如果精力有限浅尝一下就好，能够实现基本使用，有新需求时再去深入学习，毕竟做开发这行要学的东西很多，不可能面面俱到的，扎实的基础才会帮助你快速学习上手。

注意点：
 
	设置统一菜单图标颜色
	app:itemIconTint="@color/colorPrimary"
	设置非统一菜单图标颜色
	调用 NavigationView 的 setItemIconTintList(ColorStateList tint) 方法，传入 null 参数：
	navigationView.setItemIconTintList(null);
	菜单实现分割线
	这个实现就要靠group,就像示例代码中
	动态修改菜单列表
	MenuItem menuItem = navigationView.getMenu().findItem(R.id.some_menu_item);
	menuItem.setVisible(false);	// true 为显示，false 为隐藏




以上就是对NavigationView的简单的讲解，Demo已传github

Star地址：https://github.com/Kriy/AndroidMaterialDesignUI  ,谢谢支持