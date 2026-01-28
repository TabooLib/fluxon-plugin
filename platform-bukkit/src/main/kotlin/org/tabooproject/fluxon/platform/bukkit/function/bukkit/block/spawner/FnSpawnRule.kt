package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.spawner

import org.bukkit.block.spawner.SpawnRule
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.block.spawner.SpawnRule"])
@PlatformSide(Platform.BUKKIT)
object FnSpawnRule {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(SpawnRule::class.java)
                .function("minBlockLight", returnsObject().noParams()) { it.target?.minBlockLight }
                .function("setMinBlockLight", returnsObject().params(Type.OBJECT)) { it.target?.setMinBlockLight(it.getInt(0).toInt()) }
                .function("maxBlockLight", returnsObject().noParams()) { it.target?.maxBlockLight }
                .function("setMaxBlockLight", returnsObject().params(Type.OBJECT)) { it.target?.setMaxBlockLight(it.getInt(0).toInt()) }
                .function("minSkyLight", returnsObject().noParams()) { it.target?.minSkyLight }
                .function("setMinSkyLight", returnsObject().params(Type.OBJECT)) { it.target?.setMinSkyLight(it.getInt(0).toInt()) }
                .function("maxSkyLight", returnsObject().noParams()) { it.target?.maxSkyLight }
                .function("setMaxSkyLight", returnsObject().params(Type.OBJECT)) { it.target?.setMaxSkyLight(it.getInt(0).toInt()) }
                .function("equals", returns(Type.Z).params(Type.OBJECT)) { it.target?.equals(it.getRef(0)) }
                .function("hashCode", returns(Type.I).noParams()) { it.target?.hashCode() }
                .function("clone", returnsObject().noParams()) { it.target?.clone() }
                .function("deserialize", returnsObject().params(Type.OBJECT)) { SpawnRule.deserialize(it.getRef(0) as Map<String, Any>) }
        }
    }
}
