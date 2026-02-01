package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.type

import org.bukkit.block.data.type.Bed
import org.tabooproject.fluxon.function.FnEnumGetter
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.block.data.type.Bed"])
@PlatformSide(Platform.BUKKIT)
object FnBed {

    val TYPE = Type.fromClass(Bed::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Bed::class.java)
                .function("part", returns(TYPE).noParams()) { it.setReturnRef(it.target?.part) }
                .function("setPart", returnsVoid().params(TYPE)) { it.target?.setPart(it.getRef(0) as Bed.Part) }
                .function("setPart", returnsVoid().params(Type.STRING)) { FnBedPart.enumValue(it.getString(0))?.let { p0 -> it.target?.setPart(p0) } }
                .function("isOccupied", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isOccupied ?: false) }
        }
    }
}

@Requires(classes = ["org.bukkit.block.data.type.Bed.Part"])
@PlatformSide(Platform.BUKKIT)
object FnBedPart : FnEnumGetter<Bed.Part>() {

    override val enumClass: Class<Bed.Part> = Bed.Part::class.java
}
