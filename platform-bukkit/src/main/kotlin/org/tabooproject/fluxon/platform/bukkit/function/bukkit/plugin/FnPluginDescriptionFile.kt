package org.tabooproject.fluxon.platform.bukkit.function.bukkit.plugin

import org.bukkit.plugin.PluginDescriptionFile
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.plugin.PluginDescriptionFile"])
@PlatformSide(Platform.BUKKIT)
object FnPluginDescriptionFile {

    val TYPE = Type.fromClass(PluginDescriptionFile::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PluginDescriptionFile::class.java)
                .function("toString", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.toString()) }
                .function("name", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.name) }
                .function("provides",returns(Type.LIST).noParams()) { it.setReturnRef(it.target?.provides) }
                .function("version",returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.version) }
                .function("main",returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.main) }
                .function("description",returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.description) }
                .function("load", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.plugin.FnPluginLoadOrder.TYPE).noParams()) { it.setReturnRef(it.target?.load) }
                .function("authors",returns(Type.LIST).noParams()) { it.setReturnRef(it.target?.authors) }
                .function("contributors",returns(Type.LIST).noParams()) { it.setReturnRef(it.target?.contributors) }
                .function("website",returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.website) }
                .function("depend",returns(Type.LIST).noParams()) { it.setReturnRef(it.target?.depend) }
                .function("softDepend",returns(Type.LIST).noParams()) { it.setReturnRef(it.target?.softDepend) }
                .function("loadBefore",returns(Type.LIST).noParams()) { it.setReturnRef(it.target?.loadBefore) }
                .function("prefix",returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.prefix) }
                .function("permissions",returns(Type.LIST).noParams()) { it.setReturnRef(it.target?.permissions) }
                .function("permissionDefault",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.permissions.FnPermissionDefault.TYPE).noParams()) { it.setReturnRef(it.target?.permissionDefault) }
                .function("awareness",returns(org.tabooproject.fluxon.util.StandardTypes.SET).noParams()) { it.setReturnRef(it.target?.awareness) }
                .function("fullName",returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.fullName) }
                .function("aPIVersion",returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.apiVersion) }
                .function("libraries",returns(Type.LIST).noParams()) { it.setReturnRef(it.target?.libraries) }
                .function("classLoaderOf",returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.classLoaderOf) }
        }
    }
}
