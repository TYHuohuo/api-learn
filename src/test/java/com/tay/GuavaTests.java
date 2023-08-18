package com.tay;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.*;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.junit.Test;

import java.util.*;

/**
 * <p>
 *   guava工具类使用
 * </p>
 *
 * @author tay
 * @since 2022-05-15
 */
public class GuavaTests {
    @Test
    public void listTest() {
        // 普通集合创建
        // 新建list
        ArrayList<String> list = Lists.newArrayList("1", "2", "3");
        System.out.println(list);

        // 新建set
        HashSet<String> sets = Sets.newHashSet("a", "b", "c");
        System.out.println(sets);

        // 新建map
        HashMap<@Nullable Object, @Nullable Object> map = Maps.newHashMap();
        map.put("k1", "v1");
        map.put("k2", "v2");
        map.put("k3", "v3");
        System.out.println(map);
        // 不可变集合创建
        ImmutableList<String> immutableList = ImmutableList.of("1", "2", "3");
        System.out.println("immutableList" + immutableList);

        ImmutableMap<String, String> immutableMap = ImmutableMap.of("k1", "v1", "k2", "v2", "k3", "v3");
        System.out.println("immutableMap" + immutableMap);

        ImmutableSet<String> immutableSet = ImmutableSet.of("a", "b", "c");
        System.out.println("immutableSet" + immutableSet);
    }
    @Test
    public void change(){
        // 转换List
        // 快速构建Map key为String value 为List
        Multimap<@Nullable Object, @Nullable Object> mutiMap = ArrayListMultimap.create();
        mutiMap.put("name", "jay");
        mutiMap.put("name", "tay");
        mutiMap.put("name", "ray");
        mutiMap.put("name", "cooper");
        mutiMap.put("age", 12);
        mutiMap.put("age", 44);
        mutiMap.put("addr", "上海市区");
        // 结果 {name=[jay, tay, ray, cooper], addr=[上海市区], age=[12, 44]}
        System.out.println(mutiMap);

        // 可重复存值，计算次数
        Multiset<@Nullable Object> hashMultiset = HashMultiset.create();
        hashMultiset.add("aaa");
        hashMultiset.add("aaa");
        hashMultiset.add("B");
        hashMultiset.add("V ");
        hashMultiset.add("2314");
        System.out.println(hashMultiset);
        System.out.println(hashMultiset.count("aaa"));

        // key 和value都不重复 双向链表 可以通过key获取 也可reverse之后通过value获取值
        BiMap<@Nullable Object, @Nullable Object> hashBiMap = HashBiMap.create();
        hashBiMap.put("name", "tay");
        hashBiMap.put("alis", "jay");
        System.out.println(hashBiMap);
        hashBiMap.entrySet().forEach(System.out::println);
        System.out.println();
        hashBiMap.inverse().entrySet().forEach(System.out::println);
    }
    @Test
    public void listToString () {
        // list转stirng 带上拼接符
        List<String> list = Lists.newArrayList("1", "2", "3");
        String join = Joiner.on("-").join(list);
        System.out.println(join);
        // 指定map key和value中间连接符
        Map<String, String> map = Maps.newHashMap();
        map.put("name","jay");
        map.put("nickName","tay123");
        String join1 = Joiner.on(",").withKeyValueSeparator("=").join(map);
        System.out.println(join1);


    }
    @Test
    public void stringToList() {
        //将 String 转换为特定的集合
        String str = "1-2-3-4-5-6";
        List<String> splitList = Splitter.on("-").splitToList(str);
        System.out.println(splitList);
        // 去除空串与空格
        str="1-2-3-4- 5-  6  ";
        splitList = Splitter.on("-").omitEmptyStrings().trimResults().splitToList(str);
        System.out.println(splitList);

        // 将 String 转换为 map
        String str2 = "xiaoming=11,xiaohong=23";
        Map<String,String> map = Splitter.on(",").withKeyValueSeparator("=").split(str2);
        System.out.println(map);
    }
}
