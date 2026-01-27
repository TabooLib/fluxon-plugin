package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.Location
import org.bukkit.entity.Allay
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires

@Requires(classes = ["org.bukkit.entity.Allay"])
@PlatformSide(Platform.BUKKIT)
object FnAllay {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Allay::class.java)
                .function("canDuplicate", 0) { it.target?.canDuplicate() }
                .function("setCanDuplicate", 1) { it.target?.setCanDuplicate(it.getBoolean(0)) }
                .function("duplicationCooldown", 0) { it.target?.duplicationCooldown }
                .function("setDuplicationCooldown", 1) { it.target?.setDuplicationCooldown(it.getNumber(0).toLong()) }
                .function("resetDuplicationCooldown", 0) { it.target?.resetDuplicationCooldown() }
                .function("isDancing", 0) { it.target?.isDancing }
                .function("startDancing", listOf(0, 1)) {
                    if (it.arguments.isEmpty()) {
                        it.target?.startDancing()
                    } else {
                        it.target?.startDancing(it.getArgument(0) as Location)
                    }
                }
                .function("stopDancing", 0) { it.target?.stopDancing() }
                .function("duplicateAllay", 0) { it.target?.duplicateAllay() }
                .function("jukebox", 0) { it.target?.jukebox }
        }
    }
}
