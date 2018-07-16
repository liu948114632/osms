package com.itecheasy.common.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/** 
 * @author wanghw
 * @date 2015-6-23 
 * @description 线程工具类
 * @version
 */
public class ThreadUtils {
	public static final ExecutorService pool = Executors.newFixedThreadPool(10);
}
