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
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.structure.StructureManager"])
@PlatformSide(Platform.BUKKIT)
object FnStructureManager {

    val TYPE = Type.fromClass(StructureManager::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(StructureManager::class.java)
                .function("getStructure", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.getStructure(it.getRef(0) as NamespacedKey)) }
                .function("registerStructure", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(it.target?.registerStructure(
                        it.getRef(0) as NamespacedKey,
                        it.getRef(1) as Structure
                    ))
                }
                .function("unregisterStructure", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.unregisterStructure(it.getRef(0) as NamespacedKey)) }
                .function("loadStructure", returnsObject().params(Type.OBJECT)) {
                    it.setReturnRef(when (val var1 = it.getRef(0)) {
                        is NamespacedKey -> it.target?.loadStructure(var1)
                        is File -> it.target?.loadStructure(var1)
                        is InputStream -> it.target?.loadStructure(var1)
                        else -> throw IllegalArgumentException("参数必须是 NamespacedKey、File 或 InputStream 类型")
                    })
                }
                .function("loadStructure", returnsObject().params(Type.OBJECT, Type.Z)) {
                    it.setReturnRef(it.target?.loadStructure(
                        it.getRef(0) as NamespacedKey,
                        it.getBool(1)
                    ))
                }
                .function("saveStructure", returnsVoid().params(Type.OBJECT)) {
                    it.target?.saveStructure(it.getRef(0) as NamespacedKey)
                }
                .function("saveStructure", returnsVoid().params(Type.OBJECT, Type.OBJECT)) {
                    when (val var1 = it.getRef(0)) {
                        is NamespacedKey -> it.target?.saveStructure(var1, it.getRef(1) as Structure)
                        is File -> it.target?.saveStructure(var1, it.getRef(1) as Structure)
                        is OutputStream -> it.target?.saveStructure(var1, it.getRef(1) as Structure)
                        else -> throw IllegalArgumentException("第一个参数必须是 NamespacedKey、File 或 OutputStream 类型")
                    }
                }
                .function("deleteStructure", returnsVoid().params(Type.OBJECT)) {
                    it.target?.deleteStructure(it.getRef(0) as NamespacedKey)
                }
                .function("deleteStructure", returnsVoid().params(Type.OBJECT, Type.Z)) {
                    it.target?.deleteStructure(
                        it.getRef(0) as NamespacedKey,
                        it.getBool(1)
                    )
                }
                .function("getStructureFile", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.getStructureFile(it.getRef(0) as NamespacedKey)) }
                .function("createStructure", returnsObject().noParams()) { it.setReturnRef(it.target?.createStructure()) }
                .function("copy", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.copy(it.getRef(0) as Structure)) }
        }
    }
}
