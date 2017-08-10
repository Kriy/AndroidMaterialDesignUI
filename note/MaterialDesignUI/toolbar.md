## Toolbar

> Toolbar是Android5.0新增的一个控件，在开发中为了兼容低版本一般使用support v7中的Toolbar。Toolbar可以理解为就是一个工具栏，在Android5.0以前的版本中都是由ActionBar来实现的工具栏。Toolbar本身是一个 ViewGroup(而Actionbar直接继承自object)相比Actionbar可以更加灵活的配置使用。
> 
从 android 3.0（API 级别 11）开始，所有使用默认主题的 Activity 均使用 ActionBar 作为应用栏。不过，经过不同 Android 版本的演化，应用栏功能已逐渐添加到原生 ActionBar 中。因此，原生 ActionBar 的行为会随设备使用的 Android 系统的版本而发生变化。相比之下，最新功能已添加到支持库版本的 Toolbar 中，并且这些功能可以在任何能够使用该支持库的设备上使用。因此，您应使用支持库的 Toolbar 类来实现 Activity 的应用栏。使用支持库的工具栏有助于确保您的应用在最大范围的设备上保持一致的行为。例如，Toolbar 小部件能够在运行 Android 2.1（API 级别 7）或更高版本的设备上提供 Material Design 体验，但除非设备运行的是 Android 5.0（API 级别 21）或更高版本，否则原生操作栏不会支持 Material Design。


之前使用过toolbar多次了，但是没有做详细的了解，归纳起来有时候感觉无从下手，想了还是先说下
### 常用的api:

	1）public void setBackgroundColor(int color)  // 设置背景颜色 
	2）public void setTitle(CharSequence title)  // 设置主标题    
	3）public void setTitleTextColor(@ColorInt int color)  // 设置主标题颜色    
	4）public void setSubtitle(CharSequence subtitle)   //  设置副标题    
	5）public void setSubtitleTextColor(@ColorInt int color) // 设置副标题颜色    
	6）public void setNavigationIcon(@DrawableRes int resId) // 设置导航图标    
	7）public void setNavigationOnClickListener(OnClickListener listener) // 设置导航监听事件    
	8）public void setLogo(@DrawableRes int resId) // 设置logo图标    
	9）public void setTitleTextAppearance(Context context, @StyleRes int resId) // 设置主标题样式    
	10）public void setSubtitleTextAppearance(Context context, @StyleRes int resId) // 设置副标题样式   
	11）public void inflateMenu(@MenuRes int resId) // 设置actionmenu    
	12）public void setOnMenuItemClickListener(OnMenuItemClickListener listener) // 设置菜单点击事


### 基础使用


#### 1.使用的activity要引用NoActionBar类的主题或者当你继承AppCompatActivity时，在setContentView              之前使用supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
#### 2.用 setSupportActionBar 设定，Toolbar即能取代原本的 actionbar
    mToolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(mToolbar);
    
	//xml文件简单实现
    <android.support.v7.widget.Toolbar
	    xmlns:android="http://schemas.android.com/apk/res/android"
	    xmlns:app="http://schemas.android.com/apk/res-auto"
	    android:id="@+id/toolbar"
	    android:background="@android:color/holo_blue_light"
	    app:title="Title"
	    app:subtitle="Subtitle"
	    app:logo="@mipmap/ic_login"
	    app:navigationIcon="@drawable/action_bar_back"
	    android:layout_width="match_parent"
	    android:layout_height="?attr/actionBarSize"/>
#### 3.添加toolbar_menu文件
    <?xml version="1.0" encoding="utf-8"?>
    <menu xmlns:android="http://schemas.android.com/apk/res/android"
      xmlns:app="http://schemas.android.com/apk/res-auto">
    
    	<item
	    	android:id="@+id/action_search"
	    	android:icon="@drawable/ic_action_search"
	    	android:title="@string/menu_search"
	    	app:showAsAction="always"/>
    
    	<item
	    	android:id="@+id/action_notifi"
	    	android:icon="@drawable/ic_action_notifi"
	    	android:title="@string/notifica"
	    	app:showAsAction="always"/>
    	
    	<item
	    	android:id="@+id/action_menu_item0"
	    	android:title="menu_item0"
	    	app:showAsAction="never"/>
    	
    	<item
	    	android:id="@+id/action_menu_item1"
	    	android:title="menu_item1"
	    	app:showAsAction="never"/>
    
    </menu>

app:showASAction=”“的值 
其中showAsAction属性共有五个值：ifRoom、never、always、withText、collapseActionView，可以混合使用。

ifRoom 会显示在Item中，但是如果已经有4个或者4个以上的Item时会隐藏在溢出列表中。当然个数并不仅仅局限于4个，依据屏幕的宽窄而定

never 永远不会显示。只会在溢出列表中显示，而且只显示标题，所以在定义item的时候，最好把标题都带上。
always 无论是否溢出，总会显示。

withText withText值示意Action bar要显示文本标题。Action bar会尽可能的显示这个标题，但是，如果图标有效并且受到Action bar空间的限制，文本标题有可能显示不全。

collapseActionView 声明了这个操作视窗应该被折叠到一个按钮中，当用户选择这个按钮时，这个操作视窗展开。否则，这个操作视窗在默认的情况下是可见的，并且即便在用于不适用的时候，也要占据操作栏的有效空间。 
一般要配合ifRoom一起使用才会有效果。

