package com.core.work.context;

import java.util.*;

public class RequestContext {

	private String sessionToken;
	private String requestId;
	private String lang;
	private String region;
	private String timeZone;
	private String requestTimesstamp;
	private String source;
	private String userid;
	private Map<String,Object> datas;

	public String getSessionToken() {
		return sessionToken;
	}

	public void setSessionToken(String sessionToken) {
		this.sessionToken = sessionToken;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}

	public String getRequestTimesstamp() {
		return requestTimesstamp;
	}

	public void setRequestTimesstamp(String requestTimesstamp) {
		this.requestTimesstamp = requestTimesstamp;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public Map<String, Object> getDatas() {
		return datas;
	}

	public void setDatas(Map<String, Object> datas) {
		this.datas = datas;
	}

}
