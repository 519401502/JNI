package com.example.aml.clearn.view;

/**
 * Created by xv on 2018/2/23.
 */

public class PointPaint {

    private  Integer x;
    private Integer y;
    private Integer t;
    public  PointPaint(){}

    public PointPaint(Integer x,Integer y,Integer t){
        this.x=x;
        this.y=y;
        this.t=t;
    }
    public void setX(Integer x){
        this.x=x;
    }
    public  void setY(Integer y){
        this.y=y;
    }
    public void  setT(Integer t){
        this.t=t;
    }
    public Integer getX(){
        return  x;
    }
    public  Integer getY(){
        return  y;
    }
    public Integer getT (){
        return t;
    }

    @Override
    public String toString() {
        return "PointPaint{" +
                "x=" + x +
                ", y=" + y +
                ", t=" + t +
                '}';
    }

}
