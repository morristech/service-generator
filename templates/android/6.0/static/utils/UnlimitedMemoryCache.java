package {{{staticPackage}}}.utils;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Memory cache of strong references with unlimited size
 *
 * @author Service Generator
 *
 * Generated Class - DO NOT MODIFY
 */
public class UnlimitedMemoryCache<T, Q> implements CacheInterface<T, Q> {

    private final Map<T, Q> map = Collections.synchronizedMap(new HashMap<T, Q>());

    @Override
    public void put(T request, Q response) {
        map.put(request, response);
    }

    @Override
    public Q get(T request) {
        return map.get(request);
    }

    @Override
    public void remove(T request) {
        map.remove(request);
    }

    @Override
    public Collection<T> keys() {
        synchronized (map) {
            return new HashSet<T>(map.keySet());
        }
    }

    @Override
    public void clear() {
        map.clear();
    }
}
