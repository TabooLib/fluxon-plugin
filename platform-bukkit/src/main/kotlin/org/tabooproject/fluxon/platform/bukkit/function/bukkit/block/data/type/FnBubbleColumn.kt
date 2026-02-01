package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.type

import org.bukkit.block.data.type.BubbleColumn
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

@Requires(classes = ["org.bukkit.block.data.type.BubbleColumn"])
@PlatformSide(Platform.BUKKIT)
object FnBubbleColumn {

    val TYPE = Type.fromClass(BubbleColumn::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BubbleColumn::class.java)
                .function("isDrag", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isDrag ?: false) }
                .function("setDrag", returnsVoid().params(Type.Z)) { it.target?.setDrag(it.getBool(0)) }
        }
    }
}
