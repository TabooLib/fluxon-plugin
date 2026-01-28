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

@Requires(classes = ["org.bukkit.material.MonsterEggs"])
@PlatformSide(Platform.BUKKIT)
object FnMonsterEggs {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(MonsterEggs::class.java)
                .function("textures", returnsObject().noParams()) { it.target?.textures }
                .function("clone", returnsObject().noParams()) { it.target?.clone() }
        }
    }
}
