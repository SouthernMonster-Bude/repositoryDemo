package o.h.j.m.cache;

import o.h.j.m.util.JedisUtils;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.springframework.stereotype.Component;
import org.springframework.util.SerializationUtils;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.Set;
@Component
public class RedisCache<K,V> implements Cache<K,V> {

    @Resource
    JedisUtils jedisUtils;

    private final String CACHE_PRIFIX="CACHE_PRIFIX:";

    private byte[] getKey(K k){
        if(k instanceof  String){
            return (CACHE_PRIFIX+k).getBytes();
        }
        return SerializationUtils.serialize(k);
    }

    @Override
    public V get(K k) throws CacheException {
        System.out.println("从redis获取权限数据");
        byte[] value = jedisUtils.get(getKey(k));
        if(value!=null)return (V)(SerializationUtils.deserialize(value));
        return null;
    }

    @Override
    public V put(K k, V v) throws CacheException {
        byte[] key = getKey(k);
        byte[] value = SerializationUtils.serialize(v);
        jedisUtils.set(key,value);
        jedisUtils.expire(key,600);
        return v;
    }

    @Override
    public V remove(K k) throws CacheException {
        byte[] key = getKey(k);
        byte[] value = jedisUtils.get(key);
        jedisUtils.del(key);
        if (value!=null) return (V)SerializationUtils.deserialize(value);
        return null;
    }

    @Override
    public void clear() throws CacheException {
        //
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Set<K> keys() {
        return null;
    }

    @Override
    public Collection<V> values() {
        return null;
    }
}
