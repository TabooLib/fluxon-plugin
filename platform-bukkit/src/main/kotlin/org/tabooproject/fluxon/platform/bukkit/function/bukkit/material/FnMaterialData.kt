package org.tabooproject.fluxon.platform.bukkit.function.bukkit.material

import org.bukkit.material.MaterialData
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.material.MaterialData"])
@PlatformSide(Platform.BUKKIT)
object FnMaterialData {

    val TYPE = Type.fromClass(MaterialData::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(MaterialData::class.java)
                .function("data", returns(Type.I).noParams()) { it.setReturnInt(it.target?.data?.toInt() ?: 0) }
                .function("setData", returnsVoid().params(Type.I)) { it.target?.setData(it.getInt(0).toByte()) }
                .function("itemType",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnMaterial.TYPE).noParams()) { it.setReturnRef(it.target?.itemType) }
                .function("toItemStack",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack.TYPE).noParams()) { it.setReturnRef(it.target?.toItemStack()) }
                .function("toItemStack",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack.TYPE).params(Type.I)) {
                    it.setReturnRef(it.target?.toItemStack(it.getInt(0).toInt()))
                }
                .function("toString", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.toString()) }
                .function("clone",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.material.FnMaterialData.TYPE).noParams()) { it.setReturnRef(it.target?.clone()) }
        }
    }
}
