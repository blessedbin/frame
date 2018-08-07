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
public class Quality {

    private int illumination;
    private Occlusion occlusion;
    private double blur;
    private int completeness;
    public void setIllumination(int illumination) {
         this.illumination = illumination;
     }
     public int getIllumination() {
         return illumination;
     }

    public void setOcclusion(Occlusion occlusion) {
         this.occlusion = occlusion;
     }
     public Occlusion getOcclusion() {
         return occlusion;
     }

    public void setBlur(double blur) {
         this.blur = blur;
     }
     public double getBlur() {
         return blur;
     }

    public void setCompleteness(int completeness) {
         this.completeness = completeness;
     }
     public int getCompleteness() {
         return completeness;
     }

}