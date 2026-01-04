package org.tabooproject.fluxon.util

import java.util.concurrent.ConcurrentHashMap

/**
 * 轻量级 LRU 缓存，支持访问过期
 */
class SimpleCache<K : Any, V : Any>(
    private val expireAfterAccessMs: Long = 3600_000L,
    private val maxSize: Int = 100
) {

    private class Entry<V>(val value: V, var accessTime: Long = System.currentTimeMillis())

    private val store = ConcurrentHashMap<K, Entry<V>>()

    fun get(key: K, loader: (K) -> V): V {
        val now = System.currentTimeMillis()
        store[key]?.takeIf { now - it.accessTime <= expireAfterAccessMs }?.let {
            it.accessTime = now
            return it.value
        }
        return synchronized(this) {
            store[key]?.takeIf { now - it.accessTime <= expireAfterAccessMs }?.let {
                it.accessTime = now
                return it.value
            }
            val value = loader(key)
            evictIfNeeded()
            store[key] = Entry(value, now)
            value
        }
    }

    fun contains(key: K): Boolean {
        val now = System.currentTimeMillis()
        return store[key]?.let { now - it.accessTime <= expireAfterAccessMs } ?: false
    }

    private fun evictIfNeeded() {
        if (store.size < maxSize) return
        val now = System.currentTimeMillis()
        store.entries.removeIf { now - it.value.accessTime > expireAfterAccessMs }
        if (store.size >= maxSize) {
            store.entries.minByOrNull { it.value.accessTime }?.key?.let { store.remove(it) }
        }
    }
}
