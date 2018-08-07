/**
  * Copyright 2018 bejson.com 
  */
package com.blessedbin.frame.ucenter.entity.pojo;
import java.util.List;

/**
 * Auto-generated: 2018-07-14 15:11:11
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class Result {

    private int face_num;
    private List<Face_list> face_list;
    public void setFace_num(int face_num) {
         this.face_num = face_num;
     }
     public int getFace_num() {
         return face_num;
     }

    public void setFace_list(List<Face_list> face_list) {
         this.face_list = face_list;
     }
     public List<Face_list> getFace_list() {
         return face_list;
     }

    @Override
    public String toString() {
        return "Result{" +
                "face_num=" + face_num +
                ", face_list=" + face_list +
                '}';
    }
}