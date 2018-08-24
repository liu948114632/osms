/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.itecheasy.printMethod;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.JavaType;

import java.io.IOException;
import java.util.List;

/**
 * @Auther: liteng
 * @Date: 2018/8/9 19:48
 * @Description:
 */
public class JsonUtils {



    /**
     * 对象转json   方法通用
     * @param jsonStr   json集合类型对象
     * @param clazz     cast to bean
     * @param <T>
     * @return
     * @throws IOException
     */
    @Deprecated
    public static <T extends Object> List<T> StrToVo(String jsonStr, Class<T> clazz) throws IOException {
        ObjectMapper MAPPER = new ObjectMapper();
        JavaType javaType4 = MAPPER.getTypeFactory().constructParametricType(List.class, Class.class);
        List<T> list = MAPPER.readValue(jsonStr, javaType4);
        System.out.println("集合里是对象 对象里有集合转换:" + list);
        return list;
    }



}
