package com.apanse.icabst.modules.enums;

public class ResponseEnum {
	/**
	 * 响应编码
	 */
	public enum ResponseCodeEnum6 {
	    SUCCESS("000000", "成功"),
	    ERROR("100000", "失败"),
	    ERROR_200000("200000", "失败"),
	    FAIL("999999", "其它异常");
	        
	    /**
	     * 响应码
	     */
	    private String code;
	    /**
	     * 响应描述
	     */
	    private String desc;

	    public String getCode() {
	        return code;
	    }

	    private void setCode(String code) {
	        this.code = code;
	    }

	    public String getDesc() {
	        return desc;
	    }

	    private void setDesc(String desc) {
	        this.desc = desc;
	    }

	    private ResponseCodeEnum6(String code, String desc) {
	        this.setCode(code);
	        this.setDesc(desc);
	    }
	}
	
}
