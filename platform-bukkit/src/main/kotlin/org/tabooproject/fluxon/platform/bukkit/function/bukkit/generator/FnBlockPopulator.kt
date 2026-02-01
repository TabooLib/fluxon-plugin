package org.tabooproject.fluxon.platform.bukkit.function.bukkit.generator

import org.bukkit.Chunk
import org.bukkit.World
import org.bukkit.generator.BlockPopulator
import org.bukkit.generator.LimitedRegion
import org.bukkit.generator.WorldInfo
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import java.util.*
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.generator.BlockPopulator"])
@PlatformSide(Platform.BUKKIT)
object FnBlockPopulator {

    val TYPE = Type.fromClass(BlockPopulator::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BlockPopulator::class.java)
                .function("populate", returnsVoid().params(Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.target?.populate(
                        it.getRef(0) as World,
                        it.getRef(1) as Random,
                        it.getRef(2) as Chunk
                    )
                }
                .function("populate", returnsVoid().params(Type.OBJECT, Type.OBJECT, Type.I, Type.I, Type.OBJECT)) {
                    it.target?.populate(
                        it.getRef(0) as WorldInfo,
                        it.getRef(1) as Random,
                        it.getInt(2).toInt(),
                        it.getInt(3).toInt(),
                        it.getRef(4) as LimitedRegion
                    )
                }
        }
    }
}
