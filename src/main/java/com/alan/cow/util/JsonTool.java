package com.alan.cow.util;

import java.text.SimpleDateFormat;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonTool {

	/**
	 * use alibaba fastjson generate json string
	 * 
	 * @param map
	 * @return
	 * @throws JSONException
	 */
	public static String genByFastJson(Map<String, Object> map)
			throws JSONException {
		JSONObject jsonObject = new JSONObject();
		for (String key : map.keySet()) {
			jsonObject.put(key, map.get(key) == null ? "" : map.get(key));
		}
		return jsonObject.toString();
	}
	
	/**
	 * use alibaba fastjson generate json string
	 * 
	 * @param o
	 * @return
	 * @throws JSONException
	 */
	public static String genByFastJson(Object o)
			throws JSONException {
		return JSONObject.toJSON(o).toString();
	}
	
	/**
	 * use alibaba fastjson resolve json string
	 * 
	 * @param t
	 * @param jsonStr
	 * @return
	 * @throws JSONException
	 */
	public static <T> T resolveByFastJson(TypeReference<T> t, String jsonStr)
			throws JSONException {
		return JSON.parseObject(jsonStr, t);
	};

	/**
	 * use jackson generate json string
	 * 
	 * @param map
	 * @return
	 * @throws JsonProcessingException
	 */
	public static String genByJacksonJson(Map<String, Object> map)
			throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(map);
	}
	
	

	/**
	 * use jackson generate json string
	 * 
	 * @param o
	 * @return
	 * @throws JSONException
	 * @throws JsonProcessingException
	 */
	public static String genByJacksonJson(Object o)
			throws JSONException, JsonProcessingException {
		return genByJacksonJson(o , null ,null);
	}
	
	
	/**
	 * use jackson generate json string
	 * 
	 * @param o
	 * @param incl
	 * @return
	 * @throws JSONException
	 * @throws JsonProcessingException
	 */
	public static String genByJacksonJson(Object o, Include incl)
			throws JSONException, JsonProcessingException {
		return genByJacksonJson(o , incl ,null);
	}
	
	/**
	 * use jackson generate json string
	 * 
	 * @param o
	 * @param sdf
	 * @return
	 * @throws JSONException
	 * @throws JsonProcessingException
	 */
	public static String genByJacksonJson(Object o, SimpleDateFormat sdf)
			throws JSONException, JsonProcessingException {
		return genByJacksonJson(o , null ,sdf);
	}
	
	/**
	 * use jackson generate json string
	 * 
	 * @param o
	 * @param incl
	 * @param sdf
	 * @return
	 * @throws JSONException
	 * @throws JsonProcessingException
	 */
	public static String genByJacksonJson(Object o, Include incl , SimpleDateFormat sdf)
			throws JSONException, JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		if(incl != null){
			mapper.setSerializationInclusion(incl);
		}
		if(sdf != null){
			mapper.setDateFormat(sdf);
		}
		return mapper.writeValueAsString(o);
	}
	
	
	

}
