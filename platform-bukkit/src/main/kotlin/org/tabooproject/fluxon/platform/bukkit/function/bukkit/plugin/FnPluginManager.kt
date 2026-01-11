package org.tabooproject.fluxon.platform.bukkit.function.bukkit.plugin

import org.bukkit.event.Event
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.bukkit.permissions.Permissible
import org.bukkit.permissions.Permission
import org.bukkit.plugin.EventExecutor
import org.bukkit.plugin.Plugin
import org.bukkit.plugin.PluginLoader
import org.bukkit.plugin.PluginManager
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import java.io.File

object FnPluginManager {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PluginManager::class.java)
                .function(
                    "registerInterface",
                    1
                ) { it.target?.registerInterface(it.getArgument(0) as Class<PluginLoader>) }
                .function("plugin", 1) { it.target?.getPlugin(it.getString(0)!!) }
                .function("plugins", 0) { it.target?.plugins }
                .function("isPluginEnabled", 1) {
                    // boolean isPluginEnabled(@NotNull String var1)
                    // boolean isPluginEnabled(@Nullable Plugin var1)
                    TODO()
                }
                .function("loadPlugin", 1) { it.target?.loadPlugin(it.getArgument(0) as File) }
                .function("loadPlugins", 1) {
                    // Plugin[] loadPlugins(@NotNull File var1)
                    // Plugin[] loadPlugins(@NotNull File[] var1)
                    TODO()
                }
                .function("disablePlugins", 0) { it.target?.disablePlugins() }
                .function("clearPlugins", 0) { it.target?.clearPlugins() }
                .function("callEvent", 1) { it.target?.callEvent(it.getArgument(0) as Event) }
                .function("registerEvents", 2) {
                    it.target?.registerEvents(
                        it.getArgument(0) as Listener,
                        it.getArgument(1) as Plugin
                    )
                }
                .function("registerEvent", 5) {
                    it.target?.registerEvent(
                        it.getArgument(0) as Class<Event>,
                        it.getArgument(1) as Listener,
                        it.getArgument(2) as EventPriority,
                        it.getArgument(3) as EventExecutor,
                        it.getArgument(4) as Plugin
                    )
                }
                .function("registerEvent", 6) {
                    it.target?.registerEvent(
                        it.getArgument(0) as Class<Event>,
                        it.getArgument(1) as Listener,
                        it.getArgument(2) as EventPriority,
                        it.getArgument(3) as EventExecutor,
                        it.getArgument(4) as Plugin,
                        it.getBoolean(5)
                    )
                }
                .function("enablePlugin", 1) { it.target?.enablePlugin(it.getArgument(0) as Plugin) }
                .function("disablePlugin", 1) { it.target?.disablePlugin(it.getArgument(0) as Plugin) }
                .function("permission", 1) { it.target?.getPermission(it.getString(0)!!) }
                .function("addPermission", 1) { it.target?.addPermission(it.getArgument(0) as Permission) }
                .function("removePermission", 1) {
                    // void removePermission(@NotNull Permission var1)
                    // void removePermission(@NotNull String var1)
                    TODO()
                }
                .function("defaultPermissions", 1) { it.target?.getDefaultPermissions(it.getBoolean(0)) }
                .function("recalculatePermissionDefaults", 1) {
                    it.target?.recalculatePermissionDefaults(
                        it.getArgument(
                            0
                        ) as Permission
                    )
                }
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
                .function("useTimings", 0) { it.target?.useTimings() }
        }
    }
}
