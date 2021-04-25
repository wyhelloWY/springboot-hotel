package com.jxau.hotelsystem.pojo;

import java.util.List;

/**
 * 统一封装一个返回结果集
 * @author Yu W
 * @date 2021/2/8 11:28
 * 自定义响应数据结构
 *                  其他自行处理
 *                  200：表示成功
 *                  500：表示错误，错误信息在msg字段中
 *                  501：bean验证错误，不管多少个错误都以map形式返回
 *                  502：拦截器拦截到用户token出错
 *                  555：异常抛出信息
 */
public class ResultMap<T> {
    /**
     * 返回状态码
     * 200 成功200
     *
     */
    private Integer code;
    /**
     * 返回结果是否成功
     * result:success
     * result:error
     */
    private String result;
    /**
     * 返回的结果集合LIST
     */
    private List<T> dataArray;

    /**
     * 提示信息
     */
    private String msg;

    /**
     * 数据长度
     */
    private Integer length;

    private String sessionId;
    /**
     * 返回的其他对象
     */
    private Object formData;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public List<T> getDataArray() {
        return dataArray;
    }

    public void setDataArray(List<T> dataArray) {
        this.dataArray = dataArray;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Object getFormData() {
        return formData;
    }

    public void setFormData(Object formData) {
        this.formData = formData;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }


    public void setCodeResultDataArrayMsg(Integer code,String result,String msg,List<T> dataArray,Integer length){
        this.msg = msg;
        this.dataArray = dataArray;
        this.code = code;
        this.result = result;
        this.length = length;
    }
    public void setCodeResultMsg(Integer code,String result,String msg){
        this.msg = msg;
        this.code = code;
        this.result = result;
    }
    public void setCodeResultMsgFormData(Integer code,String result,String msg,Object formData){
        this.msg = msg;
        this.code = code;
        this.result = result;
        this.formData = formData;
    }
}
