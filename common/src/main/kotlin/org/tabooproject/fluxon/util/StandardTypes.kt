package org.tabooproject.fluxon.util

import org.tabooproject.fluxon.runtime.Type
import java.util.Date

/**
 * FluxonPlugin
 * org.tabooproject.fluxon.util.StandardTypes
 *
 * @author mical
 * @since 2026/2/1 17:51
 */
object StandardTypes {

    @JvmStatic
    val COLLECTION = Type.fromClass(Collection::class.java)!!
    @JvmStatic
    val DATE = Type.fromClass(Date::class.java)!!
    @JvmStatic
    val UUID = Type.fromClass(java.util.UUID::class.java)!!
    @JvmStatic
    val SET = Type.fromClass(Set::class.java)!!
    @JvmStatic
    val STRING_ARRAY = Type(String::class.java, 1)
    @JvmStatic
    val I_ARRAY = Type(Integer.TYPE, 1)
}