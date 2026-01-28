package org.tabooproject.fluxon.platform.bukkit.function.bukkit.material

import org.bukkit.material.MaterialData
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.material.MaterialData"])
@PlatformSide(Platform.BUKKIT)
object FnMaterialData {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(MaterialData::class.java)
                .function("data", returnsObject().noParams()) { it.target?.data }
                .function("setData", returnsObject().params(Type.OBJECT)) { it.target?.setData(it.getInt(0).toByte()) }
                .function("itemType", returnsObject().noParams()) { it.target?.itemType }
                .function("toItemStack", returnsObject().noParams()) {
                    if ((it.argumentCount == 0)) {
                        it.target?.toItemStack()
                    } else {
                        it.target?.toItemStack(it.getInt(0).toInt())
                    }
                }
                .function("toItemStack", returnsObject().params(Type.OBJECT)) {
                    if ((it.argumentCount == 0)) {
                        it.target?.toItemStack()
                    } else {
                        it.target?.toItemStack(it.getInt(0).toInt())
                    }
                }
                .function("toString", returns(Type.STRING).noParams()) { it.target?.toString() }
                .function("hashCode", returns(Type.I).noParams()) { it.target?.hashCode() }
                .function("equals", returns(Type.Z).params(Type.OBJECT)) { it.target?.equals(it.getRef(0)) }
                .function("clone", returnsObject().noParams()) { it.target?.clone() }
        }
    }
}
