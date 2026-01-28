package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.meta

import org.bukkit.entity.Axolotl
import org.bukkit.inventory.meta.AxolotlBucketMeta
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.inventory.meta.AxolotlBucketMeta"])
@PlatformSide(Platform.BUKKIT)
object FnAxolotlBucketMeta {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(AxolotlBucketMeta::class.java)
                .function("setVariant", returnsObject().params(Type.OBJECT)) { it.target?.setVariant(it.getRef(0) as Axolotl.Variant) }
                .function("hasVariant", returns(Type.Z).noParams()) { it.target?.hasVariant() }
                .function("clone", returnsObject().noParams()) { it.target?.clone() }
        }
    }
}
