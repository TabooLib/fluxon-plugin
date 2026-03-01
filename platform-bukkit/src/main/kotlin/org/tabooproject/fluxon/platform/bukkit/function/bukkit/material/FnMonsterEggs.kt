package org.tabooproject.fluxon.platform.bukkit.function.bukkit.material

import org.bukkit.material.MonsterEggs
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.material.MonsterEggs"])
@PlatformSide(Platform.BUKKIT)
object FnMonsterEggs {

    val TYPE = Type.fromClass(MonsterEggs::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(MonsterEggs::class.java)
                .function("textures",returns(Type.LIST).noParams()) { it.setReturnRef(it.target?.textures) }
                .function("clone", returns(TYPE).noParams()) { it.setReturnRef(it.target?.clone()) }
        }
    }
}
