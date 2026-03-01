package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data

import org.bukkit.block.data.Rail
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
import org.tabooproject.fluxon.util.StandardTypes

@Requires(classes = ["org.bukkit.block.data.Rail"])
@PlatformSide(Platform.BUKKIT)
object FnRail {

    val TYPE = Type.fromClass(Rail::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Rail::class.java)
                .function("shape", returns(FnRailShape.TYPE).noParams()) { it.setReturnRef(it.target?.shape) }
                .function("setShape", returnsVoid().params(FnRailShape.TYPE)) { it.target?.setShape(it.getRef(0) as Rail.Shape) }
                .function("setShape", returnsVoid().params(Type.STRING)) { FnRailShape.enumValue(it.getString(0))?.let { p0 -> it.target?.setShape(p0) } }
                .function("shapes", returns(StandardTypes.SET).noParams()) { it.setReturnRef(it.target?.shapes) }
        }
    }
}

@Requires(classes = ["org.bukkit.block.data.Rail\$Shape"])
@PlatformSide(Platform.BUKKIT)
object FnRailShape : FnEnumGetter<Rail.Shape>() {

    override val enumClass: Class<Rail.Shape> = Rail.Shape::class.java
}
