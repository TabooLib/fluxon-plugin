package org.tabooproject.fluxon.platform.bukkit.function.bukkit.plugin

import org.bukkit.event.Event
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.bukkit.permissions.Permissible
import org.bukkit.permissions.Permission
import org.bukkit.plugin.EventExecutor
import org.bukkit.plugin.Plugin
import org.bukkit.plugin.PluginDescriptionFile
import org.bukkit.plugin.SimplePluginManager
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import java.io.File
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnSimplePluginManager {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(SimplePluginManager::class.java)
                .function("loadPlugins", 1) {
                    when (val var1 = it.getArgument(0)) {
                        is File -> it.target?.loadPlugins(var1)
                        is Array<*> -> it.target?.loadPlugins(var1 as Array<File>)
                        else -> throw IllegalArgumentException("参数必须是 File 或 File[] 类型")
                    }
                }
                .function("isPluginEnabled", 1) {
                    when (val var1 = it.getArgument(0)) {
                        is String -> it.target?.isPluginEnabled(var1)
                        is Plugin -> it.target?.isPluginEnabled(var1)
                        else -> throw IllegalArgumentException("参数必须是 String 或 Plugin 类型")
                    }
                }
                .function("enablePlugin", 1) { it.target?.enablePlugin(it.getArgument(0) as Plugin) }
                .function("disablePlugins", 0) { it.target?.disablePlugins() }
                .function("disablePlugin", 1) { it.target?.disablePlugin(it.getArgument(0) as Plugin) }
                .function("callEvent", 1) { it.target?.callEvent(it.getArgument(0) as Event) }
                .function("registerEvents", 2) {
                    it.target?.registerEvents(
                        it.getArgument(0) as Listener,
                        it.getArgument(1) as Plugin
                    )
                }
                .function("registerEvent", listOf(5, 6)) {
                    if (it.arguments.size == 5) {
                        it.target?.registerEvent(
                            it.getArgument(0) as Class<Event>,
                            it.getArgument(1) as Listener,
                            it.getArgument(2) as EventPriority,
                            it.getArgument(3) as EventExecutor,
                            it.getArgument(4) as Plugin
                        )
                    } else {
                        it.target?.registerEvent(
                            it.getArgument(0) as Class<Event>,
                            it.getArgument(1) as Listener,
                            it.getArgument(2) as EventPriority,
                            it.getArgument(3) as EventExecutor,
                            it.getArgument(4) as Plugin,
                            it.getBoolean(5)
                        )
                    }
                }
                .function("permission", 1) { it.target?.getPermission(it.getString(0)!!) }
                .function("addPermission", listOf(1, 2)) {
                    if (it.arguments.size == 1) {
                        it.target?.addPermission(it.getArgument(0) as Permission)
                    } else {
                        it.target?.addPermission(
                            it.getArgument(0) as Permission,
                            it.getBoolean(1)
                        )
                    }
                }
                .function("defaultPermissions", 1) { it.target?.getDefaultPermissions(it.getBoolean(0)) }
                .function("removePermission", 1) {
                    when (val var1 = it.getArgument(0)) {
                        is Permission -> it.target?.removePermission(var1)
                        is String -> it.target?.removePermission(var1)
                        else -> throw IllegalArgumentException("参数必须是 Permission 或 String 类型")
                    }
                }
                .function("recalculatePermissionDefaults", 1) {
                    it.target?.recalculatePermissionDefaults(
                        it.getArgument(
                            0
                        ) as Permission
                    )
                }
                .function("dirtyPermissibles", 0) { it.target?.dirtyPermissibles() }
                .function("subscribeToPermission", 2) {
                    it.target?.subscribeToPermission(
                        it.getString(0)!!,
                        it.getArgument(1) as Permissible
                    )
                }
                .function("unsubscribeFromPermission", 2) {
                    it.target?.unsubscribeFromPermission(
                        it.getString(0)!!,
                        it.getArgument(1) as Permissible
                    )
                }
                .function("permissionSubscriptions", 1) { it.target?.getPermissionSubscriptions(it.getString(0)!!) }
                .function("subscribeToDefaultPerms", 2) {
                    it.target?.subscribeToDefaultPerms(
                        it.getBoolean(0),
                        it.getArgument(1) as Permissible
                    )
                }
                .function("unsubscribeFromDefaultPerms", 2) {
                    it.target?.unsubscribeFromDefaultPerms(
                        it.getBoolean(0),
                        it.getArgument(1) as Permissible
                    )
                }
                .function("defaultPermSubscriptions", 1) { it.target?.getDefaultPermSubscriptions(it.getBoolean(0)) }
                .function("permissions", 0) { it.target?.permissions }
                .function(
                    "isTransitiveDepend",
                    2
                ) {
                    it.target?.isTransitiveDepend(
                        it.getArgument(0) as PluginDescriptionFile,
                        it.getArgument(1) as PluginDescriptionFile
                    )
                }
                .function("useTimings", listOf(0, 1)) {
                    if (it.arguments.isEmpty()) {
                        it.target?.useTimings()
                    } else {
                        it.target?.useTimings(it.getBoolean(0))
                    }
                }
        }
    }
}
