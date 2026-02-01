package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.type

import org.bukkit.block.data.type.Bell
import org.tabooproject.fluxon.function.FnEnumGetter
import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.block.data.type.Bell"])
@PlatformSide(Platform.BUKKIT)
object FnBell {

    val TYPE = Type.fromClass(Bell::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Bell::class.java)
                .function("attachment", returns(FnBellAttachment.TYPE).noParams()) { it.setReturnRef(it.target?.attachment) }
                .function("setAttachment", returnsVoid().params(FnBellAttachment.TYPE)) { it.target?.setAttachment(it.getRef(0) as Bell.Attachment) }
                .function("setAttachment", returnsVoid().params(FnBellAttachment.TYPE)) {
                    FnBellAttachment.enumValue(it.getString(0))?.let { p0 ->
                        it.target?.setAttachment(
                            p0)
                    }
                }
        }
    }
}

@Requires(classes = ["org.bukkit.block.data.type.Bell.Attachment"])
@PlatformSide(Platform.BUKKIT)
object FnBellAttachment : FnEnumGetter<Bell.Attachment>() {

    override val enumClass: Class<Bell.Attachment> = Bell.Attachment::class.java
}
