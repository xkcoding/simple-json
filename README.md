<h1 align="center"><a href="https://github.com/xkcoding/simple-json" target="_blank">Simple-JSON</a></h1>
<p align="center">
<a href="https://travis-ci.com/xkcoding/simple-json" target="_blank"><img alt="Travis-CI" src="https://travis-ci.com/xkcoding/simple-json.svg?branch=master"/></a>
  <a href="https://search.maven.org/artifact/com.xkcoding.http/simple-json" target="_blank"><img alt="MAVEN" src="https://img.shields.io/maven-central/v/com.xkcoding.http/simple-json.svg?color=brightgreen&label=Maven%20Central"></a>
  <a href="https://xkcoding.com" target="_blank"><img alt="author" src="https://img.shields.io/badge/author-Yangkai.Shen-blue.svg"/></a>
  <a href="https://www.oracle.com/technetwork/java/javase/downloads/index.html" target="_blank"><img alt="JDK" src="https://img.shields.io/badge/JDK-1.8.0_162-orange.svg"/></a>
  <a href="https://github.com/xkcoding/simple-json/blob/master/LICENSE" target="_blank"><img alt="LICENSE" src="https://img.shields.io/github/license/xkcoding/simple-json.svg"/></a>
</p>

## 简介

> 抽取一个简单 JSON 的通用接口，底层实现根据具体引入依赖指定。

```xml
<dependency>
  <groupId>com.xkcoding.json</groupId>
  <artifactId>simple-json</artifactId>
  <version>0.0.2</version>
</dependency>
```

## 特点

- 默认会按照下面的优先级自行寻找底层实现，`jackson -> fastjson -> gson -> hutool-json`
- 也可以自行实现 `com.xkcoding.json.support.JsonAdapter` 接口，通过 `JsonUtil.setJsonAdapter(new MyJsonImpl())` 设置进来

```java
JsonUtil.setConfig(JsonConfig.builder().dateFormat("yyyy-MM-dd HH:mm:ss").build());
  String jsonStr=JsonUtil.toJsonString(obj);
  System.out.println(jsonStr);

  User user=JsonUtil.toBean(jsonStr,User.class);
  System.out.println(user);

  Map map=JsonUtil.toBean(jsonStr,Map.class);
  System.out.println(map);

  Kv kv=JsonUtil.parseKv(jsonStr);
```

## TODO

- [x] ~~抽取不同实现的 JSON 序列化/反序列配置~~
- [x] ~~优化KV体验~~(感谢[@亚东](https://github.com/zhangyd-c)的 [PR#1](https://github.com/xkcoding/simple-json/pull/1))
