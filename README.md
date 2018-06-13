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
以上几种方法进行来获取深拷贝对象


# 支持的类型
1. Object
2. Serializable
3. Parcel
4. List<Double>  List<String>  List<Object>
5. Map<String, String>
  
  
# TODO
1. 添加时间差比较
2. 添加List中其他类型
3. 添加Map中其他类型
4. 添加复杂嵌套类型
