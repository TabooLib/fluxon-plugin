package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.type

import org.bukkit.block.data.type.Slab
import org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter
import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.block.data.type.Slab"])
@PlatformSide(Platform.BUKKIT)
object FnSlab {

    val TYPE = Type.fromClass(Slab::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Slab::class.java)
                .function("type", returns(FnSlabType.TYPE).noParams()) { it.setReturnRef(it.target?.type) }
                .function("setType", returnsVoid().params(FnSlabType.TYPE)) { it.target?.setType(it.getRef(0) as Slab.Type) }
                .function("setType", returnsVoid().params(Type.STRING)) { FnSlabType.enumValue(it.getString(0))?.let { p0 -> it.target?.setType(p0) } }
        }
    }
}

@Requires(classes = ["org.bukkit.block.data.type.Slab\$Type"])
@PlatformSide(Platform.BUKKIT)
object FnSlabType: FnEnumGetter<Slab.Type>() {

    override val enumClass: Class<Slab.Type> = Slab.Type::class.java
}