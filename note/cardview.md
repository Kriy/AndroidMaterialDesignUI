# CardView 卡片视图

> Android L开始，Google向我们介绍了一个全新的控件–CardView，从本质上看，可以将CardView看做是FrameLayout在自身之上添加了圆角和阴影效果。CardView作为一种容器，并且经常在ListView和RecyclerView的Item布局中，可使item都有圆角及阴影的效果，满足MD设计规范。在开发中如果需要实现阴影，圆角，3D什么的效果，可以试试cardview，当然通过layerlist结合selector也可以实现很好的交互

# 关联点

	主要讲下继承，默认样式，分布图

## 继承

![](http://i.imgur.com/uCkW4x7.png)

## 属性
	app:cardBackgroundColor-- 背景色
	app:cardCornerRadius-- 边缘弧度数
	app:cardElevation-- 高度
	app:cardMaxElevation-- 最大高度
	app:cardUseCompatPadding-- 设置内边距，v21+的版本和之前的版本仍旧具有一样的计算方式
	app:cardPreventCornerOverlap-- 在v20和之前的版本中添加内边距，这个属性是为了防止卡片内容和边角的重叠
	app:contentPadding-- 卡片边界距离内部的距离
	app:contentPaddingLeft-- 卡片边界距离左边的距离
	app:contentPaddingTop-- 卡片边界距离顶边的距离
	app:contentPaddingRight-- 卡片边界距离右边的距离
	app:contentPaddingBottom-- 卡片边界距离底边的距离

## 分布图

![](http://i.imgur.com/OE94has.png)

# 基本使用

1.在应用的build.gradle中添加支持库,版本就看自己的了	
>     compile 'com.android.support:support-v4:25.3.1'

2.布局

	<?xml version="1.0" encoding="utf-8"?>
	<LinearLayout
	    xmlns:android="http://schemas.android.com/apk/res/android"
	    xmlns:app="http://schemas.android.com/apk/res-auto"
	    xmlns:tools="http://schemas.android.com/tools"
	    android:layout_width="match_parent"
	    android:layout_height="match_parent"
	    android:gravity="center_horizontal"
	    android:orientation="vertical"
	    tools:context="com.materialdesignui.cardview.CardViewActivity">

	    <android.support.v7.widget.CardView
	        android:layout_marginTop="20dp"
	        android:layout_width="wrap_content"
	        android:layout_height="wrap_content">
	
	        <TextView
	            android:text="普通狀態cardview"
	            android:gravity="center"
	            android:padding="5dp"
	            android:layout_width="wrap_content"
	            android:layout_height="25dp"/>
	
	    </android.support.v7.widget.CardView>
	
	    <android.support.v7.widget.CardView
	        android:layout_marginTop="20dp"
	        app:cardCornerRadius="7dp"
	        android:layout_width="wrap_content"
	        android:layout_height="wrap_content">
	
	        <TextView
	            android:text="圆角狀態cardview"
	            android:gravity="center"
	            android:padding="5dp"
	            android:layout_width="wrap_content"
	            android:layout_height="25dp"/>
	
	    </android.support.v7.widget.CardView>
	
	    <android.support.v7.widget.CardView
	        android:layout_marginTop="20dp"
	        app:cardElevation="6dp"
	        android:layout_width="wrap_content"
	        android:layout_height="wrap_content">
	
	        <TextView
	            android:text="阴影狀態cardview"
	            android:gravity="center"
	            android:padding="5dp"
	            android:layout_width="wrap_content"
	            android:layout_height="25dp"/>
	
	    </android.support.v7.widget.CardView>
	
	    <android.support.v7.widget.CardView
	        android:layout_marginTop="20dp"
	        app:contentPadding="15dp"
	        app:cardBackgroundColor="@android:color/holo_orange_light"
	        android:layout_width="wrap_content"
	        android:layout_height="wrap_content">
	
	        <TextView
	            android:text="内边距狀態cardview"
	            android:background="@android:color/white"
	            android:gravity="center"
	            android:padding="5dp"
	            android:layout_width="wrap_content"
	            android:layout_height="25dp"/>
	
	    </android.support.v7.widget.CardView>
	
	    <android.support.v7.widget.CardView
	        android:layout_marginTop="20dp"
	        android:layout_width="wrap_content"
	        android:layout_height="wrap_content">
	
	        <ImageView
	            android:src="@drawable/tab_01"
	            android:layout_width="100dp"
	            android:layout_height="100dp"/>
	
	    </android.support.v7.widget.CardView>
	
	    <android.support.v7.widget.CardView
	        android:layout_marginTop="20dp"
	        android:clickable="true"
	        app:cardElevation="10dp"
	        app:cardCornerRadius="10dp"
	        android:foreground="?attr/selectableItemBackground"
	        android:layout_width="wrap_content"
	        android:layout_height="wrap_content">
	
	        <ImageView
	            android:src="@drawable/tab_01"
	            android:layout_width="100dp"
	            android:layout_height="100dp"/>
	
	    </android.support.v7.widget.CardView>
	</LinearLayout>

3.效果如下：

![](http://i.imgur.com/GAeNhGt.gif)

这里需要说下，**点击cardview所产生的水波纹效果，CardView 加上android:foreground="?attr/selectableItemBackground" 这个属性会在 Lollipop 上自动加上 Ripple 效果，在旧版本则是一个变深/变亮的效果**

# 结合recyclerview

先看效果吧

![](http://i.imgur.com/GYgVdHS.gif)

界面展示的效果还是蛮不错的，单击也设置了水波纹的效果

布局：
	
	<?xml version="1.0" encoding="utf-8"?>
	<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
              xmlns:app="http://schemas.android.com/apk/res-auto"
              android:layout_width="match_parent"
              android:layout_height="wrap_content"
              android:orientation="vertical">

	    <android.support.v7.widget.CardView
	        android:layout_width="match_parent"
	        android:layout_height="wrap_content"
	        android:layout_margin="15dp"
	        android:clickable="true"
	        android:foreground="?attr/selectableItemBackground"
	        app:cardCornerRadius="10dp"
	        app:cardElevation="15dp">
	
	        <RelativeLayout
	            android:layout_width="match_parent"
	            android:layout_height="match_parent">
	
	            <ImageView
	                android:id="@+id/iv"
	                android:src="@drawable/tab_03"
	                android:layout_width="108dp"
	                android:layout_height="108dp"
	                android:padding="12dp"
	                android:scaleType="centerCrop"/>
	
	            <TextView
	                android:id="@+id/tv_card"
	                android:layout_width="match_parent"
	                android:layout_height="wrap_content"
	                android:layout_centerVertical="true"
	                android:layout_marginLeft="36dp"
	                android:layout_toRightOf="@id/iv"
	                android:gravity="center"
	                android:padding="3dp"
	                android:text=""/>
	        </RelativeLayout>
	    </android.support.v7.widget.CardView>
	</LinearLayout>

activity:

	public class CardRecyclerActivity extends AppCompatActivity {

	    @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_card_recycler);
	
	        RecyclerView mRv = (RecyclerView) findViewById(R.id.rv_card);
	        mRv.setLayoutManager(new LinearLayoutManager(this));
	        mRv.setAdapter(new CardRecAdapter());
	
	    }

	}

adapter:

	public class CardRecAdapter extends RecyclerView.Adapter<CardRecAdapter.ViewHolder> {

	    private List<String> mList;
	
	    public CardRecAdapter() {
	        this.mList = new ArrayList<>();
	        for (int i = 1; i <= 60; i++) {
	            mList.add("测试中的数据。。。" + i);
	        }
	    }
	
	    @Override
	    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
	        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card, parent, false);
	        return new ViewHolder(view);
	    }
	
	    @Override
	    public void onBindViewHolder(ViewHolder holder, int position) {
	        holder.render(mList.get(position));
	    }
	
	    @Override
	    public int getItemCount() {
	        return mList.size();
	    }
	
	    public class ViewHolder extends RecyclerView.ViewHolder{
	
	        private TextView mTv;
	
	        public ViewHolder(View itemView) {
	            super(itemView);
	            mTv = (TextView) itemView.findViewById(R.id.tv_card);
	        }
	
	        public void render(String text){
	            mTv.setText(text);
	        }
	    }
	}

