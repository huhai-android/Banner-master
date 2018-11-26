
#下面是我的博客地址
[点击进入](https://blog.csdn.net/qq_16177199/article/list/1)

#使用步骤

*1.添加依赖包*
<pre>
    <code>

    
     </code>
    </pre>   



*2.初始化及配置*
 
<pre>
    <code>
    //在布局中使用
     <com.huhai.banner.banner.Banner
         android:id="@+id/banner"
         android:layout_width="match_parent"
         android:layout_height="300dp">
     </com.huhai.banner.banner.Banner>

    //配置
      banner.builder(this)
                    .setUrl(url)
                    .isAutoPlay(false)
                    .setTime(2)
                    .setSelectColor(R.color.red)
                    .setNormalColor(R.color.white);

 </code>
</pre>        
                 
                 
 *3.开始*
<pre>
    <code>
banner.start();
 </code>
</pre> 
    

