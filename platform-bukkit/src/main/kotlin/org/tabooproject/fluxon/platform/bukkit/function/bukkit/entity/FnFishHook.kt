package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.Entity
import org.bukkit.entity.FishHook
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


@Requires(classes = ["org.bukkit.entity.FishHook"])
@PlatformSide(Platform.BUKKIT)
object FnFishHook {

    val TYPE = Type.fromClass(FishHook::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(FishHook::class.java)
                .function("isUnhooked", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.state == FishHook.HookState.UNHOOKED) }
                .function("isHookedEntity", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.state == FishHook.HookState.HOOKED_ENTITY) }
                .function("isBobbing", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.state == FishHook.HookState.BOBBING) }
                .function("setLureTime", returnsVoid().params(Type.I)) {
                    val time = it.getInt(0).toInt()
                    it.target?.setLureTime(time, time)
                }
                .function("setLureTime", returnsVoid().params(Type.I, Type.I)) {
                    it.target?.setLureTime(it.getInt(0).toInt(), it.getInt(1).toInt())
                }
                .function("setLureAngle", returnsVoid().params(Type.F)) {
                    val angle = it.getFloat(0)
                    it.target?.setLureAngle(angle, angle)
                }
                .function("setLureAngle", returnsVoid().params(Type.F, Type.F)) {
                    it.target?.setLureAngle(it.getFloat(0), it.getFloat(1))
                }

                .function("minWaitTime", returns(Type.I).noParams()) { it.setReturnInt(it.target?.minWaitTime ?: 0) }
                .function("setMinWaitTime", returnsVoid().params(Type.I)) { it.target?.setMinWaitTime(it.getInt(0)) }
                .function("maxWaitTime", returns(Type.I).noParams()) { it.setReturnInt(it.target?.maxWaitTime ?: 0) }
                .function("setMaxWaitTime", returnsVoid().params(Type.I)) { it.target?.setMaxWaitTime(it.getInt(0)) }
                .function("setWaitTime", returnsVoid().params(Type.I, Type.I)) { it.target?.setWaitTime(it.getInt(0), it.getInt(1)) }
                .function("minLureTime", returns(Type.I).noParams()) { it.setReturnInt(it.target?.minLureTime ?: 0) }
                .function("setMinLureTime", returnsVoid().params(Type.I)) { it.target?.setMinLureTime(it.getInt(0)) }
                .function("maxLureTime", returns(Type.I).noParams()) { it.setReturnInt(it.target?.maxLureTime ?: 0) }
                .function("setMaxLureTime", returnsVoid().params(Type.I)) { it.target?.setMaxLureTime(it.getInt(0)) }
                .function("minLureAngle", returns(Type.F).noParams()) { it.setReturnFloat(it.target?.minLureAngle ?: 0f) }
                .function("setMinLureAngle", returnsVoid().params(Type.F)) { it.target?.setMinLureAngle(it.getFloat(0)) }
                .function("maxLureAngle", returns(Type.F).noParams()) { it.setReturnFloat(it.target?.maxLureAngle ?: 0f) }
                .function("setMaxLureAngle", returnsVoid().params(Type.F)) { it.target?.setMaxLureAngle(it.getFloat(0)) }
                .function("applyLure", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.applyLure ?: false) }
                .function("setApplyLure", returnsVoid().params(Type.Z)) { it.target?.setApplyLure(it.getBool(0)) }
                .function("biteChance", returns(Type.D).noParams()) { it.setReturnDouble(it.target?.biteChance ?: 0.0) }
                .function("setBiteChance", returnsVoid().params(Type.D)) { it.target?.setBiteChance(it.getDouble(0)) }
                .function("isInOpenWater", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isInOpenWater ?: false) }
                .function("hookedEntity", returnsObject().noParams()) { it.setReturnRef(it.target?.hookedEntity) }
                .function("setHookedEntity", returnsVoid().params(Type.OBJECT)) { it.target?.setHookedEntity(it.getRef(0) as Entity) }
                .function("pullHookedEntity", returnsVoid().noParams()) { it.target?.pullHookedEntity() }
                .function("isSkyInfluenced", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isSkyInfluenced ?: false) }
                .function("setSkyInfluenced", returnsVoid().params(Type.Z)) { it.target?.setSkyInfluenced(it.getBool(0)) }
                .function("isRainInfluenced", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isRainInfluenced ?: false) }
                .function("setRainInfluenced", returnsVoid().params(Type.Z)) { it.target?.setRainInfluenced(it.getBool(0)) }
                .function("state", returnsObject().noParams()) { it.setReturnRef(it.target?.state) }
//                .function("waitTime", returnsObject().noParams()) { it.setReturnRef(it.target?.waitTime) }
//                .function("setWaitTime", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.apply { waitTime = it.getInt(0).toInt() }) }
        }
    }
}
