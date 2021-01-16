生成的代理类：`$Proxy0 extends Proxy implements Person`，
我们看到代理类继承了Proxy类，Java的继承机制决定了
JDK动态代理类们无法实现对 类 的动态代理。
所以也就决定了java动态代理只能对接口进	行代理

如果业务实现类中新增了接口中没有的方法，这些方法是无法被代理的（因为无法被调用）



