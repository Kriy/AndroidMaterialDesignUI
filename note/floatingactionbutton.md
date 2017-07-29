# FloatingActionButton  悬浮按钮


**FAB的出现在一些产品经理看来其不算一个太友好的交互控件，因为使用过后你会发现FAB在某些应用场景会挡住下一层界面的展示，可能是遮挡内容， 可能是无法点击。。。所以在考虑使用此控件时就要从良好的交互作为出发点，考虑是否会带来不好的交互，为了突出FAB的重要性，一个页面最好只有一个FAB。**

## FAB的继承关系
	从sdk25查看
	public class FloatingActionButton extends VisibilityAwareImageButton

![](http://i.imgur.com/qJK8l2Q.png)

## 基础使用

	<?xml version="1.0" encoding="utf-8"?>
	<RelativeLayout
	    xmlns:android="http://schemas.android.com/apk/res/android"
	    xmlns:app="http://schemas.android.com/apk/res-auto"
	    xmlns:tools="http://schemas.android.com/tools"
	    android:layout_width="match_parent"
	    android:layout_height="match_parent"
		tools:context="com.materialdesignui.floatingactionbutton.FloatingActionButtonActivity">

	    <android.support.design.widget.FloatingActionButton
	        android:layout_centerInParent="true"
	        android:clickable="true"
	        app:fabSize="normal"
	        app:rippleColor="#ffff00"
	        app:elevation="10dp"
	        app:pressedTranslationZ="25dp"
	        android:layout_width="wrap_content"
	        android:layout_height="wrap_content"/>

	</RelativeLayout>


效果如下：
5.1

![](http://i.imgur.com/j2EL5ny.gif)

4.4

![](http://i.imgur.com/YxssWU3.gif)

**FBA默认的的背景色的取值是theme中colorAccent的值，默认的水波纹是灰色的，默认取值是theme中的colorControlHighlight.**

### 属性解析

1、app:fabSize="normal"//2个取值，normal=56dp,mini=40dp

2、app:backgroundTint=""---------------FBA的背景颜色，不设置，默认使用theme中colorAccent的颜色

3、app:rippleColor=""--------------------点击FBA时，形成的水波纹的颜色，默认使用theme中的colorControlHighlight

4、app:elevation=""----------------------未点击时，阴影的高度

5、app:pressedTranslationZ="16dp"-----点击按钮时，按钮边缘阴影的宽度，按下Z轴移动距离
		
**注意：设置android:clickable="true"才有按下的效果**

6、app:borderWidth=""------------------边框宽度，通常设置为0 ，用于解决Android 5.X设备上阴影无法正常显示的问题


知识点：backgroundTint的默认值是theme中的colorAccent(colorAccent 对应EditText编辑时、RadioButton选中、CheckBox等选中时的颜色)
 

FloatActinButton最大的特点是其悬浮的效果，所以关于其立体感的属性当然也重要。这里也是要涉及两个属性: elevation和pressedTranslationZ，**再次强调要实现水波纹的效果的，要保证clickable属性为true,当然代码中如何设置了事件的监听那就一举两得了，属性值也是true了**


## 兼容处理

在网上查看相关资料时，发现有的人在5.X的系统上使用有问题，可是亲测使用上面基本使用的代码示例，5.1和4.4的系统都是有点击的效果

如果遇到，这样尝试下
添加属性app:borderWidth=”0dp” 
对于5.x设置一个合理的margin 
如下：

    <android.support.design.widget.FloatingActionButton
	    android:layout_width="wrap_content"
	    android:layout_height="wrap_content"
	    android:layout_gravity="end|bottom"
	    app:borderWidth="0dp"
	    android:layout_margin="@dimen/fab_margin"
	    android:src="@drawable/ic_headset" />

    values
    
    <dimen name="fab_margin">0dp</dimen>
 
    values-v21
    
    <dimen name="fab_margin">16dp</dimen>
>

## 开发实用

### 1、菜单动画FBA
效果如下，只是简单的实现，使用的话根据需求可以修改下就好了

![](http://i.imgur.com/YqyJhrT.gif)

布局
    
	<FrameLayout
	    xmlns:android="http://schemas.android.com/apk/res/android"
	    xmlns:app="http://schemas.android.com/apk/res-auto"
        android:id="@+id/fl_menu"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:visibility="gone">

        <android.support.design.widget.FloatingActionButton
            android:id="@+id/float_btn1"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_gravity="bottom|end"
            android:layout_marginBottom="20dp"
            android:layout_marginEnd="10dp"
            android:src="@mipmap/fav_2"
            app:elevation="5dp"
            app:fabSize="normal"/>

        <android.support.design.widget.FloatingActionButton
            android:id="@+id/float_btn2"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_gravity="bottom|end"
            android:layout_marginBottom="20dp"
            android:layout_marginEnd="10dp"
            android:src="@mipmap/idea"
            app:elevation="5dp"
            app:fabSize="normal"/>

        <android.support.design.widget.FloatingActionButton
            android:id="@+id/float_btn3"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_gravity="bottom|end"
            android:layout_marginBottom="20dp"
            android:layout_marginEnd="10dp"
            android:src="@mipmap/faxian"
            app:elevation="5dp"
            app:fabSize="normal"/>

        <android.support.design.widget.FloatingActionButton
            android:id="@+id/float_btn"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_gravity="bottom|end"
            android:layout_marginBottom="20dp"
            android:layout_marginEnd="10dp"
            android:src="@mipmap/menu"
            app:elevation="5dp"
            app:fabSize="normal"/>
    </FrameLayout>

代码：

	public class FloatingActionButtonActivity extends AppCompatActivity{

	    private static final int DISTANCE = 300;
	    private static final int DISTANCE2 = 220;
	
	    private FloatingActionButton actionButton, actionButton1, actionButton2, actionButton3;
	    private boolean mMenuOpen = false;
	    private View mFlMenu;
	
	    @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_floating_action_button);
	
	        initView();
	    }
	
	    private void initView() {
	        mFlMenu = findViewById(R.id.fl_menu);
	
	        actionButton = (FloatingActionButton) findViewById(R.id.float_btn);
	        actionButton1 = (FloatingActionButton) findViewById(R.id.float_btn1);
	        actionButton2 = (FloatingActionButton) findViewById(R.id.float_btn2);
	        actionButton3 = (FloatingActionButton) findViewById(R.id.float_btn3);
	
	        actionButton.setOnClickListener(new View.OnClickListener() {
	            @Override
	            public void onClick(View v) {
	                if (mMenuOpen) {
	                    hideMenu();
	                }else {
	                    showMenu();
	                }
	            }
	        });
	    }
	
	    private void showMenu() {
	        mMenuOpen = true;
	        int x = (int) actionButton.getX();
	        int y = (int) actionButton.getY();
	        ValueAnimator v1 = ValueAnimator.ofInt(x, x - DISTANCE);
	        v1.setDuration(500);
	        v1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
	            @Override
	            public void onAnimationUpdate(ValueAnimator animation) {
	                int l = (int) animation.getAnimatedValue();
	                int t = (int) actionButton1.getY();
	                int r = actionButton1.getWidth() + l;
	                int b = actionButton1.getHeight() + t;
	                actionButton1.layout(l, t, r, b);
	            }
	        });
	        ValueAnimator v2x = ValueAnimator.ofInt(x, x - DISTANCE2);
	        ValueAnimator v2y = ValueAnimator.ofInt(y, y - DISTANCE2);
	        v2x.setDuration(500).addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
	            @Override
	            public void onAnimationUpdate(ValueAnimator animation) {
	                int l = (int) animation.getAnimatedValue();
	                int t = (int) actionButton2.getY();
	                int r = actionButton2.getWidth() + l;
	                int b = actionButton2.getHeight() + t;
	                actionButton2.layout(l, t, r, b);
	            }
	        });
	        v2y.setDuration(500).addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
	            @Override
	            public void onAnimationUpdate(ValueAnimator animation) {
	                int t = (int) animation.getAnimatedValue();
	                int l = (int) actionButton2.getX();
	                int r = actionButton2.getWidth() + l;
	                int b = actionButton2.getHeight() + t;
	                actionButton2.layout(l, t, r, b);
	            }
	        });
	        ValueAnimator v3 = ValueAnimator.ofInt(y, y - DISTANCE);
	        v3.setDuration(500).addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
	            @Override
	            public void onAnimationUpdate(ValueAnimator animation) {
	                int t = (int) animation.getAnimatedValue();
	                int l = (int) actionButton3.getX();
	                int r = actionButton3.getWidth() + l;
	                int b = actionButton3.getHeight() + t;
	                actionButton3.layout(l, t, r, b);
	            }
	        });
	        v1.start();
	        v2x.start();
	        v2y.start();
	        v3.start();
	    }
	
	    private void hideMenu() {
	        mMenuOpen = false;
	        int x = (int) actionButton1.getX();
	        ValueAnimator v1 = ValueAnimator.ofInt(x, (int) actionButton.getX());
	        v1.setDuration(500);
	        v1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
	            @Override
	            public void onAnimationUpdate(ValueAnimator animation) {
	                int l = (int) animation.getAnimatedValue();
	                int t = (int) actionButton1.getY();
	                int r = actionButton1.getWidth() + l;
	                int b = actionButton1.getHeight() + t;
	                actionButton1.layout(l, t, r, b);
	            }
	        });
	        x = (int) actionButton2.getX();
	        int y = (int) actionButton2.getY();
	        ValueAnimator v2x = ValueAnimator.ofInt(x, (int) actionButton.getX());
	        ValueAnimator v2y = ValueAnimator.ofInt(y, (int) actionButton.getY());
	        v2x.setDuration(500).addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
	            @Override
	            public void onAnimationUpdate(ValueAnimator animation) {
	                int l = (int) animation.getAnimatedValue();
	                int t = (int) actionButton2.getY();
	                int r = actionButton2.getWidth() + l;
	                int b = actionButton2.getHeight() + t;
	                actionButton2.layout(l, t, r, b);
	            }
	        });
	        v2y.setDuration(500).addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
	            @Override
	            public void onAnimationUpdate(ValueAnimator animation) {
	                int t = (int) animation.getAnimatedValue();
	                int l = (int) actionButton2.getX();
	                int r = actionButton2.getWidth() + l;
	                int b = actionButton2.getHeight() + t;
	                actionButton2.layout(l, t, r, b);
	            }
	        });
	        y = (int) actionButton3.getY();
	        ValueAnimator v3 = ValueAnimator.ofInt(y, (int) actionButton.getY());
	        v3.setDuration(500).addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
	            @Override
	            public void onAnimationUpdate(ValueAnimator animation) {
	                int t = (int) animation.getAnimatedValue();
	                int l = (int) actionButton3.getX();
	                int r = actionButton3.getWidth() + l;
	                int b = actionButton3.getHeight() + t;
	                actionButton3.layout(l, t, r, b);
	            }
	        });
	        v1.start();
	        v2x.start();
	        v2y.start();
	        v3.start();
	    }
	
	    private void hideFABMenu() {
	        mRlAddBill.setVisibility(View.GONE);
	        fab01Add.setImageResource(R.drawable.ic_add);
	        isAdd = false;
	    }
	}

