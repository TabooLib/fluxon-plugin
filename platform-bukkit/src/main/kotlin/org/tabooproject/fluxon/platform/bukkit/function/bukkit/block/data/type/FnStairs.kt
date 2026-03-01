package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.type

import org.bukkit.block.data.type.Stairs
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

@Requires(classes = ["org.bukkit.block.data.type.Stairs"])
@PlatformSide(Platform.BUKKIT)
object FnStairs {

    val TYPE = Type.fromClass(Stairs::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Stairs::class.java)
                .function("shape", returns(FnStairsShape.TYPE).noParams()) { it.setReturnRef(it.target?.shape) }
                .function("setShape", returnsVoid().params(FnStairsShape.TYPE)) { it.target?.setShape(it.getRef(0) as Stairs.Shape) }
                .function("setShape", returnsVoid().params(Type.STRING)) { FnStairsShape.enumValue(it.getString(0))?.let { p0 -> it.target?.setShape(p0) } }
        }
    }
}

@Requires(classes = ["org.bukkit.block.data.type.Stairs\$Shape"])
@PlatformSide(Platform.BUKKIT)
object FnStairsShape : FnEnumGetter<Stairs.Shape>() {

    override val enumClass: Class<Stairs.Shape> = Stairs.Shape::class.java
}