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

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Bell::class.java)
                .function("ring", returnsObject().noParams()) {
                    it.setReturnRef(when (it.argumentCount) {
                        0 -> it.target?.ring()
                        1 -> when (val var1 = it.getRef(0)) {
                            is Entity -> it.target?.ring(var1)
                            is BlockFace -> it.target?.ring(var1)
                            else -> throw IllegalArgumentException("参数必须是 Entity 或 BlockFace 类型")
                        }

                        2 -> it.target?.ring(it.getRef(0) as Entity, it.getRef(1) as BlockFace)
                        else -> error("Bell#ring 函数参数数量错误: ${"args"}")
                    })
                }
                .function("ring", returnsObject().params(Type.OBJECT)) {
                    it.setReturnRef(when (it.argumentCount) {
                        0 -> it.target?.ring()
                        1 -> when (val var1 = it.getRef(0)) {
                            is Entity -> it.target?.ring(var1)
                            is BlockFace -> it.target?.ring(var1)
                            else -> throw IllegalArgumentException("参数必须是 Entity 或 BlockFace 类型")
                        }

                        2 -> it.target?.ring(it.getRef(0) as Entity, it.getRef(1) as BlockFace)
                        else -> error("Bell#ring 函数参数数量错误: ${"args"}")
                    })
                }
                .function("ring", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(when (it.argumentCount) {
                        0 -> it.target?.ring()
                        1 -> when (val var1 = it.getRef(0)) {
                            is Entity -> it.target?.ring(var1)
                            is BlockFace -> it.target?.ring(var1)
                            else -> throw IllegalArgumentException("参数必须是 Entity 或 BlockFace 类型")
                        }

                        2 -> it.target?.ring(it.getRef(0) as Entity, it.getRef(1) as BlockFace)
                        else -> error("Bell#ring 函数参数数量错误: ${"args"}")
                    })
                }
                .function("isShaking", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isShaking) }
                .function("shakingTicks", returnsObject().noParams()) { it.setReturnRef(it.target?.shakingTicks) }
                .function("isResonating", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isResonating) }
                .function("resonatingTicks", returnsObject().noParams()) { it.setReturnRef(it.target?.resonatingTicks) }
        }
    }
}
