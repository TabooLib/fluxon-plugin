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

    val COLLECTION = Type.fromClass(Collection::class.java)
    val DATE = Type.fromClass(Date::class.java)
    val UUID = Type.fromClass(java.util.UUID::class.java)
    val SET = Type.fromClass(Set::class.java)
}