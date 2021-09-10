package com.mk.demos.design.pattern.observer.pull;

import com.mk.demos.design.pattern.observer.push2.LightEffectController;
import com.mk.demos.design.pattern.observer.push2.Player;
import com.mk.demos.design.pattern.observer.push2.SoundEffectController;

/**
 * @author WangChen
 * Created on 2021/9/8 9:21
 * @since
 */
public class Main {
    public static void main(String[] args){
        Player myDog = new Player("ScoobyDoo");

        myDog.addObserver(new SoundEffectController());
        myDog.addObserver(new LightEffectController());

        myDog.moveForward(2);
        System.out.println("Nothing yet.");
        myDog.moveForward(3);
        System.out.println("Nothing yet.");

        myDog.moveForward(7);

        myDog.jump(3);

    }
}