package org.tabooproject.fluxon.platform.bukkit.function.bukkit.plugin

import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import taboolib.common.LifeCycle
import taboolib.common.Requires
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.plugin.SimpleServicesManager"])
@PlatformSide(Platform.BUKKIT)
object FnSimpleServicesManager {

    val TYPE = Type.fromClass(org.bukkit.plugin.SimpleServicesManager::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(org.bukkit.plugin.SimpleServicesManager::class.java)
                // .function("register", returnsVoid().params(Type.CLASS, Type.OBJECT, org.tabooproject.fluxon.platform.bukkit.function.bukkit.plugin.FnPlugin.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.plugin.FnServicePriority.TYPE)) { it.target?.register(it.getRef(0) as java.lang.Class, it.getRef(1) as java.lang.Object, it.getRef(2) as org.bukkit.plugin.Plugin, it.getRef(3) as org.bukkit.plugin.ServicePriority) }
                // .function("register", returnsVoid().params(Type.CLASS, Type.OBJECT, org.tabooproject.fluxon.platform.bukkit.function.bukkit.plugin.FnPlugin.TYPE, Type.STRING)) { org.tabooproject.fluxon.platform.bukkit.function.bukkit.plugin.FnServicePriority.enumValue(it.getString(3))?.let { p3 -> it.target?.register(it.getRef(0) as java.lang.Class, it.getRef(1) as java.lang.Object, it.getRef(2) as org.bukkit.plugin.Plugin, p3) } }
                .function("unregisterAll", returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.plugin.FnPlugin.TYPE)) { it.target?.unregisterAll(it.getRef(0) as org.bukkit.plugin.Plugin) }
                // .function("unregister", returnsVoid().params(Type.CLASS, Type.OBJECT)) { it.target?.unregister(it.getRef(0) as java.lang.Class, it.getRef(1) as java.lang.Object) }
                .function("unregister", returnsVoid().params(Type.OBJECT)) { it.target?.unregister(it.getRef(0) as java.lang.Object) }
                // .function("load", returns(Type.OBJECT).params(Type.CLASS)) { it.setReturnRef(it.target?.load(it.getRef(0) as java.lang.Class)) }
                // .function("getRegistration", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.plugin.FnRegisteredServiceProvider.TYPE).params(Type.CLASS)) { it.setReturnRef(it.target?.getRegistration(it.getRef(0) as java.lang.Class)) }
                .function("getRegistrations", returns(Type.LIST).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.plugin.FnPlugin.TYPE)) { it.setReturnRef(it.target?.getRegistrations(it.getRef(0) as org.bukkit.plugin.Plugin)) }
                // .function("getRegistrations", returns(Type.LIST).params(Type.CLASS)) { it.setReturnRef(it.target?.getRegistrations(it.getRef(0) as java.lang.Class)) }
                .function("getKnownServices", returns(org.tabooproject.fluxon.util.StandardTypes.SET).noParams()) { it.setReturnRef(it.target?.getKnownServices()) }
                // .function("isProvidedFor", returns(Type.Z).params(Type.CLASS)) { it.setReturnBool(it.target?.isProvidedFor(it.getRef(0) as java.lang.Class) ?: false) }
        }
    }
}
