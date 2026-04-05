package meta.medium;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LRUCacheTest {

    // ── Basic get/put ─────────────────────────────────────────────────────────

    @Test
    void getMissingKeyReturnsMinusOne() {
        LRUCache cache = new LRUCache(1);
        assertEquals(-1, cache.get(42));
    }

    @Test
    void putAndGetSingleEntry() {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 10);
        assertEquals(10, cache.get(1));
    }

    @Test
    void putUpdatesExistingKey() {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 10);
        cache.put(1, 20);
        assertEquals(20, cache.get(1));
    }

    // ── Eviction ──────────────────────────────────────────────────────────────

    @Test
    void evictsLeastRecentlyUsedEntry() {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3);  // evicts key 1 (LRU)
        assertEquals(-1, cache.get(1), "Key 1 should have been evicted");
        assertEquals(2, cache.get(2));
        assertEquals(3, cache.get(3));
    }

    @Test
    void getRefreshesRecency() {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);    // key 1 is now most-recently used
        cache.put(3, 3); // evicts key 2 (now the LRU)
        assertEquals(1, cache.get(1));
        assertEquals(-1, cache.get(2), "Key 2 should have been evicted");
        assertEquals(3, cache.get(3));
    }

    @Test
    void capacityOneAlwaysEvicts() {
        LRUCache cache = new LRUCache(1);
        cache.put(1, 10);
        cache.put(2, 20);
        assertEquals(-1, cache.get(1));
        assertEquals(20, cache.get(2));
    }
}
