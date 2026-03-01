package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.type

import org.bukkit.block.BlockFace
import org.bukkit.block.data.type.PointedDripstone
import org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.FnBlockFace
import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.util.StandardTypes

@Requires(classes = ["org.bukkit.block.data.type.PointedDripstone"])
@PlatformSide(Platform.BUKKIT)
object FnPointedDripstone {

    val TYPE = Type.fromClass(PointedDripstone::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PointedDripstone::class.java)
                .function("verticalDirection", returns(FnBlockFace.TYPE).noParams()) { it.setReturnRef(it.target?.verticalDirection) }
                .function("setVerticalDirection",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.FnBlockFace.TYPE)) { it.target?.setVerticalDirection(it.getRef(0) as BlockFace) }
                .function("verticalDirections", returns(StandardTypes.SET).noParams()) { it.setReturnRef(it.target?.verticalDirections) }
                .function("thickness", returns(FnPointedDripstoneThickness.TYPE).noParams()) { it.setReturnRef(it.target?.thickness) }
                .function("setThickness", returnsVoid().params(FnPointedDripstoneThickness.TYPE)) { it.target?.setThickness(it.getRef(0) as PointedDripstone.Thickness) }
                .function("setThickness", returnsVoid().params(Type.STRING)) {
                    FnPointedDripstoneThickness.enumValue(it.getString(0))?.let { p0 ->
                        it.target?.setThickness(
                            p0)
                    }
                }
        }
    }
}

@Requires(classes = ["org.bukkit.block.data.type.PointedDripstone\$Thickness"])
@PlatformSide(Platform.BUKKIT)
object FnPointedDripstoneThickness : FnEnumGetter<PointedDripstone.Thickness>() {

    override val enumClass: Class<PointedDripstone.Thickness> = PointedDripstone.Thickness::class.java
}
