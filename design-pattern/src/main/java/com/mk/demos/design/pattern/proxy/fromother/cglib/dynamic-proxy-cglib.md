CGLib(Code Generation Library)是针对类来实现代理的，他的原理是对代理的目标类生成一个子类，
并覆盖其中方法实现增强，因为底层是基于创建被代理类的一个子类，
所以它避免了JDK动态代理类的缺陷。


- CGlib可以传入接口也可以传入普通的类，接口使用实现的方式,普通类使用会使用继承的方式生成代理类.
- 由于是继承方式,如果是 static方法,private方法,final方法等描述的方法是不能被代理的
- 做了方法访问优化，使用建立方法索引的方式避免了传统JDK动态代理需要通过Method方法反射调用.
- 提供callback 和filter设计，可以灵活地给不同的方法绑定不同的callback。编码更方便灵活。
- CGLIB会默认代理Object中equals,toString,hashCode,clone等方法。比JDK代理多了clone。
