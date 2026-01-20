package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.bukkit.BanEntry
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import java.util.*
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnBanEntry {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BanEntry::class.java)
                .function("target", 0) { it.target?.target }
                .function("banTarget", 0) { it.target?.getBanTarget() }
                .function("created", 0) { it.target?.created }
                .function("setCreated", 1) { it.target?.setCreated(Date(it.getNumber(0).toLong())) }
                .function("source", 0) { it.target?.source }
                .function("setSource", 1) { it.target?.setSource(it.getString(0)!!) }
                .function("expiration", 0) { it.target?.expiration }
                .function("setExpiration", 1) { it.target?.setExpiration(Date(it.getNumber(0).toLong())) }
                .function("reason", 0) { it.target?.reason }
                .function("setReason", 1) { it.target?.setReason(it.getString(0)) }
                .function("save", 0) { it.target?.save() }
                .function("remove", 0) { it.target?.remove() }
        }
    }
}
