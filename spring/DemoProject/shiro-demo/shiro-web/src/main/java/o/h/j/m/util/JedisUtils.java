package o.h.j.m.util;

import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;
import java.util.Set;
@Component
public class JedisUtils {

    @Resource
    private JedisPool jedisPool;

    private Jedis getResource(){
        return jedisPool.getResource();
    }

    public byte[] set(byte[] key, byte[] value) {
        Jedis jedis = getResource();
//        System.out.println("set key "+new String(key));
//        System.out.println("set value "+new String(value));
        try {
            jedis.set(key,value);
            return value;
        } finally {
            jedis.close();
        }
    }
    public byte[] get(byte[] key) {
//        System.out.println("get "+new String(key));
        Jedis jedis = getResource();
        try {
            return jedis.get(key);
        } finally {
            jedis.close();
        }
    }

    public void expire(byte[] key, int i) {
        Jedis jedis = getResource();
        try {
            jedis.expire(key,i);
        } finally {
            jedis.close();
        }

    }

    public void del(byte[] key) {
        Jedis jedis = getResource();
        try {
            jedis.del(key);
        } finally {
            jedis.close();
        }
    }

    public Set<byte[]> keys(String prefix) {
        Jedis jedis = getResource();
        try {
            return jedis.keys((prefix+"*").getBytes());
        } finally {
            jedis.close();
        }
    }
}
