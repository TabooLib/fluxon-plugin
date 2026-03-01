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
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid

@Requires(classes = ["org.bukkit.Raid"])
@PlatformSide(Platform.BUKKIT)
object FnRaid {

    val TYPE = Type.fromClass(Raid::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Raid::class.java)
                .function("isStarted", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isStarted ?: false) }
                .function("activeTicks", returns(Type.J).noParams()) { it.setReturnLong(it.target?.activeTicks ?: 0) }
                .function("badOmenLevel", returns(Type.I).noParams()) { it.setReturnInt(it.target?.badOmenLevel ?: 0) }
                .function("setBadOmenLevel", returnsVoid().params(Type.I)) { it.target?.setBadOmenLevel(it.getInt(0).toInt()) }
                .function("location",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE).noParams()) { it.setReturnRef(it.target?.location) }
                .function("status", returns(FnRaidRaidStatus.TYPE).noParams()) { it.setReturnRef(it.target?.status) }
                .function("spawnedGroups", returns(Type.I).noParams()) { it.setReturnInt(it.target?.spawnedGroups ?: 0) }
                .function("totalGroups", returns(Type.I).noParams()) { it.setReturnInt(it.target?.totalGroups ?: 0) }
                .function("totalWaves", returns(Type.I).noParams()) { it.setReturnInt(it.target?.totalWaves ?: 0) }
                .function("totalHealth", returns(Type.F).noParams()) { it.setReturnFloat(it.target?.totalHealth ?: 0.0f) }
                .function("heroes",returns(org.tabooproject.fluxon.util.StandardTypes.SET).noParams()) { it.setReturnRef(it.target?.heroes) }
                .function("raiders",returns(Type.LIST).noParams()) { it.setReturnRef(it.target?.raiders) }
        }
    }
}
