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
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.entity.Firework"])
@PlatformSide(Platform.BUKKIT)
object FnFirework {

    val TYPE = Type.fromClass(Firework::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Firework::class.java)
                .function("fireworkMeta",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.meta.FnFireworkMeta.TYPE).noParams()) { it.setReturnRef(it.target?.fireworkMeta) }
                .function("setFireworkMeta",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.meta.FnFireworkMeta.TYPE)) { it.target?.setFireworkMeta(it.getRef(0) as FireworkMeta) }
                .function("setAttachedTo",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnLivingEntity.TYPE)) { it.target?.setAttachedTo(it.getRef(0) as LivingEntity) }
                .function("attachedTo",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnLivingEntity.TYPE).noParams()) { it.setReturnRef(it.target?.attachedTo) }
                .function("setLife", returnsVoid().params(Type.I)) { it.target?.setLife(it.getInt(0)) }
                .function("life", returns(Type.I).noParams()) { it.setReturnInt(it.target?.life ?: 0) }
                .function("setMaxLife", returnsVoid().params(Type.I)) { it.target?.setMaxLife(it.getInt(0)) }
                .function("maxLife", returns(Type.I).noParams()) { it.setReturnInt(it.target?.maxLife ?: 0) }
                .function("detonate", returnsVoid().noParams()) { it.target?.detonate() }
                .function("isDetonated", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isDetonated ?: false) }
                .function("isShotAtAngle", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isShotAtAngle ?: false) }
                .function("setShotAtAngle", returnsVoid().params(Type.Z)) { it.target?.setShotAtAngle(it.getBool(0)) }
        }
    }
}