android:orderInCategory设置menu的优先级，数字越小优先级越高。优先级低的图标在toolbar中menu图标放不下时，自动折叠到最右侧的图标下
该系统使用动作的图标，操作按钮是否显示在应用栏的动作。你可以找到很多有用的图标材料图标的页面。

#### 4.创建好menu文件后，就需要将此加载到菜单中了
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }
此处还可以通过toolbar的inflateMenu(@MenuRes int resId)来加载menu文件
接下来设置事件

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int menuId = item.getItemId();
        switch (menuId) {
            case R.id.action_search:
                Toast.makeText(this, "点击了搜素", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_notifi:
                Toast.makeText(this, "点击了提示", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_menu_item0:
                Toast.makeText(this, "点击了item0", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_menu_item1:
                Toast.makeText(this, "点击了item1", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
此处当然也可用toolbar的方法--setOnMenuItemClickListener(OnMenuItemClickListener listener)

![](http://i.imgur.com/qqN2Yz2.png)

![](http://i.imgur.com/G25iDQk.png)

以上就是toolbar的基础使用，有些地方直接调用toolbar的方法实现可能会更简单



###修改Toolbar popup menu样式
通过上面的截图
可以看到右上角的popup menu是白底黑字，可能需求上是需要改变颜色以及弹出位置

首先在styles.xml文件中，新建一个主题：
    
    <!-- toolbar弹出菜单样式 -->
    <style name="AppTheme.PopupOverlay" parent="Widget.AppCompat.Light.PopupMenu.Overflow">
        <item name="android:colorBackground">@android:color/holo_blue_light</item>
        <item name="actionOverflowMenuStyle">@style/OverflowMenuStyle</item>
    </style>

    <style name="OverflowMenuStyle" parent="Widget.AppCompat.Light.PopupMenu.Overflow">
        <item name="overlapAnchor">false</item>  <!--把该属性改为false即可使menu位置位于toolbar之下-->
    </style>

然后给toolbar加上**app:popupTheme="@style/AppTheme.PopupOverlay"**
这样，改几行代码即可修改popup menu的背景颜色及位置了，如下面所示：

![](http://i.imgur.com/l6FDbo9.png)


至于修改style方面，还可以修改menu触发的三个点按钮和menu_item的颜色等等


### 与searchview结合使用
使用方法：
	
	1.添加app:actionViewClass="android.support.v7.widget.SearchView"
    	<item
	        android:id="@+id/action_search"
	        android:icon="@drawable/ic_action_search"
	        android:title="@string/menu_search"
	        app:showAsAction="always"
	        app:actionViewClass="android.support.v7.widget.SearchView"/>

	2.添加监听
		
	    @Override
	    public boolean onCreateOptionsMenu(Menu menu) {
	        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
	        MenuItem searchItem = menu.findItem(R.id.action_search);
	        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
	        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
	            @Override
	            public boolean onQueryTextSubmit(String query) {
	                Toast.makeText(ToolbarActivity.this, "搜索中。。。", Toast.LENGTH_SHORT).show();
	                return true;
	            }
	
	            @Override
	            public boolean onQueryTextChange(String newText) {
					//搜索内容改变回调，不继续向上传递话返回true
	                return false;
	            }
	        });
	        return true;
	    }

这样就完成了与searchview的结合使用，交互效果不错,demo界面比较粗糙

![](http://i.imgur.com/SRdDTem.gif)



### 文案居中显示


布局文件

    <?xml version="1.0" encoding="utf-8"?>
    <RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
		xmlns:app="http://schemas.android.com/apk/res-auto"
		android:orientation="vertical"
		android:layout_width="match_parent"
		android:layout_height="match_parent">
		
		<android.support.v7.widget.Toolbar
			android:id="@+id/toolbar"
			app:navigationIcon="@drawable/aciton_icon_back"
			android:layout_width="match_parent"
			android:layout_height="?attr/actionBarSize">
		
			<TextView
				android:text="测试文案"
				android:layout_centerInParent="true"
				android:layout_gravity="center"
				android:layout_width="wrap_content"
				android:layout_height="wrap_content"/>
		
		</android.support.v7.widget.Toolbar>
    
    </RelativeLayout>

activity:

    public class CenterActivity extends AppCompatActivity{

	    @Override
	    protected void onCreate(@Nullable Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
	        setContentView(R.layout.activity_center);
	
	        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
	        toolbar.setTitle("");
	        setSupportActionBar(toolbar);
	        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
	            @Override
	            public void onClick(View v) {
	                finish();
	            }
	        });
	    }
    }

这里需要注意我是使用supportRequestWindowFeature(Window.FEATURE_NO_TITLE)方法去除title的，并非设置activity的theme，获得toolbar对象后调用setTitle方法去掉title

效果：

![](http://i.imgur.com/SFpzBXh.png)


下面顺便讲解下一些相关属性
**colorPrimaryDark**
状态栏背景色。
在 style 的属性中设置。

**textColorPrimary**
App bar 上的标题与更多菜单中的文字颜色。
在 style 的属性中设置。

**App bar 的背景色**
Actionbar 的背景色设定在 style 中的 colorPrimary。
Toolbar 的背景色在layout文件中设置background属性。

**colorAccent**
各控制元件(如：check box、switch 或是 radoi) 被勾选 (checked) 或是选定 (selected) 的颜色。
在 style 的属性中设置。

**colorControlNormal**
各控制元件的预设颜色。
在 style 的属性中设置

windowBackground
App 的背景色。
在 style 的属性中设置

**navigationBarColor**
导航栏的背景色，但只能用在 API Level 21 (Android 5) 以上的版本
在 style 的属性中设置