# DeepClone
Java Android DeepClone的工具

# 使用方法

```
implementation 'com.kaelq:deepclone:0.0.1'
```
引入库

```
DeepCloneUtil.deepclone(Serializable s);
DeepCloneUtil.deepclone(Parcelable p);
DeepCloneUtil.deepclone(Object o);
DeepCloneUtil.deepclone(List<T> list ,Class<T> clazz);
DeepCloneUtil.deepclone(Map<K,V> map);
```
以上几种方法进行来获取深拷贝对象，支持的类型如下：

* Object
* Serializable
* Parcel
* List\<Double>  List\<String>  List\<Object>
* Map\<String,String>

# TODO
* 添加时间差比较
* 添加List中其他类型
* 添加Map中其他类型
* 添加复杂嵌套类型
