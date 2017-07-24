# Snackbar

## Snackbar是Android Support Design Library库中的一个控件，可以在屏幕底部快速弹出消息，比Toast更加好用。

开发出一个好的产品，友好的交互是不可缺少的，通常给用户提示信息的方式有三种：Dialog、Toast、Snackbar

本文主要讲解Snackbar

	Snackbar 是一种针对操作的轻量级反馈机制，常以一个小的弹出框的形式，出现在手机屏幕下方或者桌面左下方。它们出现在屏幕所有层的最上方，包括浮动操作按钮。
	它们会在超时或者用户在屏幕其他地方触摸之后自动消失。Snackbar 可以在屏幕上滑动关闭。当它们出现时，不会阻碍用户在屏幕上的输入，并且也不支持输入。屏幕上同时最多只能现实一个 Snackbar。
官方推荐使用CoordinatorLayout，有俩个好处：

	1.用户可以滑动（右滑）消除掉snackbar。
	2.当snackbar出现的时候，布局会移动一些UI元素，比如右下角的悬浮按钮会自动上移。

通常使用的Toast,如果每次弹出的对象都使用其make方法的话，那么多次点击弹出会造成接连弹出（上一个消失后弹出）toast的现象，持续到所有的toast对象弹出。如果使用toast的单例模式，多次点击只会在弹出的Toast消失后有效，继而弹出下一个Toast。对于Snackbar而言，每次使用make方法多次点击弹出的话，会让正在显示的Snackbar对象马上消失，显示新的对象。

### 基本使用

	Snackbar.make(view, message_text, duration).show();
	//显示时间duration有三种类型LENGTH_SHORT、LENGTH_LONG和LENGTH_INDEFINITE。
	 时间短是2S，长是3.5S，设置为不确定时，就需要结合setDuration（int）方法一起使用，设定显示时间，
	 否则不会消失

	//设置可单击
    Snackbar.make(v, "test", Snackbar.LENGTH_SHORT)
            .setAction("这是Action", new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(SnackbarActivity.this, "点击了Action", Toast.LENGTH_SHORT).show();
                }
            }).show();


### 修改背景及文字颜色
 先看下内部加载布局
![](http://i.imgur.com/NAfOzBn.png)

        Snackbar snackbar = Snackbar.make(v, "test", Snackbar.LENGTH_SHORT);
        snackbar.getView().setBackgroundColor(Color.MAGENTA);
        ((TextView) snackbar.getView().findViewById(R.id.snackbar_text)).setTextColor(Color.CYAN);
        snackbar.show();

		//修改button的颜色可直接调用setActionTextColor方法


### 添加图片

	    Snackbar snackbar = Snackbar.make(v, "test", Snackbar.LENGTH_SHORT);
        Drawable img = getResources().getDrawable(R.mipmap.ic_launcher);
        img.setBounds(0, 0, img.getMinimumWidth() - 20, img.getMinimumHeight() - 80);
        ((TextView) snackbar.getView().findViewById(R.id.snackbar_text)).setCompoundDrawables(img, null, null, null);
        ((TextView) snackbar.getView().findViewById(R.id.snackbar_text)).setGravity(Gravity.CENTER_VERTICAL);
        snackbar.show();
		//添加图片的方式还有其他的方式，谷歌官方也不建议往其中加入图片，如果按照以上方式添加图片展示，要想正常展示图片又不撑开布局的高度，需要注意图片的原始大小

总体效果图：

		
![](http://i.imgur.com/TKhzOsQ.gif)

现在你有三种方式可以给用户提示信息，Dialog、Toast和Snackbar，下面我们对这三种方式的使用时机做个总结

	Dialog：当提示信息是至关重要的，并且必须要由用户做出决定才能继续的时候，使用Dialog。
	Toast：当提示信息只是告知用户某个事情发生了，用户不需要对这个事情做出响应的时候，使用Toast。
	Snackbar：以上两者之外的任何其他场景，Snackbar可能会是你最好的选择。