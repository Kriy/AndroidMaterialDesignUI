# TabLayout 标签布局
> 谷歌在Material Design中推出TabLayout以替代开源库PagerSlidingTabStrip和ViewPagerIndicator的使用。事实上，这类indicator指示器的布局可谓是Android中最常见的布局设计了，TabLayout的出现给我们带来一定便利，它的使用对开发者更加友好，并且和Toolbar一样，配合material design的其他控件使用能轻易创造出酷炫的效果。

# 关联点
	主要讲下继承，默认样式，api等等
## 继承
![](http://i.imgur.com/woBotJQ.png)

**从继承关系我们可以看到TabLayout直接继承HorizontalScrollView，所以TabLayout只支持横向的滚动**

## 默认样式
app:theme="@style/Widget.Design.TabLayout"

	从系统定义的该样式继续深入:
	 <style name="Widget.Design.TabLayout" parent="Base.Widget.Design.TabLayout">
	  <item name="tabGravity">fill</item>
	  <item name="tabMode">fixed</item>
	 </style>
	 <style name="Base.Widget.Design.TabLayout" parent="android:Widget">
	  <item name="tabMaxWidth">264dp</item>
	  <item name="tabIndicatorColor">?attr/colorAccent</item>
	  <item name="tabIndicatorHeight">2dp</item>
	  <item name="tabPaddingStart">12dp</item>
	  <item name="tabPaddingEnd">12dp</item>
	  <item name="tabBackground">?attr/selectableItemBackground</item>
	  <item name="tabTextAppearance">@style/TextAppearance.Design.Tab</item>
	  <item name="tabSelectedTextColor">?android:textColorPrimary</item>
	 </style>
	接着,看看系统定义Tab文本的样式(注意textAllcaps这个属性):   
	 <style name="TextAppearance.Design.Tab" parent="TextAppearance.AppCompat.Button">
	  <item name="android:textSize">14dp</item>
	  <item name="android:textColor">?android:textColorSecondary</item>
	  <item name="textAllCaps">true</item>
	 </style>
>
从系统定义TabLayout的默认样式可以看出,我们可以改变TabLayout对应的系统样式的属性值来适配我们自己的需求.


## 属性及api

    app:tabMinWidth				Tab的最小宽度
    app:tabMaxWidth				Tab的最大宽度
    app:tabMode		 			Tab模式，默认是fixed：固定的，标签很多时候会被挤压，不能滑动
	app:tabGravity      		"center"//居中，如果是"fill"，则是填充满
	app:tabContentStart		 	TabLayout左边位置的偏移量
    app:tabPadding				Tab内部的子控件的Padding
    app:tabPaddingStart			左
    app:tabPaddingEnd	   		右
    app:tabPaddingTop	  		上
    app:tabPaddingBottom	  	下
    app:paddingStart	  		整个TabLayout的左Padding
    app:paddingEnd				整个TabLayout的右Padding
    app:tabTextColor   			Tab未被选中字体的颜色
    app:tabTextAppearance	 	Tab中文字的样式
    app:tabSelectedTextColor   	Tab被选中字体的颜色
    app:tabIndicatorColor    	Tab指示器下标的颜色
    app:tabIndicatorHeight	  	Tab指示器下标的高度

	addTab(TabLayout.Tab tab, int position, boolean setSelected) 增加选项卡到 layout 中 
	addTab(TabLayout.Tab tab, boolean setSelected) 				 同上 
	addTab(TabLayout.Tab tab) 									 同上 
	getTabAt(int index) 										 获到选项卡 
	getTabCount() 												 获到选项卡的总个数 
	getTabGravity() 											 获到tab的 Gravity 
	getTabMode() 												 获到tab的模式 
	getTabTextColors() 											 获到tab中文本的颜色 
	newTab() 													 新建个tab 
	removeAllTabs() 											 移除所有的tab 
	removeTab(TabLayout.Tab tab) 								 移除指定的tab 
	removeTabAt(int position) 									 移除指定位置的tab 
	setCustomView(View )
	setOnTabSelectedListener(TabLayout.OnTabSelectedListener onTabSelectedListener) 	为每个 tab 增加选择监听器 
	setScrollPosition(int position, float positionOffset, boolean updateSelectedText) 	设置滚动位置 
	setTabGravity(int gravity) 									 设置 Gravity 
	setTabMode(int mode) 设置 Mode,有两种值：TabLayout.MODE_SCROLLABLE和TabLayout.MODE_FIXED分别表示当tab的内容超过屏幕宽度是否支持横向水平滑动，第一种支持滑动，第二种不支持，默认不支持水平滑动。 
	setTabTextColors(ColorStateList textColor) 					 设置tab中文本的颜色 
	setTabTextColors(int normalColor, int selectedColor) 		 设置tab中文本的颜色 默认 选中 
	setTabsFromPagerAdapter(PagerAdapter adapter) 				 设置 PagerAdapter 
	setupWithViewPager(ViewPager viewPager) 					 和ViewPager联动

**如需设置默认选中项：tablayout.getTabAt(position).select();**

## 基本使用

1.在应用的build.gradle中添加support:design支持库,版本就看自己的了
> compile 'com.android.support:design:25.3.1'

2.布局

	<?xml version="1.0" encoding="utf-8"?>
	<RelativeLayout
	    xmlns:android="http://schemas.android.com/apk/res/android"
	    xmlns:tools="http://schemas.android.com/tools"
	    android:layout_width="match_parent"
	    android:layout_height="match_parent"
	    tools:context="com.materialdesignui.tablayout.TabLayoutActivity">

	    <android.support.design.widget.TabLayout
	        android:id="@+id/tb"
	        android:layout_width="match_parent"
	        android:layout_height="wrap_content">
	
	        <android.support.design.widget.TabItem
	            android:layout_width="wrap_content"
	            android:layout_height="wrap_content"
	            android:text="Tab1"/>
	
	        <android.support.design.widget.TabItem
	            android:layout_width="wrap_content"
	            android:layout_height="wrap_content"
	            android:text="Tab2"/>
	
	        <android.support.design.widget.TabItem
	            android:layout_width="wrap_content"
	            android:layout_height="wrap_content"
	            android:text="Tab3"/>
	
	        <android.support.design.widget.TabItem
	            android:layout_width="wrap_content"
	            android:layout_height="wrap_content"
	            android:text="Tab4"/>
	    </android.support.design.widget.TabLayout>

	</RelativeLayout>

也可以通过代码添加tab，这样布局也减少许多

	tabLayout= (TabLayout) findViewById(R.id.tb);
	tabLayout.addTab(tabLayout.newTab().setText("Tab1"));
	tabLayout.addTab(tabLayout.newTab().setText("Tab2"));
	tabLayout.addTab(tabLayout.newTab().setText("Tab3"));
	tabLayout.addTab(tabLayout.newTab().setText("Tab4"));

效果如下：

![](http://i.imgur.com/66kYa59.gif)

下面修改了常用的属性

    <android.support.design.widget.TabLayout
        android:id="@+id/tb"
		//tab未选中的颜色
        app:tabTextColor="@color/colorPrimary"
		//tab选中的颜色
        app:tabSelectedTextColor="@android:color/holo_orange_light"
		//tab指示器的颜色
        app:tabIndicatorColor="@android:color/holo_blue_light"
		//tab指示器的高度
        app:tabIndicatorHeight="6dp"
        android:layout_width="match_parent"
        android:layout_height="wrap_content">

效果如下：

![](http://i.imgur.com/NGzrDFb.gif)

### 设置tabMode属性值        

    <android.support.design.widget.TabLayout
        android:id="@+id/tb"
		//tab的模式
		app:tabMode="scrollable"
		//tab的最小宽度
        app:tabMinWidth="100dp"
        app:tabTextColor="@color/colorPrimary"
        app:tabSelectedTextColor="@android:color/holo_orange_light"
        app:tabIndicatorColor="@android:color/holo_blue_light"
        app:tabIndicatorHeight="6dp"
        android:layout_width="match_parent"
        android:layout_height="wrap_content">

效果如下：

![](http://i.imgur.com/wLdFYfi.gif)

### 设置app:tabGravity属性值

	    <android.support.design.widget.TabLayout
	        android:id="@+id/tb"
			//设置tab居中
			app:tabGravity="center"
	        app:tabTextColor="@color/colorPrimary"
	        app:tabSelectedTextColor="@android:color/holo_orange_light"
	        app:tabIndicatorColor="@android:color/holo_blue_light"
	        app:tabIndicatorHeight="6dp"
	        android:layout_width="match_parent"
	        android:layout_height="wrap_content">

效果如下：

![](http://i.imgur.com/LGvWAkX.gif)

上述效果使用的场景还是挺多的，tablayout也可以放在toolbar中

### 上面演示中字母都展示的是大写，因为默认的textAllCaps属性值为true
设置为false的话可以简单的通过app:tabTextAppearance属性来修改

	    <android.support.design.widget.TabLayout
	        android:id="@+id/tb"
			app:tabGravity="center"
	        app:tabTextColor="@color/colorPrimary"
			//设置字体
			app:tabTextAppearance="@android:style/TextAppearance.Holo.Large"
	        app:tabSelectedTextColor="@android:color/holo_orange_light"
	        app:tabIndicatorColor="@android:color/holo_blue_light"
	        app:tabIndicatorHeight="6dp"
	        android:layout_width="match_parent"
	        android:layout_height="wrap_content">

效果如下：

![](http://i.imgur.com/SGIgu1c.png)

### 添加图片

设置tabitem

        <android.support.design.widget.TabItem
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:icon="@mipmap/ic_launcher"
            android:text="Tab1"/>

或者tabLayout.addTab(tabLayout.newTab().setText("Tab 1").setIcon(R.mipmap.ic_launcher));

效果如下：

![](http://i.imgur.com/bCifoth.png)

> 如果只要图片，可以不设置text，在某些情况下使用可能会需要自定义tab的view


## tablayout+viewpage

这两个是很友好的搭档，在开发中是经常会使用到的

先来个横向展示图片的效果：


![](http://i.imgur.com/xodKSJt.gif)

**这里特别强调注意的一个地方，在textAllCaps为true的话，会阻止ImageSpan渲染出来，一定要将textAllCaps设置为false**

布局代码：

	<?xml version="1.0" encoding="utf-8"?>
	<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
              xmlns:app="http://schemas.android.com/apk/res-auto"
              android:orientation="vertical"
              android:layout_width="match_parent"
              android:layout_height="match_parent">

    <android.support.design.widget.TabLayout
        android:id="@+id/tb"
        app:tabTextAppearance="@android:style/TextAppearance.Holo.Large"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"/>

    <android.support.v4.view.ViewPager
        android:id="@+id/vp"
        android:layout_width="match_parent"
        android:layout_height="match_parent"/>

	</LinearLayout>

TabPagerAdapter:

	public class TabPagerAdapter extends PagerAdapter {

	    private Context mContext;
	    private static final String[] mTitles = {"tab1", "tab2", "tab3"};
	    private int[] mImageIds = {R.drawable.tab_01, R.drawable.tab_02, R.drawable.tab_03};
	    private final List<TextView> mList;
	
	    public TabPagerAdapter(Context context) {
	        this.mContext = context;
	        mList = new ArrayList<>();
	
	        TextView tv;
	        for (int i = 0; i < 3; i++) {
	            tv = new TextView(mContext);
	            mList.add(tv);
	        }
	    }
	
	
	    @Override
	    public int getCount() {
	        return mList.size();
	    }
	
	    @Override
	    public boolean isViewFromObject(View view, Object object) {
	        return view == object;
	    }
	
	    @Override
	    public Object instantiateItem(ViewGroup container, int position) {
	        container.addView(mList.get(position));
	        mList.get(position).setText(mTitles[position]);
	        return mList.get(position);
	    }
	
	    @Override
	    public void destroyItem(ViewGroup container, int position, Object object) {
	        container.removeView(mList.get(position));
	    }
	
	    @Override
	    public CharSequence getPageTitle(int position) {
	        Drawable drawable = ContextCompat.getDrawable(mContext, mImageIds[position]);
	        drawable.setBounds(0, 0, drawable.getIntrinsicWidth() / 5, drawable.getIntrinsicHeight() / 5);
	
	        ImageSpan imageSpan = new ImageSpan(drawable, ImageSpan.ALIGN_BOTTOM);
	        SpannableString spannableString = new SpannableString("   " + mTitles[position]);
	        spannableString.setSpan(imageSpan, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
	        return spannableString;
	    }
	}
**在getPageTitle方法中，setBounds是设置drawable的展示区域，注意大小，大小有问题的话也会展示不出来**

Activity:
	
	public class TabIconActivity extends AppCompatActivity {

	    private TabLayout mTabLayout;
	    private ViewPager mVp;
	
	    @Override
	    protected void onCreate(@Nullable Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_tab_icon);
	
	        mTabLayout = (TabLayout) findViewById(R.id.tb);
	        mVp = (ViewPager) findViewById(R.id.vp);
	
	        TabPagerAdapter tabPageAdapter = new TabPagerAdapter(this);
	        mVp.setAdapter(tabPageAdapter);
	        mTabLayout.setupWithViewPager(mVp);
	    }
	}


自定义视图 效果如下：

![](http://i.imgur.com/OnuT6mU.gif)

这个是通过tab的setCustomView方法设置的布局，实现了，文字+图片纵向显示

自定义布局：item_tab.xml

	<?xml version="1.0" encoding="utf-8"?>
	<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
		android:layout_width="match_parent"
		android:layout_height="match_parent"
		android:gravity="center"
		android:orientation="vertical">
	
	    <TextView
	        android:id="@+id/txt_title"
	        android:layout_width="wrap_content"
	        android:layout_height="wrap_content"
	        android:gravity="center"
	        android:textSize="14sp" />
	
	    <ImageView
	        android:id="@+id/img_title"
	        android:src="@drawable/tab_01"
	        android:layout_width="wrap_content"
	        android:layout_height="wrap_content" />
	
	</LinearLayout>
 
布局：

    <?xml version="1.0" encoding="utf-8"?>
    <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
		xmlns:app="http://schemas.android.com/apk/res-auto"
		android:orientation="vertical"
		android:layout_width="match_parent"
		android:layout_height="match_parent">
    
    
	    <android.support.design.widget.TabLayout
		    android:id="@+id/tb"
		    app:tabTextAppearance="@android:style/TextAppearance.Holo.Large"
		    android:layout_width="match_parent"
		    android:layout_height="wrap_content"/>
    
	    <android.support.v4.view.ViewPager
		    android:id="@+id/vp"
		    android:layout_width="match_parent"
		    android:layout_height="match_parent"/>
    
    </LinearLayout>

Activity:

	public class TabIconVerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_icon_ver);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tb);
        ViewPager viewPager = (ViewPager) findViewById(R.id.vp);

        TabVerPagerAdapter tabVerPagerAdapter = new TabVerPagerAdapter(this);
        viewPager.setAdapter(tabVerPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            if (tab != null) {
                tab.setCustomView(tabVerPagerAdapter.getTabView(i));
            }
        }
        viewPager.setCurrentItem(1);
    }
}
Adapter：
	
	public class TabVerPagerAdapter extends PagerAdapter {


	    private Context mContext;
	    private static final String[] mTitles = {"tabbat1", "tabbat2", "tabbat3"};
	    private int[] mImageIds = {R.drawable.tab_01, R.drawable.tab_02, R.drawable.tab_03};
	    private final List<TextView> mList;
	
	    public TabVerPagerAdapter(Context context) {
	        this.mContext = context;
	        mList = new ArrayList<>();
	
	        TextView tv;
	        for (int i = 0; i < 3; i++) {
	            tv = new TextView(mContext);
	            mList.add(tv);
	        }
	    }
	
	    @Override
	    public int getCount() {
	        return mList.size();
	    }
	
	    @Override
	    public boolean isViewFromObject(View view, Object object) {
	        return view == object;
	    }
	
	    @Override
	    public Object instantiateItem(ViewGroup container, int position) {
	        container.addView(mList.get(position));
	        mList.get(position).setText(mTitles[position]);
	        return mList.get(position);
	    }
	
	    @Override
	    public void destroyItem(ViewGroup container, int position, Object object) {
	        container.removeView(mList.get(position));
	    }
	
	    @Override
	    public CharSequence getPageTitle(int position) {
	        return mTitles[position];
	    }
	
	
	    public View getTabView(int position){
	        View view = LayoutInflater.from(mContext).inflate(R.layout.item_tab, null);
	        TextView tv= (TextView) view.findViewById(R.id.txt_title);
	        tv.setText(mTitles[position]);
	        ImageView img = (ImageView) view.findViewById(R.id.img_title);
	        img.setImageResource(mImageIds[position]);
	        return view;
	    }
	}

主要是通过getTabView方法实现的数据加载，setCustomView实现自定义

改变指示器长度
 这个主要通过**反射**实现的

先看效果吧

![](http://i.imgur.com/2ZHa3GQ.gif)

通过gif，可以看到指示器的长度改变了


代码贴出activity中的，其他没什么变化

	public class TabIndicatorActivity extends AppCompatActivity{
	
	    private TabLayout mTabLayout;
	    private ViewPager mVp;
	
	    @Override
	    protected void onCreate(@Nullable Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_tab_icon);
	
	
	        mTabLayout = (TabLayout) findViewById(R.id.tb);
	        mVp = (ViewPager) findViewById(R.id.vp);
	
	        TabIndicatorAdapter tabPageAdapter = new TabIndicatorAdapter(this);
	        mVp.setAdapter(tabPageAdapter);
	        mTabLayout.setupWithViewPager(mVp);
	
	        mTabLayout.post(new Runnable() {
	            @Override
	            public void run() {
	                setIndicator(mTabLayout, 25, 25);
	            }
	        });
	    }
	
	    public void setIndicator(TabLayout tabs, int leftDip, int rightDip) {
	        Class<?> tabLayout = tabs.getClass();
	        Field tabStrip = null;
	        try {
	            tabStrip = tabLayout.getDeclaredField("mTabStrip");
	        } catch (NoSuchFieldException e) {
	            e.printStackTrace();
	        }
	        tabStrip.setAccessible(true);
	        LinearLayout llTab = null;
	        try {
	            llTab = (LinearLayout) tabStrip.get(tabs);
	        } catch (IllegalAccessException e) {
	            e.printStackTrace();
	        }
	        int left = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, leftDip, Resources.getSystem().getDisplayMetrics());
	        int right = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, rightDip, Resources.getSystem().getDisplayMetrics());
	        for (int i = 0; i < llTab.getChildCount(); i++) {
	            View child = llTab.getChildAt(i);
	            child.setPadding(0, 0, 0, 0);
	            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 1);
	            params.leftMargin = left;
	            params.rightMargin = right;
	            child.setLayoutParams(params);
	            child.invalidate();
	        }
	    }
	}

在代码中view.post方法都是在view渲染完后执行的，所以有时获取的控件长宽值，或者其他需在渲染完后执行的都可使用post方法，避免出错


以上就是对TabLayout的简单的讲解，Demo已传github

Star地址：https://github.com/Kriy/AndroidMaterialDesignUI  ,谢谢支持