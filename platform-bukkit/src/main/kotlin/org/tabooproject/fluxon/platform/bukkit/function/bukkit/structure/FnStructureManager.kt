package org.tabooproject.fluxon.platform.bukkit.function.bukkit.structure

import org.bukkit.NamespacedKey
import org.bukkit.structure.Structure
import org.bukkit.structure.StructureManager
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

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
                .function("loadStructure", 2) {
                    it.target?.loadStructure(
                        it.getArgument(0) as NamespacedKey,
                        it.getBoolean(1)
                    )
                }
                .function("loadStructure", 1) {
                    // Structure loadStructure(@NotNull NamespacedKey var1)
                    // Structure loadStructure(@NotNull File var1)
                    // Structure loadStructure(@NotNull InputStream var1)
                    TODO()
                }
                .function("saveStructure", 1) { it.target?.saveStructure(it.getArgument(0) as NamespacedKey) }
                .function("saveStructure", 2) {
                    // void saveStructure(@NotNull NamespacedKey var1, @NotNull Structure var2)
                    // void saveStructure(@NotNull File var1, @NotNull Structure var2)
                    // void saveStructure(@NotNull OutputStream var1, @NotNull Structure var2)
                    TODO()
                }
                .function("deleteStructure", 1) { it.target?.deleteStructure(it.getArgument(0) as NamespacedKey) }
                .function("deleteStructure", 2) {
                    it.target?.deleteStructure(
                        it.getArgument(0) as NamespacedKey,
                        it.getBoolean(1)
                    )
                }
                .function("structureFile", 1) { it.target?.getStructureFile(it.getArgument(0) as NamespacedKey) }
                .function("createStructure", 0) { it.target?.createStructure() }
                .function("copy", 1) { it.target?.copy(it.getArgument(0) as Structure) }
        }
    }
}
