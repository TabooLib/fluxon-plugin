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

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PluginDescriptionFile::class.java)
                .function("toString", returns(Type.STRING).noParams()) { it.target?.toString() }
                .function("name", returns(Type.STRING).noParams()) { it.target?.name }
                .function("provides", returnsObject().noParams()) { it.target?.provides }
                .function("version", returnsObject().noParams()) { it.target?.version }
                .function("main", returnsObject().noParams()) { it.target?.main }
                .function("description", returnsObject().noParams()) { it.target?.description }
                .function("load", returnsObject().noParams()) { it.target?.load }
                .function("authors", returnsObject().noParams()) { it.target?.authors }
                .function("contributors", returnsObject().noParams()) { it.target?.contributors }
                .function("website", returnsObject().noParams()) { it.target?.website }
                .function("depend", returnsObject().noParams()) { it.target?.depend }
                .function("softDepend", returnsObject().noParams()) { it.target?.softDepend }
                .function("loadBefore", returnsObject().noParams()) { it.target?.loadBefore }
                .function("prefix", returnsObject().noParams()) { it.target?.prefix }
                .function("permissions", returnsObject().noParams()) { it.target?.permissions }
                .function("permissionDefault", returnsObject().noParams()) { it.target?.permissionDefault }
                .function("awareness", returnsObject().noParams()) { it.target?.awareness }
                .function("fullName", returnsObject().noParams()) { it.target?.fullName }
                .function("aPIVersion", returnsObject().noParams()) { it.target?.apiVersion }
                .function("libraries", returnsObject().noParams()) { it.target?.libraries }
                .function("classLoaderOf", returnsObject().noParams()) { it.target?.classLoaderOf }
        }
    }
}
