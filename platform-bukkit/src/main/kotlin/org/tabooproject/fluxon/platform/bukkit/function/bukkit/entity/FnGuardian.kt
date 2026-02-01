package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.Guardian
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.entity.Guardian"])
@PlatformSide(Platform.BUKKIT)
object FnGuardian {

    val TYPE = Type.fromClass(Guardian::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Guardian::class.java)
                .function("setLaser", returns(Type.Z).params(Type.Z)) { it.setReturnBool(it.target?.setLaser(it.getBool(0)) == true) }
                .function("hasLaser", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.hasLaser() ?: false) }
                .function("laserDuration", returns(Type.I).noParams()) { it.setReturnInt(it.target?.laserDuration ?: 0) }
                .function("setLaserTicks", returnsVoid().params(Type.I)) { it.target?.setLaserTicks(it.getInt(0).toInt()) }
                .function("laserTicks", returns(Type.I).noParams()) { it.setReturnInt(it.target?.laserTicks ?: 0) }
                .function("isElder", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isElder ?: false) }
                .function("setElder", returnsVoid().params(Type.Z)) { it.target?.setElder(it.getBool(0)) }
                .function("isMoving", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isMoving ?: false) }
        }
    }
}
