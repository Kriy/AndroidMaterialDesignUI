# SwipeRefreshLayout概述
#### SwipeRefrshLayout是Google官方更新的一个Widget,可以实现下拉刷新的效果。该控件集成自ViewGroup在support-v4兼容包下

用户通过手势或者点击某个按钮实现内容视图的刷新，布局里加入SwipeRefreshLayout嵌套一个子视图如ListView、 RecyclerView等，触发刷新会通过OnRefreshListener的onRefresh方法回调，我们在这里执行页面数据的刷新，每次手势 的完成都会执行一次通知，根据滑动距离判断是否需要回调。setRefreshing（false）通过代码直接取消刷新，true则手动设置刷新调出刷 新视图。setEnabled（false）通过boolean控制是否禁用手势刷新

### 注意:SwipeRefreshLayout虽然可以存在多个子控件，但是只会显示第一个

常用api:

    public void setProgressViewOffset(boolean scale, int start, int end) //设置滚动View位置,一般在刚打开界面时才用 [scale:true;start/end] 
    public void setProgressViewEndTarget(boolean scale, int end)  //设置滚动View结束位置 [scale:true;end]
    public void setSize(int size)  //背景圆圈大小(样式) [LARGE/DEFAULT]
    public void setOnRefreshListener(OnRefreshListener listener)  //设置监听，需要重写onRefresh()方法，顶部下拉时会调用这个方法，在里面实现请求数据的逻辑，设置下拉进度条消失等等。

    public void setRefreshing(boolean refreshing) //设置刷新状态，true表示正在刷新，false表示取消刷新

    public void setProgressBackgroundColorSchemeColor(@ColorInt int color)
    public void setProgressBackgroundColorSchemeResource(@ColorRes int colorRes)  //设置下拉进度条的背景颜色，默认白色。

	public void setColorSchemeColors(int... colors)
    public void setColorSchemeResources(@ColorRes int... colorResIds)  //设置下拉进度条的颜色主题，参数为可变参数，并且是资源id，可以设置多种不同的颜色，每转一圈就显示一种颜色 
    
    public boolean isRefreshing()  //判断当前的状态是否是刷新状态。
    public void setDistanceToTriggerSync(int distance) //手指滑动多少距离后刷新进度同步下降
    public int getProgressCircleDiameter() // 获取刷新进度圆的直径
    public boolean canChildScrollUp() //布局可以向上滚动,Override这个方法
不知道大家注意到没，转一圈就是1S

这里只是大致介绍一下相应的api,在实际开发中结合其他控件使用时，会遇到一些冲突，这个就需要去分析处理了


Demo： 
	https://github.com/Kriy/AndroidMaterialDesignUI

效果如下：


![](http://i.imgur.com/G5cVok9.gif)

可以看到在加载的过程中也是可改变的