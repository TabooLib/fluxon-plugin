package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block

import org.bukkit.block.BlockFace
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns


@Requires(classes = ["org.bukkit.block.BlockFace"])
@PlatformSide(Platform.BUKKIT)
object FnBlockFace {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BlockFace::class.java)
                // 橙汁喵: 枚举类语法
                .function("name", returns(Type.STRING).noParams()) { it.target?.name }
                // 橙汁喵: 枚举类语法
                .function("ordinal", returnsObject().noParams()) { it.target?.ordinal }
                .function("modX", returnsObject().noParams()) { it.target?.modX }
                .function("modY", returnsObject().noParams()) { it.target?.modY }
                .function("modZ", returnsObject().noParams()) { it.target?.modZ }
                .function("direction", returnsObject().noParams()) { it.target?.direction }
                .function("isCartesian", returns(Type.Z).noParams()) { it.target?.isCartesian }
                .function("oppositeFace", returnsObject().noParams()) { it.target?.oppositeFace }
        }
    }
}
