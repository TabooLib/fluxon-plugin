package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.spawner

import org.bukkit.block.spawner.SpawnRule
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

@Requires(classes = ["org.bukkit.block.spawner.SpawnRule"])
@PlatformSide(Platform.BUKKIT)
object FnSpawnRule {

    val TYPE = Type.fromClass(SpawnRule::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(SpawnRule::class.java)
                .function("minBlockLight", returns(Type.I).noParams()) { it.setReturnInt(it.target?.minBlockLight ?: 0) }
                .function("setMinBlockLight", returnsVoid().params(Type.I)) {
                    it.target?.setMinBlockLight(it.getInt(0).toInt())
                }
                .function("maxBlockLight", returns(Type.I).noParams()) { it.setReturnInt(it.target?.maxBlockLight ?: 0) }
                .function("setMaxBlockLight", returnsVoid().params(Type.I)) {
                    it.target?.setMaxBlockLight(it.getInt(0).toInt())
                }
                .function("minSkyLight", returns(Type.I).noParams()) { it.setReturnInt(it.target?.minSkyLight ?: 0) }
                .function("setMinSkyLight", returnsVoid().params(Type.I)) {
                    it.target?.setMinSkyLight(it.getInt(0).toInt())
                }
                .function("maxSkyLight", returns(Type.I).noParams()) { it.setReturnInt(it.target?.maxSkyLight ?: 0) }
                .function("setMaxSkyLight", returnsVoid().params(Type.I)) {
                    it.target?.setMaxSkyLight(it.getInt(0).toInt())
                }
                .function("equals", returns(Type.Z).params(Type.OBJECT)) {
                    it.setReturnBool(it.target?.equals(it.getRef(0)) ?: false)
                }
                .function("hashCode", returns(Type.I).noParams()) { it.setReturnInt(it.target?.hashCode() ?: 0) }
                .function("clone", returnsObject().noParams()) { it.setReturnRef(it.target?.clone()) }
                .function("deserialize", returnsObject().params(Type.OBJECT)) { it.setReturnRef(SpawnRule.deserialize(it.getRef(0) as Map<String, Any>)) }
        }
    }
}
