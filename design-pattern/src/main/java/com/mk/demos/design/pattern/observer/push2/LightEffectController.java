package com.mk.demos.design.pattern.observer.push2;

/**
 * @author WangChen
 * Created on 2021/9/8 9:20
 * @since
 */
public class LightEffectController implements Observer{

    private boolean isLightFlickering = false;

    public void flickerLights(){
        System.out.println("Flicker the lights");
        isLightFlickering = true;
    }

    public void update(Object o) {
        if(o instanceof Integer){
            Integer xCoordiante = (Integer)o;
            if(xCoordiante>10 && isLightFlickering==false){
                flickerLights();
            }
        }
    }

}