### 列表式

![](http://i.imgur.com/Mb5J1S4.gif)

布局：

	    <RelativeLayout
		    xmlns:android="http://schemas.android.com/apk/res/android"
		    xmlns:app="http://schemas.android.com/apk/res-auto"
	        android:id="@+id/rl_other_layout"
	        android:layout_width="match_parent"
	        android:layout_height="match_parent">

        <RelativeLayout
            android:id="@+id/rlAddBill"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:background="#80000000"
            android:visibility="gone">

            <LinearLayout
                android:id="@+id/ll01"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:layout_alignParentBottom="true"
                android:layout_marginBottom="100dp"
                android:orientation="horizontal">

                <TextView
                    android:layout_width="0dp"
                    android:layout_height="wrap_content"
                    android:layout_gravity="center_vertical"
                    android:layout_toLeftOf="@+id/miniFab01"
                    android:layout_weight="1"
                    android:gravity="right"
                    android:paddingBottom="5dp"
                    android:text="测试中"
                    android:textColor="@android:color/white"
                    android:textSize="15sp"/>

                <android.support.design.widget.FloatingActionButton
                    android:id="@+id/miniFab01"
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:layout_marginRight="25dp"
                    android:src="@mipmap/menu"
                    app:backgroundTint="@color/color_test"
                    app:elevation="5dp"
                    app:fabSize="mini"/>
            </LinearLayout>

            <LinearLayout
                android:id="@+id/ll02"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:layout_above="@+id/ll01"
                android:layout_marginBottom="20dp"
                android:orientation="horizontal"
                >

                <TextView
                    android:layout_width="0dp"
                    android:layout_height="wrap_content"
                    android:layout_gravity="center_vertical"
                    android:layout_toLeftOf="@+id/miniFab02"
                    android:layout_weight="1"
                    android:gravity="right"
                    android:paddingBottom="5dp"
                    android:text="测试中"
                    android:textColor="@android:color/white"
                    android:textSize="15sp"/>

                <android.support.design.widget.FloatingActionButton
                    android:id="@+id/miniFab02"
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:layout_marginRight="25dp"
                    android:src="@mipmap/menu"
                    app:backgroundTint="@color/color_test"
                    app:elevation="5dp"
                    app:fabSize="mini"/>
            </LinearLayout>

            <LinearLayout
                android:id="@+id/ll03"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:layout_above="@+id/ll02"
                android:layout_marginBottom="20dp"
                android:orientation="horizontal">

                <TextView
                    android:layout_width="0dp"
                    android:layout_height="wrap_content"
                    android:layout_gravity="center_vertical"
                    android:layout_toLeftOf="@+id/miniFab02"
                    android:layout_weight="1"
                    android:gravity="right"
                    android:paddingBottom="5dp"
                    android:text="测试中"
                    android:textColor="@android:color/white"
                    android:textSize="15sp"/>

                <android.support.design.widget.FloatingActionButton
                    android:id="@+id/miniFab03"
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:layout_marginRight="25dp"
                    android:src="@mipmap/menu"
                    app:backgroundTint="@color/color_test"
                    app:elevation="5dp"
                    app:fabSize="mini"/>
            </LinearLayout>

            <LinearLayout
                android:id="@+id/ll04"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:layout_above="@+id/ll03"
                android:layout_marginBottom="20dp"
                android:orientation="horizontal">

                <TextView
                    android:layout_width="0dp"
                    android:layout_height="wrap_content"
                    android:layout_gravity="center_vertical"
                    android:layout_toLeftOf="@+id/miniFab02"
                    android:layout_weight="1"
                    android:gravity="right"
                    android:paddingBottom="5dp"
                    android:text="测试中"
                    android:textColor="@android:color/white"
                    android:textSize="15sp"/>

                <android.support.design.widget.FloatingActionButton
                    android:id="@+id/miniFab04"
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:layout_marginRight="25dp"
                    android:src="@mipmap/menu"
                    app:backgroundTint="@color/color_test"
                    app:elevation="5dp"
                    app:fabSize="mini"/>
            </LinearLayout>
        </RelativeLayout>

        <android.support.design.widget.FloatingActionButton
            android:id="@+id/fabAdd"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_alignParentBottom="true"
            android:layout_alignParentRight="true"
            android:layout_marginBottom="20dp"
            android:layout_marginRight="15dp"
            android:src="@mipmap/idea"
            app:backgroundTint="#31bfcf"
            app:elevation="5dp"
            app:fabSize="normal"
            app:rippleColor="#e7d161"
            />
    </RelativeLayout>


代码：


	public class FloatingActionButtonActivity extends AppCompatActivity implements View.OnClickListener{

	    private FloatingActionButton mFabAdd;
	    private boolean isAdd = false;
	    private RelativeLayout mRlAddBill;
	    private int[]                  llId     = new int[]{R.id.ll01,R.id.ll02,R.id.ll03,R.id.ll04};
	    private LinearLayout[]         mLlArray = new LinearLayout[llId.length];
	    private int[]                  mFabId   = new int[]{R.id.miniFab01,R.id.miniFab02,R.id.miniFab03,R.id.miniFab04};
	    private FloatingActionButton[] mFabs    = new FloatingActionButton[mFabId.length];
	    private AnimatorSet mAddBillTranslate1;
	    private AnimatorSet mAddBillTranslate2;
	    private AnimatorSet mAddBillTranslate3;
	    private AnimatorSet mAddBillTranslate4;
	
	    @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_floating_action_button);
	
	        initView();
	    }
	
	    private void initView() {
	        mFabAdd = (FloatingActionButton)findViewById(R.id.fabAdd);
	        mRlAddBill = (RelativeLayout)findViewById(R.id.rlAddBill);
	        for (int i = 0; i < llId.length;i++){
	            mLlArray[i] = (LinearLayout)findViewById(llId[i]);
	        }
	        for (int i = 0; i < mFabId.length; i++){
	            mFabs[i] = (FloatingActionButton)findViewById(mFabId[i]);
	        }
	
	        mAddBillTranslate1 = (AnimatorSet) AnimatorInflater.loadAnimator(this,R.animator.add_anim);
	        mAddBillTranslate2 = (AnimatorSet) AnimatorInflater.loadAnimator(this,R.animator.add_anim);
	        mAddBillTranslate3 = (AnimatorSet) AnimatorInflater.loadAnimator(this,R.animator.add_anim);
	        mAddBillTranslate4 = (AnimatorSet) AnimatorInflater.loadAnimator(this,R.animator.add_anim);
	
	        mFabAdd.setOnClickListener(this);
	        for (int i = 0; i < mFabId.length; i++){
	            mFabs[i].setOnClickListener(this);
	        }
	    }
	
	    @Override
	    public void onClick(View v) {
	        switch (v.getId()) {
	            case R.id.fabAdd:
	                mFabAdd.setImageResource(isAdd ? R.drawable.ic_add :R.drawable.ic_close);
	                isAdd = !isAdd;
	                mRlAddBill.setVisibility(isAdd ? View.VISIBLE : View.GONE);
	                if (isAdd) {
	                        mAddBillTranslate1.setTarget(mLlArray[0]);
	                        mAddBillTranslate1.start();
	                        mAddBillTranslate2.setTarget(mLlArray[1]);
	                        mAddBillTranslate2.setStartDelay(150);
	                        mAddBillTranslate2.start();
	                        mAddBillTranslate3.setTarget(mLlArray[2]);
	                        mAddBillTranslate3.setStartDelay(00);
	                        mAddBillTranslate3.start();
	                        mAddBillTranslate4.setTarget(mLlArray[3]);
	                        mAddBillTranslate4.setStartDelay(250);
	                        mAddBillTranslate4.start();
	                    }
	                break;
	            case R.id.miniFab01:
	            case R.id.miniFab02:
	            case R.id.miniFab03:
	            case R.id.miniFab04:
	                hideFABMenu();
	                break;
	            default:
	                break;
	        }
	    }
	
	    private void hideFABMenu() {
	        mRlAddBill.setVisibility(View.GONE);
	        mFabAdd.setImageResource(R.drawable.ic_add);
	        isAdd = false;
	    }	
	}


