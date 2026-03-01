package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.meta

import org.bukkit.entity.Axolotl
import org.bukkit.inventory.meta.AxolotlBucketMeta
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.inventory.meta.AxolotlBucketMeta"])
@PlatformSide(Platform.BUKKIT)
object FnAxolotlBucketMeta {

    val TYPE = Type.fromClass(AxolotlBucketMeta::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(AxolotlBucketMeta::class.java)
                .function("setVariant", returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnAxolotlVariant.TYPE)) { it.target?.setVariant(it.getRef(0) as Axolotl.Variant)  }
                .function("setVariant", returnsVoid().params(Type.STRING)) { org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnAxolotlVariant.enumValue(it.getString(0))?.let { p0 -> it.target?.setVariant(p0)  } }
                .function("hasVariant", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.hasVariant() ?: false) }
                .function("clone",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.meta.FnAxolotlBucketMeta.TYPE).noParams()) { it.setReturnRef(it.target?.clone()) }
        }
    }
}
