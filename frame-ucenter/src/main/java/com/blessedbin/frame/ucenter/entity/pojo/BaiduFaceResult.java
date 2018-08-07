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
public class BaiduFaceResult {

    private Result result;
    private long log_id;
    private String error_msg;
    private int cached;
    private int error_code;
    private long timestamp;
    public void setResult(Result result) {
         this.result = result;
     }
     public Result getResult() {
         return result;
     }

    public void setLog_id(long log_id) {
         this.log_id = log_id;
     }
     public long getLog_id() {
         return log_id;
     }

    public void setError_msg(String error_msg) {
         this.error_msg = error_msg;
     }
     public String getError_msg() {
         return error_msg;
     }

    public void setCached(int cached) {
         this.cached = cached;
     }
     public int getCached() {
         return cached;
     }

    public void setError_code(int error_code) {
         this.error_code = error_code;
     }
     public int getError_code() {
         return error_code;
     }

    public void setTimestamp(long timestamp) {
         this.timestamp = timestamp;
     }
     public long getTimestamp() {
         return timestamp;
     }

    @Override
    public String toString() {
        return "BaiduFaceResult{" +
                "result=" + result +
                ", log_id=" + log_id +
                ", error_msg='" + error_msg + '\'' +
                ", cached=" + cached +
                ", error_code=" + error_code +
                ", timestamp=" + timestamp +
                '}';
    }
}