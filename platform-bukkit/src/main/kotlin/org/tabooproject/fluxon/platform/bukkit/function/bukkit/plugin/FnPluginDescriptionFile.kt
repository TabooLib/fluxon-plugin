package org.tabooproject.fluxon.platform.bukkit.function.bukkit.plugin

import org.bukkit.plugin.PluginDescriptionFile
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnPluginDescriptionFile {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PluginDescriptionFile::class.java)
                .function("toString", 0) { it.target?.toString() }
                .function("name", 0) { it.target?.name }
                .function("provides", 0) { it.target?.provides }
                .function("version", 0) { it.target?.version }
                .function("main", 0) { it.target?.main }
                .function("description", 0) { it.target?.description }
                .function("load", 0) { it.target?.load }
                .function("authors", 0) { it.target?.authors }
                .function("contributors", 0) { it.target?.contributors }
                .function("website", 0) { it.target?.website }
                .function("depend", 0) { it.target?.depend }
                .function("softDepend", 0) { it.target?.softDepend }
                .function("loadBefore", 0) { it.target?.loadBefore }
                .function("prefix", 0) { it.target?.prefix }
                .function("permissions", 0) { it.target?.permissions }
                .function("permissionDefault", 0) { it.target?.permissionDefault }
                .function("awareness", 0) { it.target?.awareness }
                .function("fullName", 0) { it.target?.fullName }
                .function("aPIVersion", 0) { it.target?.apiVersion }
                .function("libraries", 0) { it.target?.libraries }
                .function("classLoaderOf", 0) { it.target?.classLoaderOf }
        }
    }
}
