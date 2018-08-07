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
public class Face_list {

    private Expression expression;
    private Face_shape face_shape;
    private double beauty;
    private Gender gender;
    private Race race;
    private int face_probability;
    private Quality quality;
    private Glasses glasses;
    private List<Landmark72> landmark72;
    private Face_type face_type;
    private Angle angle;
    private String face_token;
    private Location location;
    private List<Landmark> landmark;
    private int age;
    public void setExpression(Expression expression) {
         this.expression = expression;
     }
     public Expression getExpression() {
         return expression;
     }

    public void setFace_shape(Face_shape face_shape) {
         this.face_shape = face_shape;
     }
     public Face_shape getFace_shape() {
         return face_shape;
     }

    public void setBeauty(double beauty) {
         this.beauty = beauty;
     }
     public double getBeauty() {
         return beauty;
     }

    public void setGender(Gender gender) {
         this.gender = gender;
     }
     public Gender getGender() {
         return gender;
     }

    public void setRace(Race race) {
         this.race = race;
     }
     public Race getRace() {
         return race;
     }

    public void setFace_probability(int face_probability) {
         this.face_probability = face_probability;
     }
     public int getFace_probability() {
         return face_probability;
     }

    public void setQuality(Quality quality) {
         this.quality = quality;
     }
     public Quality getQuality() {
         return quality;
     }

    public void setGlasses(Glasses glasses) {
         this.glasses = glasses;
     }
     public Glasses getGlasses() {
         return glasses;
     }

    public void setLandmark72(List<Landmark72> landmark72) {
         this.landmark72 = landmark72;
     }
     public List<Landmark72> getLandmark72() {
         return landmark72;
     }

    public void setFace_type(Face_type face_type) {
         this.face_type = face_type;
     }
     public Face_type getFace_type() {
         return face_type;
     }

    public void setAngle(Angle angle) {
         this.angle = angle;
     }
     public Angle getAngle() {
         return angle;
     }

    public void setFace_token(String face_token) {
         this.face_token = face_token;
     }
     public String getFace_token() {
         return face_token;
     }

    public void setLocation(Location location) {
         this.location = location;
     }
     public Location getLocation() {
         return location;
     }

    public void setLandmark(List<Landmark> landmark) {
         this.landmark = landmark;
     }
     public List<Landmark> getLandmark() {
         return landmark;
     }

    public void setAge(int age) {
         this.age = age;
     }
     public int getAge() {
         return age;
     }

    @Override
    public String toString() {
        return "Face_list{" +
                "expression=" + expression +
                ", face_shape=" + face_shape +
                ", beauty=" + beauty +
                ", gender=" + gender +
                ", race=" + race +
                ", face_probability=" + face_probability +
                ", quality=" + quality +
                ", glasses=" + glasses +
                ", landmark72=" + landmark72 +
                ", face_type=" + face_type +
                ", angle=" + angle +
                ", face_token='" + face_token + '\'' +
                ", location=" + location +
                ", landmark=" + landmark +
                ", age=" + age +
                '}';
    }
}