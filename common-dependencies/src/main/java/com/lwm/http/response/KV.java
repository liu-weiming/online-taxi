package com.lwm.http.response;

import java.util.HashMap;
import java.util.Map;

/**
 * @author weeming
 * @date 2022/9/22 12:03
 */
public class KV extends HashMap<String, Object> {

    public KV() {
        super(8);
    }

    @Override
    public KV put(String key, Object value) {
        super.put(key, value);
        return this;
    }

    public KV put(Map<String, Object> kv) {
        super.putAll(kv);
        return this;
    }

}
