package org.tabooproject.fluxon.util

import org.tabooproject.fluxon.runtime.Function
import org.tabooproject.fluxon.runtime.Type
import taboolib.common.platform.ProxyCommandSender
import taboolib.common.platform.ProxyPlayer
import taboolib.common.platform.service.PlatformExecutor
import taboolib.common.util.Location
import taboolib.library.configuration.ConfigurationSection
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

    @JvmStatic
    val PROXY_COMMAND_SENDER = Type.fromClass(ProxyCommandSender::class.java)!!
    @JvmStatic
    val PROXY_PLAYER = Type.fromClass(ProxyPlayer::class.java)!!
    @JvmStatic
    val PROXY_LOCATION = Type.fromClass(Location::class.java)!!
    @JvmStatic
    val PLATFORM_TASK = Type.fromClass(PlatformExecutor.PlatformTask::class.java)!!
    @JvmStatic
    val CONFIGURATION_SECTION = Type.fromClass(ConfigurationSection::class.java)!!

    @JvmStatic
    val FLUXON_FUNCTION = Type.fromClass(Function::class.java)!!
}