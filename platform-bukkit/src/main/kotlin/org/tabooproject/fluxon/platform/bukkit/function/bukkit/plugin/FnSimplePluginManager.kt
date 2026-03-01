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
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.plugin.SimplePluginManager"])
@PlatformSide(Platform.BUKKIT)
object FnSimplePluginManager {

    val TYPE = Type.fromClass(SimplePluginManager::class.java)
    private val FILE_ARRAY = Type.fromClass(Array<File>::class.java)
    private val PLUGIN_ARRAY = Type.fromClass(Array<Plugin>::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(SimplePluginManager::class.java)
                .function("loadPlugins", returns(PLUGIN_ARRAY).params(Type.FILE)) { it.setReturnRef(it.target?.loadPlugins(it.getRef(0) as File)) }
                .function("loadPlugins", returns(PLUGIN_ARRAY).params(FILE_ARRAY)) { it.setReturnRef(it.target?.loadPlugins(it.getRef(0) as Array<File>)) }
                .function("isPluginEnabled", returns(Type.Z).params(Type.STRING)) { it.setReturnBool(it.target?.isPluginEnabled(it.getString(0)!!) ?: false) }
                .function("isPluginEnabled", returns(Type.Z).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.plugin.FnPlugin.TYPE)) { it.setReturnBool(it.target?.isPluginEnabled(it.getRef(0) as Plugin) ?: false) }
                .function("enablePlugin",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.plugin.FnPlugin.TYPE)) { it.target?.enablePlugin(it.getRef(0) as Plugin) }
                .function("disablePlugins", returnsVoid().noParams()) { it.target?.disablePlugins() }
                .function("disablePlugin",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.plugin.FnPlugin.TYPE)) { it.target?.disablePlugin(it.getRef(0) as Plugin) }
                .function("callEvent",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.FnEvent.TYPE)) { it.target?.callEvent(it.getRef(0) as Event) }
                .function("registerEvents", returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.FnListener.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.plugin.FnPlugin.TYPE)) {
                    it.target?.registerEvents(
                        it.getRef(0) as Listener,
                        it.getRef(1) as Plugin
                    )
                }
                .function("registerEvent", returnsVoid().params(Type.CLASS, org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.FnListener.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.FnEventPriority.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.plugin.FnEventExecutor.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.plugin.FnPlugin.TYPE)) {
                    it.target?.registerEvent(
                        it.getRef(0) as Class<Event>,
                        it.getRef(1) as Listener,
                        it.getRef(2) as EventPriority,
                        it.getRef(3) as EventExecutor,
                        it.getRef(4) as Plugin
                    )
                }
                .function("registerEvent", returnsVoid().params(Type.CLASS, org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.FnListener.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.FnEventPriority.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.plugin.FnEventExecutor.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.plugin.FnPlugin.TYPE, Type.Z)) {
                    it.target?.registerEvent(
                        it.getRef(0) as Class<Event>,
                        it.getRef(1) as Listener,
                        it.getRef(2) as EventPriority,
                        it.getRef(3) as EventExecutor,
                        it.getRef(4) as Plugin,
                        it.getBool(5)
                    )
                }
                .function("getPermission",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.permissions.FnPermission.TYPE).params(Type.STRING)) { it.setReturnRef(it.target?.getPermission(it.getString(0)!!)) }
                .function("addPermission",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.permissions.FnPermission.TYPE)) {
                    it.target?.addPermission(it.getRef(0) as Permission)
                }
                .function("addPermission",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.permissions.FnPermission.TYPE, Type.Z)) {
                    it.target?.addPermission(
                        it.getRef(0) as Permission,
                        it.getBool(1)
                    )
                }
                .function("getDefaultPermissions",returns(org.tabooproject.fluxon.util.StandardTypes.SET).params(Type.Z)) { it.setReturnRef(it.target?.getDefaultPermissions(it.getBool(0))) }
                .function("removePermission", returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.permissions.FnPermission.TYPE)) { it.target?.removePermission(it.getRef(0) as Permission) }
                .function("removePermission", returnsVoid().params(Type.STRING)) { it.target?.removePermission(it.getString(0)!!) }
                .function("recalculatePermissionDefaults",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.permissions.FnPermission.TYPE)) {
                    it.target?.recalculatePermissionDefaults(it.getRef(0) as Permission)
                }
                .function("dirtyPermissibles", returnsVoid().noParams()) { it.target?.dirtyPermissibles() }
                .function("subscribeToPermission",returnsVoid().params(Type.STRING, org.tabooproject.fluxon.platform.bukkit.function.bukkit.permissions.FnPermissible.TYPE)) {
                    it.target?.subscribeToPermission(
                        it.getString(0)!!,
                        it.getRef(1) as Permissible
                    )
                }
                .function("unsubscribeFromPermission",returnsVoid().params(Type.STRING, org.tabooproject.fluxon.platform.bukkit.function.bukkit.permissions.FnPermissible.TYPE)) {
                    it.target?.unsubscribeFromPermission(
                        it.getString(0)!!,
                        it.getRef(1) as Permissible
                    )
                }
                .function("getPermissionSubscriptions",returns(org.tabooproject.fluxon.util.StandardTypes.SET).params(Type.STRING)) {
                    it.setReturnRef(it.target?.getPermissionSubscriptions(it.getString(0)!!))
                }
                .function("subscribeToDefaultPerms",returnsVoid().params(Type.Z, org.tabooproject.fluxon.platform.bukkit.function.bukkit.permissions.FnPermissible.TYPE)) {
                    it.target?.subscribeToDefaultPerms(
                        it.getBool(0),
                        it.getRef(1) as Permissible
                    )
                }
                .function("unsubscribeFromDefaultPerms",returnsVoid().params(Type.Z, org.tabooproject.fluxon.platform.bukkit.function.bukkit.permissions.FnPermissible.TYPE)) {
                    it.target?.unsubscribeFromDefaultPerms(
                        it.getBool(0),
                        it.getRef(1) as Permissible
                    )
                }
                .function("getDefaultPermSubscriptions",returns(org.tabooproject.fluxon.util.StandardTypes.SET).params(Type.Z)) {
                    it.setReturnRef(it.target?.getDefaultPermSubscriptions(it.getBool(0)))
                }
                .function("permissions",returns(org.tabooproject.fluxon.util.StandardTypes.SET).noParams()) { it.setReturnRef(it.target?.permissions) }
                .function("isTransitiveDepend",returns(Type.Z).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.plugin.FnPluginDescriptionFile.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.plugin.FnPluginDescriptionFile.TYPE)) {
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
