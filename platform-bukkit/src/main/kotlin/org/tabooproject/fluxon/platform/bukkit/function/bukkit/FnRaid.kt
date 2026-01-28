package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.bukkit.Raid
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.Raid"])
@PlatformSide(Platform.BUKKIT)
object FnRaid {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Raid::class.java)
                .function("isStarted", returns(Type.Z).noParams()) { it.target?.isStarted }
                .function("activeTicks", returnsObject().noParams()) { it.target?.activeTicks }
                .function("badOmenLevel", returnsObject().noParams()) { it.target?.badOmenLevel }
                .function("setBadOmenLevel", returnsObject().params(Type.OBJECT)) { it.target?.setBadOmenLevel(it.getInt(0).toInt()) }
                .function("location", returnsObject().noParams()) { it.target?.location }
                .function("status", returnsObject().noParams()) { it.target?.status }
                .function("spawnedGroups", returnsObject().noParams()) { it.target?.spawnedGroups }
                .function("totalGroups", returnsObject().noParams()) { it.target?.totalGroups }
                .function("totalWaves", returnsObject().noParams()) { it.target?.totalWaves }
                .function("totalHealth", returnsObject().noParams()) { it.target?.totalHealth }
                .function("heroes", returnsObject().noParams()) { it.target?.heroes }
                .function("raiders", returnsObject().noParams()) { it.target?.raiders }
        }
    }
}