动画：res目录下创建animator文件夹，创建add_anim.xml文件

	<?xml version="1.0" encoding="utf-8"?>
	<set xmlns:android="http://schemas.android.com/apk/res/android"
	    android:ordering="sequentially">
	
	    <set
	        android:ordering="together">
	        <objectAnimator
	            android:duration="100"
	            android:propertyName="translationY"
	            android:repeatCount="0"
	            android:startOffset="0"
	            android:valueFrom="100.00"
	            android:valueTo="-50.00"
	            android:valueType="floatType"/>
	        <objectAnimator
	            android:duration="100"
	            android:propertyName="alpha"
	            android:repeatCount="0"
	            android:startOffset="0"
	            android:valueFrom="0.00"
	            android:valueTo="1.00"
	            android:valueType="floatType"/>
	        <objectAnimator
	            android:duration="100"
	            android:propertyName="scaleY"
	            android:repeatCount="0"
	            android:startOffset="0"
	            android:valueFrom="0.00"
	            android:valueTo="1.50"
	            android:valueType="floatType"/>
	    </set>
	    <set
	        android:ordering="together">
	        <objectAnimator
	            android:duration="100"
	            android:propertyName="translationY"
	            android:repeatCount="0"
	            android:startOffset="0"
	            android:valueTo="0.00"
	            android:valueType="floatType"/>
	        <objectAnimator
	            android:duration="100"
	            android:propertyName="scaleY"
	            android:repeatCount="0"
	            android:startOffset="0"
	            android:valueTo="1.0"
	            android:valueType="floatType"/>
	    </set>

	</set>



以上就是对FBA的简单的讲解，总体来说FBA的交互效果还是很好的，具体还是看项目中的使用了，网上的的相关介绍许多，有兴趣可以多看看，Demo已传github

Star地址：https://github.com/Kriy/AndroidMaterialDesignUI  ,谢谢支持