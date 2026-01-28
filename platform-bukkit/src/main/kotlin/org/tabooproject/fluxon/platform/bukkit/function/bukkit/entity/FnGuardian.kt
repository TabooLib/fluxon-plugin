package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.Guardian
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.entity.Guardian"])
@PlatformSide(Platform.BUKKIT)
object FnGuardian {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Guardian::class.java)
                .function("setLaser", returnsObject().params(Type.OBJECT)) { it.target?.setLaser(it.getBool(0)) }
                .function("hasLaser", returns(Type.Z).noParams()) { it.target?.hasLaser() }
                .function("laserDuration", returnsObject().noParams()) { it.target?.laserDuration }
                .function("setLaserTicks", returnsObject().params(Type.OBJECT)) { it.target?.setLaserTicks(it.getInt(0).toInt()) }
                .function("laserTicks", returnsObject().noParams()) { it.target?.laserTicks }
                .function("isElder", returns(Type.Z).noParams()) { it.target?.isElder }
                .function("setElder", returnsObject().params(Type.OBJECT)) { it.target?.setElder(it.getBool(0)) }
                .function("isMoving", returns(Type.Z).noParams()) { it.target?.isMoving }
        }
    }
}
