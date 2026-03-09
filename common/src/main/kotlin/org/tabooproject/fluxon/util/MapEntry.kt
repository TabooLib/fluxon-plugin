package org.tabooproject.fluxon.util

infix fun <K, V> K.with(v: V): Map.Entry<K, V> = object : Map.Entry<K, V> {
    override val key = this@with
    override val value = v
}