# 注意点

 - CardView从本质上属于FrameLayout，而CardView通常包含了较多的内容元素，为了方便地排版布局中的各个元素，一般借助于其他基本布局容器，比如这里我们使用了一个 RelativeLayout 作为CardView的唯一Child。

 - 在Android Lollipop之前的系统，CardView会自动添加一些额外的padding空间来绘制阴影部分，这也导致了以Lollipop为分界线的不同系统上CardView的尺寸大小不同。为了解决这个问题，有两种方法：第一种，使用不同API版本的dimension资源适配（也就是借助values和values-21文件夹中不同的dimens.xml文件）；

		1.创建 /res/value 和 /res/value-v21 资源文件夹于项目对应 Module 目录下，前者放置旧版本/通用的资源文件（了解的可以跳过），后者放置 21 及更高 SDK 版本的资源文件。

		2.在 value 内的 dimen.xml 创建一个 Dimension （<dimen> 属性），随便命个名（如 xxx_card_margin）并填入数值 0dp。
 
		3.接着在 value-v21 文件夹内的 dimen.xml 创建名字相同的 Dimension，并填入你期望的预留边距（一般和 CardElevation 阴影大小相同）

		4.最后，在你布局中的 CardView 中设置 android:layout_margin="@dimen/card_margin"
  
	 第二种，就是使用 setUseCompatPadding 属性，设置为true（默认值为false），让CardView在不同系统中使用相同的padding值。

 -实现水波纹的动画选择器，创建一个 TranslationZ 的变换动画放在 /res/anim，自己取一个名（如 touch_raise.xml），加入以下内容：

	<?xml version="1.0" encoding="utf-8"?>
	<selector xmlns:android="http://schemas.android.com/apk/res/android">
	     <item android:state_enabled="true" android:state_pressed="true">
	          <objectAnimator
	               android:duration="@android:integer/config_shortAnimTime"
	               android:propertyName="translationZ"
	               android:valueTo="@dimen/touch_raise"
	               android:valueType="floatType" />
	     </item>
	     <item>
	           <objectAnimator
	           android:duration="@android:integer/config_shortAnimTime"
	           android:propertyName="translationZ"
	           android:valueTo="0dp"
	           android:valueType="floatType" />
	     </item>
	</selector>

	android:stateListAnimator="@anim/touch_raise"。


以上就是对CardView的简单的讲解，Demo已传github

Star地址：https://github.com/Kriy/AndroidMaterialDesignUI  ,谢谢支持
