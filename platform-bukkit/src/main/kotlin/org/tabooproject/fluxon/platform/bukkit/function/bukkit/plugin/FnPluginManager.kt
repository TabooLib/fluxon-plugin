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
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.plugin.PluginManager"])
@PlatformSide(Platform.BUKKIT)
object FnPluginManager {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PluginManager::class.java)
                .function("registerInterface", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.registerInterface(it.getRef(0) as Class<PluginLoader>)) }
                .function("getPlugin", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.getPlugin(it.getString(0)!!)) }
                .function("plugins", returnsObject().noParams()) { it.setReturnRef(it.target?.plugins) }
                .function("isPluginEnabled", returns(Type.Z).params(Type.OBJECT)) {
                    it.setReturnRef(when (val var1 = it.getRef(0)) {
                        is String -> it.target?.isPluginEnabled(var1)
                        is Plugin -> it.target?.isPluginEnabled(var1)
                        else -> throw IllegalArgumentException("参数必须是 String 或 Plugin 类型")
                    })
                }
                .function("loadPlugin", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.loadPlugin(it.getRef(0) as File)) }
                .function("loadPlugins", returnsObject().params(Type.OBJECT)) {
                    it.setReturnRef(when (val var1 = it.getRef(0)) {
                        is File -> it.target?.loadPlugins(var1)
                        is Array<*> -> it.target?.loadPlugins(var1 as Array<File>)
                        else -> throw IllegalArgumentException("参数必须是 File 或 File[] 类型")
                    })
                }
                .function("disablePlugins", returnsObject().noParams()) { it.setReturnRef(it.target?.disablePlugins()) }
                .function("clearPlugins", returnsObject().noParams()) { it.setReturnRef(it.target?.clearPlugins()) }
                .function("callEvent", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.callEvent(it.getRef(0) as Event)) }
                .function("registerEvents", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(it.target?.registerEvents(
                        it.getRef(0) as Listener,
                        it.getRef(1) as Plugin
                    ))
                }
                .function("registerEvent", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(if (it.argumentCount == 5) {
                        it.target?.registerEvent(
                            it.getRef(0) as Class<Event>,
                            it.getRef(1) as Listener,
                            it.getRef(2) as EventPriority,
                            it.getRef(3) as EventExecutor,
                            it.getRef(4) as Plugin
                        )
                    } else {
                        it.target?.registerEvent(
                            it.getRef(0) as Class<Event>,
                            it.getRef(1) as Listener,
                            it.getRef(2) as EventPriority,
                            it.getRef(3) as EventExecutor,
                            it.getRef(4) as Plugin,
                            it.getBool(5)
                        )
                    })
                }
                .function("registerEvent", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(if (it.argumentCount == 5) {
                        it.target?.registerEvent(
                            it.getRef(0) as Class<Event>,
                            it.getRef(1) as Listener,
                            it.getRef(2) as EventPriority,
                            it.getRef(3) as EventExecutor,
                            it.getRef(4) as Plugin
                        )
                    } else {
                        it.target?.registerEvent(
                            it.getRef(0) as Class<Event>,
                            it.getRef(1) as Listener,
                            it.getRef(2) as EventPriority,
                            it.getRef(3) as EventExecutor,
                            it.getRef(4) as Plugin,
                            it.getBool(5)
                        )
                    })
                }
                .function("enablePlugin", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.enablePlugin(it.getRef(0) as Plugin)) }
                .function("disablePlugin", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.disablePlugin(it.getRef(0) as Plugin)) }
                .function("getPermission", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.getPermission(it.getString(0)!!)) }
                .function("addPermission", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.addPermission(it.getRef(0) as Permission)) }
                .function("removePermission", returnsObject().params(Type.OBJECT)) {
                    it.setReturnRef(when (val var1 = it.getRef(0)) {
                        is Permission -> it.target?.removePermission(var1)
                        is String -> it.target?.removePermission(var1)
                        else -> throw IllegalArgumentException("参数必须是 Permission 或 String 类型")
                    })
                }
                .function("getDefaultPermissions", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.getDefaultPermissions(it.getBool(0))) }
                .function("recalculatePermissionDefaults", returnsObject().params(Type.OBJECT)) {
                    it.setReturnRef(it.target?.recalculatePermissionDefaults(
                        it.getRef(
                            0
                        ) as Permission
                    ))
                }
                .function("subscribeToPermission", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(it.target?.subscribeToPermission(
                        it.getString(0)!!,
                        it.getRef(1) as Permissible
                    ))
                }
                .function("unsubscribeFromPermission", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(it.target?.unsubscribeFromPermission(
                        it.getString(0)!!,
                        it.getRef(1) as Permissible
                    ))
                }
                .function("getPermissionSubscriptions", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.getPermissionSubscriptions(it.getString(0)!!)) }
                .function("subscribeToDefaultPerms", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(it.target?.subscribeToDefaultPerms(
                        it.getBool(0),
                        it.getRef(1) as Permissible
                    ))
                }
                .function("unsubscribeFromDefaultPerms", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(it.target?.unsubscribeFromDefaultPerms(
                        it.getBool(0),
                        it.getRef(1) as Permissible
                    ))
                }
                .function("getDefaultPermSubscriptions", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.getDefaultPermSubscriptions(it.getBool(0))) }
                .function("permissions", returnsObject().noParams()) { it.setReturnRef(it.target?.permissions) }
                .function("useTimings", returnsObject().noParams()) { it.setReturnRef(it.target?.useTimings()) }
        }
    }
}
