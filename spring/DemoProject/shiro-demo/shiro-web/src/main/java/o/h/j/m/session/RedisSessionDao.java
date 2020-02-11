package o.h.j.m.session;

import o.h.j.m.util.JedisUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.eis.AbstractSessionDAO;
import org.springframework.util.CollectionUtils;
import org.springframework.util.SerializationUtils;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class RedisSessionDao extends AbstractSessionDAO {
    @Resource
    private JedisUtils jedisUtils;

    private final String SHIRO_SESSION_PREFIX = "PREFIX:";

    private byte[] getKey(String key) {
        return (SHIRO_SESSION_PREFIX + key).getBytes();
    }

    private void saveSession(Session session) {
        if (session != null && session.getId() != null) {
            byte[] key = getKey(session.getId().toString());
            byte[] value = SerializationUtils.serialize(session);
            jedisUtils.set(key, value);
            jedisUtils.expire(key, 60);
        }
    }

    @Override
    protected Serializable doCreate(Session session) {
        System.out.println("doCreate " + session.getId());
        Serializable sessionId = generateSessionId(session);
        assignSessionId(session, sessionId);
        saveSession(session);
        return sessionId;
    }

    @Override
    protected Session doReadSession(Serializable sessionId) {
        if (sessionId == null) return null;
        byte[] key = getKey(sessionId.toString());
        byte[] value = jedisUtils.get(key);
        Session session = null;
        try {
            session = (Session) SerializationUtils.deserialize(value);
            System.out.println("doReadSession " + key + " ;value " + value);
        } catch (Exception e){
            e.printStackTrace();
        }
        return session;
    }

    @Override
    public void update(Session session) throws UnknownSessionException {
        saveSession(session);
    }

    @Override
    public void delete(Session session) {
        if (session == null || session.getId() == null) return;
        byte[] key = getKey(session.getId().toString());
        jedisUtils.del(key);
    }

    @Override
    public Collection<Session> getActiveSessions() {
        Set<byte[]> keys = jedisUtils.keys(SHIRO_SESSION_PREFIX);
        Set<Session> sessions = new HashSet<Session>();
        if (CollectionUtils.isEmpty(keys)) {
            return sessions;
        }
        for (byte[] key : keys) {
            Session session = (Session) SerializationUtils.deserialize(jedisUtils.get(key));
            sessions.add(session);
        }
        return sessions;
    }
}
