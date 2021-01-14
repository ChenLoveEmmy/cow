package com.alan.cow.util;

import com.alan.cow.enums.RetEnumIntf;
import com.alibaba.fastjson.JSONException;

import java.util.HashMap;
import java.util.Map;

public class JsonBizTool {
	
	public static String genJson(String ret, String msg) throws JSONException {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ret", ret);
		map.put("msg", msg);
		return JsonTool.genByFastJson(map);
	}
	
	public static String genJson(RetEnumIntf rei)
			throws JSONException {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ret", rei.getRet());
		map.put("msg", rei.getMsg());
		return JsonTool.genByFastJson(map);
	}
	
	public static String genJson(RetEnumIntf rei, Map<String, Object> map)
			throws JSONException {
		map.put("ret", rei.getRet());
		map.put("msg", rei.getMsg());
		return JsonTool.genByFastJson(map);
	}
	
	public static String genJson(Map<String, Object> map)
			throws JSONException {
		return JsonTool.genByFastJson(map);
	}

}
