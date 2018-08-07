/**
  * Copyright 2018 bejson.com 
  */
package com.blessedbin.frame.ucenter.entity.pojo;

/**
 * Auto-generated: 2018-07-14 15:11:11
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class Location {

    private double top;
    private double left;
    private int rotation;
    private int width;
    private int height;
    public void setTop(double top) {
         this.top = top;
     }
     public double getTop() {
         return top;
     }

    public void setLeft(double left) {
         this.left = left;
     }
     public double getLeft() {
         return left;
     }

    public void setRotation(int rotation) {
         this.rotation = rotation;
     }
     public int getRotation() {
         return rotation;
     }

    public void setWidth(int width) {
         this.width = width;
     }
     public int getWidth() {
         return width;
     }

    public void setHeight(int height) {
         this.height = height;
     }
     public int getHeight() {
         return height;
     }

    @Override
    public String toString() {
        return "Location{" +
                "top=" + top +
                ", left=" + left +
                ", rotation=" + rotation +
                ", width=" + width +
                ", height=" + height +
                '}';
    }
}