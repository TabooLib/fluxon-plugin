package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.type

import org.bukkit.block.data.type.Switch
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

@Requires(classes = ["org.bukkit.block.data.type.Switch"])
@PlatformSide(Platform.BUKKIT)
object FnSwitch {

    val TYPE = Type.fromClass(Switch::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Switch::class.java)
                .function("face", returns(FnSwitchFace.TYPE).noParams()) { it.setReturnRef(it.target?.face) }
                .function("setFace", returnsVoid().params(FnSwitchFace.TYPE)) { it.target?.setFace(it.getRef(0) as Switch.Face) }
                .function("setFace", returnsVoid().params(Type.STRING)) { FnSwitchFace.enumValue(it.getString(0))?.let { p0 -> it.target?.setFace(p0) } }
        }
    }
}

@Requires(classes = ["org.bukkit.block.data.type.Switch\$Face"])
@PlatformSide(Platform.BUKKIT)
object FnSwitchFace : FnEnumGetter<Switch.Face>() {

    override val enumClass: Class<Switch.Face> = Switch.Face::class.java
}