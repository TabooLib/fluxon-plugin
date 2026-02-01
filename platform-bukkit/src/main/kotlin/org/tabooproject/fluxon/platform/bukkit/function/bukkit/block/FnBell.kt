package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block

import org.bukkit.block.Bell
import org.bukkit.block.BlockFace
import org.bukkit.entity.Entity
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.block.Bell"])
@PlatformSide(Platform.BUKKIT)
object FnBell {

    val TYPE = Type.fromClass(Bell::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Bell::class.java)
                .function("ring", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.ring() ?: false) }
                .function("ring", returns(Type.Z).params(Type.OBJECT)) {
                    it.setReturnBool(when (val var1 = it.getRef(0)) {
                        is Entity -> it.target?.ring(var1)
                        is BlockFace -> it.target?.ring(var1)
                        else -> throw IllegalArgumentException("参数必须是 Entity 或 BlockFace 类型")
                    } ?: false)
                }
                .function("ring", returns(Type.Z).params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnBool(it.target?.ring(
                        it.getRef(0) as Entity,
                        it.getRef(1) as BlockFace
                    ) ?: false)
                }
                .function("isShaking", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isShaking ?: false) }
                .function("shakingTicks", returns(Type.I).noParams()) { it.setReturnInt(it.target?.shakingTicks ?: 0) }
                .function("isResonating", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isResonating ?: false) }
                .function("resonatingTicks", returns(Type.I).noParams()) { it.setReturnInt(it.target?.resonatingTicks ?: 0) }
        }
    }
}
