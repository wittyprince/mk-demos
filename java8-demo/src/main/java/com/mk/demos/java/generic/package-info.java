package com.mk.demos.java.generic;

// 泛型
// 对于PECS(Produce Extends and Consumer Super 或者： Get and Put Principal)
// Collection<? extend T> src;
// PE: 说明的是，对于使用我src而言的其他主体，我src是生产者，我src生产东西供你主体使用
//  我src只会向外提供，不接受add
//  我src接受赋值，即初始化，但注意，接受的是T或T的子类的Collection，即使用T或T的子类来生产T

// Collection<? super T> dist;
// CS: 说明的是，对于使用我dist而言的其他主体，我dist是消费者，我dist接受(消费)你主体生产的东西
// 我dist只接受外界提供的东西，不生产，及不能get(index)
// 我dist接受赋值，即初始化，但注意，接受的是T或T的父类的Collection，即使用T或T的父类的容器来接受T

// 作为特例: 我dist也可以向外提供东西，但是提供的东西是Object类型的，这是因为，作为接收的容器可以是T或T的父类的容器，
// 所以从该容器获取的东西类型为Object的，(另一种解释是类型擦除)

