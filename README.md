
#下面是我的博客地址
[点击进入](https://blog.csdn.net/qq_16177199/article/list/1)

#使用步骤

*1.添加依赖包*
<pre>
    <code>
allprojects {
        repositories
                {...
                maven { url 'https://jitpack.io' }
        }
}

   dependencies {
   	        implementation 'com.github.huhaiAndroid:Banner-master:1.0.0'
   	}
     </code>
    </pre>   

*2.布局*

    <com.huhai.banner.banner.Banner
             android:id="@+id/banner"
            android:layout_width="match_parent"
            android:layout_height="300dp">
        </com.huhai.banner.banner.Banner>

 </code>
*2.初始化及配置*
 
<pre>
    <code>
    //在布局中使用

    //配置
      banner.builder(this)
                    .setUrl(url)//设置url地址
                    .isAutoPlay(false)//是否轮播
                    .setTime(2)//设置轮播时间
                    .setSelectColor(R.color.red)//设置选中颜色
                    .setNormalColor(R.color.white);//设置正常颜色

 </code>
</pre>        
                 
                 
 *3.开始*
<pre>
    <code>
banner.start();
 </code>
</pre> 
    

