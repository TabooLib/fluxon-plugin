package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.Firework
import org.bukkit.entity.LivingEntity
import org.bukkit.inventory.meta.FireworkMeta
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.entity.Firework"])
@PlatformSide(Platform.BUKKIT)
object FnFirework {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Firework::class.java)
                .function("fireworkMeta", returnsObject().noParams()) { it.target?.fireworkMeta }
                .function("setFireworkMeta", returnsObject().params(Type.OBJECT)) { it.target?.setFireworkMeta(it.getRef(0) as FireworkMeta) }
                .function("setAttachedTo", returnsObject().params(Type.OBJECT)) { it.target?.setAttachedTo(it.getRef(0) as LivingEntity) }
                .function("attachedTo", returnsObject().noParams()) { it.target?.attachedTo }
                .function("setLife", returnsObject().params(Type.OBJECT)) { it.target?.setLife(it.getInt(0).toInt()) }
                .function("life", returnsObject().noParams()) { it.target?.life }
                .function("setMaxLife", returnsObject().params(Type.OBJECT)) { it.target?.setMaxLife(it.getInt(0).toInt()) }
                .function("maxLife", returnsObject().noParams()) { it.target?.maxLife }
                .function("detonate", returnsObject().noParams()) { it.target?.detonate() }
                .function("isDetonated", returns(Type.Z).noParams()) { it.target?.isDetonated }
                .function("isShotAtAngle", returns(Type.Z).noParams()) { it.target?.isShotAtAngle }
                .function("setShotAtAngle", returnsObject().params(Type.OBJECT)) { it.target?.setShotAtAngle(it.getBool(0)) }
        }
    }
}
