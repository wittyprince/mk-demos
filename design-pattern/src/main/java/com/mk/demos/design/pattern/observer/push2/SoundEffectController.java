package com.mk.demos.design.pattern.observer.push2;

/**
 * @author WangChen
 * Created on 2021/9/8 9:19
 * @since
 */
public class SoundEffectController implements Observer{

    private boolean isSoundPlaying = false;

    public void playSound(){
        System.out.println("Play an eerie sound");
        isSoundPlaying = true;
    }

    public void update(Object o) {
        if(o instanceof Integer){
            Integer yCoordiante = (Integer)o;
            if(yCoordiante>0 && isSoundPlaying== false){
                playSound();
            }
        }
    }

}
