package com.mk.demos;

/**
 * access modifiers
 * 注意 java8中default关键字只能用于修饰interface中的method, 而不能用于class中
 *
 * public, protected, private and default (package private)
 * ______________________________________________________________
 * |           │ Class │ Package │ Subclass │ Subclass │ World  |
 * |           │       │         │(same pkg)│(diff pkg)│        |
 * |───────────┼───────┼─────────┼──────────┼──────────┼────────|
 * |public     │   +   │    +    │    +     │     +    │   +    |
 * |───────────┼───────┼─────────┼──────────┼──────────┼────────|
 * |protected  │   +   │    +    │    +     │     +    │        |
 * |───────────┼───────┼─────────┼──────────┼──────────┼────────|
 * |no modifier│   +   │    +    │    +     │          │        |
 * |───────────┼───────┼─────────┼──────────┼──────────┼────────|
 * |private    │   +   │         │          │          │        |
 * |___________|_______|_________|__________|__________|________|
 *  + : accessible         blank : not accessible
 *
 * @author WangChen
 * Created on 2019/12/15 9:06
 * @since 1.0
 */
public class AccessModifiers {


}
