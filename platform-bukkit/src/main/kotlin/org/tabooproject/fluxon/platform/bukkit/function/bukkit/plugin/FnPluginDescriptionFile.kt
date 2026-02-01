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
                .function("provides", returnsObject().noParams()) { it.setReturnRef(it.target?.provides) }
                .function("version", returnsObject().noParams()) { it.setReturnRef(it.target?.version) }
                .function("main", returnsObject().noParams()) { it.setReturnRef(it.target?.main) }
                .function("description", returnsObject().noParams()) { it.setReturnRef(it.target?.description) }
                .function("load", returnsObject().noParams()) { it.setReturnRef(it.target?.load) }
                .function("authors", returnsObject().noParams()) { it.setReturnRef(it.target?.authors) }
                .function("contributors", returnsObject().noParams()) { it.setReturnRef(it.target?.contributors) }
                .function("website", returnsObject().noParams()) { it.setReturnRef(it.target?.website) }
                .function("depend", returnsObject().noParams()) { it.setReturnRef(it.target?.depend) }
                .function("softDepend", returnsObject().noParams()) { it.setReturnRef(it.target?.softDepend) }
                .function("loadBefore", returnsObject().noParams()) { it.setReturnRef(it.target?.loadBefore) }
                .function("prefix", returnsObject().noParams()) { it.setReturnRef(it.target?.prefix) }
                .function("permissions", returnsObject().noParams()) { it.setReturnRef(it.target?.permissions) }
                .function("permissionDefault", returnsObject().noParams()) { it.setReturnRef(it.target?.permissionDefault) }
                .function("awareness", returnsObject().noParams()) { it.setReturnRef(it.target?.awareness) }
                .function("fullName", returnsObject().noParams()) { it.setReturnRef(it.target?.fullName) }
                .function("aPIVersion", returnsObject().noParams()) { it.setReturnRef(it.target?.apiVersion) }
                .function("libraries", returnsObject().noParams()) { it.setReturnRef(it.target?.libraries) }
                .function("classLoaderOf", returnsObject().noParams()) { it.setReturnRef(it.target?.classLoaderOf) }
        }
    }
}
