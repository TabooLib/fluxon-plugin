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
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.plugin.SimplePluginManager"])
@PlatformSide(Platform.BUKKIT)
object FnSimplePluginManager {

    val TYPE = Type.fromClass(SimplePluginManager::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(SimplePluginManager::class.java)
                .function("loadPlugins", returnsObject().params(Type.OBJECT)) {
                    it.setReturnRef(when (val var1 = it.getRef(0)) {
                        is File -> it.target?.loadPlugins(var1)
                        is Array<*> -> it.target?.loadPlugins(var1 as Array<File>)
                        else -> throw IllegalArgumentException("参数必须是 File 或 File[] 类型")
                    })
                }
                .function("isPluginEnabled", returns(Type.Z).params(Type.OBJECT)) {
                    it.setReturnBool(when (val var1 = it.getRef(0)) {
                        is String -> it.target?.isPluginEnabled(var1)
                        is Plugin -> it.target?.isPluginEnabled(var1)
                        else -> throw IllegalArgumentException("参数必须是 String 或 Plugin 类型")
                    } ?: false)
                }
                .function("enablePlugin", returnsVoid().params(Type.OBJECT)) { it.target?.enablePlugin(it.getRef(0) as Plugin) }
                .function("disablePlugins", returnsVoid().noParams()) { it.target?.disablePlugins() }
                .function("disablePlugin", returnsVoid().params(Type.OBJECT)) { it.target?.disablePlugin(it.getRef(0) as Plugin) }
                .function("callEvent", returnsVoid().params(Type.OBJECT)) { it.target?.callEvent(it.getRef(0) as Event) }
                .function("registerEvents", returnsVoid().params(Type.OBJECT, Type.OBJECT)) {
                    it.target?.registerEvents(
                        it.getRef(0) as Listener,
                        it.getRef(1) as Plugin
                    )
                }
                .function("registerEvent", returnsVoid().params(Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.target?.registerEvent(
                        it.getRef(0) as Class<Event>,
                        it.getRef(1) as Listener,
                        it.getRef(2) as EventPriority,
                        it.getRef(3) as EventExecutor,
                        it.getRef(4) as Plugin
                    )
                }
                .function("registerEvent", returnsVoid().params(Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.Z)) {
                    it.target?.registerEvent(
                        it.getRef(0) as Class<Event>,
                        it.getRef(1) as Listener,
                        it.getRef(2) as EventPriority,
                        it.getRef(3) as EventExecutor,
                        it.getRef(4) as Plugin,
                        it.getBool(5)
                    )
                }
                .function("getPermission", returnsObject().params(Type.STRING)) { it.setReturnRef(it.target?.getPermission(it.getString(0)!!)) }
                .function("addPermission", returnsVoid().params(Type.OBJECT)) {
                    it.target?.addPermission(it.getRef(0) as Permission)
                }
                .function("addPermission", returnsVoid().params(Type.OBJECT, Type.Z)) {
                    it.target?.addPermission(
                        it.getRef(0) as Permission,
                        it.getBool(1)
                    )
                }
                .function("getDefaultPermissions", returnsObject().params(Type.Z)) { it.setReturnRef(it.target?.getDefaultPermissions(it.getBool(0))) }
                .function("removePermission", returnsVoid().params(Type.OBJECT)) {
                    when (val var1 = it.getRef(0)) {
                        is Permission -> it.target?.removePermission(var1)
                        is String -> it.target?.removePermission(var1)
                        else -> throw IllegalArgumentException("参数必须是 Permission 或 String 类型")
                    }
                }
                .function("recalculatePermissionDefaults", returnsVoid().params(Type.OBJECT)) {
                    it.target?.recalculatePermissionDefaults(it.getRef(0) as Permission)
                }
                .function("dirtyPermissibles", returnsObject().noParams()) { it.setReturnRef(it.target?.dirtyPermissibles()) }
                .function("subscribeToPermission", returnsVoid().params(Type.STRING, Type.OBJECT)) {
                    it.target?.subscribeToPermission(
                        it.getString(0)!!,
                        it.getRef(1) as Permissible
                    )
                }
                .function("unsubscribeFromPermission", returnsVoid().params(Type.STRING, Type.OBJECT)) {
                    it.target?.unsubscribeFromPermission(
                        it.getString(0)!!,
                        it.getRef(1) as Permissible
                    )
                }
                .function("getPermissionSubscriptions", returnsObject().params(Type.STRING)) {
                    it.setReturnRef(it.target?.getPermissionSubscriptions(it.getString(0)!!))
                }
                .function("subscribeToDefaultPerms", returnsVoid().params(Type.Z, Type.OBJECT)) {
                    it.target?.subscribeToDefaultPerms(
                        it.getBool(0),
                        it.getRef(1) as Permissible
                    )
                }
                .function("unsubscribeFromDefaultPerms", returnsVoid().params(Type.Z, Type.OBJECT)) {
                    it.target?.unsubscribeFromDefaultPerms(
                        it.getBool(0),
                        it.getRef(1) as Permissible
                    )
                }
                .function("getDefaultPermSubscriptions", returnsObject().params(Type.Z)) {
                    it.setReturnRef(it.target?.getDefaultPermSubscriptions(it.getBool(0)))
                }
                .function("permissions", returnsObject().noParams()) { it.setReturnRef(it.target?.permissions) }
                .function("isTransitiveDepend", returns(Type.Z).params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnBool(it.target?.isTransitiveDepend(
                        it.getRef(0) as PluginDescriptionFile,
                        it.getRef(1) as PluginDescriptionFile
                    ) ?: false)
                }
                .function("useTimings", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.useTimings() ?: false) }
                .function("useTimings", returnsVoid().params(Type.Z)) { it.target?.useTimings(it.getBool(0)) }
        }
    }
}
