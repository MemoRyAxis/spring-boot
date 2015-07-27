package com.memory.base.util;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

public class EhcacheUtil {

	private static CacheManager cacheManager;
	private static final String DEFAULT_CACHE = "defaultCache";
	private static Cache defaultCache;
	private static String currentCache;

	static {
		cacheManager = CacheManager.create();
		defaultCache = new Cache(DEFAULT_CACHE, 0, true, false, 60, 30);
		cacheManager.addCache(defaultCache);
		currentCache = DEFAULT_CACHE;
	}

	public static void addCache(Cache cache) {
		cacheManager.addCache(cache);
	}

	public static Cache getCurrentCache() {
		return cacheManager.getCache(currentCache);
	}

	public static Cache getCache(String name) {
		return cacheManager.getCache(name);
	}

	public static void setCurrentCache(String name) {
		currentCache = name;
	}

	public static void put(Element element) {
		getCurrentCache().put(element);
	}

	public static void put(Object key, Object value) {
		getCurrentCache().put(new Element(key, value));
	}

	public static void put(String name, Element element) {
		getCache(name).put(element);
	}

	public static void put(String name, Object key, Object value) {
		getCache(name).put(new Element(key, value));
	}

	public static Element get(Object key) {
		return getCurrentCache().get(key);
	}

	public static Element get(String name, Object key) {
		return getCache(name).get(key);
	}

	public static void remove(Object key) {
		getCurrentCache().remove(key);
	}

	public static void remove(String name, Object key) {
		getCache(name).remove(key);
	}

	public static void removeAll() {
		getCurrentCache().removeAll();
	}

	public static void removeAll(String name) {
		getCache(name).removeAll();
	}

	public static boolean haveElement(Object key) {
		return getCurrentCache().isKeyInCache(key);
	}

	public static boolean haveElement(String name, Object key) {
		return getCache(name).isKeyInCache(key);
	}
}
