package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.Location
import org.bukkit.entity.Allay
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.entity.Allay"])
@PlatformSide(Platform.BUKKIT)
object FnAllay {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Allay::class.java)
                .function("canDuplicate", returns(Type.Z).noParams()) { it.target?.canDuplicate() }
                .function("setCanDuplicate", returnsObject().params(Type.OBJECT)) { it.target?.setCanDuplicate(it.getBool(0)) }
                .function("duplicationCooldown", returnsObject().noParams()) { it.target?.duplicationCooldown }
                .function("setDuplicationCooldown", returnsObject().params(Type.OBJECT)) { it.target?.setDuplicationCooldown(it.getInt(0).toLong()) }
                .function("resetDuplicationCooldown", returnsObject().noParams()) { it.target?.resetDuplicationCooldown() }
                .function("isDancing", returns(Type.Z).noParams()) { it.target?.isDancing }
                .function("startDancing", returnsObject().noParams()) {
                    if ((it.argumentCount == 0)) {
                        it.target?.startDancing()
                    } else {
                        it.target?.startDancing(it.getRef(0) as Location)
                    }
                }
                .function("startDancing", returnsObject().params(Type.OBJECT)) {
                    if ((it.argumentCount == 0)) {
                        it.target?.startDancing()
                    } else {
                        it.target?.startDancing(it.getRef(0) as Location)
                    }
                }
                .function("stopDancing", returnsObject().noParams()) { it.target?.stopDancing() }
                .function("duplicateAllay", returnsObject().noParams()) { it.target?.duplicateAllay() }
                .function("jukebox", returnsObject().noParams()) { it.target?.jukebox }
        }
    }
}
