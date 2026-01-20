package org.tabooproject.fluxon.platform.bukkit.function.bukkit.structure

import org.bukkit.NamespacedKey
import org.bukkit.structure.Structure
import org.bukkit.structure.StructureManager
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import java.io.File
import java.io.InputStream
import java.io.OutputStream
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnStructureManager {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(StructureManager::class.java)
                .function("structure", 1) { it.target?.getStructure(it.getArgument(0) as NamespacedKey) }
                .function("registerStructure", 2) {
                    it.target?.registerStructure(
                        it.getArgument(0) as NamespacedKey,
                        it.getArgument(1) as Structure
                    )
                }
                .function(
                    "unregisterStructure",
                    1
                ) { it.target?.unregisterStructure(it.getArgument(0) as NamespacedKey) }
                .function("loadStructure", listOf(1, 2)) {
                    if (it.arguments.size == 1) {
                        when (val var1 = it.getArgument(0)) {
                            is NamespacedKey -> it.target?.loadStructure(var1)
                            is File -> it.target?.loadStructure(var1)
                            is InputStream -> it.target?.loadStructure(var1)
                            else -> throw IllegalArgumentException("参数必须是 NamespacedKey、File 或 InputStream 类型")
                        }
                    } else {
                        it.target?.loadStructure(
                            it.getArgument(0) as NamespacedKey,
                            it.getBoolean(1)
                        )
                    }
                }
                .function("saveStructure", listOf(1, 2)) {
                    if (it.arguments.size == 1) {
                        it.target?.saveStructure(it.getArgument(0) as NamespacedKey)
                    } else {
                        when (val var1 = it.getArgument(0)) {
                            is NamespacedKey -> it.target?.saveStructure(var1, it.getArgument(1) as Structure)
                            is File -> it.target?.saveStructure(var1, it.getArgument(1) as Structure)
                            is OutputStream -> it.target?.saveStructure(var1, it.getArgument(1) as Structure)
                            else -> throw IllegalArgumentException("第一个参数必须是 NamespacedKey、File 或 OutputStream 类型")
                        }
                    }
                }
                .function("deleteStructure", listOf(1, 2)) {
                    if (it.arguments.size == 1) {
                        it.target?.deleteStructure(it.getArgument(0) as NamespacedKey)
                    } else {
                        it.target?.deleteStructure(
                            it.getArgument(0) as NamespacedKey,
                            it.getBoolean(1)
                        )
                    }
                }
                .function("structureFile", 1) { it.target?.getStructureFile(it.getArgument(0) as NamespacedKey) }
                .function("createStructure", 0) { it.target?.createStructure() }
                .function("copy", 1) { it.target?.copy(it.getArgument(0) as Structure) }
        }
    }
}
