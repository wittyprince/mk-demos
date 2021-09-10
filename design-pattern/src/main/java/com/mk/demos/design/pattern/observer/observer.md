注意：push或者pull，首先要需要明确的是站在哪个主体角度看待。    
这里我们选择站在`被观察者Observable object的角度`，
不管是push还是pull，通知所有订阅者(观察者)均是被观察对象Observable的责任。    
不同之处仅在于：    
push：观察者获得了它想要的全部数据。观察者不需要再查询数据。
> Observer get the required data directly. The observer doesn't need to query the subject for information.

pull：观察者需要的数据包裹在某个对象(主要是Observable对象)中，它必须从中提取所需的数据。
> Observer get the data wrapped in an object and it needs to extract that.